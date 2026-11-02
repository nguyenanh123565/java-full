# Tự làm — One-to-many và many-to-one

TODO: Tạo hai category và ba product bằng lab; chuyển một product giữa hai category trong bản sao service, đồng bộ hai phía và kiểm tra FK bằng SQL.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: Java Core: List chứa object reference; SQL: products.category_id FK; JDBC: join cùng khóa; HTTP: DTO product có categoryName thay vì trả cả collection entity.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
