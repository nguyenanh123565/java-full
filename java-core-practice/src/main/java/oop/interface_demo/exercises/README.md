# Bài tập tự làm: Hợp đồng bằng interface

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau abstraction và polymorphism. Chỉ interface, implements, public, array và boolean; default/static method chưa bắt buộc. So sánh interface với abstract class đã học ở abstraction.

Bài cũ [InterfaceExercise.java](../InterfaceExercise.java) dùng Printer, Notifier và Rectangle đa interface. Bộ mới dùng formatter, phép kiểm tra đầu vào và thiết bị có nhiều vai trò.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.interface_demo.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.interface_demo.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## INT-01 — Định dạng mã

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Interface, implements, public.
- **Bối cảnh và yêu cầu:** Tạo TextFormatter có String format(String text). BracketFormatter nhận chuỗi và trả "["+text+"]"; null xem như chuỗi rỗng. Gọi qua biến TextFormatter, không khởi tạo interface.
- **Dữ liệu / ví dụ sử dụng:** format("Java") → [Java]; format(null) → [].
- **Trường hợp biên:** Chuỗi rỗng và có khoảng trắng giữ nguyên nội dung.
- **Hoàn thành khi:** Method triển khai public, caller chỉ biết hợp đồng; chỉ rõ đâu là object, đâu là kiểu reference.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INT-02 — Một object hai vai trò

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Nhiều interface, chia sẻ trạng thái.
- **Bối cảnh và yêu cầu:** Có Switchable với boolean turnOn(), Readable với boolean isOn(). Lamp implements cả hai, on ban đầu false; turnOn đổi on=true và trả true. Dự đoán sau Lamp lamp=new Lamp(); Switchable s=lamp; Readable r=lamp; s.turnOn(); in r.isOn(); giải thích có bao nhiêu Lamp.
- **Dữ liệu / ví dụ sử dụng:** Lần gọi turnOn đầu và lần thứ hai đều true theo hợp đồng.
- **Trường hợp biên:** Không coi mỗi biến interface là object mới; không so với String bằng ==.
- **Hoàn thành khi:** Ghi output, sơ đồ reference và chỉ ra hành vi được phép gọi qua từng interface.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INT-03 — Hợp đồng public

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Quyền truy cập và chữ ký.
- **Bối cảnh và yêu cầu:** Sửa `class BracketFormatter implements TextFormatter { String format(String text) { return "["+text+"]"; } }`. Chỉ ra lỗi compile về quyền truy cập, sau đó sửa null theo INT-01, không xóa implements để né hợp đồng.
- **Dữ liệu / ví dụ sử dụng:** Qua TextFormatter f: f.format("A") → [A], null → [].
- **Trường hợp biên:** Giữ tên method đúng chữ hoa/thường; không giảm public thành protected.
- **Hoàn thành khi:** Thêm @Override, giải thích vì sao public được yêu cầu dù interface viết thiếu từ public.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INT-04 — Ghép bộ định dạng

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Interface làm tham số, composition đơn giản.
- **Bối cảnh và yêu cầu:** Thêm HashFormatter: null/rỗng → ##, chuỗi khác → #text#. Viết formatAll(TextFormatter[] formatters,String text) trả String[] cùng độ dài; ô formatter null → "SKIP"; mảng null trả rỗng. Không if theo class.
- **Dữ liệu / ví dụ sử dụng:** [BracketFormatter,HashFormatter,null], "A" → ["[A]","#A#","SKIP"].
- **Trường hợp biên:** text null; mảng rỗng; formatter trùng reference.
- **Hoàn thành khi:** Đúng thứ tự và null contract; giải thích caller dùng interface và không cần chung lớp cha cụ thể.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## INT-05 — Kiểm tra biểu mẫu mở rộng

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Interface, encapsulation, nhiều implementation.
- **Bối cảnh và yêu cầu:** Tạo Rule có boolean accepts(String text). NonEmptyRule từ chối null/rỗng; MaxLengthRule nhận max 0..20, sai chuẩn hóa 0, từ chối null và nhận length<=max. Viết acceptsAll(Rule[],String): mảng null hoặc ô null trả false, mảng rỗng trả true. Đánh giá đồng thời NonEmpty và MaxLength(3), rồi thêm StartsWithARule không sửa acceptsAll. Viết 3–5 dòng so sánh interface Rule với một abstract class có state max.
- **Dữ liệu / ví dụ sử dụng:** NonEmpty + MaxLength(3): "An" true, "" false, "Long" false; thêm StartsWithA: "An" true, "Bo" false.
- **Trường hợp biên:** max=0,20,-1; null text; mảng rỗng và ô null; prefix phân biệt hoa/thường.
- **Hoàn thành khi:** Đủ ca, giữ max private; caller không phân nhánh kiểu; giải thích khi nào abstract class giúp chia sẻ state và khi nào interface đủ.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
