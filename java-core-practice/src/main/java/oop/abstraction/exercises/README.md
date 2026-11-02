# Bài tập tự làm: Trừu tượng bằng lớp abstract

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau inheritance và encapsulation. Bài mới dùng abstract class/method và method cụ thể; chưa bắt interface (so sánh ở nhóm OOP sau khi học interface_demo). Chưa cần final/static, exception hoặc số thực. Bài Report final cũ là mở rộng đọc lại sau static_final.

Bài cũ [AbstractionExercise.java](../AbstractionExercise.java) dùng Shape/Rectangle/Circle và Report. Bộ mới trừu tượng cách tính phí, quy trình nhận dữ liệu và điểm mở rộng hành vi.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.abstraction.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.abstraction.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## ABS-01 — Công thức phí giao hàng

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Abstract class, method cụ thể/abstract.
- **Bối cảnh và yêu cầu:** Tạo abstract Delivery có fee(int km) và label(). label() trả "Delivery". FlatDelivery fee luôn 20 với km 0..100, ngoài miền trả -1. Không tạo trực tiếp Delivery; tạo biến Delivery giữ FlatDelivery.
- **Dữ liệu / ví dụ sử dụng:** fee(0)=20, fee(10)=20, fee(-1)=-1.
- **Trường hợp biên:** km 100 hợp lệ; 101 sai; giá trị -1 là kết quả từ chối, không phải phí.
- **Hoàn thành khi:** Biên dịch lớp con đủ method, gọi được method cụ thể của cha; giải thích abstract không có nghĩa mọi method đều abstract.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ABS-02 — Quy trình gọi bước thay đổi

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Dispatch trong method của abstract class.
- **Bối cảnh và yêu cầu:** Đọc: abstract Delivery có abstract int rate(); int fee(int km) { return 10 + km * rate(); }; BikeDelivery.rate() trả 2. Dự đoán Delivery d = new BikeDelivery(); d.fee(5). Giải thích method cha gọi rate nào và tại sao không cần if tên loại.
- **Dữ liệu / ví dụ sử dụng:** km=5; thử 0. Đoạn này chỉ nhận km hợp lệ 0..100.
- **Trường hợp biên:** Không gọi rate trong constructor; đối chiếu một lớp VanDelivery rate=4.
- **Hoàn thành khi:** Có dự đoán hai loại và vẽ luồng fee→rate; chỉ rõ phần cố định/phần thay đổi.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ABS-03 — Lớp cụ thể chưa hoàn chỉnh

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Triển khai abstract method đúng chữ ký.
- **Bối cảnh và yêu cầu:** Sửa `abstract class Delivery { abstract int fee(int km); } class BikeDelivery extends Delivery { int fee() { return 20; } }`. Giữ BikeDelivery là class cụ thể và cài phí 10+2*km cho km 0..100, ngoài miền -1. Giữ bản lỗi dưới comment.
- **Dữ liệu / ví dụ sử dụng:** new BikeDelivery().fee(5) →20.
- **Trường hợp biên:** fee() không thay thế fee(int); không new Delivery(); km âm/101 từ chối.
- **Hoàn thành khi:** Compiler chấp nhận @Override và giải thích lỗi là thiếu implementation, không phải lỗi runtime.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ABS-04 — Quy trình xuất nhãn

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Chia sẻ trạng thái, constructor abstract class.
- **Bối cảnh và yêu cầu:** Tạo abstract Label có private prefix; constructor chuẩn hóa null/rỗng thành INFO. abstract content(); render() trả prefix+":"+content(). StockLabel nhận prefix và quantity, quantity âm chuẩn hóa 0, content trả "stock="+quantity. Không gọi content trong constructor.
- **Dữ liệu / ví dụ sử dụng:** new StockLabel("SHOP",3).render() → SHOP:stock=3; null,-1 → INFO:stock=0.
- **Trường hợp biên:** quantity=0; prefix rỗng; lớp cha khởi tạo prefix trước lớp con.
- **Hoàn thành khi:** Hành vi chung nằm ở Label; lớp con chỉ cung cấp nội dung, giải thích lợi ích và rủi ro gọi override quá sớm.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ABS-05 — So sánh phương án giao hàng

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Abstract, kế thừa, mảng và validation.
- **Bối cảnh và yêu cầu:** Thiết kế Delivery chung có fee(km). BikeDelivery phí 10+2*km, VanDelivery phí 20+3*km; mọi loại nhận 0..100, sai trả -1. Viết cheapest(Delivery[] options,int km) trả phí nhỏ nhất hợp lệ, bỏ null; không có lựa chọn hợp lệ trả -1. Có thể chia sẻ validation/công thức trong cha nhưng giải thích lựa chọn.
- **Dữ liệu / ví dụ sử dụng:** Bike/Van với km=5 → min 20; chỉ Van →35; mảng null →-1.
- **Trường hợp biên:** Mảng rỗng/toàn null; km -1,101; km=0; không lấy -1 làm phí rẻ nhất.
- **Hoàn thành khi:** Không if theo class trong cheapest; đủ ca, trình bày cha chia sẻ gì và lớp con thay đổi gì.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
