# Tự làm — JPQL và entity query

TODO: Thêm JPQL lọc giá tối thiểu vào bản sao repository; so sánh query và kết quả với JDBC PreparedStatement tương đương.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: JDBC: PreparedStatement dùng ?, JPQL thường dùng :minimum; SQL WHERE/ORDER BY vẫn là mental model nền. HTTP query minPrice cần parse/validate trước khi gọi repository.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
