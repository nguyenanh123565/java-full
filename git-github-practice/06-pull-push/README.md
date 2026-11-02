# Fetch, pull, push: trao đổi commit

## 1. Problem — tại sao khái niệm tồn tại

Mỗi người có local history riêng. Cần đưa commit lên remote và nhận commit của người khác mà không mất thay đổi.

## 2. Mental model

`push` gửi commit và đề nghị cập nhật ref remote. `fetch` cập nhật remote-tracking refs như origin/main, không tự sửa working tree. `pull` fetch rồi tích hợp theo cấu hình; bài dùng `--ff-only` để chỉ nhận khi có thể tiến thẳng.

## 3. Ví dụ nhỏ

Demo dùng hai clone cùng bare remote: A push, B clone và commit rồi push, A `pull --ff-only` nhận commit.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: sau pull vẫn cần build. HTTP: push source không đồng nghĩa API đang chạy đã deploy. SQL: pull file migration không tự thực thi SQL.

## 5. Những lỗi thường gặp

Pull khi còn thay đổi chưa commit; push bị từ chối rồi dùng force bừa; nghĩ push tự deploy; tưởng pull lúc nào cũng merge commit.

## 6. Câu hỏi tự kiểm tra

Fetch thay đổi file hiện tại không? Push uncommitted file được không? Vì sao ff-only từ chối khi local và remote phân nhánh?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
