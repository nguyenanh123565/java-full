# Demo trace một request — reference chạy ở thư mục cha

Đây là mô tả ứng dụng có source đầy đủ ở [README cha](../README.md), không phải Maven module riêng.

1. Client gửi GET /products/count tới host port 8081.
2. Mapping chuyển vào app port 8080, MVC chọn ProductCountController.count.
3. Controller gọi service; service gọi repository qua constructor dependency.
4. JdbcTemplate dùng DataSource từ JDBC environment; driver kết nối db:5432.
5. PostgreSQL chạy SELECT COUNT(*) FROM products. Aggregate trả một row ngay cả khi table rỗng.
6. Long trở thành field count của record; message converter ghi HTTP 200 + JSON.

Hai row seed trên volume mới cho count=2. Không có danh sách product trong memory thay database; nếu SQL không chạy được, endpoint không thể tạo số đếm đúng. Trước khi chạy, dự đoán điểm lỗi khi hostname DB sai và khi path HTTP sai; chúng thuộc hai lớp khác nhau.
