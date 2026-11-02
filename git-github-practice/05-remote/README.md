# Remote và origin: địa chỉ chia sẻ lịch sử

## 1. Problem — tại sao khái niệm tồn tại

Lịch sử chỉ nằm một máy sẽ khó chia sẻ hoặc phục hồi khi mất máy. Cần địa chỉ một repository khác.

## 2. Mental model

Remote là tên gắn với URL/path. `origin` là tên quy ước do clone thường tạo. Bare repository lưu lịch sử, không có working tree để sửa source trực tiếp.

## 3. Ví dụ nhỏ

`git remote add origin <path>` chỉ lưu địa chỉ; chưa gửi commit. Demo dùng bare repo cùng máy để quan sát mà không cần mạng.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: local source vẫn compile khi remote tắt. HTTP: HTTPS là một giao thức vận chuyển Git, không phải REST API của app. SQL: remote Git không sao lưu dữ liệu DB; không commit DB dump chứa dữ liệu riêng.

## 5. Những lỗi thường gặp

Tưởng add remote tự push; nhầm origin với branch main; đăng mật khẩu/token vào URL hoặc file cấu hình.

## 6. Câu hỏi tự kiểm tra

Một repo có nhiều remote được không? Remote có bắt buộc là GitHub? Add origin có cần Internet không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
