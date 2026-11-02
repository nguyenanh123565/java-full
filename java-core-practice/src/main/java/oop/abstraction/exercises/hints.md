# Gợi ý: Trừu tượng bằng lớp abstract

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## ABS-01

**Mức 1 — khái niệm:** Tách hợp đồng cần cài đặt khỏi hành vi đã có.

**Mức 2 — hướng triển khai:** Lớp cụ thể cung cấp fee, cha có thể tự cung cấp label.

## ABS-02

**Mức 1 — khái niệm:** fee giữ công thức chung; rate là điểm thay đổi.

**Mức 2 — hướng triển khai:** Object thực tế quyết định instance method rate bị override.

## ABS-03

**Mức 1 — khái niệm:** So sánh tên và danh sách kiểu tham số.

**Mức 2 — hướng triển khai:** Thêm @Override giúp compiler chỉ ra chữ ký không phù hợp.

## ABS-04

**Mức 1 — khái niệm:** Trạng thái prefix là phần chung, nội dung tùy lớp con.

**Mức 2 — hướng triển khai:** render chỉ được caller gọi sau khi new hoàn tất.

## ABS-05

**Mức 1 — khái niệm:** Caller chỉ quan tâm kết quả hợp đồng fee.

**Mức 2 — hướng triển khai:** Giá tốt nhất ban đầu có thể là -1; chỉ cập nhật với phí >=0.
