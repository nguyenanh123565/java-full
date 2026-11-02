# Branch: tên trỏ vào một dòng lịch sử

## 1. Problem — tại sao khái niệm tồn tại

Muốn thử tính năng tìm product mà vẫn giữ bản main dễ đọc. Copy cả project làm mất quan hệ lịch sử.

## 2. Mental model

Branch là tên ref trỏ tới commit; HEAD cho biết branch/commit đang checkout. Tạo branch không copy toàn bộ thư mục. Commit mới làm branch hiện tại tiến lên.

## 3. Ví dụ nhỏ

`git switch -c feature/search` tạo và chuyển branch; sau commit ở branch mới, `git switch main` đưa file về snapshot của main.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: dùng branch để thay thuật toán tìm kiếm rồi so hành vi. HTTP: thử endpoint mới mà main vẫn giữ API cũ. SQL: file migration đi theo branch, database đang chạy không tự đổi theo branch.

## 5. Những lỗi thường gặp

Tưởng đổi branch là đổi database; để thay đổi chưa commit rồi switch dẫn tới mang theo thay đổi hoặc bị chặn; coi branch là thư mục.

## 6. Câu hỏi tự kiểm tra

Branch nào tiến khi commit? Vì sao log main chưa thấy commit feature? Dữ liệu PostgreSQL có đổi khi switch không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
