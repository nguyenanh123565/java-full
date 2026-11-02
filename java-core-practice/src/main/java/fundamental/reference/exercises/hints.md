# Gợi ý: Tham chiếu

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## REF-01 — Ảnh chụp số và alias

**Mức 1:** saved lưu giá trị int tại thời điểm gán.

**Mức 2:** alias giữ tham chiếu, saved giữ số; gán alias không gán a.

## REF-02 — Hai slot rồi tách một slot

**Mức 1:** Array sao chép reference shared vào từng slot.

**Mức 2:** Sửa field tác động Box chung; gán slot chỉ thay một reference.

## REF-03 — Reset không tới caller

**Mức 1:** Mục tiêu là đổi trạng thái object, không đổi một bản sao reference.

**Mức 2:** if(box!=null) box.value=0; không dùng box=new Box(0).

## REF-04 — Copy từng Box theo slot

**Mức 1:** Đừng chỉ copy reference của source[i].

**Mức 2:** Với mỗi slot khác null, dùng new Box(source[i].value).

## REF-05 — Chuyển giá trị giữa hai hộp

**Mức 1:** Nếu sửa from trước khi biết to hợp lệ, trạng thái có thể bị thay đổi dở dang.

**Mức 2:** Kiểm tra null và thiếu lượng; nếu from==to return true; còn lại trừ/cộng.
