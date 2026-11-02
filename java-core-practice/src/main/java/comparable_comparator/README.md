# ComparableComparator

## Dùng để làm gì?
Định nghĩa thứ tự tự nhiên và nhiều quy tắc sắp xếp khác nhau cho object.

## Những ý bắt buộc phải hiểu
- Comparable<T>.compareTo định nghĩa thứ tự tự nhiên trong class.
- Comparator<T> là quy tắc bên ngoài; có thể kết hợp comparing, thenComparing, reversed.
- Kết quả âm/0/dương biểu thị trước/ngang/sau; cần bắc cầu và nhất quán.
- Integer.compare tránh tràn do phép trừ; thứ tự trong TreeSet nên nhất quán với equals.

## Lỗi người mới thường gặp
- Dùng a - b trong compare gây tràn int.
- Gọi reversed sau khi ghép khiến đảo toàn bộ quy tắc ngoài ý muốn.
- Nhầm so sánh thứ tự bằng 0 với equals trong mọi cấu trúc.

## Câu hỏi tự kiểm tra
1. Khi nào chọn Comparable và khi nào Comparator?
2. Vì sao phép trừ có thể làm comparator sai?
3. thenComparing dùng khi nào?
4. TreeSet xử lý hai phần tử compare bằng 0 như thế nào?

## Ba bài tập từ dễ đến khó
1. Dễ: Product implements Comparable<Product> theo id bằng String.compareTo; giải thích thứ tự tự nhiên.
2. Vừa: sắp xếp giá tăng, nếu cùng giá thì id tăng; giá dùng long và Long.compare hoặc comparingLong. Giải thích tie-break.
3. Khó: sắp xếp giá giảm nhưng id vẫn tăng khi cùng giá; thử P03=10, P01=20, P02=20 và giải thích đặt reversed ở đâu.

## Cách học
Đọc `ComparableComparatorDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`ComparableComparatorExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `ComparableComparatorSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes comparable_comparator.ComparableComparatorDemo` (sau khi biên dịch).


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
