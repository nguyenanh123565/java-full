# Gợi ý: Biến và kiểu dữ liệu

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## VAR-01 — Bản ghi cảm biến

**Mức 1:** Tách kiểu của giá trị đếm lớn khỏi kiểu của số thứ tự.

**Mức 2:** Literal long cần hậu tố L; char đặt trong dấu nháy đơn.

## VAR-02 — Thu hẹp rồi gán lại

**Mức 1:** byte chỉ biểu diễn từ -128 tới 127.

**Mức 2:** Giữ lại 8 bit thấp khi thu hẹp int về byte; saved được gán trước raw=5.

## VAR-03 — Hai lỗi trước khi chạy

**Mức 1:** Đọc lỗi javac từng lỗi một, nhưng sửa cả hai nguyên nhân.

**Mức 2:** Khởi tạo count bằng 0 và thêm L vào literal lớn.

## VAR-04 — Tách thời lượng

**Mức 1:** Tính giờ trước rồi trừ số giây đã dùng cho giờ.

**Mức 2:** Từ phần còn lại tính phút; giây còn lại bằng phần đó trừ phút*60.

## VAR-05 — Báo cáo hai kho

**Mức 1:** Kiểu của biến đích không quyết định kiểu của phép nhân.

**Mức 2:** Nâng một toán hạng lên long trước nhân; chuyển tổng sang double trước chia cho 2.
