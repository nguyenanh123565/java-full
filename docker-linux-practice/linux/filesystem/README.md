# Linux filesystem: đường dẫn và working directory

## 1. Problem — tại sao khái niệm tồn tại

App cần tìm JAR, resource và file log. Đường dẫn sai làm code đúng vẫn không đọc được dữ liệu.

## 2. Mental model

Tree bắt đầu từ `/`; absolute path bắt đầu `/`, relative path tính từ current directory. `/tmp` dùng dữ liệu tạm, `/etc` thường là cấu hình hệ thống. Tên file trên Linux thường phân biệt hoa/thường.

## 3. Ví dụ nhỏ

`pwd` cho biết đang ở đâu; `ls -la` xem file; `mkdir` tạo thư mục thử; `cat` đọc file nhỏ. Không cần sudo.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: Path.of("data.txt") phụ thuộc working directory; classpath resource là cơ chế khác. HTTP: `/products` là đường dẫn URL, không phải thư mục Linux. SQL: database row không biến thành file CSV trong cwd.

## 5. Những lỗi thường gặp

Nhầm URL path với file path; dùng tên File.txt rồi đọc file.txt; sửa thư mục hệ thống; tưởng cd làm đổi classpath JAR.

## 6. Câu hỏi tự kiểm tra

Đường dẫn tương đối tính từ đâu? `/app/app.jar` trong container có phải cùng file path trên host? Vì sao thiếu file khác thiếu table?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
