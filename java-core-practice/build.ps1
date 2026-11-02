param(
    [string]$MainClass = ""
)

$ErrorActionPreference = 'Stop'
[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new($false)
$OutputEncoding = [Console]::OutputEncoding
if (-not (Get-Command javac -ErrorAction SilentlyContinue)) {
    throw 'Can JDK 17+ (javac phai co trong PATH).'
}
$sourceRoot = Join-Path $PSScriptRoot 'src\main\java'
$outputPath = Join-Path $PSScriptRoot 'target\classes'
$sourceList = Join-Path $PSScriptRoot 'target\java-sources.txt'
New-Item -ItemType Directory -Path $outputPath -Force | Out-Null
$sources = @(Get-ChildItem -LiteralPath $sourceRoot -Filter '*.java' -Recurse -File |
    Sort-Object FullName | ForEach-Object { '"' + $_.FullName.Replace('\', '/') + '"' })
if ($sources.Count -eq 0) { throw 'Khong tim thay source Java.' }
# Argfile tránh giới hạn độ dài command line; UTF-8 không BOM.
[System.IO.File]::WriteAllLines($sourceList, [string[]]$sources, [System.Text.UTF8Encoding]::new($false))
& javac --release 17 -encoding UTF-8 -d $outputPath "@$sourceList"
if ($LASTEXITCODE -ne 0) { throw 'Bien dich that bai. Kiem tra loi javac o tren.' }
Write-Host "Compiled $($sources.Count) Java files -> $outputPath"
if ($MainClass) {
    & java '-Dfile.encoding=UTF-8' -cp $outputPath $MainClass
    if ($LASTEXITCODE -ne 0) { throw "Chay $MainClass that bai." }
}
