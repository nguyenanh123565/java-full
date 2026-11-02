# Gợi ý: Đóng gói và trạng thái hợp lệ

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## ENC-01

**Mức 1 — khái niệm:** Viết điều kiện bất biến trước khi viết API.

**Mức 2 — hướng triển khai:** So sánh amount với phần sức chứa còn lại trước khi cộng.

## ENC-02

**Mức 1 — khái niệm:** False có hoàn tác phép gán đã chạy không?

**Mức 2 — hướng triển khai:** Phân biệt trả kết quả kiểm tra với chặn thay đổi trạng thái.

## ENC-03

**Mức 1 — khái niệm:** Không thay đổi field để thử xem thao tác có hợp lệ không.

**Mức 2 — hướng triển khai:** Dùng seats <= capacity - booked rồi mới cộng.

## ENC-04

**Mức 1 — khái niệm:** Viết một điều kiện bao trùm cả hai mốc.

**Mức 2 — hướng triển khai:** Chỉ sau khi cả cặp hợp lệ mới ghi hai field.

## ENC-05

**Mức 1 — khái niệm:** Tái dùng quy tắc kiểm tra đã suy luận, không chép code lỗi.

**Mức 2 — hướng triển khai:** Hàm tổng chỉ quan sát qua getter; Room tự bảo vệ trạng thái.
