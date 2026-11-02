# Đối chiếu sau cùng: Kế thừa đúng quan hệ

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.inheritance.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## INH-01 — Vé có tên sự kiện

**Cách làm / kết quả đối chiếu:** Ticket có getter getEvent; constructor con super(event) rồi gán seat. describe kết hợp getter với seat.

**Lỗi hay gặp:** Chép thêm event vào con khiến có hai field dễ lệch nhau.

## INH-02 — Giá trị cha và con

**Cách làm / kết quả đối chiếu:** getEvent là Music, t==r true; t.describe không biên dịch vì Ticket không có method đó. Object vẫn là ReservedTicket.

**Lỗi hay gặp:** Tưởng upcast biến object thành Ticket chỉ còn field cha.

## INH-03 — Constructor cha cần đối số

**Cách làm / kết quả đối chiếu:** Thêm super(e) đầu constructor con; nó dùng constructor sẵn có của cha và chỉ tạo một object con.

**Lỗi hay gặp:** new Ticket(e) trong thân không thay được super(e).

## INH-04 — Kế thừa có giữ lời hứa?

**Cách làm / kết quả đối chiếu:** Các loại vé extends Ticket và override price; vòng lặp gọi price. Receipt nên giữ dữ liệu/reference Ticket thay vì giả làm vé.

**Lỗi hay gặp:** Dùng kế thừa chỉ vì muốn dùng lại field event.

## INH-05 — Tổng kết quầy vé

**Cách làm / kết quả đối chiếu:** Ba class chia sẻ event qua cha, mỗi loại cung cấp price. sumPrices duyệt kiểu Ticket, cùng reference hai ô được tính hai lần.

**Lỗi hay gặp:** Dùng instanceof trong hàm tổng hoặc đếm số constructor thành số object.

## Câu hỏi review — điểm cần có

1. **Một lớp con có thể thay thế lớp cha nếu nó từ chối hành vi mà cha hứa không?** Không nếu lớp con phá lời hứa của cha. Quan hệ thay thế cần giữ hành vi, không chỉ compile bằng extends.
2. **super(...) có tạo object cha độc lập không?** Không. Constructor cha khởi tạo phần trạng thái được kế thừa trong cùng object con; upcast vẫn cùng reference.
3. **Dùng chung một field có đủ lý do để extends không?** Không. Receipt có dữ liệu vé nhưng là chứng từ, nên dùng dữ liệu/reference Ticket thay vì giả làm Ticket.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
