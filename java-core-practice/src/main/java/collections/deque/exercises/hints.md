# Gợi ý: Deque

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## DQ-01 — Ghép hai đầu

1. **Mức 1:** Lấy đầu trước; chỉ lấy cuối nếu vẫn còn phần tử.
2. **Mức 2:** Không add tín hiệu null vào kết quả.

## DQ-02 — Trộn stack và queue

1. **Mức 1:** push tương đương addFirst.
2. **Mức 2:** Sau ba lệnh thêm: B,A,C.

## DQ-03 — Redo bị đảo thứ tự

1. **Mức 1:** Cả undo và redo đều là stack.
2. **Mức 2:** Đẩy và lấy cùng đầu; ghi lại text hiện tại trước khi chuyển trạng thái.

## DQ-04 — Kiểm tra chuỗi đối xứng bằng deque

1. **Mức 1:** Mỗi vòng so một cặp đối xứng.
2. **Mức 2:** Lặp khi deque.size()>1.

## DQ-05 — Editor undo/redo bằng snapshot

1. **Mức 1:** Lưu snapshot cũ trước mỗi thay đổi.
2. **Mức 2:** String bất biến có thể lưu trực tiếp, không cần deep copy.
