# Đối chiếu — Process: chương trình đang thực thi

File JAR là input; mỗi lần chạy tạo process riêng. Mỗi process có thể yêu cầu bind cùng một host address/port nên lần sau có thể bị address already in use. App Java giữ object và JDBC connection; PostgreSQL giữ dữ liệu DB. Chỉ kết thúc process thử có PID xác định.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
