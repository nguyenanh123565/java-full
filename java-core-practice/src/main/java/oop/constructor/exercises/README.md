# Bài tập tự làm: Constructor và this

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Đã học fundamental và class_object. Bài mới chỉ constructor, this, this(...), mảng và boolean; không yêu cầu exception hoặc static/final. Bài Product cũ ném exception: quay lại sau mục exception nếu chưa học.

Bài cũ [ConstructorExercise.java](../ConstructorExercise.java) là Book mặc định, Product validation và Student copy constructor. Bộ mới tập trung this bị che tên, thứ tự chaining và thiết bị cấu hình theo quy tắc chuẩn hóa rõ ràng.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.constructor.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.constructor.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## CTOR-01 — Hẹn giờ mặc định

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Constructor và this.
- **Bối cảnh và yêu cầu:** Tạo Timer có label và minutes. Timer(String label, int minutes) nhận phút từ 0..120; ngoài khoảng đổi thành 0. label null hoặc rỗng đổi thành "Timer". Dùng this để phân biệt field với tham số cùng tên.
- **Dữ liệu / ví dụ sử dụng:** new Timer("Tea", 5) → Tea:5; new Timer(null,-1) → Timer:0.
- **Trường hợp biên:** Phút 0,120,121; label "". Chuỗi chỉ có khoảng trắng được giữ nguyên theo hợp đồng này.
- **Hoàn thành khi:** Có constructor khởi tạo đủ field, method describe() trả label:minutes, giải thích chính sách chuẩn hóa.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## CTOR-02 — Một object qua hai constructor

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** this(...) và thứ tự khởi tạo.
- **Bối cảnh và yêu cầu:** Đọc và dự đoán thứ tự output cùng số object Ticket được tạo.

```java
class Ticket {
  Ticket() { this("A"); System.out.print("2"); }
  Ticket(String code) { System.out.print("1" + code); }
}
// new Ticket(); System.out.print("3");
```

Giải thích vì sao this("A") không giống new Ticket("A").

- **Dữ liệu / ví dụ sử dụng:** Lời gọi: new Ticket(); rồi in "3".
- **Trường hợp biên:** Thử riêng new Ticket("B"); không thêm biến đếm static.
- **Hoàn thành khi:** Ghi dự đoán trước, kiểm chứng hai lời gọi tách biệt và giải thích số object.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## CTOR-03 — Method giả constructor

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Constructor mặc định, shadowing.
- **Bối cảnh và yêu cầu:** Sửa class có `int minutes; void Timer(int minutes) { minutes = minutes; }` để `new Timer(7)` khởi tạo field thành 7. Chỉ ra hai lỗi độc lập. Đoạn lỗi chỉ giữ trong comment, không phá build.
- **Dữ liệu / ví dụ sử dụng:** new Timer(7).minutes → 7; new Timer(0).minutes → 0.
- **Trường hợp biên:** Sau khi thêm constructor có tham số, thử giải thích vì sao new Timer() không tự còn hợp lệ.
- **Hoàn thành khi:** Loại bỏ kiểu trả về, dùng this đúng và giải thích việc compiler sinh constructor mặc định.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## CTOR-04 — Cấu hình ghế ngồi

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Constructor chaining, chuẩn hóa.
- **Bối cảnh và yêu cầu:** Tạo Seat có row và number. Seat() dùng A,1; Seat(String row) dùng number=1; Seat(String row,int number) là nơi chuẩn hóa duy nhất: row null/rỗng → A, number ngoài 1..20 →1. Hai constructor đầu gọi this(...). describe trả row-number.
- **Dữ liệu / ví dụ sử dụng:** new Seat() → A-1; new Seat("B") → B-1; new Seat("C",20) → C-20; new Seat("",21) → A-1.
- **Trường hợp biên:** number 0,1,20,21; row null; không dùng this(...) đệ quy vòng tròn.
- **Hoàn thành khi:** Ba cách tạo có cùng quy tắc, không lặp validation và chỉ tạo một object mỗi lần new.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## CTOR-05 — Lịch hẹn độc lập

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Khởi tạo, copy dữ liệu, mảng object.
- **Bối cảnh và yêu cầu:** Tạo Appointment có title và minutes theo quy tắc Timer CTOR-01; thêm constructor Appointment(Appointment other), với null dùng mặc định Timer:0. Tạo lịch gốc 30 phút và bản sao, đổi phút bản sao thành 45. Tạo Appointment[] có gốc và bản sao, tính tổng phút bằng method. Giải thích copy constructor tự viết, không gọi lại constructor như method.
- **Dữ liệu / ví dụ sử dụng:** Gốc Review:30; bản sao Review:45; tổng 75; gốc == bản sao là false.
- **Trường hợp biên:** Sao chép null → Timer:0; mảng rỗng tổng 0; mảng trong bài không chứa null.
- **Hoàn thành khi:** Có kiểm tra identity, dữ liệu riêng, tổng phút; không dùng collection.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
