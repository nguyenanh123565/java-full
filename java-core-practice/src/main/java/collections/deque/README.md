# Deque

## Dùng để làm gì
Hàng đợi hai đầu; có thể dùng như queue FIFO hoặc stack LIFO. Phù hợp lưu lịch sử undo.

## Bắt buộc phải hiểu
- Deque là interface; ArrayDeque là implementation thường dùng cho stack/queue một thread.
- offerFirst/offerLast thêm vào đầu/cuối; pollFirst/pollLast lấy/xóa ở đầu/cuối.
- push tương đương addFirst; pop tương đương removeFirst, ném ngoại lệ nếu rỗng.
- FIFO: thêm cuối, lấy đầu. LIFO: thêm đầu, lấy đầu.
- ArrayDeque không chứa null; các thao tác đầu/cuối thường O(1) phân bổ.

## Lỗi thường gặp
Trộn đầu thêm/lấy dẫn tới sai thứ tự, pop khi rỗng, tưởng lưu lịch sử là đã hoàn tác trạng thái nghiệp vụ.

## Tự kiểm tra
1. push thêm ở đầu nào?
2. Chọn cặp thao tác nào để tạo FIFO?
3. pollFirst và pop khác nhau thế nào khi rỗng?
4. Vì sao undo thường dùng LIFO?

## Ba bài tập
1. **Dễ:** offerLast 1/2, offerFirst 0, pollFirst/pollLast; vẽ trạng thái và giải thích.
2. **Vừa:** So sánh FIFO/LIFO với A/B/C, giải thích thứ tự.
3. **Khó:** Lưu Insert A, Insert B, Delete A; mô phỏng undo bằng pop, xử lý rỗng và giải thích LIFO.

Tự làm DequeExercise trước khi mở DequeSolution.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
