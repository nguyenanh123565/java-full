param()

$ErrorActionPreference = 'Stop'
[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new($false)
$OutputEncoding = [Console]::OutputEncoding
$sourceRoot = Join-Path $PSScriptRoot 'src\main\java'
$outputRoot = Join-Path $PSScriptRoot 'target\exercise-verification'
New-Item -ItemType Directory -Path $outputRoot -Force | Out-Null

# Validate file targets in local Markdown links. No network requests are needed.
$markdownFiles = @(Get-ChildItem -LiteralPath $PSScriptRoot -Recurse -File -Filter '*.md' |
    Where-Object { $_.FullName -notmatch '\\target\\' })
$linkPattern = '(?<!!)\[[^\]\r\n]+\]\((?<target><[^>]+>|[^)\s]+)(?:\s+"[^"]*")?\)'
$brokenLinks = @()
$linkCount = 0
foreach ($document in $markdownFiles) {
    $body = [System.IO.File]::ReadAllText($document.FullName)
    $body = [regex]::Replace($body, '(?ms)^```[^\r\n]*\r?\n.*?^```[^\r\n]*$', '')
    foreach ($match in [regex]::Matches($body, $linkPattern)) {
        $target = $match.Groups['target'].Value.Trim('<', '>')
        if ($target -match '^[a-zA-Z][a-zA-Z0-9+.-]*:' -or $target.StartsWith('#')) { continue }
        $localTarget = [Uri]::UnescapeDataString(($target -split '#', 2)[0])
        if (-not $localTarget) { continue }
        $resolved = Join-Path $document.DirectoryName $localTarget
        $linkCount++
        if (-not (Test-Path -LiteralPath $resolved)) {
            $brokenLinks += "$($document.FullName) -> $target"
        }
    }
}
if ($brokenLinks.Count -gt 0) {
    $brokenLinks | ForEach-Object { Write-Host $_ }
    throw "$($brokenLinks.Count) broken Markdown file links."
}
Write-Host "Checked $linkCount local link targets across $($markdownFiles.Count) Markdown files."

# Check bundle coverage and ensure that exercise IDs stay unambiguous.
$starterSources = @(Get-ChildItem -LiteralPath $sourceRoot -Recurse -File -Filter 'Starter.java' |
    Where-Object { $_.FullName -match '\\exercises\\starter\\Starter\.java$' })
if ($starterSources.Count -eq 0) { throw 'No exercise bundles found.' }
$exerciseCodes = [System.Collections.Generic.List[string]]::new()
foreach ($starter in $starterSources) {
    $bundleRoot = $starter.Directory.Parent.FullName
    foreach ($relativeFile in @('README.md', 'hints.md', 'review.md', 'solutions\README.md', 'solutions\ReferenceSolution.java')) {
        if (-not (Test-Path -LiteralPath (Join-Path $bundleRoot $relativeFile))) {
            throw "Missing bundle file: $bundleRoot\$relativeFile"
        }
    }
    $problemText = [System.IO.File]::ReadAllText((Join-Path $bundleRoot 'README.md'))
    $codeMatches = [regex]::Matches($problemText, '(?m)^#{2,3}\s+([A-Z][A-Z0-9_-]*-\d{2})\b')
    if ($codeMatches.Count -lt 3) { throw "Missing exercise IDs: $bundleRoot" }
    foreach ($codeMatch in $codeMatches) { $exerciseCodes.Add($codeMatch.Groups[1].Value) }
}
$duplicateCodes = @($exerciseCodes | Group-Object | Where-Object { $_.Count -gt 1 })
if ($duplicateCodes.Count -gt 0) { throw "Duplicate exercise IDs: $($duplicateCodes.Name -join ', ')" }
Write-Host "Checked $($starterSources.Count) exercise bundles and $($exerciseCodes.Count) unique exercise IDs."

# Compile through the original build entry point and Java 17 release target.
& (Join-Path $PSScriptRoot 'build.ps1')
if ($LASTEXITCODE -ne 0) { throw 'Build failed.' }

# Run demos and solutions, including the new behavioral checks with assertions enabled.
# Exercise mains are deliberately left to the learner; some may read console input.
$runnableSources = @(Get-ChildItem -LiteralPath $sourceRoot -Recurse -File -Filter '*.java' |
    Where-Object { $_.Name -match '(Demo|Solution)\.java$' } | Sort-Object FullName)
$runCount = 0
$newReferenceCount = 0
$log = [System.Collections.Generic.List[string]]::new()
foreach ($source in $runnableSources) {
    $body = [System.IO.File]::ReadAllText($source.FullName)
    if ($body -notmatch 'public\s+static\s+void\s+main\s*\(') { continue }
    $packageMatch = [regex]::Match($body, 'package\s+([\w.]+)\s*;')
    if (-not $packageMatch.Success) { throw "Missing package: $($source.FullName)" }
    $mainClass = $packageMatch.Groups[1].Value + '.' + $source.BaseName
    $result = @(& java '-ea' '-Dfile.encoding=UTF-8' -cp (Join-Path $PSScriptRoot 'target\classes') $mainClass 2>&1)
    if ($LASTEXITCODE -ne 0) {
        $result | ForEach-Object { Write-Host $_ }
        throw "Failed: $mainClass"
    }
    $log.Add("CLASS $mainClass")
    foreach ($line in $result) { $log.Add([string]$line) }
    $runCount++
    if ($source.FullName -match '\\exercises\\solutions\\ReferenceSolution\.java$') { $newReferenceCount++ }
}
$runLog = Join-Path $outputRoot 'run-log.txt'
[System.IO.File]::WriteAllLines($runLog, $log, [System.Text.UTF8Encoding]::new($false))
Write-Host "Passed $runCount demo/solution mains, including $newReferenceCount new exercise references."
Write-Host "Detailed output: $runLog"
Write-Host 'This checks supplied examples and references; it does not grade learner Exercise files.'
