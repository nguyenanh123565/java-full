# Strings — Chuỗi bất biến

## Dùng để làm gì?

`String` biểu diễn văn bản: tên, mã, thông báo và dữ liệu nhập. Hiểu tính bất biến giúp xử lý chuỗi đúng khi có nhiều biến hoặc khi truyền qua method.

## Những ý bắt buộc phải hiểu

- `String` là object immutable: không thay đổi nội dung của object đã tạo. Biến tham chiếu `String` vẫn có thể được gán sang object khác.
- `trim`, `toUpperCase`, `concat`, `replace` trả kết quả; cần dùng kết quả nếu muốn cập nhật biến. Một số thao tác có thể trả lại chính object cũ khi không có thay đổi, nên không suy ra số object được cấp phát từ số lời gọi.
- `==` so sánh danh tính; `equals` của `String` so sánh nội dung. Literal chuỗi được intern nhưng code so sánh nội dung không nên dựa vào điều đó.
- `StringBuilder` mutable, phù hợp khi nối nhiều lần; các alias cùng nhìn thấy thay đổi nội dung.
- `length()` tính số đơn vị UTF-16; `charAt` trả một đơn vị `char`, không luôn tương đương một ký tự người dùng nhìn thấy. Bài tập ở đây dùng ASCII.
- Chuyển hoa/thường phụ thuộc locale; dùng `Locale.ROOT` để kết quả của ví dụ ổn định.
// "Anh".equals(name);   là tìm đối tương chứa noi dung "anh" để so sánh vs name,,    nên k null point exception
## Lỗi người mới thường gặp

- Gọi `text.concat(...)` rồi bỏ kết quả và nghĩ `text` đã đổi.
- Dùng `==` kiểm tra hai chuỗi có cùng nội dung.
- Nhầm String immutable với biến String không được gán lại; `final` và immutable là hai ý khác nhau.
- Đếm chính xác toàn bộ object String trong heap từ vài literal; pooling, object nội bộ và tối ưu JVM khiến kết luận đó không phù hợp.

## Tự kiểm tra

1. `s = s + "!"` có sửa object String cũ không? Nó đổi điều gì?
2. Vì sao `new String("Java").equals("Java")` là `true` dù `==` là `false`?
3. Method gán lại tham số String có đổi biến caller không? Vì sao?
4. Nếu hai biến trỏ cùng StringBuilder, append qua một biến có thấy qua biến kia không?

## Ba bài tập từ dễ đến khó

1. **Dễ — Chuẩn hóa:** đầu vào `"  java core  "` khác `null`; tạo kết quả `"JAVA CORE"` bằng `trim` và `toUpperCase(Locale.ROOT)`. In chuỗi gốc trong dấu `[]` để thấy `[  java core  ]`. Giải thích vì sao chuỗi gốc không đổi và cần dùng giá trị trả về.
2. **Vừa — Identity và content:** tạo `literal="Java"`, `alias=literal`, `separate=new String("Java")`. In `literal == alias`, `literal == separate`, `literal.equals(separate)` tương ứng `true`, `false`, `true`. Giải thích mỗi phép so sánh; không đếm toàn bộ object String trong heap.
3. **Khó — Qua method:** String caller bắt đầu `"Java"`. Method `void` gán lại tham số bằng chuỗi có hậu tố `" Core"` không đổi caller; method trả String mới và caller nhận kết quả tạo `"Java Core"`. Với StringBuilder bắt đầu `"Java"`, method gọi `append(" Core")` làm caller thấy `"Java Core"`. Giải thích pass-by-value và mutable/immutable trong cả ba trường hợp. Các tham số đều khác `null`.

## Cách học

Đoán `StringDemo.java`, tự thực hiện `StringExercise.java`, rồi đối chiếu `StringSolution.java`. Tránh dùng `new String` trong code thông thường; ở đây chỉ dùng để làm rõ danh tính object.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
