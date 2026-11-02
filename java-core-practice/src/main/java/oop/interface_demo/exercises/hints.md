# Gợi ý: Hợp đồng bằng interface

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## INT-01

**Mức 1 — khái niệm:** Class cụ thể tạo object, interface làm kiểu.

**Mức 2 — hướng triển khai:** Kiểu trả về và danh sách tham số phải đúng hợp đồng.

## INT-02

**Mức 1 — khái niệm:** Hai kiểu reference có thể nhìn hai vai trò của cùng object.

**Mức 2 — hướng triển khai:** State on nằm trong Lamp, không nằm riêng trong interface.

## INT-03

**Mức 1 — khái niệm:** Method abstract thông thường trong interface mặc định public.

**Mức 2 — hướng triển khai:** Implementation phải đáp ứng quyền gọi mà interface hứa với caller.

## INT-04

**Mức 1 — khái niệm:** Chỉ caller xử lý chỗ không có formatter.

**Mức 2 — hướng triển khai:** Quy tắc định dạng thuộc từng implementation.

## INT-05

**Mức 1 — khái niệm:** Mỗi Rule kiểm tra một quy tắc; caller kết hợp bằng AND.

**Mức 2 — hướng triển khai:** Mảng rỗng không có quy tắc thất bại; null biểu diễn cấu hình thiếu.
