# Bài tập tự làm: Phối hợp object bằng composition

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau toàn bộ chín mục OOP trước composition; dùng interface, constructor, private, mảng. Chưa dùng List/generics/Objects/exception. Bài Classroom cũ dùng List<Student>: quay lại sau collections/list, không phải điều kiện làm bộ mới.

Bài cũ [CompositionExercise.java](../CompositionExercise.java) có Car/Engine, NotificationService và shallow-copy List. Bộ mới dùng máy in có mực, quyền sở hữu và trình tự phối hợp object.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.composition.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.composition.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## COMP-01 — Máy in sở hữu hộp mực

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Has-a, ủy quyền và quyền sở hữu.
- **Bối cảnh và yêu cầu:** Tạo Ink có units=10 private; consume(int n) chỉ nhận n>0 và đủ mực, trả boolean, sai giữ nguyên. Printer tự tạo một Ink riêng, print(int pages) dùng một đơn vị mỗi trang và trả boolean, remaining() đọc số mực. Không extends Ink.
- **Dữ liệu / ví dụ sử dụng:** print(3) →true, remaining=7; print(8) →false, remaining vẫn7.
- **Trường hợp biên:** 0/âm; in đúng 10 ở máy mới; hai Printer có Ink riêng.
- **Hoàn thành khi:** Printer chỉ điều phối, Ink giữ bất biến; giải thích has-a và đếm một Printer + một Ink mỗi lần new Printer.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## COMP-02 — Chia sẻ hay sở hữu riêng

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Aliasing collaborator.
- **Bối cảnh và yêu cầu:** Một SharedPrinter nhận Ink từ constructor; đối số null thì tự tạo Ink mới. Hai SharedPrinter nhận cùng Ink có 10 đơn vị, máy A in 3 rồi máy B in 2. Dự đoán remaining ở A/B và số Ink. So sánh với hai Printer COMP-01 tự tạo Ink.
- **Dữ liệu / ví dụ sử dụng:** Cùng Ink ban đầu10; các lời gọi lần lượt3,2.
- **Trường hợp biên:** Nếu truyền null hai lần thì mỗi máy có Ink riêng; field reference private không xóa chia sẻ.
- **Hoàn thành khi:** Có sơ đồ ownership, nêu shared collaborator là chia sẻ/aggregation theo UML chặt chẽ, không nhận là sở hữu độc quyền.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## COMP-03 — Máy tính giá không phải quy tắc giá

- **Mức độ:** Tìm lỗi + thiết kế.
- **Kiến thức luyện:** Composition thay kế thừa sai quan hệ.
- **Bối cảnh và yêu cầu:** Thiết kế nháp: Checkout extends PriceRule chỉ để gọi finalPrice(int). Sửa mô hình để Checkout giữ PriceRule qua constructor, null dùng IdentityRule. PriceRule là interface; IdentityRule nhận giá 0..10000, sai -1; HalfRule chia2. Checkout.quote chỉ ủy quyền. Giải thích vì sao Checkout không phải một PriceRule trong bài này.
- **Dữ liệu / ví dụ sử dụng:** Checkout(HalfRule).quote(101)=50; Checkout(null).quote(101)=101.
- **Trường hợp biên:** Giá -1,10001 từ chối; không dùng nhánh instanceof.
- **Hoàn thành khi:** Code có field collaborator, không extends chỉ để dùng lại; giữ tên/hợp đồng rõ ràng.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## COMP-04 — Bản sao danh sách công việc

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Mảng object, shallow copy và quyền sửa.
- **Bối cảnh và yêu cầu:** Tạo Task có title private, getter và rename chỉ nhận tên non-null/non-empty, sai trả false. Constructor tên sai dùng Untitled. Board nhận Task[] (null→rỗng), sao chép cấu trúc mảng ở constructor và getTasks bằng vòng lặp; không sao chép Task. Chứng minh thay ô mảng ngoài không đổi Board, nhưng rename một Task qua mảng sao vẫn được Board quan sát.
- **Dữ liệu / ví dụ sử dụng:** input[0]=Task("A"); tạo Board; input[0]=Task("B") → Board còn A; Board.getTasks()[0].rename("C") → Board thấy C.
- **Trường hợp biên:** Mảng null/rỗng; ô null được giữ nguyên; rename(null/"") không đổi tên.
- **Hoàn thành khi:** Kiểm tra cả đầu vào/getter và chia sẻ phần tử; mô tả chủ ý chia sẻ, đề xuất cách cô lập sâu bằng copy Task nếu cần nhưng chưa bắt làm.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## COMP-05 — Quầy in phối hợp các thành phần

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Composition, interface, bất biến và trình tự.
- **Bối cảnh và yêu cầu:** Tạo PrintDesk giữ Printer và ReceiptStyle qua constructor; null Printer tạo máy mới, null style dùng PlainStyle. ReceiptStyle.format(int pages,int remaining) trả thông điệp; PlainStyle trả pages:remaining, FancyStyle trả [pages:remaining]. PrintDesk.submit gọi print trước; thất bại trả REJECTED và không tạo thông điệp thành công, thành công mới format. Cho phép lắp style mới mà không sửa submit.
- **Dữ liệu / ví dụ sử dụng:** Máy mới, Plain: submit(3) →3:7; submit(8) →REJECTED, remaining vẫn7. Fancy với máy mới submit(2) →[2:8].
- **Trường hợp biên:** pages=0/âm; mực hết; hai desk dùng chung Printer phải thấy cùng số mực.
- **Hoàn thành khi:** Mỗi class có trách nhiệm rõ, đúng thứ tự và false không đổi trạng thái; viết nhận xét class nào nên độc lập và class nào nhận collaborator.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
