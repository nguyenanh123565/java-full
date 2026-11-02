# Queue

## Dùng để làm gì
Lưu công việc chờ xử lý. ArrayDeque dùng qua Queue tạo hàng đợi FIFO.

## Bắt buộc phải hiểu
- Queue là interface; chính implementation quyết định thứ tự. PriorityQueue là ngoại lệ với thứ tự ưu tiên.
- Với ArrayDeque: offer thêm cuối, poll lấy/xóa đầu, peek xem đầu.
- poll/peek trả null khi rỗng; remove/element ném NoSuchElementException.
- Trong queue có giới hạn sức chứa, offer có thể trả false; add có thể ném IllegalStateException. ArrayDeque tự mở rộng.
- ArrayDeque không cho null và không tự an toàn khi nhiều thread cùng sửa.

## Lỗi thường gặp
Nhầm peek làm mất phần tử, gọi remove trên queue rỗng, giả định mọi Queue đều FIFO, vừa duyệt for-each vừa thêm/xóa cấu trúc.

## Tự kiểm tra
1. peek và poll khác nhau ở điểm nào?
2. Queue có phải class để dùng new Queue không?
3. Vì sao null bị cấm trong ArrayDeque?
4. PriorityQueue có xử lý theo thời điểm thêm vào không?

## Ba bài tập
1. **Dễ:** offer A/B, peek rồi poll đến rỗng; giải thích size.
2. **Vừa:** So sánh bốn API khi rỗng và giải thích việc cấm null.
3. **Khó:** Xử lý A/B/C, thêm D khi xử lý A; giải thích thứ tự và cách tránh sửa khi đang duyệt iterator.

Tự làm QueueExercise trước; QueueSolution dành cho đối chiếu.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
