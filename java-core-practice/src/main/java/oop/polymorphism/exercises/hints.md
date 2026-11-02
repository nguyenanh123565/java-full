# Gợi ý: Đa hình qua lớp cha

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## POLY-01

**Mức 1 — khái niệm:** Caller chỉ cần kiểu Discount.

**Mức 2 — hướng triển khai:** Validation phải giống nhau giữa các implementation.

## POLY-02

**Mức 1 — khái niệm:** b sao chép reference ở thời điểm gán.

**Mức 2 — hướng triển khai:** Object HalfDiscount vẫn tồn tại và được b giữ.

## POLY-03

**Mức 1 — khái niệm:** Đổi int thành long tạo method khác.

**Mức 2 — hướng triển khai:** Override cần cùng tên và danh sách kiểu tham số phù hợp.

## POLY-04

**Mức 1 — khái niệm:** Giữ tương ứng chỉ số giữa input và output.

**Mức 2 — hướng triển khai:** Null là không có lựa chọn, không phải ưu đãi miễn phí.

## POLY-05

**Mức 1 — khái niệm:** Ưu đãi mới giữ cùng chữ ký và miền đầu vào.

**Mức 2 — hướng triển khai:** Trách nhiệm caller là gọi hợp đồng, không chọn công thức.
