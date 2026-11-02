# Đối chiếu sau cùng: Enum có dữ liệu và hành vi

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes enum_demo.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## ENUM-01 — Hướng di chuyển

**Cách làm / kết quả đối chiếu:** switch ánh xạ từng cặp đối diện; moveX kiểm tra null rồi switch, không phụ thuộc vị trí khai báo.

**Lỗi hay gặp:** Tính bằng ordinal+2 nên vô tình gắn quy tắc vào thứ tự.

## ENUM-02 — Mã ổn định qua đổi thứ tự

**Cách làm / kết quả đối chiếu:** Ban đầu EMAIL,0,E; sau đổi thứ tự EMAIL,1,E. Mã tự định nghĩa ổn định hơn thứ tự nhưng vẫn cần chủ động giữ hợp đồng mã.

**Lỗi hay gặp:** Cho rằng ordinal là một ID cố định do Java bảo đảm.

## ENUM-03 — Đọc mã không phải tên enum

**Cách làm / kết quả đối chiếu:** Kiểm tra null, trim rồi tìm Channel có code equalsIgnoreCase. valueOf("E") thất bại vì không có hằng tên E.

**Lỗi hay gặp:** Bắt lỗi rồi luôn trả EMAIL khiến mã sai bị chấp nhận.

## ENUM-04 — Phiếu hỗ trợ có trạng thái

**Cách làm / kết quả đối chiếu:** canMoveTo dùng switch trên this và so next bằng ==; moveTo chỉ gán nếu state.canMoveTo(next).

**Lỗi hay gặp:** Dùng ordinal tăng dần nên không cho mở lại RESOLVED→WORKING.

## ENUM-05 — Tổng kết phân luồng phiếu

**Cách làm / kết quả đối chiếu:** countByState switch state và tăng ô được quy định. Constructor xử lý channel null bằng EMAIL; mã lạ không được giả vờ parsing thành công.

**Lỗi hay gặp:** Dùng ordinal làm index ngầm mà tài liệu không bảo đảm thứ tự enum.

## Câu hỏi review — điểm cần có

1. **Enum khác một nhóm String ở khả năng kiểm tra kiểu như thế nào?** Enum là kiểu riêng, compiler chặn nhiều giá trị/lời gọi sai kiểu; String vẫn nhận mọi văn bản nếu không có validation riêng.
2. **Vì sao mã nghiệp vụ không dùng ordinal?** ordinal chỉ là vị trí khai báo. Đổi thứ tự làm nó đổi; mã code do hợp đồng nghiệp vụ quản lý độc lập.
3. **valueOf có chuẩn hóa khoảng trắng hoặc chữ thường tự động không?** Không. valueOf yêu cầu đúng name và chữ hoa/thường; fromCode trong bài tự trim và so code không phân biệt hoa/thường.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
