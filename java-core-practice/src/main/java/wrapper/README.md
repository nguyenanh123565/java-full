# Wrapper

## Dùng để làm gì?
Dùng object đại diện cho primitive trong generic, collection và dữ liệu có thể thiếu.

## Những ý bắt buộc phải hiểu
- Autoboxing chuyển primitive sang wrapper; unboxing làm ngược lại.
- Wrapper có thể null; unboxing null gây NullPointerException.
- equals xét giá trị cùng kiểu wrapper; == trên hai wrapper xét identity.
- parseInt trả int; valueOf trả Integer; List<Integer>.remove có overload theo index và object.

## Lỗi người mới thường gặp
- So giá trị Integer bằng == rồi phụ thuộc cache.
- Quên kiểm tra null trước khi unbox.
- Gọi remove(1) khi muốn xóa giá trị 1.

## Câu hỏi tự kiểm tra
1. Vì sao List<int> không hợp lệ?
2. Integer null khi cộng 1 sẽ xảy ra gì?
3. equals giữa Integer(1) và Long(1) có bằng nhau không?
4. remove(1) khác remove(Integer.valueOf(1)) ở đâu?

## Ba bài tập từ dễ đến khó
1. Dễ: đọc ["42", "abc", "-7"] bằng Integer.parseInt, báo lỗi từng chuỗi mà vẫn xử lý tiếp; giải thích NumberFormatException.
2. Vừa: viết valueOrZero(Integer value) trả 0 nếu null; thử null và 8. Giải thích chính xác lúc unboxing diễn ra.
3. Khó: dùng hai bản sao [1, 2, 1], một list remove(1), list kia remove(Integer.valueOf(1)); tính tổng list thứ hai. Giải thích overload và vì sao so wrapper bằng equals.

## Cách học
Đọc `WrapperDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`WrapperExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `WrapperSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes wrapper.WrapperDemo` (sau khi biên dịch).


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
