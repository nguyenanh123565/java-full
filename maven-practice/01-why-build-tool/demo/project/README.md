# Project demo — build Java chuẩn

Mục tiêu: quan sát compile/resource/test source/package. Java17; không có application dependency. Không tự cài Maven, không tải thư viện trong bước tạo workspace. Khi muốn thực hành và máy đã có JDK17+ cùng Maven, mở terminal tại thư mục này:

```powershell
mvn compile
java -cp target/classes learning.Main
mvn package
jar tf target/product-total-1.0.0.jar
java -cp target/product-total-1.0.0.jar learning.Main
```

Dự đoán: total của 19.90 × 3 là gì? Vì sao compile không in label? Chỉ khi bạn chạy java, output sẽ là `Product total: 59.70`.

POM không cấu hình Main-Class manifest nên dùng `java -cp ... learning.Main`; `java -jar ...` không phải command phù hợp cho JAR thường này.

`src/test/java/learning/ManualPriceCheck.java` là smoke check main, chưa dùng JUnit. `mvn test` có thể compile nó nhưng **không tự chạy main này**. Sau `mvn test-compile`, trên PowerShell gọi rõ:

```powershell
java -cp 'target/classes;target/test-classes' learning.ManualPriceCheck
```

Trên Linux, classpath separator là `:`. Khi chưa có Maven vẫn có thể kiểm tra bằng javac, output nên nằm trong thư mục tạm riêng; cần copy app.properties vào classpath để Main đọc được. Bài testing sẽ dạy test suite tự chạy có framework/provider phù hợp.
