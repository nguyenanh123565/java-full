# Volume: dữ liệu có vòng đời riêng container

## 1. Problem — tại sao khái niệm tồn tại

Container có thể được thay thế khi cập nhật app/image. Database row cần được giữ dù container cũ không còn.

## 2. Mental model

Writable layer thuộc container; named volume là storage có vòng đời riêng do Docker quản lý. Mount đúng data directory của PostgreSQL 17: `/var/lib/postgresql/data`. Volume không phải Git repo hoặc backup tự động.

## 3. Ví dụ nhỏ

`pg_data` trong Compose gắn vào DB data directory. Restart/recreate không xóa named volume; command down mặc định giữ nó. Bài không dùng down -v.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: object memory mất khi JVM dừng; row DB lưu bền qua volume. HTTP: POST thành công cần xác định dữ liệu thực đã commit. SQL: transaction durability dựa DB/storage, không dựa source Java.

## 5. Những lỗi thường gặp

Tưởng mọi file container bền; mount sai directory; xóa volume để sửa lỗi rồi mất bài; nghĩ volume là bản backup ở nơi khác.

## 6. Câu hỏi tự kiểm tra

Volume khác bind mount ở đâu? Restart app có làm mất product không? Dữ liệu bền có thay thế backup không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
