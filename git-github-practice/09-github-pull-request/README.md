# Pull Request: đề nghị review một thay đổi

## 1. Problem — tại sao khái niệm tồn tại

Nhóm cần đọc mục tiêu, diff và bằng chứng kiểm tra trước khi tích hợp code. Push chỉ chia sẻ commit, chưa tạo cuộc trao đổi review.

## 2. Mental model

Pull Request (PR) là đối tượng cộng tác của GitHub, so head branch với base branch. Reviewer đọc diff, hỏi lý do và kiểm tra; merge là hành động Git tích hợp sau quyết định đó.

## 3. Ví dụ nhỏ

Base `main`, head `feature/search`; PR mô tả thêm `GET /products?name=...`, cách test và giới hạn. Demo là checklist, không tự mở PR hoặc gửi message.

Đọc [demo](demo/README.md); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: ghi test thuật toán lọc. HTTP: cung cấp request/status/body mẫu. SQL: mô tả query và ảnh hưởng schema. Đó là bằng chứng review, không chỉ danh sách file.

## 5. Những lỗi thường gặp

Đổi nhầm base/head; PR chứa nhiều việc không liên quan; chỉ ghi “done”; nghĩ mở PR tự deploy hoặc tự merge.

## 6. Câu hỏi tự kiểm tra

Git hoạt động khi không có PR không? Reviewer cần biết gì để tự xác nhận behavior? PR khác pull command ở đâu?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
