# ReverseArray

## Dùng để làm gì?
Luyện hai con trỏ và phân biệt thay đổi array với gán lại reference.

## Những ý bắt buộc phải hiểu
- Đổi chỗ từ hai đầu; dừng khi left >= right.
- Đảo tại chỗ O(n), O(1) bộ nhớ phụ.
- Alias quan sát cùng thay đổi; clone tạo mảng độc lập.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Vì sao cần biến tạm khi swap?
2. Mảng lẻ có cần đổi phần tử giữa không?
3. Vì sao alias thấy thay đổi còn clone không thấy?

## Ba bài tập từ dễ đến khó
1. Dễ: vẽ các bước đổi chỗ [1, 2, 3, 4] và [1, 2, 3]; giải thích điểm dừng.
2. Vừa: viết void reverse(int[]) tại chỗ; mảng rỗng hợp lệ. Giải thích vì sao O(1) bộ nhớ phụ.
3. Khó: cho b = a và c = a.clone(), đảo a; dự đoán b và c, rồi kiểm tra đảo hai lần khôi phục mảng ban đầu. Giải thích pass-by-value.

## Cách học
Đọc `ReverseArrayDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`ReverseArrayExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `ReverseArraySolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.reverse_array.ReverseArrayDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
