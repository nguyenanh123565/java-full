# Gợi ý: PriorityQueue theo số tự nhiên

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## PQ-01 — Lấy k phần tử nhỏ nhất

1. **Mức 1:** Tạo queue riêng từ nguồn.
2. **Mức 2:** Poll tối đa k lần hoặc đến khi rỗng.

## PQ-02 — Peek sau khi chèn mới

1. **Mức 1:** Mỗi lần chỉ head được bảo đảm nhỏ nhất.
2. **Mức 2:** Poll đầu là 3, sau khi offer(1) head đổi.

## PQ-03 — Xem trước làm mất dữ liệu

1. **Mức 1:** Poll luôn xóa.
2. **Mức 2:** Tạo PriorityQueue mới bằng constructor nhận queue.

## PQ-04 — Ghép hai đoạn ngắn nhất

1. **Mức 1:** Kiểm tra tổng bằng long trước khi tính.
2. **Mức 2:** Lặp khi queue.size()>1; chi phí tích lũy long.

## PQ-05 — Bộ lịch đợi theo thời điểm

1. **Mức 1:** Peek để xem đã tới hạn trước khi poll.
2. **Mức 2:** while không rỗng và peek<=now.
