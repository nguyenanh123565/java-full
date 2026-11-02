# Gợi ý: Phối hợp object bằng composition

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## COMP-01

**Mức 1 — khái niệm:** Hành vi tiêu thụ và trạng thái mực thuộc Ink.

**Mức 2 — hướng triển khai:** Printer gọi method collaborator thay vì chép field units.

## COMP-02

**Mức 1 — khái niệm:** Hai owner có thể giữ cùng một reference.

**Mức 2 — hướng triển khai:** Đếm lần new Ink, không đếm số field giữ Ink.

## COMP-03

**Mức 1 — khái niệm:** Xác định object nào có trách nhiệm tính công thức.

**Mức 2 — hướng triển khai:** Checkout điều phối và nhận quy tắc thay được, không tự nhận vai trò quy tắc.

## COMP-04

**Mức 1 — khái niệm:** Cấu trúc mảng và object phần tử là hai mức khác nhau.

**Mức 2 — hướng triển khai:** Copy từng reference tạo mảng mới nhưng không tạo Task mới.

## COMP-05

**Mức 1 — khái niệm:** Trách nhiệm in và định dạng hóa đơn thuộc hai collaborator khác nhau.

**Mức 2 — hướng triển khai:** Không format thành công trước khi biết print thành công.
