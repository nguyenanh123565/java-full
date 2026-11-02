# Working tree → staging → commit

## 1. Problem — tại sao khái niệm tồn tại

Một lần sửa có nhiều ý tưởng nhưng một commit nên mô tả một thay đổi có ý nghĩa. Cần chọn nội dung nào đi vào snapshot kế tiếp.

## 2. Mental model

Có ba trạng thái nội dung: HEAD (commit hiện tại), index/staging và working tree. `git diff` so working tree với index; `git diff --cached` so index với HEAD.

## 3. Ví dụ nhỏ

Trong demo: giá 100 được commit; đổi 120 rồi add; đổi tiếp 150; commit kế tiếp ghi 120. 150 vẫn nằm ngoài commit.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: sửa phương thức không làm `.class` tự thay đổi, giống working tree không tự thành commit. HTTP: có thể commit controller cùng contract API. SQL: ghi migration và code sử dụng cột mới trong một commit có ý nghĩa.

## 5. Những lỗi thường gặp

`git add` rồi sửa tiếp nhưng tưởng commit đã chứa bản sau; dùng `git add .` mà chưa xem file; nhầm `git diff` rỗng với không có staged changes.

## 6. Câu hỏi tự kiểm tra

Vì sao một file có thể hiện ở cả staged và unstaged? `git commit` có gửi remote không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
