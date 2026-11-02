param([ValidateRange(1, 65535)][int]$Port = 3000)

$ErrorActionPreference = 'Stop'
[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new($false)
if (-not (Get-Command javac -ErrorAction SilentlyContinue)) { throw 'Can JDK 17+ trong PATH.' }
$classPath = Join-Path $PSScriptRoot 'target'
New-Item -ItemType Directory -Path $classPath -Force | Out-Null
& javac --release 17 --add-modules jdk.httpserver -encoding UTF-8 -d $classPath (Join-Path $PSScriptRoot 'CorsClientServer.java')
if ($LASTEXITCODE -ne 0) { throw 'Bien dich browser demo that bai.' }
& java --add-modules jdk.httpserver '-Dfile.encoding=UTF-8' -cp $classPath CorsClientServer $Port (Join-Path $PSScriptRoot 'cors-demo.html')
if ($LASTEXITCODE -ne 0) { throw 'Browser demo khong khoi dong duoc hoac da dung voi loi.' }
