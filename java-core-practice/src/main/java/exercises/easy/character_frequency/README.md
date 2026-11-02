# CharacterFrequency

## Dùng để làm gì?
Đếm ký tự trong String và luyện Map<Character, Integer>.

## Những ý bắt buộc phải hiểu
- Bài cơ bản nhận ASCII, phân biệt hoa/thường, tính cả khoảng trắng.
- Character là wrapper của char; char là UTF-16 code unit.
- LinkedHashMap cho thứ tự gặp đầu; mở rộng Unicode nên dùng codePoints và Integer key.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Khoảng trắng có được tính không?
2. "Aa" có bao nhiêu key theo quy ước này?
3. Vì sao một emoji có thể chiếm hai char?

## Ba bài tập từ dễ đến khó
1. Dễ: đếm tay "banana" và "Aa a"; giải thích phân biệt hoa/thường và khoảng trắng.
2. Vừa: viết frequency(String) trả Map<Character, Integer>, giữ thứ tự xuất hiện đầu. Giải thích getOrDefault.
3. Khó: thử "", "aaa", "a a"; chứng minh tổng số đếm bằng length cho ASCII và giải thích giới hạn char khi mở rộng Unicode.

## Cách học
Đọc `CharacterFrequencyDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`CharacterFrequencyExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `CharacterFrequencySolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.character_frequency.CharacterFrequencyDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
