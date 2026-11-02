# TwoSum

## Dùng để làm gì?
Tìm hai chỉ số khác nhau có tổng bằng target, luyện tra cứu bằng HashMap.

## Những ý bắt buộc phải hiểu
- Trả cặp index, không phải cặp giá trị; không tái sử dụng cùng index.
- Tra phần bù trước khi thêm phần tử hiện tại.
- Dùng long cho phép trừ phần bù để tránh overflow int.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Vì sao [3, 3], target=6 vẫn có nghiệm?
2. Vì sao phải lookup trước put?
3. Target và giá trị int có thể tạo phần bù ngoài int không?

## Ba bài tập từ dễ đến khó
1. Dễ: thử vét cạn [2, 7, 11, 15], target=9, tìm index [0, 1]; giải thích khác biệt index và value.
2. Vừa: viết twoSum(int[], int) dùng Map, trả [-1, -1] nếu không có nghiệm; [3, 3], target=6 phải dùng hai index. Giải thích O(n) kỳ vọng.
3. Khó: thử [], [3] target=6 và [Integer.MAX_VALUE, 1] target=Integer.MIN_VALUE (không có nghiệm toán học); giải thích overflow và chứng minh không dùng lại index.

## Cách học
Đọc `TwoSumDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`TwoSumExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `TwoSumSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.two_sum.TwoSumDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
