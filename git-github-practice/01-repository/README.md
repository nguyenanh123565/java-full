# Repository: source code và lịch sử

## 1. Problem — tại sao khái niệm tồn tại

Lưu `Main-final-v2.java` không cho biết thay đổi nào thuộc một lần sửa hoặc ai sửa. Repository ghi các snapshot và quan hệ giữa chúng.

## 2. Mental model

Working directory chứa file nhìn thấy; `.git` chứa metadata, object và ref. Commit là snapshot có cha, message, tác giả. Git chỉ biết file sau khi bạn đưa nó vào lịch sử.

## 3. Ví dụ nhỏ

`git init -b main` tạo repository trống; `git status` mô tả trạng thái hiện tại; sau commit đầu, `git log --oneline` mới có lịch sử.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java Core: compiler đọc `.java`, còn Git lưu lịch sử file đó. HTTP: clone/push có thể dùng HTTPS nhưng repository vẫn tồn tại offline. SQL: commit Git là snapshot source, khác transaction commit dữ liệu đang chạy.

## 5. Những lỗi thường gặp

Khởi tạo repository lồng trong repository khác; tưởng Git tự lưu mọi lần gõ; commit file chứa mật khẩu; nhầm thư mục `.git` với source.

## 6. Câu hỏi tự kiểm tra

Có thể biên dịch Java khi không có Git không? Có thể có Git repo nhưng chưa có commit không? Clone khác tải một file ZIP ở đâu?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
