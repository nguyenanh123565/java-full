# Gợi ý: Bộ nhớ và vòng đời tham chiếu

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## MEM-01 — Qua hai frame

**Mức 1:** Array được tạo trong outer nhưng không phải chính biến local của outer.

**Mức 2:** inner nhận bản sao reference cùng array, còn seed ở main là int riêng.

## MEM-02 — Đường đi qua mảng ngoài

**Mức 1:** Reference có thể nằm ở slot của array, không chỉ local.

**Mức 2:** Trước table=null, saved đã sao chép reference hàng; array ngoài và hàng có đường đi khác nhau.

## MEM-03 — Mọi hàng trở thành hàng cuối

**Mức 1:** Gán vào nhiều slot không tạo ra array hàng mới.

**Mức 2:** Tạo new int[]{i} bên trong từng lượt, thay vì dùng một row chung.

## MEM-04 — Giữ dữ liệu sau khi bỏ vỏ chứa

**Mức 1:** Giữ array không phải giữ reference ngược về Slot.

**Mức 2:** Reference là có hướng: Slot->array và retained->array; array không tự dẫn ngược về Slot.

## MEM-05 — Lịch sử phiên bản độc lập

**Mức 1:** Mỗi phiên bản phải có array mới trước khi sửa.

**Mức 2:** Copy previous, sửa copy[index], return copy; history giữ reference độc lập với biến v0/v1.
