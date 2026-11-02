# Bài tập tự làm: Enum có dữ liệu và hành vi

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau OOP, exception, static_final, wrapper, generics và collections theo roadmap gốc. Bộ bài chỉ cần String, mảng, enum, switch, constructor, final và vòng lặp; không yêu cầu lambda/stream. Không dùng ordinal làm dữ liệu nghiệp vụ.

Bài cũ [EnumExercise.java](../EnumExercise.java) đã có Severity, priority và OrderStatus. Bộ mới dùng hướng di chuyển, mã ổn định, đầu vào văn bản và workflow phiếu hỗ trợ.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `enum_demo.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes enum_demo.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## ENUM-01 — Hướng di chuyển

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Enum, switch, so sánh ==.
- **Bối cảnh và yêu cầu:** Tạo Direction NORTH/EAST/SOUTH/WEST. Method opposite() trả hướng đối diện bằng switch. Viết moveX(Direction) trả EAST=1, WEST=-1, còn lại0, null=0. Không dùng thứ tự ordinal để suy luận hướng.
- **Dữ liệu / ví dụ sử dụng:** NORTH.opposite()=SOUTH; EAST.opposite()=WEST; moveX(WEST)=-1.
- **Trường hợp biên:** Hai lần opposite trở về ban đầu; null phải được kiểm tra trước switch.
- **Hoàn thành khi:** Kiểm đủ bốn hướng, so bằng == và giải thích enum là kiểu riêng.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENUM-02 — Mã ổn định qua đổi thứ tự

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Field final, constructor enum.
- **Bối cảnh và yêu cầu:** Enum Channel { EMAIL("E"), SMS("S"), PUSH("P"); private final String code; ... }. Dự đoán EMAIL.name(), EMAIL.ordinal(), EMAIL.code(). Sau đó mô phỏng khai báo PUSH trước EMAIL: thứ gì thay đổi? Ghi dự đoán rồi kiểm chứng bằng enum thứ hai cùng tên hằng trong class khác hoặc tên khác.
- **Dữ liệu / ví dụ sử dụng:** Ban đầu EMAIL ở vị trí đầu, code E; sau đổi thứ tự PUSH,EMAIL,SMS.
- **Trường hợp biên:** Không ghi ordinal làm ID; code không phụ thuộc vị trí. Không sửa enum có sẵn của người học.
- **Hoàn thành khi:** Nêu rõ ordinal đổi, name/code giữ; code getter và constructor enum không public.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENUM-03 — Đọc mã không phải tên enum

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** valueOf, parsing có hợp đồng.
- **Bối cảnh và yêu cầu:** Người viết dùng Channel.valueOf("E") để đọc mã E, nên không nhận được EMAIL. Sửa bằng fromCode(String code) trả hằng theo code, không khớp trả null; chấp nhận code chữ thường và khoảng trắng ở hai đầu. Không sửa tên hằng thành E. Có thể dùng values() và loop, không bắt try/catch.
- **Dữ liệu / ví dụ sử dụng:** fromCode(" e ") → EMAIL; fromCode("SMS") →null vì SMS là name, không phải code S.
- **Trường hợp biên:** null, rỗng, "X"; tránh gọi trim trên null; mã chỉ E/S/P.
- **Hoàn thành khi:** Đủ ca và giải thích valueOf so khớp name chính xác, không tra code tùy chỉnh.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENUM-04 — Phiếu hỗ trợ có trạng thái

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Enum và chuyển trạng thái.
- **Bối cảnh và yêu cầu:** Tạo TicketState OPEN/WORKING/RESOLVED/CLOSED. canMoveTo: OPEN→WORKING hoặc CLOSED; WORKING→RESOLVED; RESOLVED→WORKING hoặc CLOSED; CLOSED không đi tiếp. Mọi chuyển sang chính nó hoặc null đều false. Tạo SupportTicket khởi đầu OPEN, moveTo cập nhật chỉ khi hợp lệ và trả boolean.
- **Dữ liệu / ví dụ sử dụng:** OPEN→WORKING→RESOLVED→WORKING là ba lần true; OPEN→RESOLVED false; CLOSED→OPEN false.
- **Trường hợp biên:** Mọi cặp trạng thái gồm self; null; chuyển sai giữ nguyên object state.
- **Hoàn thành khi:** Quy tắc ở enum, object giữ private state; không setter tùy ý.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENUM-05 — Tổng kết phân luồng phiếu

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Enum, OOP, mảng và kiểm tra đầy đủ.
- **Bối cảnh và yêu cầu:** SupportTicket ở ENUM-04 nhận thêm Channel qua constructor, null dùng EMAIL; chỉ đọc channel. Viết countByState(SupportTicket[]) trả int[] theo thứ tự được quy định OPEN,WORKING,RESOLVED,CLOSED, bỏ phiếu null và mảng null trả bốn số0. Dùng switch ánh xạ vị trí rõ ràng thay ordinal. Tạo ba phiếu có các kênh đọc từ mã, chuyển trạng thái rồi thống kê.
- **Dữ liệu / ví dụ sử dụng:** Ba phiếu ở OPEN,WORKING,CLOSED và một ô null → [1,1,0,1]. Channel null → EMAIL.
- **Trường hợp biên:** Mảng rỗng/toàn null; RESOLVED mở lại; mã lạ trả null rồi constructor áp dụng mặc định đã công bố.
- **Hoàn thành khi:** Đúng thống kê, chuyển sai không đổi; giải thích tại sao thứ tự output là hợp đồng độc lập thứ tự enum.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
