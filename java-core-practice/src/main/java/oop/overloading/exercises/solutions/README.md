# Đối chiếu sau cùng: Nạp chồng rõ ý định

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.overloading.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## OVL-01 — Nhãn một hoặc nhiều bản

**Cách làm / kết quả đối chiếu:** label(text) gọi label(text,1); bản đầy đủ kiểm tra copies, chuẩn hóa text và nối | giữa các lượt.

**Lỗi hay gặp:** Bỏ qua bản text rỗng làm sai số dấu phân cách.

## OVL-02 — Mở rộng primitive

**Cách làm / kết quả đối chiếu:** Lần lượt int,long,int; literal L có kiểu long, short mở rộng int trong tập overload này.

**Lỗi hay gặp:** Chọn overload dựa vào giá trị 3 vừa int thay vì kiểu khai báo long.

## OVL-03 — Đổi tên tham số không đủ

**Cách làm / kết quả đối chiếu:** tag(int) ủy quyền label("X",count), tag(String,int) vào label; size(String) trả int. Xóa khai báo trùng chứ không chỉ đổi tên biến.

**Lỗi hay gặp:** Đổi count thành quantity rồi tưởng đã khác chữ ký.

## OVL-04 — Thứ tự kiểu tham số

**Cách làm / kết quả đối chiếu:** String,int và int,String là hai signature; hai cặp int,int không thể phân biệt bằng tên. Tên như formatNameCount có thể rõ hơn khi ngữ nghĩa khác.

**Lỗi hay gặp:** Tưởng đảo tên tham số cùng kiểu tạo method mới.

## OVL-05 — Overload trước, override sau

**Cách làm / kết quả đối chiếu:** Kết quả base-string,fancy-object,base-string. Compiler chọn String,Object,String; chỉ signature Object bị Fancy override.

**Lỗi hay gặp:** Dùng kiểu runtime String của o để đổi sang overload String.

## Câu hỏi review — điểm cần có

1. **Kiểu trả về có tham gia phân biệt overload không?** Không. Chỉ đổi return hoặc tên biến tham số không tạo chữ ký mới; danh sách kiểu/số lượng/thứ tự kiểu mới phân biệt overload.
2. **Vì sao đổi kiểu khai báo đối số có thể đổi overload?** Compiler chọn overload dựa kiểu khai báo đối số; Object o giữ String vẫn có kiểu đối số Object lúc chọn overload.
3. **Khi nào overload thuận tiện trở thành API khó đọc?** Khi nhiều thứ tự/tham số cùng kiểu hoặc ngữ nghĩa khác làm caller khó đoán. Một tên method thể hiện rõ ý định có thể tốt hơn thêm overload.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
