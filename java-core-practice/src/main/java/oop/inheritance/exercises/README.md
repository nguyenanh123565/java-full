# Bài tập tự làm: Kế thừa đúng quan hệ

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau class_object, constructor, encapsulation. Dùng extends, super và ghi đè như README hiện tại; chưa cần interface, collection, exception hoặc ép kiểu xuống.

Bài cũ [InheritanceExercise.java](../InheritanceExercise.java) đã có Person/Teacher, Employee và dấu mốc constructor Base/Child. Bộ mới dùng vé, giới hạn hợp đồng và tình huống không nên kế thừa.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.inheritance.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.inheritance.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## INH-01 — Vé có tên sự kiện

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** extends, constructor, private và super.
- **Bối cảnh và yêu cầu:** Tạo Ticket giữ private event; event null/rỗng chuẩn hóa thành "Unknown". ReservedTicket extends Ticket thêm seat; null/rỗng chuẩn hóa "Free". Dùng getter của cha, describe() ở con trả event/seat. Constructor con phải gọi constructor cha.
- **Dữ liệu / ví dụ sử dụng:** ReservedTicket("Music","A1").describe() → Music/A1.
- **Trường hợp biên:** Tên/số ghế rỗng, null; tạo Ticket độc lập vẫn có getter đúng.
- **Hoàn thành khi:** Không truy cập trực tiếp field private; giải thích quan hệ ReservedTicket là một Ticket.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INH-02 — Giá trị cha và con

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Upcast, identity và hành vi kế thừa.
- **Bối cảnh và yêu cầu:** Dùng lớp INH-01, tạo ReservedTicket r = new ReservedTicket("Music","A1"); Ticket t = r; dự đoán t.getEvent(), t == r và liệu t.describe() có biên dịch nếu Ticket chưa khai báo describe. Giải thích mà không ép kiểu.
- **Dữ liệu / ví dụ sử dụng:** Dữ liệu Music/A1; thử lời gọi không hợp lệ dưới comment.
- **Trường hợp biên:** So với Ticket độc lập cùng event: so sánh identity, không so String bằng ==.
- **Hoàn thành khi:** Có kết luận riêng cho giá trị chạy và quyền gọi khi biên dịch; số object vé tạo là một.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INH-03 — Constructor cha cần đối số

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Constructor không kế thừa.
- **Bối cảnh và yêu cầu:** Với Ticket chỉ có Ticket(String event), sửa `class ReservedTicket extends Ticket { ReservedTicket(String e) { } }` để khởi tạo được tên Music. Giải thích lời gọi ngầm super() bị thiếu constructor đích. Không thêm constructor rỗng vô nghĩa để né lỗi.
- **Dữ liệu / ví dụ sử dụng:** new ReservedTicket("Music").getEvent() → Music (bỏ field seat trong bản tối thiểu này).
- **Trường hợp biên:** event null vẫn tuân theo chuẩn hóa của Ticket; super phải ở đầu trong Java 17.
- **Hoàn thành khi:** Biên dịch bản sửa, giữ bản lỗi trong comment và chỉ rõ constructor nào chạy trước.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INH-04 — Kế thừa có giữ lời hứa?

- **Mức độ:** Vận dụng + thiết kế.
- **Kiến thức luyện:** Quan hệ is-a, hợp đồng hành vi.
- **Bối cảnh và yêu cầu:** Vé thường price()=100; DiscountTicket trả 60, ComplimentaryTicket trả 0. Caller chỉ yêu cầu mọi Ticket có giá không âm. Viết ba kiểu và sumPrices(Ticket[]) bỏ null, null/rỗng trả 0. Đồng thời viết 4–6 dòng vì sao Receipt không nên extends Ticket chỉ để lấy event: biên lai là chứng từ chứa thông tin vé.
- **Dữ liệu / ví dụ sử dụng:** Giá [100,60,0,null] → 160.
- **Trường hợp biên:** Không cho giá âm; mảng toàn null; không yêu cầu lớp Receipt hoàn chỉnh trước composition.
- **Hoàn thành khi:** Caller không phân nhánh theo tên class; lập luận quan hệ mô hình và hợp đồng, chấp nhận thiết kế khác nếu giữ hành vi.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INH-05 — Tổng kết quầy vé

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Encapsulation, kế thừa, constructor, mảng.
- **Bối cảnh và yêu cầu:** Mở rộng Ticket ở INH-01 có price()=100; ReservedTicket giữ seat và price()=150. Thêm DiscountTicket price()=60, vẫn có event hợp lệ. Viết summary(Ticket[]) trả tổng giá và kiểm tra người dùng đọc được event qua kiểu cha. Phân biệt tổng tiền với số object khi cùng vé xuất hiện hai ô.
- **Dữ liệu / ví dụ sử dụng:** Ticket("Talk"), ReservedTicket("Music","A1"), DiscountTicket("Film") → tổng 310. Hai ô cùng ReservedTicket → 300.
- **Trường hợp biên:** null/rỗng →0; ô null bỏ qua; tên sai chuẩn hóa Unknown.
- **Hoàn thành khi:** Có kiểm tra giá/tên/identity và đoạn giải thích vì sao ba kiểu thay được Ticket trong caller.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
