# Java Collections

## Dùng để làm gì?
Chọn cấu trúc lưu trữ theo truy cập, trùng lặp và thứ tự.

## Thứ tự học
1. [arraylist](arraylist/README.md)
2. [linkedlist](linkedlist/README.md)
3. [hashset](hashset/README.md)
4. [hashmap](hashmap/README.md)
5. [queue](queue/README.md)
6. [deque](deque/README.md)
7. [priorityqueue](priorityqueue/README.md)

## Những ý bắt buộc phải hiểu
- List cho phép trùng; Set xác định phần tử bằng nhau; Map ánh xạ key/value.
- HashMap/HashSet cần hợp đồng equals/hashCode.
- Queue FIFO, stack LIFO, PriorityQueue lấy theo độ ưu tiên.

## Lỗi người mới thường gặp
- Giả định HashMap/HashSet có thứ tự duyệt.
- Nhầm remove theo index với theo giá trị.
- Cho rằng iterator PriorityQueue đã sort.

## Câu hỏi tự kiểm tra
1. Khi nào dùng Map thay List?
2. Key mutable nguy hiểm như thế nào?
3. peek khác poll ở đâu?

## Ba bài tập từ dễ đến khó
1. Dễ: thao tác ArrayList và phân biệt copy/alias.
2. Vừa: làm HashSet/HashMap cùng equals_hashcode.
3. Khó: giải bài queue/deque/priorityqueue rồi áp dụng Valid Parentheses.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
