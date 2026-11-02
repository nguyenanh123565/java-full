# Tự làm — Sinh ID và identity

TODO: Tạo mới hai sản phẩm và quan sát SQL; mô phỏng rollback một lần. Dự đoán khoảng trống id và giải thích từ SQL sequence.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: JDBC: INSERT ... RETURNING id; SQL: primary key/sequence. Java Core: Long nullable biểu diễn entity mới chưa có ID. HTTP POST có thể trả id mới, client không tự chọn id từ số hàng.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
