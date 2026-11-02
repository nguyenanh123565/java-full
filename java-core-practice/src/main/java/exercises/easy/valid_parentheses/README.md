# ValidParentheses

## Dùng để làm gì?
Kiểm tra ngoặc (), [] và {} bằng stack, hiểu thứ tự LIFO.

## Những ý bắt buộc phải hiểu
- Ngoặc đóng phải khớp ngoặc mở gần nhất.
- Dùng Deque như stack; kiểm tra rỗng trước pop.
- Chuỗi rỗng hợp lệ; ký tự ngoài ba loại ngoặc trả false.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Vì sao chỉ đếm số ngoặc là chưa đủ?
2. Tại sao cần LIFO thay FIFO?
3. Sau khi đọc hết chuỗi, điều kiện cuối là gì?

## Ba bài tập từ dễ đến khó
1. Dễ: đoán kết quả "([]{})", "([)]", ")("; giải thích vì sao số ngoặc bằng nhau vẫn có thể sai.
2. Vừa: viết isValid(String) dùng ArrayDeque; chỉ chấp nhận ()[]{}. Giải thích vì sao pop từ stack.
3. Khó: thử "", "(", "]" và "a"; giải thích xử lý stack rỗng, ngoặc thừa, ký tự lạ, cùng O(n) thời gian/O(n) bộ nhớ.

## Cách học
Đọc `ValidParenthesesDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`ValidParenthesesExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `ValidParenthesesSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.valid_parentheses.ValidParenthesesDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
