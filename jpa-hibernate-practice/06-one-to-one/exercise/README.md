# Tự làm — Quan hệ one-to-one và owning side

TODO: Thiết kế ProductDetail riêng với FK UNIQUE trên giấy và trong bản sao lab mới; xác định owning side và thử lưu chỉ phía inverse.

1. Dự đoán trước khi chạy: kết quả, số hàng và số câu SQL. Ghi vào notes trước khi mở log.
2. Viết thử nghiệm nhỏ của bạn trong thư mục này hoặc bản sao lab học riêng; không chỉnh ba workspace cũ.
3. Kiểm chứng bằng SQL log và SELECT trực tiếp trên database học mới; so sánh với dự đoán.
4. Vì sao kết quả đó xảy ra? Giải thích theo mapping/transaction/SQL, không chỉ chép tên annotation.
5. Liên hệ kiến thức cũ: Java Core: hai reference cần được đồng bộ trong bộ nhớ; SQL: FK + UNIQUE; HTTP: nên trả DTO để không serialize Product ↔ Detail thành vòng lặp.
6. TODO: viết một trường hợp sai có thể tái hiện và cách chẩn đoán trước khi xem đáp án.

Thư mục này không chứa solution. Tạm hoãn demo có quan hệ mở rộng nếu bạn chưa tự thiết kế đủ DDL.
