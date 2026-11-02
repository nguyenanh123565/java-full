# Inheritance

## Dùng để làm gì?
Kế thừa biểu diễn quan hệ is-a, cho phép lớp con dùng và mở rộng hành vi lớp cha khi có quan hệ mô hình phù hợp.

## Bắt buộc hiểu
- Một class chỉ extends một class; có thể implements nhiều interface.
- Field private của cha không được truy cập trực tiếp từ lớp con; dùng hành vi hoặc getter phù hợp.
- Constructor không kế thừa; `super(...)` khởi tạo phần lớp cha của cùng object.
- Biến kiểu cha có thể giữ reference tới object con; điều này không sao chép hay cắt bỏ object.
- Method instance bị override được chọn theo kiểu object lúc chạy; field không hoạt động như vậy.

## Lỗi thường gặp
- Dùng kế thừa chỉ để lấy vài method dù không có quan hệ is-a.
- Nghĩ `super(...)` tạo thêm một object cha độc lập.
- Tưởng mọi thành viên private của cha được truy cập trực tiếp trong con.
- Trông chờ constructor mặc định của cha khi cha chỉ có constructor có tham số.

## Tự kiểm tra
1. Teacher có thể được dùng ở nơi cần Person không? Vì sao?
2. Constructor cha hay con chạy trước trong ví dụ Java 17 này?
3. Gán Child vào Base có làm mất phần trạng thái Child không?
4. Vì sao quan hệ has-a thường phù hợp với composition hơn inheritance?

## Bài tập từ dễ đến khó
1. Person/Teacher với name private, getter và subject; giải thích quyền truy cập.
2. Employee/FullTimeEmployee tính lương qua biến kiểu cha; giải thích is-a và dispatch.
3. Quan sát constructor Base/Child và identity sau upcast; giải thích chỉ có một object.

Đoán output trong `InheritanceDemo.java`, làm `InheritanceExercise.java`, đối chiếu riêng với `InheritanceSolution.java`.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
