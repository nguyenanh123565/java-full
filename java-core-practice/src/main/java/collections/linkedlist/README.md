# LinkedList

## Dùng để làm gì
Danh sách liên kết đôi; có thể dùng như List hoặc Deque để thao tác hai đầu.

## Bắt buộc phải hiểu
- Mỗi node giữ phần tử và liên kết tới node trước/sau.
- Thêm/xóa ở hai đầu là O(1); tìm theo index có thể O(n).
- Chèn/xóa sau khi đã tìm node khác với chi phí tìm node.
- peek/poll trả null khi rỗng; getFirst/removeFirst ném NoSuchElementException.
- FIFO: thêm cuối, lấy đầu. LinkedList cho phép null nhưng dễ gây nhập nhằng với tín hiệu rỗng.

## Lỗi thường gặp
Cho rằng LinkedList luôn nhanh hơn ArrayList, lặp get(i) cho mọi index, gọi removeFirst khi list rỗng mà không xử lý.

## Tự kiểm tra
1. Vì sao get(i) cần duyệt liên kết?
2. peekFirst có làm size giảm không?
3. Để FIFO cần thêm và lấy ở đầu nào?
4. null từ pollFirst có luôn chứng minh list rỗng nếu list cho chứa null không?

## Ba bài tập
1. **Dễ:** Từ [B], thêm A đầu, C cuối; đọc và xóa đầu, giải thích peek/poll.
2. **Vừa:** Xử lý công việc An, Bình, Chi theo FIFO, giải thích thứ tự.
3. **Khó:** So sánh bốn API đọc/xóa đầu trên list rỗng và phân tích get(i).

Tự làm LinkedListExercise trước khi mở LinkedListSolution.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
