# Palindrome

## Dùng để làm gì?
Kiểm tra chuỗi đối xứng bằng hai con trỏ; phân biệt String với mảng char.

## Những ý bắt buộc phải hiểu
- Bài này so khớp chính xác, phân biệt hoa/thường và giữ cả khoảng trắng.
- Chuỗi rỗng và một ký tự là palindrome.
- Phạm vi cơ bản là ASCII; char là UTF-16 code unit, không phải mọi ký tự Unicode.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. "Aa" có đối xứng theo quy ước của bài không?
2. Vì sao không cần tạo chuỗi đảo mới?
3. Vì sao charAt có giới hạn khi xử lý emoji?

## Ba bài tập từ dễ đến khó
1. Dễ: dự đoán "level", "java", "Aa", ""; giải thích quy ước so sánh chính xác.
2. Vừa: viết isPalindrome(String) bằng hai con trỏ, không dùng reverse; input ASCII. Giải thích O(n) thời gian/O(1) bộ nhớ.
3. Khó: thử "a", "ab ba", "abba" và "abca"; giải thích String không bị sửa và vì sao mở rộng Unicode cần code point.

## Cách học
Đọc `PalindromeDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`PalindromeExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `PalindromeSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.palindrome.PalindromeDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
