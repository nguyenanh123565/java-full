# Gợi ý: Stream

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## STM-01 — Tổng độ dài tên hợp lệ

1. **Mức 1:** Mỗi bước chỉ làm một việc.
2. **Mức 2:** filter(Objects::nonNull), map(String::trim), filter không rỗng, mapToInt, sum.

## STM-02 — Lười tới terminal thực sự

1. **Mức 1:** Intermediate chỉ xây pipeline.
2. **Mức 2:** Chỉ số vượt filter mới vào map; toList cần giá trị mapped.

## STM-03 — Dùng lại stream đã kết thúc

1. **Mức 1:** Terminal làm stream consumed.
2. **Mức 2:** Gọi values.stream() cho từng phép tính.

## STM-04 — Tổng tồn kho đủ điều kiện

1. **Mức 1:** Tổng bắt đầu0 cho dữ liệu rỗng.
2. **Mức 2:** p.price * p.stock đã là long khi price có kiểu long.

## STM-05 — Báo cáo sản phẩm theo danh mục

1. **Mức 1:** Chia ba câu hỏi thành ba pipeline đọc cùng nguồn.
2. **Mức 2:** groupingBy(category,counting()) sau filter stock>0; comparator giá giảm rồi id tăng; limit k.
