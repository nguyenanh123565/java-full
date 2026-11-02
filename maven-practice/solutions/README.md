# Định hướng bài tổng hợp

Một bản hoàn thành cần source Java trong src/main/java, resource trong src/main/resources, smoke check trong src/test/java và POM có tọa độ/release. Compile không chạy main; package đi qua test phase rồi tạo JAR; install mới thêm artifact/POM vào local repository. `clean` phải gọi riêng khi cần dọn output.

Phép tính giảm giá không cần thư viện bên ngoài nếu BigDecimal đáp ứng. JDBC chỉ cần driver khi thực sự kết nối DB; HTTP server chỉ nghe port lúc process start. Bằng chứng tốt là nội dung JAR, output main/smoke check và bảng dự đoán đã đối chiếu. Test main tự viết không biến thành JUnit suite chỉ vì tên file nằm dưới src/test/java.
