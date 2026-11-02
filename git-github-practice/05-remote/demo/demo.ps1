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
    git init --bare -b main $remote
    git remote add origin $remote
    git remote -v
    git --git-dir=$remote log --oneline
    # Remote chưa có commit nên lệnh log ở trên báo nhánh chưa có lịch sử; đây là quan sát chủ ý.
} finally {
    Pop-Location
}
