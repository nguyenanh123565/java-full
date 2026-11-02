# Enum

## Dùng để làm gì?
Mô hình hóa tập giá trị hữu hạn như trạng thái đơn hàng, giúp tránh chuỗi sai chính tả.

## Những ý bắt buộc phải hiểu
- Enum là kiểu riêng; mỗi hằng số là một instance được tạo sẵn.
- So sánh enum bằng ==; switch giúp xử lý từng trạng thái.
- Enum có thể có field, constructor và method; constructor không public.
- Không dùng ordinal làm ID lưu trữ hay quy tắc nghiệp vụ.

## Lỗi người mới thường gặp
- Dùng String thay enum cho tập trạng thái cố định.
- valueOf không khớp chính xác tên sẽ ném IllegalArgumentException.
- Cho phép đổi từ trạng thái kết thúc về trạng thái bắt đầu.

## Câu hỏi tự kiểm tra
1. Enum khác một nhóm hằng String ở đâu?
2. Vì sao so sánh enum bằng == là phù hợp?
3. Vì sao ordinal không nên là ID ổn định?
4. Bạn mô hình hóa chuyển trạng thái hợp lệ như thế nào?

## Ba bài tập từ dễ đến khó
1. Dễ: tạo Severity LOW/MEDIUM/HIGH và switch trả thông điệp; giải thích lợi ích kiểm tra kiểu.
2. Vừa: gắn mức ưu tiên 1/2/3 cho Severity bằng field final + constructor; giải thích vì sao không dùng ordinal.
3. Khó: OrderStatus NEW -> PAID hoặc CANCELLED, PAID -> SHIPPED; trạng thái kết thúc không chuyển tiếp. Viết canMoveTo, kiểm tra NEW->SHIPPED sai và PAID->SHIPPED đúng, giải thích quy tắc.

## Cách học
Đọc `EnumDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`EnumExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `EnumSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes enum_demo.EnumDemo` (sau khi biên dịch).


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
