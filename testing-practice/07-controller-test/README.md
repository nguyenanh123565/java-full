# Kiểm HTTP mapping với MockMvc

## 1. Problem — vì sao tồn tại
Unit service không thấy route, status, JSON hoặc chuyển đổi path parameter.

## 2. Mental model
MockMvc chạy Spring MVC trong process, không mở TCP port. Dùng service mock để cô lập hợp đồng HTTP.

## 3. Ví dụ nhỏ
GET /products/1 → 200 JSON; ID không có → 404; /products/abc → 400.
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
HTTP method/path/status nối với @GetMapping; object Java được serialize thành JSON. Test này chưa kiểm SQL.

## 5. Những lỗi thường gặp
Tưởng MockMvc gọi port 8080; chỉ assert 200 mà không xem body; nhầm standalone setup với toàn bộ cấu hình ứng dụng.

## 6. Câu hỏi tự kiểm tra
Vì sao route đúng nhưng JSON vẫn sai? Test standalone bỏ qua cấu hình nào?

## 7. Exercise
TODO test URL không phải số, product thiếu, tên JSON; dự đoán status trước khi chạy curl/test.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
