# Reference — Biến tham chiếu và danh tính object

## Dùng để làm gì?

Tham chiếu giúp nhiều phần của chương trình truy cập cùng object. Hiểu alias và gán lại tham chiếu là nền tảng của OOP, mảng, collections và thiết kế tránh sửa dữ liệu ngoài ý muốn.

## Những ý bắt buộc phải hiểu

- Biến reference giữ giá trị tham chiếu hoặc `null`, không chứa toàn bộ object. Java không cho tính toán địa chỉ như con trỏ C/C++.
- `Box b = a` sao chép tham chiếu, không tạo bản copy của Box. Hai biến có thể cùng truy cập một object.
- `b.value = ...` sửa object; `b = new Box(...)` thay giá trị biến `b`. Hai thao tác khác nhau.
- `==` với reference kiểm tra cùng object. `Object.equals` mặc định cũng kiểm tra danh tính; lớp như String có thể override để so sánh nội dung.
- Hai Box có field giống nhau vẫn là hai object khác nhau. Đếm số `new Box` trong đoạn chạy chỉ nói về các Box của đoạn đó, không phải tất cả object trong heap.
- Java truyền bản sao giá trị reference vào method. Gán lại tham số không đổi biến caller; sửa field có thể được caller thấy.
- Truy cập field/method instance qua `null` gây `NullPointerException`.

## Lỗi người mới thường gặp

- Đồng nhất “hai biến” với “hai object”.
- Nhầm gán lại reference với sửa object đang được tham chiếu.
- Cho rằng `equals` của mọi lớp đều tự so sánh field; cần định nghĩa quan hệ bằng nhau của lớp.
- Nghĩ method đổi chỗ hai tham số reference sẽ đổi hai biến bên ngoài.

## Tự kiểm tra

1. Sau `Box b = a`, có bản copy Box được tạo không?
2. Nếu gán `b = null`, object mà `a` tham chiếu có biến mất ngay không?
3. Hai Box cùng `value=10` có chắc `equals` là `true` không? Vì sao?
4. Vì sao đổi field trong method có hiệu lực ở caller còn đổi tham số không có?

## Ba bài tập từ dễ đến khó

1. **Dễ — Alias:** tự tạo lớp Box có `int value` và constructor. `a=new Box(10)`, `b=a`, sửa `b.value=20`; in `a.value` (`20`) và `a==b` (`true`). Vẽ hai mũi tên và giải thích vì sao đoạn này tạo một Box.
2. **Vừa — Identity:** tạo hai Box bằng hai biểu thức `new Box(10)`, chưa override `equals`. In `a==b`, `a.equals(b)`, `a.value==b.value`: `false, false, true`. Giải thích vì sao giá trị field giống nhau chưa có nghĩa là cùng object hoặc bằng nhau theo `equals` hiện tại.
3. **Khó — Swap:** tạo hai Box khác nhau, khác `null`, có `value=1` và `value=2`. Method `trySwap` đổi hai biến tham số reference: caller vẫn `1,2`. Method `swapValues` đổi field: caller thành `2,1`. Giải thích bằng sơ đồ tham chiếu; không dùng biến toàn cục để thay caller.

## Cách học

Lớp Box rất nhỏ chỉ nhằm quan sát tham chiếu; OOP sẽ giải thích class và constructor kỹ hơn. Đoán `ReferenceDemo.java`; tự viết trong `ReferenceExercise.java`; đối chiếu `ReferenceSolution.java` khi cần.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
