# Tự làm — N+1 và fetch join có chủ đích

TODO: Tạo ít nhất ba category và ba product, mỗi product một category; dự đoán rồi đếm SELECT của list/list-details ở hai lần chạy app riêng. Giải thích chênh lệch.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: Java Core: vòng lặp getter có thể phát I/O; JDBC: mỗi executeQuery có chi phí; SQL LEFT JOIN cần hiểu trước. HTTP list DTO product/categoryName là use case quyết định fetch plan.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
