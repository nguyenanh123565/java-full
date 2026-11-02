# Gợi ý: Kế thừa đúng quan hệ

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## INH-01

**Mức 1 — khái niệm:** Trạng thái cha được khởi tạo qua super.

**Mức 2 — hướng triển khai:** Con đọc tên sự kiện bằng hành vi cha cung cấp.

## INH-02

**Mức 1 — khái niệm:** Kiểu khai báo giới hạn API nhìn thấy.

**Mức 2 — hướng triển khai:** Gán sang kiểu cha không sao chép hoặc xóa phần seat.

## INH-03

**Mức 1 — khái niệm:** Java cần khởi tạo phần cha trong cùng object.

**Mức 2 — hướng triển khai:** Chuyển e vào super(e), không tạo new Ticket(e) phụ.

## INH-04

**Mức 1 — khái niệm:** Mọi loại vé phải giữ lời hứa price không âm.

**Mức 2 — hướng triển khai:** Kiến thức is-a quan trọng hơn việc có field cùng tên.

## INH-05

**Mức 1 — khái niệm:** Gom trạng thái chung ở cha, trạng thái ghế ở con.

**Mức 2 — hướng triển khai:** Hợp đồng tính theo ô, không theo identity duy nhất.
