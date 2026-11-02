# Connection và DriverManager

## 1. Problem — vì sao cần khái niệm này?
Code Java cần biết server ở đâu, database nào và tài khoản nào được phép truy cập. Một kết nối thất bại không đồng nghĩa câu SELECT sai.

## 2. Mental model
DriverManager chọn driver từ JDBC URL, driver mở phiên kết nối, Connection đại diện cho phiên đó. URL, user và password là cấu hình; không đưa mật khẩu thật vào source hoặc Git.

## 3. Ví dụ nhỏ
`DriverManager.getConnection(url, user, password)` trả Connection. `connection.isValid(2)` kiểm tra kết nối bằng timeout hai giây; không thay thế việc xử lý lỗi khi query.

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: object có vòng đời và có thể ném SQLException. HTTP: host/port xác định nơi gọi; SQL: một server có nhiều database, một database có nhiều schema.

## 5. Những lỗi thường gặp
Dùng URL http:// thay jdbc:postgresql://; nhầm tên database với schema; cố sửa code khi server/credential sai; in password vào log.

## 6. Câu hỏi tự kiểm tra
Driver jar có cần khi javac không? Vì sao Connection không nên là một static object dùng mãi?

## 7. Exercise
Đọc cấu hình từ biến môi trường và phân loại ba lỗi: thiếu biến, sai port, sai database. Chỉ ghi lỗi đã được lược bỏ thông tin nhạy cảm.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
