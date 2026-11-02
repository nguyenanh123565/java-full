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
    $remote = Join-Path $lab 'remote.git'
    $peer = Join-Path $lab 'peer'
    git init --bare -b main $remote
    git remote add origin $remote
    git push -u origin main
    git clone $remote $peer
    git -C $peer config user.name 'Second Learner'
    git -C $peer config user.email 'peer@example.invalid'
    [IO.File]::WriteAllText((Join-Path $peer 'api.txt'), 'GET /products', [Text.UTF8Encoding]::new($false))
    git -C $peer add api.txt
    git -C $peer commit -m 'Add API contract from peer'
    git -C $peer push origin main
    git fetch origin
    git log --all --graph --oneline
    git pull --ff-only
    git status
} finally {
    Pop-Location
}
