# Tự làm — Transaction, persistence context và dirty checking

TODO: Chạy fail-add rồi SELECT kiểm tra không có hàng mới. Trong bản sao, đổi managed entity và so sánh SQL khi chỉ đọc. Giải thích flush/commit.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: JDBC: setAutoCommit(false)/commit/rollback vẫn là nền tảng dưới transaction manager. Java Core: exception và method call; HTTP request nghiệp vụ nên được bao bởi service transaction, không giữ transaction trong thời gian client suy nghĩ.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
