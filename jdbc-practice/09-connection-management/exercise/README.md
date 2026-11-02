# Bài tập — Vòng đời tài nguyên JDBC

TODO: Viết truy vấn dùng try-with-resources rồi cố tình ném lỗi trong vòng lặp. Đánh dấu ai sở hữu tài nguyên; giải thích cách giảm thời gian giữ Connection.

1. Dự đoán trước khi chạy: ghi kết quả, số dòng bị ảnh hưởng hoặc số câu SQL mong đợi.
2. Tạo ví dụ nhỏ của riêng bạn trong thư mục này; không chép demo nguyên vẹn.
3. Chạy trên môi trường học riêng theo README workspace. Ghi lệnh, kết quả thực tế và điểm khác dự đoán.
4. Vì sao hành vi đó xảy ra? Trả lời bằng luồng xử lý, không chỉ tên annotation/API.
5. Liên hệ kiến thức cũ: Java Core: AutoCloseable và scope. HTTP: request kết thúc thì tài nguyên phục vụ request cần được trả. SQL: transaction giữ lock cho tới khi kết thúc. Connection pool chỉ giới thiệu khái niệm; chưa thêm thư viện.
6. TODO: thêm một trường hợp lỗi, ghi cách tái hiện và nguyên nhân trước khi sửa.

Không có đáp án trong thư mục này. Kết quả khác dự đoán là dữ liệu để học.
