# PriorityQueue

## Dùng để làm gì
Lấy phần tử ưu tiên nhất, chẳng hạn công việc có độ ưu tiên cao hoặc số nhỏ nhất.

## Bắt buộc phải hiểu
- Mặc định ưu tiên giá trị nhỏ theo natural ordering; có thể truyền Comparator.
- Cấu trúc heap chỉ đảm bảo phần tử đầu là phần tử ưu tiên nhất; toàn bộ cấu trúc không phải list đã sort.
- peek thường O(1); offer/poll O(log n). contains/remove(Object) thường O(n).
- Duyệt iterator, for-each và toString không đảm bảo thứ tự ưu tiên; poll liên tiếp thì có và đồng thời xóa phần tử.
- Cho phép trùng; không cho null. Không bảo đảm FIFO giữa phần tử có cùng độ ưu tiên.
- Nếu cần thứ tự rõ ràng khi hòa, thêm tiêu chí phụ như sequence.
- Không đổi trường dùng để so sánh khi object đang trong queue; heap không tự sắp lại vì object bị sửa.

## Lỗi thường gặp
Tưởng for-each in theo thứ tự sort, tưởng tie giữ thứ tự chèn, trừ hai số trong Comparator gây overflow, sửa priority trực tiếp khi đang trong queue.

## Tự kiểm tra
1. peek có xóa phần tử không?
2. Vì sao iterator không nhất thiết tăng dần?
3. Comparator.reverseOrder thay đổi phần tử đầu như thế nào?
4. Làm sao đảm bảo thứ tự giữa hai job cùng priority?

## Ba bài tập
1. **Dễ:** Thêm 5, 1, 3, 1; peek rồi poll hết, giải thích phần tử trùng.
2. **Vừa:** Lấy số lớn trước với Comparator, giải thích vì sao phải poll để thấy thứ tự ưu tiên.
3. **Khó:** Job A(2,0), B(1,1), C(1,2); so sánh priority rồi sequence, giải thích tie và tính bất biến.

Tự làm PriorityQueueExercise trước; PriorityQueueSolution dành cho đối chiếu.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
