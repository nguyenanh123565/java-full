# Git / GitHub — quản lý lịch sử thay đổi

Học ngay song song Java Core. Cần biết file/folder và sửa được một file Java; chưa cần Spring hay tài khoản GitHub ở bài 01–08. Git là công cụ lưu lịch sử tại máy; GitHub là dịch vụ chứa repository và cộng tác.

```text
File thay đổi (working tree)
→ git add
→ staging (ảnh chụp nội dung muốn ghi)
→ git commit
→ local repository (lịch sử trên máy)
→ git push
→ remote repository (bản sao lịch sử ở địa chỉ khác)
```

`add` lấy nội dung tại thời điểm gọi. Sửa file sau `add` tạo nội dung chưa stage; `commit` lấy staging, không tự gom mọi thay đổi. `push` chỉ gửi commit, không gửi thay đổi chưa commit. Remote tên `origin` là quy ước, không phải lệnh hay tài khoản GitHub.

Đọc lần lượt:

- [01-repository](01-repository/README.md)
- [02-working-tree-staging-commit](02-working-tree-staging-commit/README.md)
- [03-branch](03-branch/README.md)
- [04-merge](04-merge/README.md)
- [05-remote](05-remote/README.md)
- [06-pull-push](06-pull-push/README.md)
- [07-conflict](07-conflict/README.md)
- [08-gitignore](08-gitignore/README.md)
- [09-github-pull-request](09-github-pull-request/README.md)

Mỗi bài có demo PowerShell độc lập tạo repository trong thư mục tạm với tên ngẫu nhiên; script in đường dẫn để bạn tự kiểm tra. Không chạy `git init` trong workspace đang học. Đọc script, dự đoán, rồi khi muốn thực hành dùng `powershell -ExecutionPolicy Bypass -File .\demo\demo.ps1` từ bài tương ứng; đây chỉ là cách gọi script khi bạn đã chọn chạy, không có bước cài đặt. Bài 09 đọc demo kế hoạch Pull Request.

Hoàn thành [bài tổng hợp](exercises/README.md), dùng [cheatsheet](cheatsheet.md) để tra và ghi notes từng lesson. Sẵn sàng đi tiếp khi giải thích được vì sao file có thể vừa staged vừa modified, tự giải một conflict và đọc `git diff` trước commit. Không cần ghi nhớ mọi command.

Tham khảo chính thức: [Recording changes](https://git-scm.com/book/en/v2/Git-Basics-Recording-Changes-to-the-Repository). Các demo dùng local bare remote, không gửi dữ liệu lên mạng.
