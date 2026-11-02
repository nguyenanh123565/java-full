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
    Write-LabFile 'product.txt' "name=Book`nprice=120`n"
    git add product.txt
    Write-LabFile 'product.txt' "name=Book`nprice=150`n"
    git diff
    git diff --cached
    git status --short
    git commit -m 'Update staged price to 120'
    git show HEAD:product.txt
    git status --short
} finally {
    Pop-Location
}
