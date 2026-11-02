# Starter tự làm — chưa có CRUD

POM, main, record và interface là khung. ProductService ném UnsupportedOperationException; controller chưa đăng ký route. Chạy được server không chứng minh hoàn thành bài; lúc đầu /products chưa có handler.

1. TODO: Cài memory repository theo interface, tự quyết định cách tạo id.
2. TODO: Cài service bằng constructor; chưa biết missing thì tìm lại bài exception Java.
3. TODO: Thêm controller CRUD và mapping theo bảng hợp đồng ở README mini-project.
4. TODO: Validation 400, missing 404 và response đúng Location/204.
5. TODO: Trước mỗi request, ghi dự đoán và vì sao. Đối chiếu từng thao tác repository với một SQL parameterized trên giấy.

Nếu đã có JDK 17–25 và Maven 3.6.3+, mở terminal trong thư mục này: `mvn spring-boot:run`. Lệnh có thể tải dependency lần đầu, chỉ chạy khi bạn chủ động muốn thực hành. Không có script tự setup/cài dependency. Đừng sửa solution để hoàn thành starter.
