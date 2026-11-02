# Bài tổng hợp JPA — chưa xem solution

TODO: xây Product/Category với repository và service trong console lab của riêng bạn.

1. Vẽ class/table/field/column, PK/FK, owning side và mappedBy.
2. Dự đoán SQL CRUD; chứng minh managed entity update qua dirty checking và fail-add rollback.
3. Tạo ít nhất ba category khác nhau, mỗi category có một product. Dự đoán và đếm SQL list DTO; sửa N+1 theo use case, không đặt EAGER mọi nơi.
4. Vì sao repository không thay thế service? Vì sao save khác commit? Vì sao entity không nên là HTTP response mặc định?
5. Liên hệ JDBC: viết PreparedStatement tương đương cho một derived query và một fetch join.
6. TODO: thiết kế Order/OrderItem có quantity/price tại thời điểm mua; giải thích vì sao không dùng ManyToMany thuần.

Tự ghi lỗi, SQL quan sát và cách kiểm chứng vào notes; không copy toàn reference vào exercise.
