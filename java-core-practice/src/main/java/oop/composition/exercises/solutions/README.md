# Đối chiếu sau cùng: Phối hợp object bằng composition

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.composition.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## COMP-01 — Máy in sở hữu hộp mực

**Cách làm / kết quả đối chiếu:** Printer có private Ink ink=new Ink(); print ủy quyền ink.consume; hai máy tạo hai hộp mực.

**Lỗi hay gặp:** Cho Printer extends Ink chỉ để lấy consume.

## COMP-02 — Chia sẻ hay sở hữu riêng

**Cách làm / kết quả đối chiếu:** Hai máy đều đọc 5 và chỉ một Ink; hai máy tự sở hữu riêng đọc 7 và8 sau cùng thao tác. null tạo hộp riêng mỗi lần.

**Lỗi hay gặp:** Tưởng constructor tự sao chép collaborator được truyền vào.

## COMP-03 — Máy tính giá không phải quy tắc giá

**Cách làm / kết quả đối chiếu:** PriceRule triển khai hai công thức; Checkout giữ private rule, chuẩn hóa null rồi gọi finalPrice.

**Lỗi hay gặp:** Chuyển công thức vào Checkout làm mất khả năng thay collaborator.

## COMP-04 — Bản sao danh sách công việc

**Cách làm / kết quả đối chiếu:** copy loop tạo Task[] mới và gán reference phần tử. Cấu trúc không bị lộ nhưng Task vẫn chia sẻ; đó là chính sách của đề.

**Lỗi hay gặp:** Gọi đây là deep copy hoặc trả trực tiếp mảng field.

## COMP-05 — Quầy in phối hợp các thành phần

**Cách làm / kết quả đối chiếu:** PrintDesk ủy quyền Printer, kiểm tra boolean rồi giao việc ReceiptStyle. Mở rộng style bằng implementation mới và thay phần lắp ráp.

**Lỗi hay gặp:** Trừ mực ở desk lẫn Printer hoặc luôn định dạng kể cả lệnh in bị từ chối.

## Câu hỏi review — điểm cần có

1. **Object sở hữu và object cộng tác được chia sẻ khác nhau thế nào?** Sở hữu riêng nghĩa owner chủ động tạo/quản lý thành phần; collaborator chia sẻ có thể được nhiều owner quan sát/sửa. SharedPrinter dùng Ink chung là quan hệ chia sẻ.
2. **Vì sao copy mảng object chưa chắc cô lập các object?** Copy mảng tạo cấu trúc mới nhưng từng ô vẫn giữ cùng reference Task. Đổi ô không ảnh hưởng Board, rename Task được chia sẻ thì có.
3. **Một object dùng object khác có cần extends không?** Không. Printer có Ink và PrintDesk có Printer/ReceiptStyle; ủy quyền hành vi thể hiện has-a thay vì extends chỉ để dùng lại code.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
