# RemoveDuplicate

## Dùng để làm gì?
Loại phần tử trùng và giữ thứ tự xuất hiện đầu tiên mà không sửa mảng nguồn.

## Những ý bắt buộc phải hiểu
- Set nhận diện phần tử đã gặp.
- LinkedHashSet giữ thứ tự chèn.
- Kết quả là mảng mới; O(n) kỳ vọng, O(k) bộ nhớ phụ.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Vì sao chọn LinkedHashSet thay HashSet?
2. Có thể giữ nguyên mảng nguồn bằng cách nào?
3. Một giá trị lặp nhiều lần xuất hiện bao nhiêu lần trong kết quả?

## Ba bài tập từ dễ đến khó
1. Dễ: dự đoán kết quả [3, 1, 3, 2, 1] -> [3, 1, 2]; giải thích quy tắc giữ thứ tự.
2. Vừa: viết unique(int[]) trả mảng mới, không sửa nguồn. Giải thích cấu trúc lưu phần tử đã gặp.
3. Khó: kiểm tra [], [7, 7] và mảng toàn khác nhau; so identity mảng nguồn/kết quả, giải thích chi phí bộ nhớ.

## Cách học
Đọc `RemoveDuplicateDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`RemoveDuplicateExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `RemoveDuplicateSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.remove_duplicate.RemoveDuplicateDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
