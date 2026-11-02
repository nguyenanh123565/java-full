# Đối chiếu sau cùng: Tổng hợp OOP: dữ liệu, hành vi và cộng tác

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## OOP-01 — Một dòng hàng tự tính tiền

**Cách làm / kết quả đối chiếu:** Một phương án Line giữ private name/unitPrice/quantity, chuẩn hóa constructor, total trả unitPrice*quantity; không setter vì là ảnh chụp lúc mua.

**Lỗi hay gặp:** Dùng int cho mọi phép tính rồi đổi sang long sau khi nhân hoặc tự gán tham số.

## OOP-02 — Giá sản phẩm đổi sau khi thêm

**Cách làm / kết quả đối chiếu:** Snapshot total giữ200, Product giá120; thiết kế đọc Product hiện tại cho240. Đơn xác nhận chọn snapshot để không đổi lịch sử.

**Lỗi hay gặp:** Cho rằng private reference tự ngăn thay đổi từ owner khác.

## OOP-03 — Thêm dòng phải nguyên vẹn

**Cách làm / kết quả đối chiếu:** Nếu line null hoặc count>=lines.length trả false; còn lại lines[count]=line; count++; return true.

**Lỗi hay gặp:** Tăng count trước kiểm tra hoặc để ArrayIndexOutOfBoundsException mới nhận ra đã đầy.

## OOP-04 — Chọn quan hệ thiết kế

**Cách làm / kết quả đối chiếu:** EmailSender nhận dữ liệu/reference qua method hoặc constructor; Receipt dùng has-a. ExpressOrder chỉ hợp lý nếu giữ hợp đồng hoặc hợp đồng loại đơn được định nghĩa lại rõ. Ví dụ PricePolicy con thay công thức nhưng vẫn trả giá hợp lệ là is-a hợp lý.

**Lỗi hay gặp:** Kế thừa chỉ để dùng lại getId hoặc coi mọi subclass bất kỳ là thay thế được cha.

## OOP-05 — Interface và lớp abstract cho thông báo

**Cách làm / kết quả đối chiếu:** Sender interface đủ cho hai công thức ngắn; PrefixSender implements Sender và giữ prefix, render gọi channelName. Đây là một phương án để chia sẻ code, không bắt mọi sender phải có lớp cha chung.

**Lỗi hay gặp:** Nhầm interface có constructor hoặc tạo abstract class chỉ để đủ tên tính chất.

## OOP-06 — Biên nhận dùng bộ định dạng

**Cách làm / kết quả đối chiếu:** Receipt giữ id/total snapshot và interface format; render gọi format.render(id,total). Constructor chuẩn hóa null.

**Lỗi hay gặp:** Viết if(format instanceof ...) trong Receipt hoặc để formatter sửa dữ liệu đơn.

## OOP-07 — Đơn hàng giữ bất biến

**Cách làm / kết quả đối chiếu:** Order chứa Line[], count và boolean confirmed; add kiểm tra trước ghi; total duyệt count; confirm kiểm count và confirmed. Composition đủ cho phần dữ liệu.

**Lỗi hay gặp:** Cho sửa total trực tiếp, confirm đơn rỗng hoặc cập nhật count khi thêm thất bại.

## OOP-08 — Đơn hàng và thông báo nhiều kênh

**Cách làm / kết quả đối chiếu:** Một phương án Order chứa Line; NotificationService nhận Sender[] qua method và chỉ gọi Sender.render với id:total. Email/Sms/Push implement Sender. Kiểm tra đơn đã confirmed và mọi sender trước tạo output. Chỉ thêm PushSender và phần lắp mảng; Order/service giữ nguyên.

**Lỗi hay gặp:** Gắn if EMAIL/SMS trong Order, gửi trước confirm hoặc ép Order kế thừa Sender để đủ tính chất OOP.

## Trách nhiệm và các tính chất trong capstone

| Thành phần mẫu | Trách nhiệm |
| --- | --- |
| Line | Giữ snapshot dữ liệu một dòng; tự tính thành tiền; không có setter. |
| Order | Sở hữu mảng dòng, kiểm tra thêm/xác nhận, bảo vệ count và trạng thái; suy ra tổng. |
| Sender và các implementation | Hợp đồng định dạng một thông báo; EMAIL/SMS/PUSH chỉ mô phỏng bằng chuỗi. |
| NotificationService | Kiểm tra đơn/cấu hình đủ, tạo nội dung và gọi đa hình; không chứa công thức từng kênh. |

Đóng gói nằm ở field private và API giữ bất biến; trừu tượng ở Sender; đa hình ở vòng lặp gọi render; composition ở Order chứa Line và service phối hợp các Sender. PrefixSender là biến thể abstract class cho OOP-05, không cần dùng trong capstone. Receipt/ReceiptFormat phục vụ OOP-04/06, không bắt thêm vào luồng xác nhận.

Để thêm PUSH, viết PushSender implements Sender, rồi thêm new PushSender() vào mảng ở main/điểm lắp ráp. Không sửa Order, NotificationService hoặc các kênh đã có. Phương án khác là một lớp kênh cấu hình prefix nếu cả ba chỉ khác nhãn; đều hợp lệ nếu giữ hợp đồng và giải thích lựa chọn.

Giới hạn có chủ ý: boolean không mô tả nhiều nguyên nhân thất bại; mảng có sức chứa 10 và dữ liệu không bền vững. Đây là bài OOP trong bộ nhớ; không cần giải quyết gửi mạng, lưu lịch sử hoặc transaction. Có thể mở rộng API kết quả sau khi đã học thêm, nhưng không bắt làm ở đây.

## Câu hỏi review — điểm cần có

1. **Object nào chịu trách nhiệm bảo vệ tổng tiền và trạng thái đơn?** Order bảo vệ count/trạng thái và suy ra tổng từ Line; Line giữ snapshot đơn giá/số lượng. Menu hoặc service không được tự đặt tổng/trạng thái.
2. **Tại sao một service không nên kế thừa object dữ liệu chỉ để tái sử dụng field?** EmailSender là kênh định dạng, không phải Order. Nhận dữ liệu hoặc collaborator qua tham số/constructor giữ đúng trách nhiệm.
3. **Interface và abstract class chia sẻ được những gì khác nhau?** Interface mô tả hợp đồng và nhiều vai trò; abstract class có constructor, state instance và code dùng chung. PrefixSender là biến thể minh họa, không bắt capstone dùng.
4. **Thêm một kênh thông báo mới có buộc sửa xử lý đơn không?** Không. Thêm PushSender implements Sender và đổi mảng ở điểm lắp ráp; Order và NotificationService không cần nhánh mới.
5. **Vì sao không cần ép bài đơn hàng dùng đủ bốn tính chất OOP?** Tính chất phục vụ hành vi cần đạt. Capstone dùng đóng gói, hợp đồng interface, đa hình và composition; không cần bịa quan hệ kế thừa class chỉ để đủ bốn.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
