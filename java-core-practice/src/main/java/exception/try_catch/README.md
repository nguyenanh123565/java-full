# Try / catch / finally

## Dùng để làm gì
Xử lý lỗi tại nơi biết cách phản hồi; đảm bảo tài nguyên được đóng đúng lúc.

## Bắt buộc phải hiểu
- Khi exception phát sinh, phần còn lại của block try bị bỏ qua; tìm catch phù hợp theo loại.
- Checked exception phải được catch hoặc khai báo throws; unchecked (RuntimeException và các lớp con) không bị compiler bắt buộc.
- NumberFormatException và ArithmeticException là unchecked; IOException là checked.
- Nếu các catch có quan hệ kế thừa, catch lớp con phải đứng trước lớp cha.
- finally thường chạy khi rời try/catch; JVM dừng đột ngột hoặc System.exit có thể ngăn nó chạy.
- Không return trong finally vì có thể che mất return hoặc exception trước đó.
- try-with-resources đóng AutoCloseable tự động, cả khi xử lý dữ liệu ném exception.

## Lỗi thường gặp
Catch Exception quá rộng rồi bỏ qua lỗi, chỉ in thông báo mơ hồ, nghĩ finally luôn chạy mọi tình huống, quên đóng tài nguyên hoặc đặt return trong finally.

## Tự kiểm tra
1. Dòng sau lệnh gây exception trong try có chạy không?
2. NumberFormatException có bắt buộc catch không? Vì sao?
3. Vì sao catch lớp cha trước lớp con có thể không compile?
4. try-with-resources giúp gì khi parse một dòng thất bại?
5. Khi nào giá trị fallback là một chính sách hợp lý thay vì che lỗi?

## Ba bài tập
1. **Dễ:** parseOrDefault với "12"/"abc" và fallback=0; giải thích fallback và unchecked.
2. **Vừa:** Chia hai chuỗi số với ("6","2"), ("6","0"), ("six","2"); catch riêng hai loại lỗi và finally, giải thích luồng chạy.
3. **Khó:** Tổng dòng số bằng BufferedReader/StringReader trong try-with-resources; thử dữ liệu hợp lệ và dòng x, xử lý lỗi rõ ràng và giải thích đóng reader.

Tự làm TryCatchExercise trước khi đối chiếu TryCatchSolution.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
