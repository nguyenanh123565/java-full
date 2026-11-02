# CountFrequency

## Dùng để làm gì?
Dùng Map để đếm số lần xuất hiện của từng số nguyên.

## Những ý bắt buộc phải hiểu
- Key là giá trị, value là số lần gặp.
- getOrDefault xử lý key chưa có.
- LinkedHashMap giữ thứ tự gặp đầu; HashMap không hứa thứ tự.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Tại sao key trùng chỉ có một entry?
2. getOrDefault khác get ở đâu?
3. Độ phức tạp kỳ vọng là gì nếu hashing hoạt động tốt?

## Ba bài tập từ dễ đến khó
1. Dễ: đếm tay [2, 1, 2, -1, 1]; giải thích key/value trong kết quả.
2. Vừa: viết frequency(int[]) trả Map<Integer, Integer>, giữ thứ tự gặp đầu. Giải thích bước tăng số đếm.
3. Khó: thử [], [5, 5, 5] và số âm; giải thích vì sao tổng các value bằng độ dài mảng, cùng O(n) kỳ vọng và O(k) bộ nhớ.

## Cách học
Đọc `CountFrequencyDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`CountFrequencyExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `CountFrequencySolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.count_frequency.CountFrequencyDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
