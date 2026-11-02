# Bài tập tự làm: Class và object

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Đã học fundamental đến memory: field, method, mảng, String, reference và null. Chưa cần constructor tự viết, private, kế thừa hoặc equals/hashCode.

Ba bài Student trong [ClassObjectExercise.java](../ClassObjectExercise.java) đã luyện tạo object, alias và sao chép field. Bộ này dùng thiết bị đo, thêm lỗi khởi tạo, truyền tham số và mảng reference.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.class_object.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.class_object.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## OBJ-01 — Hai bộ đếm độc lập

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Class, object, field, method.
- **Bối cảnh và yêu cầu:** Một cửa hàng đếm lượt khách ở hai cửa. Tạo Counter có int value, tăng bằng increment() và trả số bằng read(). Tạo hai Counter, tăng cửa A hai lần và B một lần; không dùng biến dùng chung.
- **Dữ liệu / ví dụ sử dụng:** A: increment, increment; B: increment → read A = 2, read B = 1.
- **Trường hợp biên:** Bộ đếm mới bằng 0; hai cửa cùng bằng 0 vẫn là hai object.
- **Hoàn thành khi:** Chạy được và giải thích tại sao thay đổi A không làm đổi B.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OBJ-02 — Reference đi qua method

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Alias, pass-by-value.
- **Bối cảnh và yêu cầu:** Đọc đoạn dưới, vẽ các reference sau mỗi dòng, ghi output và số object Counter đã tạo trước khi chạy. Sau đó kiểm chứng và giải thích từng phép gán.

```java
Counter a = new Counter();
Counter b = a;
b.value = 4;
replace(b);
System.out.println(a.value + ":" + (a == b));
// void replace(Counter c) { c = new Counter(); c.value = 99; }
```

- **Dữ liệu / ví dụ sử dụng:** Dữ liệu: value ban đầu 0; replace chỉ gán lại tham số c như comment.
- **Trường hợp biên:** So sánh với biến thể replace dùng c.value = 99 mà không new.
- **Hoàn thành khi:** Có dự đoán trước khi chạy, sơ đồ và giải thích khác nhau giữa gán reference và sửa object.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OBJ-03 — Ô mảng chưa có thiết bị

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** null và khởi tạo object.
- **Bối cảnh và yêu cầu:** Đoạn Counter[] gates = new Counter[2]; gates[0].increment(); không chạy như mong đợi. Chỉ ra chính xác ô nào thiếu object; sửa để mỗi ô có một Counter riêng và tăng ô 0 một lần.
- **Dữ liệu / ví dụ sử dụng:** Sau sửa: gates[0].read() = 1, gates[1].read() = 0, gates[0] == gates[1] là false.
- **Trường hợp biên:** Mảng độ dài 0 không được truy cập phần tử; không dùng một Counter gán cho mọi ô.
- **Hoàn thành khi:** Giải thích new Counter[2] tạo gì, khởi tạo đủ các ô và giữ project biên dịch được.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OBJ-04 — Cảm biến chấp nhận số đo

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Hành vi object, boolean.
- **Bối cảnh và yêu cầu:** Tạo Sensor lưu reading ban đầu 0. Method update(int value) chỉ nhận -50..100, trả boolean và giữ nguyên số cũ khi từ chối. Method read() trả reading. Tạo hai cảm biến độc lập.
- **Dữ liệu / ví dụ sử dụng:** update(25) → true, read() → 25; update(101) → false, read() vẫn 25.
- **Trường hợp biên:** Thử -51, -50, 0, 100, 101 và trạng thái cảm biến thứ hai.
- **Hoàn thành khi:** Đủ kiểm tra biên; mô tả dữ liệu và hành vi thuộc từng object. Field có thể để package-private ở bước này.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OBJ-05 — Bảng theo dõi cảm biến

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Object, mảng reference, method và vòng lặp.
- **Bối cảnh và yêu cầu:** Dùng Sensor ở OBJ-04, tạo Sensor[] có ba cảm biến. Viết countAbove(Sensor[] sensors, int threshold): đếm số đo lớn hơn threshold; bỏ ô null, mảng null trả 0. Không thay đổi cảm biến. Thử thay một ô bằng reference cùng cảm biến khác và giải thích đếm theo ô.
- **Dữ liệu / ví dụ sử dụng:** Các số đo [10, null, 40], threshold 20 → 1; [40,40] dùng cùng object → 2.
- **Trường hợp biên:** Mảng null/rỗng; mọi ô null; số đo đúng bằng ngưỡng không được tính.
- **Hoàn thành khi:** Chạy đủ ca; phân biệt số ô, số reference và số object; ghi một lỗi dự đoán vào ghi chú riêng.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
