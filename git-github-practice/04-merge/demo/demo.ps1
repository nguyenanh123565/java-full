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
    git switch -c feature/search
    Write-LabFile 'search.txt' 'GET /products?name=Book'
    git add search.txt
    git commit -m 'Document search API'
    git switch main
    Write-LabFile 'api.txt' 'GET /products/{id}'
    git add api.txt
    git commit -m 'Document product lookup'
    git merge feature/search -m 'Merge product search'
    git log --all --graph --oneline
} finally {
    Pop-Location
}
