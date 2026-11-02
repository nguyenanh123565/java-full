# Bài tập tự làm: Tổng hợp OOP: dữ liệu, hành vi và cộng tác

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Hoàn thành 10 mục con OOP theo [thứ tự trong README](../README.md) và fundamental (method, array, String, reference). Nhóm bài này tổng hợp sau composition, trước exception/static_final/generics/collections/enum. Chỉ Java Core, mảng, boolean, long, interface/abstract class/override; không bắt exception, enum, List, lambda, stream, database hay gửi email/SMS thật.

Nhóm OOP cũ có ba hướng luyện chung và mỗi mục con đã có ba TODO. Bộ này không lặp lại Student/Animal/Shape/Wallet: bảy bước luyện và một bài tổng kết mô phỏng đơn hàng. Các mục con có bộ riêng ở exercises/ của từng mục; làm nhóm này sau cùng.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## OOP-01 — Một dòng hàng tự tính tiền

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Class, object, constructor, this, hành vi.
- **Bối cảnh và yêu cầu:** Tạo mô hình dòng hàng có tên, đơn giá nguyên và số lượng; tự chọn tên class/method. Constructor nhận tên null/rỗng thì dùng Unnamed, giá ngoài 0..1000000 dùng 0, số lượng ngoài 1..100 dùng 1. Dòng hàng tự trả thành tiền bằng long; chỉ đọc dữ liệu, không có setter. Tạo hai dòng khác nhau và giải thích this.
- **Dữ liệu / ví dụ sử dụng:** Tên Pen, giá2000, số lượng3 →6000; tên null, giá-1, số lượng0 →Unnamed,0,1,total0.
- **Trường hợp biên:** Giá0/1000000; số lượng1/100/101; chuỗi chỉ khoảng trắng giữ nguyên.
- **Hoàn thành khi:** Có hai object độc lập, constructor tạo trạng thái hợp lệ và method tính tiền; trách nhiệm tính thuộc dòng hàng.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OOP-02 — Giá sản phẩm đổi sau khi thêm

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Reference, snapshot và trách nhiệm.
- **Bối cảnh và yêu cầu:** Một Product có giá 100 và method changePrice hợp lệ; dòng hàng chụp tên/đơn giá/số lượng2 vào constructor ở OOP-01. Sau đó đổi Product thành120. Dự đoán tổng dòng hàng và giá Product. So sánh thiết kế khác: dòng giữ Product và mỗi lần total lấy giá hiện tại. Chọn chính sách phù hợp khi đơn đã xác nhận phải giữ giá lúc mua.
- **Dữ liệu / ví dụ sử dụng:** Bắt đầu giá100,số lượng2; sau changePrice(120).
- **Trường hợp biên:** Hai dòng cùng Product; Product đổi tên/giá không được tự đổi snapshot đã mua.
- **Hoàn thành khi:** Có dự đoán hai thiết kế, chỉ ra snapshot dữ liệu khác giữ reference và nêu chính sách giá bằng lời.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OOP-03 — Thêm dòng phải nguyên vẹn

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Đóng gói, kiểm tra trước cập nhật.
- **Bối cảnh và yêu cầu:** Kho dòng hàng nháp có `count++; lines[count-1]=line; if (line==null || count>lines.length) return false;`. Tìm lỗi null và vượt mảng; viết cách thêm để thất bại không thay đổi count hoặc mảng. Chưa cần triển khai cả đơn. Quy định tối đa2 dòng trong bài nhỏ.
- **Dữ liệu / ví dụ sử dụng:** Thêm null vào mảng rỗng →false,count0; thêm hai dòng hợp lệ →count2; thêm dòng thứ3 →false,count2.
- **Trường hợp biên:** Mảng đã đầy; số ô null chưa dùng; không đọc phần tử ngoài mảng để kiểm tra sức chứa.
- **Hoàn thành khi:** Có kiểm tra count và hai ô sau mỗi thất bại; giải thích vì sao kiểm tra sau ghi không bảo đảm an toàn.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OOP-04 — Chọn quan hệ thiết kế

- **Mức độ:** Thiết kế + suy luận.
- **Kiến thức luyện:** Kế thừa, is-a, composition.
- **Bối cảnh và yêu cầu:** Đánh giá ba đề xuất: EmailSender extends Order để lấy mã đơn; ExpressOrder extends Order nhưng cấm thêm dòng trong khi hợp đồng Order cho phép; Receipt giữ dữ liệu Order để xuất biên nhận. Với từng đề xuất, nêu vai trò, hành vi caller mong đợi và lý do chấp nhận/đổi thiết kế. Viết một mô hình object nhỏ để render biên nhận từ mã/tổng, không bắt tạo subclass Order.
- **Dữ liệu / ví dụ sử dụng:** Mã A1,tổng40000 →Receipt.render() trả A1:40000.
- **Trường hợp biên:** Đơn rỗng tổng0; đầu vào mã null/rỗng chuẩn hóa DRAFT; không sửa đơn trong render.
- **Hoàn thành khi:** Nêu ít nhất một lúc không dùng kế thừa và một trường hợp lớp con hợp lý giữ hợp đồng; thiết kế khác được chấp nhận nếu giải thích rõ.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OOP-05 — Interface và lớp abstract cho thông báo

