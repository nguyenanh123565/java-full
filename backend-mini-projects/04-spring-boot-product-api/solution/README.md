# Đối chiếu Product API

Reference ở [Spring mini project](../../../spring-boot-practice/mini-project/README.md).
Controller nhận HTTP/DTO và status; service giữ quy tắc; repository giữ lưu trữ.
Với Map, restart mất dữ liệu. Khi đổi sang JDBC, giữ interface repository và đặt
SQL trong DAO; không đổi controller thành nơi mở Connection.
Sau khi đủ cơ chế mới làm biến thể JPA và thêm test từ testing-practice.
