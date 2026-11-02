# JDBC overview

## 1. Problem — vì sao cần khái niệm này?
Một List<Product> chỉ sống trong bộ nhớ của JVM. Muốn lưu qua lần chạy sau, Java phải gửi yêu cầu đến PostgreSQL và đọc dữ liệu trả về.

## 2. Mental model
Java → JDBC API → PostgreSQL Driver → PostgreSQL → ResultSet → Java Object. JDBC API là các interface trong java.sql; driver là bản triển khai nói giao thức PostgreSQL. Database thực thi SQL, driver chuyển dữ liệu qua kết nối.

## 3. Ví dụ nhỏ
`SELECT 1 AS value` trả một hàng. `rs.next()` đưa con trỏ đến hàng đó; `rs.getInt("value")` tạo giá trị int ở Java.

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: interface và implementation giải thích vì sao biến Connection không buộc code ứng dụng vào class driver. HTTP cũng có client/server, nhưng JDBC nói giao thức PostgreSQL chứ không gửi HTTP request.

## 5. Những lỗi thường gặp
Nhầm JDBC là database; nghĩ driver chứa dữ liệu; nghĩ ResultSet tự biến thành Product; quên rằng SQL chạy ở server.

## 6. Câu hỏi tự kiểm tra
JDK có java.sql nhưng thiếu driver thì lỗi ở bước nào? Khi database ngừng chạy, một List trong Java có thể vẫn tồn tại không?

## 7. Exercise
Vẽ luồng đọc một Product từ SQL tới Java; sửa SELECT để đọc hai cột và tự ánh xạ vào record.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
