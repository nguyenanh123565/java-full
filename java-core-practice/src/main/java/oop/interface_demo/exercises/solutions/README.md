# Đối chiếu sau cùng: Hợp đồng bằng interface

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.interface_demo.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## INT-01 — Định dạng mã

**Cách làm / kết quả đối chiếu:** BracketFormatter implements TextFormatter, public format chuẩn hóa null rồi bọc ngoặc.

**Lỗi hay gặp:** Quên public trong implementation.

## INT-02 — Một object hai vai trò

**Cách làm / kết quả đối chiếu:** r.isOn là true, chỉ một Lamp. Switchable nhìn thấy turnOn, Readable nhìn thấy isOn; chúng cùng quan sát field on.

**Lỗi hay gặp:** Đặt state trong interface hoặc đếm ba object từ ba biến.

## INT-03 — Hợp đồng public

**Cách làm / kết quả đối chiếu:** Thêm @Override public String format(String text), xử lý null trước nối chuỗi.

**Lỗi hay gặp:** Bỏ interface để compile nhưng mất mục tiêu bài học.

## INT-04 — Ghép bộ định dạng

**Cách làm / kết quả đối chiếu:** Tạo mảng kết quả, mỗi formatter khác null nhận cùng text; HashFormatter cài công thức riêng.

**Lỗi hay gặp:** Cho formatAll tự chứa công thức của từng implementation.

## INT-05 — Kiểm tra biểu mẫu mở rộng

**Cách làm / kết quả đối chiếu:** NonEmptyRule/MaxLengthRule/StartsWithARule implement Rule. acceptsAll kiểm tra cấu hình rồi duyệt. Interface đủ khi các rule không cần chia sẻ trạng thái instance.

**Lỗi hay gặp:** Cho mảng null tự qua hoặc ép mọi rule kế thừa một state không cần thiết.

## Câu hỏi review — điểm cần có

1. **Vì sao implementation không được giảm quyền public?** Method abstract thông thường của interface public, nên implementation phải cho phép ít nhất cùng quyền truy cập.
2. **Interface chia sẻ trạng thái instance như abstract class được không?** Không có field trạng thái riêng cho từng instance hoặc constructor như abstract class. State max/on thuộc class triển khai.
3. **Caller có cần biết tên class triển khai không?** Không. formatAll/acceptsAll chỉ gọi method hợp đồng; thêm implementation không buộc sửa vòng lặp.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
