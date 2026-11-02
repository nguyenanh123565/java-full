# Assertion diễn đạt hợp đồng

## 1. Problem — vì sao tồn tại
Một test chạy không exception vẫn có thể trả sai tên hoặc sai số tiền.

## 2. Mental model
Assertion đối chiếu actual với expected của hợp đồng; assertThrows kiểm cả đường lỗi.

## 3. Ví dụ nhỏ
assertEquals("Book", product.name()); assertThrows(ProductNotFoundException.class, ...).
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
Equals Java quan trọng: BigDecimal.equals xét cả scale; SQL NUMERIC và JSON cũng cần quy ước biểu diễn tiền.

## 5. Những lỗi thường gặp
Đảo expected/actual; dùng assertTrue(a.equals(b)) làm thông báo khó đọc; so double tiền bằng ==.

## 6. Câu hỏi tự kiểm tra
Vì sao BigDecimal("1.0").equals(BigDecimal("1.00")) là false? Khi nào so compareTo?

## 7. Exercise
TODO viết assertion cho tên, stock và lỗi product không tồn tại; thêm một case BigDecimal khác scale.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
