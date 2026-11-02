# Tham khảo: Chuỗi

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## STR-01 — Đếm nguyên âm ASCII

Tạo biến upper=text.toUpperCase(Locale.ROOT), duyệt 0..length-1 và tăng count khi gặp nguyên âm.

**Lỗi thường gặp:** Đếm y hoặc không gán kết quả toUpperCase nên bỏ sót chữ thường.

## STR-02 — Alias của builder sau khi gán lại

Kết quả AB,CD,A,false. Nếu ban đầu rỗng: B,CD,"",false; String snapshot không tự cập nhật theo builder.

**Lỗi thường gặp:** Nghĩ saved là một cửa sổ trực tiếp theo dõi builder.

## STR-03 — Lệnh EXIT không được nhận

Literal.equals so nội dung an toàn; kiểm tra null trước trim; không sửa text của caller.

**Lỗi thường gặp:** Dùng replace để xóa mọi khoảng trắng và nhận sai EX IT thành EXIT.

## STR-04 — Ghép nhãn có chọn lọc

Duyệt mảng, skip null/trống, thêm phân cách theo độ dài builder rồi append nhãn; toString khi kết thúc.

**Lỗi thường gặp:** Append | mỗi lượt rồi cắt ký tự cuối làm lỗi khi kết quả rỗng.

## STR-05 — Sổ mã ba chữ cái

validCode chuẩn hóa và kiểm tra 3 char; báo cáo chỉ append mã đã chuẩn hóa khi hợp lệ. Đây là lọc, không là tập hợp.

**Lỗi thường gặp:** Chỉ kiểm tra length==3 mà không kiểm tra nội dung.
