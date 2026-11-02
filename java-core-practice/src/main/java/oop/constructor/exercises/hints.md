# Gợi ý: Constructor và this

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## CTOR-01

**Mức 1 — khái niệm:** Tên tham số có thể che tên field.

**Mức 2 — hướng triển khai:** Chuẩn hóa trước hoặc ngay trong gán this.field; không để nhánh thiếu gán.

## CTOR-02

**Mức 1 — khái niệm:** Đi vào constructor được ủy quyền trước.

**Mức 2 — hướng triển khai:** Quay lại phần còn lại của constructor không tham số sau khi constructor có tham số kết thúc.

## CTOR-03

**Mức 1 — khái niệm:** Tên giống class vẫn có thể là method.

**Mức 2 — hướng triển khai:** Constructor không có void; field được chỉ rõ bằng this.minutes.

## CTOR-04

**Mức 1 — khái niệm:** Chọn constructor đầy đủ làm điểm đến.

**Mức 2 — hướng triển khai:** Trong Java 17, this(...) nằm ở câu lệnh đầu của constructor gọi nó.

## CTOR-05

**Mức 1 — khái niệm:** Copy field primitive tạo giá trị độc lập; String không cần sửa nội dung.

**Mức 2 — hướng triển khai:** Có thể ủy quyền constructor copy vào constructor đầy đủ, dùng điều kiện khi other null.
