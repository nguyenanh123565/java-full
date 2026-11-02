# FindMin

## Dùng để làm gì?
Tìm phần tử nhỏ nhất bằng một lượt duyệt, kể cả toàn số dương.

## Những ý bắt buộc phải hiểu
- Khởi tạo từ dữ liệu thực thay vì 0.
- Định nghĩa rõ hành vi với mảng rỗng.
- O(n) thời gian và O(1) bộ nhớ phụ.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Khởi tạo bằng 0 sai ở trường hợp nào?
2. Bất biến vòng lặp của min là gì?
3. So sánh có làm tràn số không?

## Ba bài tập từ dễ đến khó
1. Dễ: dự đoán min của [7, 2, 9], [5], [3, 3]; giải thích lỗi khi khởi tạo 0.
2. Vừa: viết findMin(int[]) không dùng Stream; mảng rỗng ném IllegalArgumentException. Giải thích tính đúng đắn và O(n).
3. Khó: kiểm tra mảng rỗng và [Integer.MAX_VALUE, 1]; giải thích vì sao không nên tìm min bằng phép trừ.

## Cách học
Đọc `FindMinDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`FindMinExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `FindMinSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.find_min.FindMinDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
