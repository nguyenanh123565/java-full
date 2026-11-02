# Interface

## Dùng để làm gì?
Interface định nghĩa một hợp đồng hành vi, cho phép nhiều class khác nhau được sử dụng qua cùng một kiểu reference và giảm phụ thuộc vào cài đặt cụ thể.

## Bắt buộc hiểu
- Class dùng `implements`; một class có thể implements nhiều interface.
- Method abstract thông thường trong interface mặc định là public; method triển khai không được giảm quyền truy cập.
- Không khởi tạo trực tiếp interface; biến interface giữ reference tới object triển khai nó.
- Interface có thể có default/static method và constant; không có constructor hay field trạng thái riêng cho từng object.
- Nhiều reference thuộc nhiều interface có thể trỏ cùng object.

## Lỗi thường gặp
- Quên public khi triển khai method interface.
- Nghĩ mỗi reference interface tạo một object riêng.
- Dùng instanceof trong caller để chọn cài đặt dù method hợp đồng đã đủ.
- Cho rằng interface và abstract class luôn có cùng vai trò; abstract class có thể chia sẻ trạng thái instance.

## Tự kiểm tra
1. Vì sao ConsolePrinter.print phải public?
2. Interface có thể dùng làm kiểu tham số method không?
3. Vì sao sendWelcome không cần sửa khi thêm PushNotifier?
4. Drawable và Resizable có thể tham chiếu cùng Rectangle không? Vì sao?

## Bài tập từ dễ đến khó
1. Printer/ConsolePrinter: gọi qua interface và giải thích quyền truy cập.
2. Hai Notifier mô phỏng cùng dùng sendWelcome; giải thích caller phụ thuộc hợp đồng.
3. Rectangle implements Drawable và Resizable; giải thích trạng thái chung sau resize.

Đọc và đoán `InterfaceDemo.java`; làm `InterfaceExercise.java`; đối chiếu `InterfaceSolution.java` khi cần.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
