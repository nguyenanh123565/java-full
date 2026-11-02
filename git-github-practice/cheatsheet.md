# Git cheatsheet — tra sau khi hiểu model

| Mục đích | Lệnh | Đọc gì? |
|---|---|---|
| Trạng thái | `git status --short` | untracked / staged / unstaged |
| Chưa stage | `git diff` | working tree so index |
| Sắp commit | `git diff --cached` | index so HEAD |
| Chọn snapshot | `git add <file>` | nội dung tại thời điểm add |
| Ghi lịch sử | `git commit -m "Describe behavior"` | snapshot staging, chỉ local |
| Xem lịch sử | `git log --all --graph --oneline` | quan hệ commit, không chỉ ngày |
| Xem snapshot | `git show HEAD:path/to/file` | nội dung đã commit |
| Tạo/chuyển nhánh | `git switch -c feature/name` / `git switch main` | branch hiện tại |
| Tích hợp | `git merge feature/name` | branch hiện tại nhận thay đổi |
| Địa chỉ remote | `git remote -v` | origin không phải branch |
| Nhận lịch sử | `git fetch origin` | cập nhật origin/main |
| Nhận và tiến thẳng | `git pull --ff-only` | từ chối khi phân nhánh |
| Gửi commit | `git push -u origin main` | đặt upstream lần đầu |
| Kiểm tra ignore | `git check-ignore -v <file>` | pattern áp dụng |
| Hủy merge dở | `git merge --abort` | chỉ dùng khi hiểu trạng thái sandbox |

Trước add đọc diff; trước commit đọc cached diff; trước push đọc log. `git pull` khác Pull Request. Không cần reset --hard, clean -fd hoặc force push để học các bài này.
