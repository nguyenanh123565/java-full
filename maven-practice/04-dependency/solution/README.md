# Đối chiếu — Dependency, classpath và repository

BigDecimal và JDBC API thuộc Java platform; driver là JAR ngoài; PostgreSQL server là process riêng. Driver không cần cho phép tính tổng nên demo không khai báo nó. Maven resolve cả dependency bắc cầu theo POM. JAR thường không tự chứa mọi dependency; Spring Boot executable JAR là kiểu đóng gói riêng được học sau.

Dùng output và nội dung artifact làm bằng chứng; không chỉ kết luận BUILD SUCCESS. Mở solution sau khi đã ghi dự đoán và tự thử.
