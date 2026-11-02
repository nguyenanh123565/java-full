# Đối chiếu sau cùng: Đa hình qua lớp cha

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.polymorphism.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## POLY-01 — Quy tắc giảm giá

**Cách làm / kết quả đối chiếu:** Hai lớp con override apply và từ chối ngoài miền trước tính toán; 101/2 bằng 50.

**Lỗi hay gặp:** Dùng số thực và làm tròn thành 51 trái hợp đồng chia nguyên.

## POLY-02 — Đổi biến giữ object

**Cách làm / kết quả đối chiếu:** Sau gán lại a: 100,50,false; trước gán lại a==b true. Hai object được tạo.

**Lỗi hay gặp:** Tưởng b tự theo dõi mọi phép gán tương lai vào a.

## POLY-03 — Chữ ký sai làm mất đa hình

**Cách làm / kết quả đối chiếu:** Viết @Override int apply(int price), validation như hợp đồng; d.apply(100) chọn chữ ký int rồi dispatch lớp con.

**Lỗi hay gặp:** Chỉ gọi bằng HalfDiscount và long để thấy 50 mà không sửa hợp đồng đa hình.

## POLY-04 — Bảng so sánh ưu đãi

**Cách làm / kết quả đối chiếu:** Tạo mảng int mới, duyệt theo chỉ số; null ghi -1, còn lại gọi apply(price).

**Lỗi hay gặp:** Loại bỏ ô null làm lệch vị trí hoặc ghi đè mảng đầu vào.

## POLY-05 — Thêm ưu đãi mới

**Cách làm / kết quả đối chiếu:** MinusTenDiscount override apply; giá hợp lệ trả price<10?0:price-10. Chỉ thêm object vào mảng lựa chọn; quote giữ nguyên.

**Lỗi hay gặp:** Để kết quả âm khi price<10 hoặc thêm nhánh if vào quote.

## Câu hỏi review — điểm cần có

1. **Kiểu khai báo và object thực tế quyết định hai việc khác nhau nào?** Kiểu khai báo quyết định chữ ký có thể gọi khi compile; object thực tế quyết định implementation instance bị override chạy.
2. **Thêm một lớp con có buộc sửa vòng lặp không?** Không nếu lớp con giữ cùng hợp đồng. Chỉ thêm implementation và đưa object mới vào dữ liệu/điểm lắp ráp.
3. **Vì sao cast không phải cách thêm hành vi chung?** Cast chỉ đổi góc nhìn reference, không thay object. Hành vi chung nên nằm trong hợp đồng cha để caller gọi đa hình.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
