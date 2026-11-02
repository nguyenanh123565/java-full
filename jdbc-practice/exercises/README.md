# Tổng hợp JDBC — làm trước khi mở solution

TODO: tự xây ProductDao với add/list/findById/update/delete, không có SQL ở menu CLI.

1. Dự đoán trước khi chạy: tên có dấu nháy, bảng rỗng, id không tồn tại, price âm và rollback sau bước ghi thứ hai.
2. Tạo test checklist thủ công: đầu vào → SQL dự kiến → kết quả DB → object Java → thông báo CLI.
3. Vì sao DAO không trả ResultSet? Vì sao một nghiệp vụ nhiều câu SQL cần dùng cùng Connection?
4. Liên hệ Java Core: interface, List, Optional, exception, BigDecimal; HTTP: giả sử chuyển CLI thành REST, trách nhiệm nào đổi? SQL: WHERE, constraint, transaction.
5. TODO: viết phương án chuyển stock giữa hai product, ghi hai SQL và đặt ranh giới transaction; chưa cần code đồng thời phức tạp.

Tiêu chí hoàn thành: không nối input vào SQL, đóng tài nguyên, phân biệt not-found với lỗi kết nối, rollback không để dữ liệu nửa chừng. Không lưu credential trong source.
