# Tự làm — JPA, Hibernate và Spring Data JPA

TODO: Vẽ luồng từ repository đến PostgreSQL, ghi mỗi lớp giải quyết vấn đề gì. Đối chiếu với JDBC tuần trước.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: Java Core: interface/implementation; JDBC: interface Connection và driver implementation là phép so sánh hữu ích nhưng không đồng nhất với JPA. HTTP vẫn do web layer xử lý, không phải Hibernate.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
