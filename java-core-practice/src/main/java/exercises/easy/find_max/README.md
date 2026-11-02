# FindMax

## Dùng để làm gì?
Duyệt mảng để tìm phần tử lớn nhất và xây dựng bất biến vòng lặp.

## Những ý bắt buộc phải hiểu
- Không khởi tạo max bằng 0 khi mảng có toàn số âm.
- Mảng rỗng: ném IllegalArgumentException; không giả sử tồn tại phần tử đầu.
- Một lượt duyệt O(n), bộ nhớ phụ O(1).

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Vì sao bắt đầu bằng phần tử đầu thay vì 0?
2. Bất biến sau khi đã duyệt i phần tử là gì?
3. Mảng một phần tử được xử lý thế nào?

## Ba bài tập từ dễ đến khó
1. Dễ: dự đoán max của [-7, -2, -9], [5], [3, 3]; giải thích vì sao khởi tạo 0 sẽ sai.
2. Vừa: viết findMax(int[]) không dùng Stream; mảng rỗng ném IllegalArgumentException. Giải thích bất biến và O(n).
3. Khó: kiểm tra mảng rỗng và [Integer.MIN_VALUE, -1]; chứng minh thuật toán không sửa mảng gốc và không cần phép cộng.

## Cách học
Đọc `FindMaxDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`FindMaxExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `FindMaxSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.find_max.FindMaxDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
