# Đối chiếu sau cùng: Ghi đè giữ hợp đồng

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.overriding.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## OVR-01 — Phí dịch vụ ưu tiên

**Cách làm / kết quả đối chiếu:** Con gọi super.fee(units), kết quả <0 trả -1, còn lại cộng 5.

**Lỗi hay gặp:** Cộng 5 vô điều kiện khiến đầu vào sai thành phí hợp lệ.

## OVR-02 — Method cha gọi method con

**Cách làm / kết quả đối chiếu:** Output fee=18 và fee=-1. describe kế thừa nhưng lời gọi fee dispatch theo PriorityService.

**Lỗi hay gặp:** Cho rằng mọi method được gọi trong code cha đều là implementation cha.

## OVR-03 — Chữ hoa làm khác method

**Cách làm / kết quả đối chiếu:** Đổi Fee thành fee cùng tham số int, gọi super để giữ validation rồi cộng 5 nếu hợp lệ.

**Lỗi hay gặp:** Chỉ đổi lời gọi sang Fee làm caller phụ thuộc lớp con.

## OVR-04 — Mở rộng không tự gọi lại

**Cách làm / kết quả đối chiếu:** Dùng super.fee và kiểm tra -1. Premium extends Service riêng, nếu extends Priority rồi cộng 10 sẽ thành phụ phí 15.

**Lỗi hay gặp:** Đổi this thành tên class nhưng gọi instance method như static.

## OVR-05 — Bảng giá giữ lời hứa

**Cách làm / kết quả đối chiếu:** Vòng lặp chỉ gọi fee. Compiler kiểm tra chữ ký/quyền truy cập, không chứng minh bất biến giá trị; ca kiểm tra bắt BadService trả -5.

**Lỗi hay gặp:** Cho rằng có @Override là implementation đã đúng nghiệp vụ.

## Câu hỏi review — điểm cần có

1. **@Override giúp phát hiện gì ngay khi biên dịch?** Phát hiện ý định override sai tên/chữ ký hoặc không có method cha phù hợp; không chứng minh công thức nghiệp vụ đúng.
2. **super.fee và this.fee trong fee của con đi đâu?** super.fee gọi implementation cha; this.fee trong fee của con quay lại cùng method con và gây đệ quy nếu không có điểm dừng.
3. **Override đúng chữ ký đã đủ giữ đúng hành vi chưa?** Chưa. BadService đúng chữ ký vẫn trả -5 trái hợp đồng; phải kiểm tra hành vi và biên, không chỉ annotation.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
