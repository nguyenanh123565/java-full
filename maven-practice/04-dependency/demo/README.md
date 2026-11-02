# Demo — không thêm dependency khi chưa có nhu cầu

Đọc import trong [Main](../../01-why-build-tool/demo/project/src/main/java/learning/Main.java): tất cả từ JDK. Đọc [POM](../../01-why-build-tool/demo/project/pom.xml): không có dependencies.

Ví dụ chỉ để nhận diện tọa độ, **không dán vào demo này**:

```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <version>42.7.7</version>
  <scope>runtime</scope>
</dependency>
```

Version trên là ví dụ cố định để đọc POM, không tuyên bố mới nhất. App JDBC dùng API java.sql có thể compile mà không tham chiếu trực tiếp class driver, nhưng runtime cần driver trên classpath và DB server chạy riêng. Bài JDBC có project phù hợp để học việc đó.
