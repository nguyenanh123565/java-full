# Đối chiếu sau cùng: Trừu tượng bằng lớp abstract

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.abstraction.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## ABS-01 — Công thức phí giao hàng

**Cách làm / kết quả đối chiếu:** Delivery khai báo abstract int fee(int km), label có thân. FlatDelivery cài fee với validation và dùng label kế thừa.

**Lỗi hay gặp:** Bỏ thân cả label hoặc quên cài fee trong lớp cụ thể.

## ABS-02 — Quy trình gọi bước thay đổi

**Cách làm / kết quả đối chiếu:** Bike fee(5)=20 và fee(0)=10; Van fee(5)=30. Dù fee nằm ở cha, rate dispatch theo object.

**Lỗi hay gặp:** Cho rằng lời gọi từ cha buộc dùng cài đặt rate ở cha.

## ABS-03 — Lớp cụ thể chưa hoàn chỉnh

**Cách làm / kết quả đối chiếu:** Đổi thành @Override int fee(int km) và giữ validation. fee() khác chữ ký nên chưa triển khai method abstract.

**Lỗi hay gặp:** Đổi BikeDelivery thành abstract chỉ để hết lỗi nhưng vẫn định new nó.

## ABS-04 — Quy trình xuất nhãn

**Cách làm / kết quả đối chiếu:** Label lưu prefix và render gọi content sau khởi tạo. StockLabel gọi super(prefix) rồi gán quantity và override content.

**Lỗi hay gặp:** Gọi content trong constructor cha khi quantity con còn là giá trị mặc định.

## ABS-05 — So sánh phương án giao hàng

**Cách làm / kết quả đối chiếu:** Cha giữ fee validation và công thức qua base/rate abstract; cheapest duyệt Delivery, bỏ -1. Cũng hợp lệ nếu từng lớp con tự cài fee nhưng giữ cùng hợp đồng.

**Lỗi hay gặp:** Math.min ngay với giá khởi tạo -1 khiến kết quả luôn -1.

## Phiên bản độc lập và bản tổng hợp

ABS-02 dùng ReasoningDelivery/ReasoningBike/ReasoningVan để giữ đúng đoạn suy luận có base=10, rate lần lượt 2 và 4 (fee(5)=20/30). ABS-03 có DebugDelivery/FixedBikeDelivery triển khai trực tiếp fee(int). Bản tổng hợp ABS-05 dùng Delivery/BikeDelivery/VanDelivery tách base/rate để tái dùng validation, với Van base=20,rate=3. Sự khác tên trong file chỉ để nhiều phiên bản cùng biên dịch, không đổi kết quả từng đề.

## Câu hỏi review — điểm cần có

1. **Abstract class có thể có constructor không?** Có. Constructor cha abstract vẫn chạy khi tạo object lớp con, để khởi tạo phần trạng thái chung.
2. **Caller cần biết công thức tính phí không?** Không. Caller chỉ biết hợp đồng fee và sentinel -1; từng implementation cung cấp công thức, caller chọn phí hợp lệ thấp nhất.
3. **Vì sao tránh gọi method override từ constructor?** Method override có thể đọc field con trước khi constructor con gán chúng. Dời việc gọi ra sau khi new hoàn tất để tránh dữ liệu khởi tạo dở.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
