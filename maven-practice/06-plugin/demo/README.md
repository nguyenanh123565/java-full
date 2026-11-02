# Demo — nối phase với goal

Xem [POM](../../01-why-build-tool/demo/project/pom.xml). Đọc `<build><plugins>` và properties release. Khi tự chạy `mvn compile`, quan sát log dòng compiler plugin để thấy phase giao công việc cho goal.

Không cần thêm plugin chạy main: `java -cp target/classes learning.Main` đủ. Không cần plugin Spring Boot trong project Java chuẩn này. Học plugin Boot sau khi hiểu vì sao cần executable JAR chứa dependency.
