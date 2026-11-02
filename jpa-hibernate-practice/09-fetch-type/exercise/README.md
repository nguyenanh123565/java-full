# Tự làm — Fetch type và thời điểm đọc dữ liệu

TODO: Đo SQL của list và list-details với ba category khác nhau; dự đoán trước khi chạy. Giải thích vì sao DTO được tạo trong service transaction.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: Java Core: gọi getter có thể không còn là đọc field đơn giản khi có proxy. JDBC: mỗi query có chi phí mạng; SQL JOIN đọc nhiều bảng; HTTP: DTO cần được tạo trước khi rời persistence context.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
