# Abstraction

## Dùng để làm gì?
Trừu tượng hóa mô tả hành vi cần có và che chi tiết cài đặt. Abstract class có thể chia sẻ trạng thái, constructor và hành vi chung cho các lớp con.

## Bắt buộc hiểu
- Không thể khởi tạo trực tiếp abstract class; vẫn có thể dùng nó làm kiểu reference.
- Abstract method không có thân; lớp con cụ thể phải cài đặt các abstract method còn thiếu.
- Abstract class có thể chứa method cụ thể, constructor và field.
- Caller làm việc qua hợp đồng chung, không cần biết từng công thức riêng.
- `final` method có thể giữ quy trình chung, còn abstract method cung cấp bước thay đổi.

## Lỗi thường gặp
- Cho rằng mọi method trong abstract class đều phải abstract.
- Quên triển khai method nên lớp con chưa thể trở thành class cụ thể.
- Viết một chuỗi `if` kiểm tra mọi loại hình ngay trong vòng lặp tổng diện tích.
- Gọi method bị override trong constructor khi trạng thái lớp con chưa khởi tạo xong.

## Tự kiểm tra
1. Vì sao Shape là abstract nhưng Rectangle có thể được new?
2. Constructor abstract class có được chạy khi tạo lớp con không?
3. Caller tính tổng diện tích cần biết gì về Circle?
4. `final printReport()` và `abstract body()` có vai trò khác nhau thế nào?

## Bài tập từ dễ đến khó
1. Shape/Rectangle có validation kích thước; giải thích hạn chế khởi tạo abstract class.
2. Thêm Circle và tổng diện tích qua Shape[]; giải thích hợp đồng chung.
3. Report giữ quy trình in bằng final method; StudentReport cung cấp nội dung qua abstract method.

Đọc `AbstractionDemo.java`, dự đoán trước khi chạy. Tự làm `AbstractionExercise.java`; lời giải mẫu ở `AbstractionSolution.java`.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
