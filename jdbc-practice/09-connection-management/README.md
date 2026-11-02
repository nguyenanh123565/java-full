# Vòng đời tài nguyên JDBC

## 1. Problem — vì sao cần khái niệm này?
Connection, Statement và ResultSet giữ tài nguyên ở client/server. Quên đóng có thể khiến ứng dụng chạy một lúc rồi hết kết nối.

## 2. Mental model
try-with-resources đóng theo thứ tự ngược: ResultSet → Statement → Connection, kể cả khi có exception. Đóng Connection đang có transaction chưa xong không thay cho commit/rollback rõ ràng.

## 3. Ví dụ nhỏ
`try (Connection c = ...; PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) { ... }`

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: AutoCloseable và scope. HTTP: request kết thúc thì tài nguyên phục vụ request cần được trả. SQL: transaction giữ lock cho tới khi kết thúc. Connection pool chỉ giới thiệu khái niệm; chưa thêm thư viện.

## 5. Những lỗi thường gặp
Đóng tài nguyên quá sớm rồi trả ResultSet; tạo kết nối không kiểm soát trong vòng lặp; chia sẻ Connection giữa nhiều thread; mở Connection để chờ người dùng nhập CLI.

## 6. Câu hỏi tự kiểm tra
Nếu body ném exception thì close có chạy không? Với pool, close Connection thường có ý nghĩa gì?

## 7. Exercise
Viết truy vấn dùng try-with-resources rồi cố tình ném lỗi trong vòng lặp. Đánh dấu ai sở hữu tài nguyên; giải thích cách giảm thời gian giữ Connection.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