- **Mức độ:** Vận dụng + so sánh.
- **Kiến thức luyện:** Abstraction, interface, abstract class, polymorphism.
- **Bối cảnh và yêu cầu:** Định nghĩa Sender có render(String message), null xem rỗng. Hai implementation trả EMAIL:message và SMS:message. Caller chỉ nhận Sender. Sau đó làm biến thể abstract PrefixSender giữ prefix và triển khai render chung, lớp con cung cấp channelName() abstract; chuỗi là prefix+channelName()+":"+message. Viết 4–6 dòng so sánh hai thiết kế, không ép capstone kế thừa nếu không cần chia sẻ state.
- **Dữ liệu / ví dụ sử dụng:** Sender Email với "A1" →EMAIL:A1; biến thể prefix "[SHOP]" và Email →[SHOP]EMAIL:A1.
- **Trường hợp biên:** message null/rỗng; prefix null xem rỗng; implementation method interface phải public.
- **Hoàn thành khi:** Caller đa hình không if tên lớp, biến thể abstract có state/constructor và một điểm thay đổi; đánh giá lợi/hại.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OOP-06 — Biên nhận dùng bộ định dạng

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Composition, interface và phân trách nhiệm.
- **Bối cảnh và yêu cầu:** Tạo Receipt lấy mã/tổng đơn và ReceiptFormat qua constructor; null format dùng PlainFormat. Mã null/rỗng dùng DRAFT, tổng âm dùng0. PlainFormat tạo id:total; BracketFormat tạo [id:total]. Receipt.render chỉ ủy quyền, không biết kiểu cụ thể. Thay format bằng cách tạo Receipt mới.
- **Dữ liệu / ví dụ sử dụng:** Receipt("A1",40000,Plain) →A1:40000; Bracket →[A1:40000].
- **Trường hợp biên:** Mã rỗng, tổng0; null collaborator theo chính sách mặc định; không kế thừa ReceiptFormat.
- **Hoàn thành khi:** Có giải thích ba trách nhiệm dữ liệu/điều phối/định dạng; thêm format khác không sửa render.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OOP-07 — Đơn hàng giữ bất biến

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Encapsulation, array, composition, validation.
- **Bối cảnh và yêu cầu:** Tự thiết kế đơn nháp có mã (null/rỗng dùng DRAFT), tối đa10 dòng, tổng được tính từ các dòng. add(name,unitPrice,quantity) chỉ nhận tên non-null/non-empty, giá0..1000000, số lượng1..100; sai trả false và không đổi. Mỗi add thành công là dòng riêng kể cả tên trùng. confirm() chỉ true đúng lần đầu khi có ít nhất một dòng; sau đó không thêm được. Chỉ đọc mã/tổng/count/trạng thái qua API.
- **Dữ liệu / ví dụ sử dụng:** add("Pen",2000,3), add("Book",10000,2) →total26000,count2; confirm→true; thêm tiếp→false; confirm lần2→false.
- **Trường hợp biên:** Đơn rỗng không confirm; dòng thứ11 từ chối; giá0 hợp lệ; giữ giá snapshot khi Product ngoài đổi.
- **Hoàn thành khi:** Không lộ mảng nội bộ; không setter tổng/trạng thái; kiểm đủ sai không đổi; viết trách nhiệm từng object và lý do không dùng kế thừa ở đây.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OOP-08 — Đơn hàng và thông báo nhiều kênh

- **Mức độ:** Tổng kết — mở.
- **Kiến thức luyện:** Thiết kế OOP, đa hình, composition, mở rộng.
- **Bối cảnh và yêu cầu:** Dựa trên OOP-07, tự xác định class, dữ liệu, hành vi và trách nhiệm để xác nhận đơn rồi tạo thông báo mô phỏng qua EMAIL và SMS. Không dùng dịch vụ thật. Một thao tác tạo thông báo nhận đơn đã xác nhận và mảng các kênh; trả String[] cùng thứ tự, nội dung chính xác CHANNEL:id:total. Đơn null/chưa xác nhận, mảng kênh null/rỗng hoặc có ô null →mảng rỗng, không tạo thông báo từng phần. Tạo lại thông báo cùng dữ liệu được phép, không đổi trạng thái đơn. Sau đó thêm PUSH, chỉ rõ code thêm/sửa; giải thích tính chất OOP thực sự dùng và vì sao không cần ép dùng đủ bốn.
- **Dữ liệu / ví dụ sử dụng:** Đơn O1: Pen2000x3 và Book10000x2, xác nhận → EMAIL:O1:26000 và SMS:O1:26000. Thêm PUSH →PUSH:O1:26000, xử lý đơn vẫn cùng hành vi.
- **Trường hợp biên:** Đơn rỗng; add sai; confirm hai lần; quá10 dòng; kênh null/toàn null; thông báo lặp lại; tổng tối đa1000000000 vẫn trong long; không gửi khi thiếu cấu hình.
- **Hoàn thành khi:** Chạy đủ ca dữ liệu/trạng thái/kênh; giải thích trách nhiệm từng class và vị trí đóng gói/đa hình/trừu tượng/composition nếu có. Thêm PUSH giữ hàm xử lý đơn và hàm duyệt kênh. Nêu một trade-off và một cách thiết kế khác hợp lý. Chấp nhận mọi mô hình đạt hành vi, không bắt tên class hay hierarchy.
- **Được dùng / giới hạn:** Chỉ kiến thức fundamental + 10 mục OOP: mảng, long, boolean, interface/abstract class tùy nhu cầu. Không Spring/DB/thư viện ngoài, collection/enum/exception/lambda; không gửi mạng thật.
