# Kiểm các thành phần ghép thật

## 1. Problem — vì sao tồn tại
Mock không phát hiện sai SQL, thiếu driver, port/wiring hoặc schema không phù hợp.

## 2. Mental model
Integration test khai báo rõ ranh giới: HTTP thật → app Map, hoặc JDBC thật → PostgreSQL. Hai ranh giới này khác nhau.

## 3. Ví dụ nhỏ
@SpringBootTest(RANDOM_PORT) mở app thật; JDBC test dùng Connection và TEMP TABLE trong transaction rollback.
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
Java exceptions, HTTP serialization và SQL NUMERIC được quan sát ở lớp tương ứng. DB test phải dùng DB học riêng.

## 5. Những lỗi thường gặp
Gọi H2 là PostgreSQL tương đương; phụ thuộc dữ liệu có sẵn; test cần DB nhưng bỏ qua và báo tất cả đã được kiểm.

## 6. Câu hỏi tự kiểm tra
Vì sao HTTP integration với Map chưa kiểm persistence? Rollback có xóa TEMP TABLE ON COMMIT DROP không?

## 7. Exercise
TODO viết ma trận unit/MVC/HTTP/DB; tự thêm JDBC round-trip có FK trong DB học riêng sau khi nêu rõ dữ liệu dọn thế nào.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
