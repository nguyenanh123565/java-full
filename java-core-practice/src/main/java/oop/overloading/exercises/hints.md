# Gợi ý: Nạp chồng rõ ý định

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## OVL-01

**Mức 1 — khái niệm:** Overload tiện dụng có thể gọi overload đầy đủ.

**Mức 2 — hướng triển khai:** Dấu phân cách cần căn cứ vị trí, kể cả text rỗng.

## OVL-02

**Mức 1 — khái niệm:** Ưu tiên khớp int chính xác nếu có.

**Mức 2 — hướng triển khai:** short có thể mở rộng int hoặc long, int là lựa chọn cụ thể hơn.

## OVL-03

**Mức 1 — khái niệm:** Tên tham số không nằm trong chữ ký method.

**Mức 2 — hướng triển khai:** Kiểu trả về chỉ được xét sau khi đã chọn được method.

## OVL-04

**Mức 1 — khái niệm:** So sánh danh sách kiểu theo đúng thứ tự.

**Mức 2 — hướng triển khai:** int,int đổi tên biến vẫn giữ cùng danh sách kiểu.

## OVL-05

**Mức 1 — khái niệm:** Receiver FancyFormatter và đối số String là hai vai trò khác nhau.

**Mức 2 — hướng triển khai:** Runtime chỉ xét override của chữ ký compiler đã chọn.
