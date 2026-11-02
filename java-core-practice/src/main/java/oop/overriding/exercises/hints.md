# Gợi ý: Ghi đè giữ hợp đồng

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## OVR-01

**Mức 1 — khái niệm:** Lớp con có thể lấy kết quả của cha.

**Mức 2 — hướng triển khai:** Phân biệt sentinel -1 với một phí hợp lệ trước cộng phụ phí.

## OVR-02

**Mức 1 — khái niệm:** Trong describe, fee(n) tương đương this.fee(n).

**Mức 2 — hướng triển khai:** this vẫn là PriorityService dù thân describe được kế thừa.

## OVR-03

**Mức 1 — khái niệm:** So sánh tên từng ký tự.

**Mức 2 — hướng triển khai:** Annotation xác minh ý định ghi đè thay vì tạo method mới.

## OVR-04

**Mức 1 — khái niệm:** this.fee ngay trong fee của chính object sẽ quay lại đâu?

**Mức 2 — hướng triển khai:** Premium cần phụ phí 10 trên nền thường, không vô tình cộng thêm 5.

## OVR-05

**Mức 1 — khái niệm:** Kiểu trả về int không tự bảo đảm giá trị không âm.

**Mức 2 — hướng triển khai:** Caller dựa vào lời hứa của Service; implementation phải giữ lời hứa đó.
