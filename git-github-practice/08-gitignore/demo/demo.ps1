# Chỉ tạo và sửa repository học tập mới trong thư mục tạm.
$ErrorActionPreference = 'Stop'
$lab = Join-Path ([IO.Path]::GetTempPath()) ('backend-git-' + [guid]::NewGuid().ToString('N'))
New-Item -ItemType Directory -Path $lab | Out-Null
Write-Host "Sandbox: $lab"
Push-Location $lab
try {
    git init -b main
    git config user.name 'Backend Learner'
    git config user.email 'learner@example.invalid'
    function Write-LabFile([string]$name, [string]$value) {
        [IO.File]::WriteAllText((Join-Path $lab $name), $value, [Text.UTF8Encoding]::new($false))
    }
    Write-LabFile 'product.txt' "name=Book`nprice=100`n"
    git add product.txt
    git commit -m 'Add product seed'
    Write-LabFile '.gitignore' "target/`n.env`nproduct.txt`n"
    New-Item -ItemType Directory -Path (Join-Path $lab 'target') | Out-Null
    Write-LabFile 'target/output.txt' 'Generated output'
    Write-LabFile '.env' 'DB_PASSWORD=fake-only'
    Write-LabFile 'product.txt' "name=Book`nprice=130`n"
    git status --short
    git check-ignore -v target/output.txt .env
    git diff product.txt
} finally {
    Pop-Location
}
