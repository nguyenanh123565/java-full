# Gợi ý: Tổng hợp OOP: dữ liệu, hành vi và cộng tác

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## OOP-01

**Mức 1 — khái niệm:** Định nghĩa miền dữ liệu trước khi viết constructor.

**Mức 2 — hướng triển khai:** this phân biệt field với tham số cùng tên; phép nhân dùng long.

## OOP-02

**Mức 1 — khái niệm:** Đặt câu hỏi đơn đang lưu giá trị lúc mua hay liên kết dữ liệu sống.

**Mức 2 — hướng triển khai:** Chia sẻ object có lợi nhưng phải đúng yêu cầu nghiệp vụ.

## OOP-03

**Mức 1 — khái niệm:** Điều kiện null và chỗ trống phải được xét trước thao tác ghi.

**Mức 2 — hướng triển khai:** Chỉ tăng count sau khi đã có vị trí hợp lệ.

## OOP-04

**Mức 1 — khái niệm:** Có dữ liệu giống nhau không đủ để là quan hệ is-a.

**Mức 2 — hướng triển khai:** Lớp con không nên phá điều kiện mà caller của cha dựa vào.

## OOP-05

**Mức 1 — khái niệm:** Interface đặt hợp đồng; abstract class có thể chia sẻ state và code.

**Mức 2 — hướng triển khai:** Hai lựa chọn có thể phục vụ cùng caller nhưng chi phí liên kết khác nhau.

## OOP-06

**Mức 1 — khái niệm:** Receipt có một formatter, không phải một formatter.

**Mức 2 — hướng triển khai:** Giữ dữ liệu và quy tắc trình bày tách nhau để caller thay được.

## OOP-07

**Mức 1 — khái niệm:** Tổng là dữ liệu suy ra, không cần setter.

**Mức 2 — hướng triển khai:** Kiểm tra trạng thái, sức chứa và toàn bộ input trước tạo/thêm dòng.

## OOP-08

**Mức 1 — khái niệm:** Tách bất biến đơn khỏi hành vi định dạng thông báo; caller dựa hợp đồng kênh.

**Mức 2 — hướng triển khai:** Kiểm tra toàn bộ cấu hình trước duyệt render để tránh kết quả từng phần; tạo object kênh ở điểm lắp ráp.
