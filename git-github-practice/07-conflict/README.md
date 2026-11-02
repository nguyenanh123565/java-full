# Conflict: Git cần quyết định từ con người

## 1. Problem — tại sao khái niệm tồn tại

Hai branch cùng đổi một dòng theo hai ý nghĩa khác nhau. Git không thể đoán hành vi sản phẩm cần giữ.

## 2. Mental model

Conflict là trạng thái tích hợp chưa hoàn tất. Marker `<<<<<<<`, `=======`, `>>>>>>>` biểu diễn hai lựa chọn; người học đọc ý nghĩa, sửa nội dung cuối, add rồi commit.

## 3. Ví dụ nhỏ

Hai branch đổi giá 100 thành 120 và 150. Merge tạo conflict. Demo cố ý dừng tại đó và in đường dẫn sandbox để tự giải.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: xóa marker chưa chắc phương thức đúng. HTTP: xác định contract cuối khi hai branch đổi status code. SQL: quyết định giá đúng theo nghiệp vụ, không theo nhánh nào mới hơn.

## 5. Những lỗi thường gặp

Giữ cả marker trong file; chọn toàn bộ ours/theirs mà không đọc; add trước khi kiểm tra; coi conflict là mất source.

## 6. Câu hỏi tự kiểm tra

Git còn giữ hai phía không? Vì sao cần test sau giải conflict? Có thể cancel merge bằng `git merge --abort` trong repo thử không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
