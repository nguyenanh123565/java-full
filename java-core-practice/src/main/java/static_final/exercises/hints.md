# Gợi ý: Static và final

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## STF-01 — Hai phòng dùng chung giới hạn

**Mức 1:** Mỗi phòng có trạng thái riêng, cùng một quy tắc sức chứa.

**Mức 2:** reserve kiểm tra used>=CAPACITY trước tăng; getter chỉ đọc.

## STF-02 — Final giữ điều gì?

**Mức 1:** Final cấm gán lại chính biến được đánh dấu.

**Mức 2:** alias[0] và limits[0] là cùng một ô; gán limits=... là thay biến reference.

## STF-03 — Số dư của người này sửa người khác

**Mức 1:** Cùng một field static được mọi instance truy cập.

**Mức 2:** balance bỏ static; validate trước gán và trước created++.

## STF-04 — Lịch có các hàng độc lập

**Mức 1:** Copy ngoài vẫn giữ reference tới hàng nguồn.

**Mức 2:** Viết helper kiểm tra và tạo bản copy từng hàng; gọi khi nhận vào và khi trả ra.

## STF-05 — Hai giỏ hàng và bộ đếm chung

**Mức 1:** Đừng cộng amount trước khi biết phép cộng an toàn.

**Mức 2:** Kiểm tra amount<=99-current trước cập nhật; tăng static count sau khi thay đổi thành công.
