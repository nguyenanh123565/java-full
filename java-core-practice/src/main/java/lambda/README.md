# Lambda

## Dùng để làm gì?
Biểu diễn ngắn một hành vi để truyền vào phương thức có functional interface.

## Những ý bắt buộc phải hiểu
- Functional interface có một phương thức abstract; có thể có default/static method.
- Predicate kiểm tra, Function biến đổi, Consumer nhận giá trị, Supplier tạo giá trị.
- Biến local được capture phải final hoặc effectively final.
- Lambda được gọi khi hành vi được thực thi, không chỉ khi khai báo.

## Lỗi người mới thường gặp
- Nhầm lambda với kết quả của việc gọi lambda.
- Thay đổi biến local đã được capture.
- Viết lambda dài và nhiều tác dụng phụ khiến khó đọc.

## Câu hỏi tự kiểm tra
1. Functional interface khác interface bất kỳ ở đâu?
2. Predicate<T> trả về kiểu gì?
3. Effectively final là gì?
4. andThen thực hiện hai phép biến đổi theo thứ tự nào?

## Ba bài tập từ dễ đến khó
1. Dễ: tạo IntUnaryOperator nhân ba; thử -2, 0, 4. Giải thích vì sao phải gọi applyAsInt mới có kết quả.
2. Vừa: tạo Predicate<Integer> kiểm tra tuổi >= 18, lọc [15, 18, 21] bằng vòng lặp. Giải thích vì sao lambda không tự duyệt danh sách.
3. Khó: dùng DoubleUnaryOperator giảm giá 10% rồi tính thuế 5%, ghép bằng andThen. Với giá 100 kết quả là 94.5; giải thích capture và thứ tự phép tính.

## Cách học
Đọc `LambdaDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`LambdaExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `LambdaSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes lambda.LambdaDemo` (sau khi biên dịch).


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
