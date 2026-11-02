# Gợi ý: Queue FIFO

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## QU-01 — Xử lý theo lô

1. **Mức 1:** Dừng khi đủ max hoặc queue rỗng.
2. **Mức 2:** Dùng vòng while với hai điều kiện, poll cho mỗi lượt.

## QU-02 — Peek hai lần không tiến hàng

1. **Mức 1:** peek không mutation.
2. **Mức 2:** Chỉ poll thứ ba làm size giảm.

## QU-03 — Retry vô hạn

1. **Mức 1:** Cần trạng thái số lần thử gắn với job.
2. **Mức 2:** Nếu thất bại lần 1 thì offer lại, lần 2 kết thúc FAILED.

## QU-04 — Quầy phục vụ theo lượt

1. **Mức 1:** Chọn Queue<String> với ArrayDeque.
2. **Mức 2:** join dùng offer; serveNext dùng poll.

## QU-05 — Lịch chạy công việc không trùng

1. **Mức 1:** Queue giữ thứ tự; Set giữ mã đang chờ.
2. **Mức 2:** Chỉ offer khi set.add true; sau poll nhớ remove khỏi set.
