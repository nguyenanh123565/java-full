param([ValidateRange(1, 65535)][int]$Port = 8080)

$ErrorActionPreference = 'Stop'
[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new($false)
$OutputEncoding = [Console]::OutputEncoding
if (-not (Get-Command javac -ErrorAction SilentlyContinue)) { throw 'Can JDK 17+ trong PATH.' }
$classPath = Join-Path $PSScriptRoot 'target'
$sourcePath = Join-Path $PSScriptRoot 'HttpLabServer.java'
New-Item -ItemType Directory -Path $classPath -Force | Out-Null
& javac --release 17 --add-modules jdk.httpserver -encoding UTF-8 -d $classPath $sourcePath
if ($LASTEXITCODE -ne 0) { throw 'Bien dich lab server that bai.' }
& java --add-modules jdk.httpserver '-Dfile.encoding=UTF-8' -cp $classPath HttpLabServer $Port
if ($LASTEXITCODE -ne 0) { throw 'Lab server khong khoi dong duoc hoac da dung voi loi.' }
