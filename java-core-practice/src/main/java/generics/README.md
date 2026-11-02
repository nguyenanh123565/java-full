# Generics

## Dùng để làm gì?
Viết cấu trúc và thuật toán dùng được với nhiều kiểu mà vẫn được kiểm tra kiểu lúc biên dịch.

## Những ý bắt buộc phải hiểu
- Tham số kiểu T đại diện cho kiểu tham chiếu; dùng Integer thay cho int.
- Box<Integer> không phải Box<Number>; generic là invariant.
- Giới hạn kiểu và wildcard: ? extends Number phù hợp để đọc Number.
- Type erasure: không thể new T() hoặc kiểm tra instanceof List<String>.

## Lỗi người mới thường gặp
- Dùng raw type làm mất kiểm tra kiểu.
- Ép kiểu Object khi generic đã giải quyết được.
- Cho rằng có thể thêm Integer vào List<? extends Number>.

## Câu hỏi tự kiểm tra
1. Generic giúp phát hiện lỗi vào thời điểm nào?
2. Vì sao Box<int> không hợp lệ?
3. Vì sao List<Integer> không gán được cho List<Number>?
4. Tại sao ? extends Number đọc được nhưng không thêm số tùy ý được?

## Ba bài tập từ dễ đến khó
1. Dễ: tạo Box<T> có constructor, get và set; dùng Box<String> và Box<Integer>. Giải thích vì sao không cần cast.
2. Vừa: viết <T> T first(T[] values); mảng rỗng phải ném IllegalArgumentException. Thử String[], Integer[] và giải thích kiểm tra kiểu.
3. Khó: tính tổng List<? extends Number> thành double; thử Integer và Double. Giải thích invariance và vì sao không thêm phần tử trong hàm.

## Cách học
Đọc `GenericsDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`GenericsExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `GenericsSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes generics.GenericsDemo` (sau khi biên dịch).


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
