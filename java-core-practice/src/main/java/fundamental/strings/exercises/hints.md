# Gợi ý: Chuỗi

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## STR-01 — Đếm nguyên âm ASCII

**Mức 1:** Có thể đổi bản chuẩn hóa sang chữ hoa rồi duyệt.

**Mức 2:** So từng char với A,E,I,O,U bằng ||, không dùng == giữa hai String.

## STR-02 — Alias của builder sau khi gán lại

**Mức 1:** Tới append đầu tiên, a và b còn cùng builder.

**Mức 2:** Sau b=new..., a vẫn giữ builder AB, saved vẫn A.

## STR-03 — Lệnh EXIT không được nhận

**Mức 1:** Chuẩn hóa tạo kết quả mới.

**Mức 2:** Sau null guard, dùng "EXIT".equals(text.trim().toUpperCase(Locale.ROOT)).

## STR-04 — Ghép nhãn có chọn lọc

**Mức 1:** Chỉ thêm dấu phân cách khi đã có nội dung trước đó.

**Mức 2:** Kiểm tra builder.length()>0 trước append("|") cho một nhãn hợp lệ.

## STR-05 — Sổ mã ba chữ cái

**Mức 1:** Kiểm tra độ dài trước charAt.

**Mức 2:** Mã hợp lệ nếu mọi char sau chuẩn hóa đều >=A và <=Z; codeReport dùng lại validCode và cách ghép bài STR-04.
