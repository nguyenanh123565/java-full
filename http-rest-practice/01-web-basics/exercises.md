# Bài tập 01 — Web basics

Chỉ viết câu trả lời của bạn ở dưới các TODO. Chưa mở solutions trước khi tự giải thích.

## TODO 1 — Dễ: xác định vai trò

Ứng dụng điện thoại cần hiển thị danh sách users được lưu trong PostgreSQL.

- Vẽ các bước từ thao tác của người dùng đến lúc hiển thị kết quả.
- Gắn nhãn client, backend và database.
- Giải thích vì sao điện thoại thường không nhận mật khẩu PostgreSQL để truy cập trực tiếp.

**Bài làm của tôi:** TODO

## TODO 2 — Vừa: lỗi nằm ở đâu?

Phân tích ba tình huống độc lập: server chưa chạy; server chạy nhưng URL không tồn tại; server nhận request nhưng database mất kết nối.

- Trường hợp nào chắc chắn chưa có HTTP response từ backend?
- Trường hợp nào backend có thể trả HTTP response? Chưa cần học thuộc status code.
- Vì sao chỉ đổi SQL không thể sửa cả ba lỗi?

**Bài làm của tôi:** TODO

## TODO 3 — Khó: hai thiết bị

Backend chạy trên máy tính ở cổng 8080. Điện thoại trên cùng Wi-Fi gọi `http://localhost:8080/health` nhưng thất bại.

- Giải thích `localhost` đang trỏ vào đâu trên mỗi thiết bị.
- Đề xuất địa chỉ cần kiểm tra và các điều kiện về mạng, địa chỉ lắng nghe và firewall.
- Vì sao một request thành công từ máy tính chưa chứng minh điện thoại có thể gọi được?
- Đây là bài phân tích; không cần mở server lab ra mạng để làm bài.

**Bài làm của tôi:** TODO
