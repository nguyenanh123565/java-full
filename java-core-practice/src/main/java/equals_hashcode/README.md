# EqualsHashCode

## Dùng để làm gì?
Định nghĩa hai object bằng nhau theo giá trị và giúp HashSet/HashMap tìm đúng phần tử.

## Những ý bắt buộc phải hiểu
- == so identity với reference; equals mặc định từ Object cũng dùng identity.
- equals phải phản xạ, đối xứng, bắc cầu, nhất quán và trả false khi so với null.
- Hai object equals thì hashCode bắt buộc bằng nhau; cùng hashCode chưa đủ để equals.
- Không đổi field dùng cho equals/hashCode khi object đang là key hoặc phần tử HashSet.

## Lỗi người mới thường gặp
- Override equals mà quên hashCode.
- Dùng == cho String hoặc object có giá trị nghiệp vụ.
- Đưa field mutable vào key rồi thay đổi sau khi put.

## Câu hỏi tự kiểm tra
1. Cùng hashCode có chắc equals không?
2. Vì sao HashSet cần cả hashCode và equals?
3. Object bằng nhau theo ID có cần tên giống nhau không?
4. Làm sao thiết kế key để tránh lỗi do mutation?

## Ba bài tập từ dễ đến khó
1. Dễ: tạo StudentKey bất biến, equals/hashCode chỉ theo id; hai key id S01 có == false nhưng equals true. Giải thích identity và equality.
2. Vừa: thêm hai key S01 và một key S02 vào HashSet; size phải 2. Giải thích hợp đồng hashCode và equals.
3. Khó: put key S01 hai lần vào HashMap với giá trị khác, lấy bằng key S01 mới và chứng minh ghi đè. Giải thích vì sao giữ id final an toàn hơn key mutable.

## Cách học
Đọc `EqualsHashCodeDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`EqualsHashCodeExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `EqualsHashCodeSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes equals_hashcode.EqualsHashCodeDemo` (sau khi biên dịch).


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
