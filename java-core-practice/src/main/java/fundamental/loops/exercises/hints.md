# Gợi ý: Vòng lặp

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## LOP-01 — Giai thừa có giới hạn

**Mức 1:** Tích rỗng không được khởi tạo bằng 0.

**Mức 2:** Duyệt factor từ 2 tới n, nhân vào long result=1.

## LOP-02 — Đọc vòng lọc có dừng sớm

**Mức 1:** Xét từng điều kiện theo đúng thứ tự trong thân.

**Mức 2:** 3 và 6 bị continue; 7 tới break; chỉ 1,2,4,5 được cộng.

## LOP-03 — While đứng yên ở số chẵn

**Mức 1:** Ở lượt i=4, câu lệnh nào có thể làm i thay đổi?

**Mức 2:** Có thể bỏ continue, chỉ cộng khi lẻ rồi luôn giảm i ở cuối thân.

## LOP-04 — Số chữ số không cần String

**Mức 1:** Mỗi lần chia nguyên 10 bỏ một chữ số cuối.

**Mức 2:** Dùng do-while để số 0 cũng có một lượt, hoặc xử lý 0 riêng.

## LOP-05 — Ngày đạt mục tiêu tiết kiệm

**Mức 1:** Tiếp tục khi total<target, không phải <=.

**Mức 2:** Mỗi lượt tăng day rồi cộng day*1000L; mục tiêu hữu hạn, tiền gửi dương nên sẽ dừng.
