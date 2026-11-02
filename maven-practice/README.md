# Maven — source → build → artifact

Học sau Java Core và JDBC nền tảng, trước Spring Boot. Cần tự giải thích javac, java, package/import và classpath. Không cần cài/tải gì để đọc tài liệu; command dưới đây để thực hành khi máy đã có JDK 17+ và Maven. Workspace này không tự chạy setup.

Maven chuẩn hóa cấu trúc, dependency và chuỗi build. JVM chạy bytecode; Maven gọi compiler/plugin và sắp xếp artifact, không thay Java runtime.

| Đường dẫn | Vai trò |
|---|---|
| `src/main/java` | source app, biên dịch thành target/classes |
| `src/main/resources` | cấu hình/tài nguyên được copy vào classpath, không biên dịch Java |
| `src/test/java` | source kiểm tra, tách khỏi app chính |
| `target` | output sinh ra: class, report, JAR; có thể build lại |
| `pom.xml` | tọa độ artifact, cấu hình build, dependency/plugin |

Lộ trình:

- [01-why-build-tool](01-why-build-tool/README.md)
- [02-project-structure](02-project-structure/README.md)
- [03-pom](03-pom/README.md)
- [04-dependency](04-dependency/README.md)
- [05-lifecycle](05-lifecycle/README.md)
- [06-plugin](06-plugin/README.md)

`mvn clean` dọn output do clean plugin quản lý (thường target); không compile. `mvn compile` chạy đến compile trong default lifecycle. `mvn test` chạy đến test, có cả compile main/test; chỉ có test thật khi project có test framework/provider phù hợp. `mvn package` chạy qua test rồi đóng gói artifact; không tự start app. `mvn install` chạy đến install rồi đưa artifact và POM vào local repository để project khác dùng; không cài Java hoặc app thành dịch vụ. `clean` là lifecycle riêng, không tự xảy ra trước compile/package/install.

Một [demo không có application dependency](01-why-build-tool/demo/project/README.md) dùng Java chuẩn; Maven vẫn có thể phải tải plugin build lần đầu nếu chưa có cache. Đọc [cheatsheet](cheatsheet.md), làm [bài tổng hợp](exercises/README.md), tự ghi notes từng lesson.

Sẵn sàng sang Spring Boot khi giải thích được dependency khác plugin, package khác install, tìm được class/resource trong JAR và biết BUILD SUCCESS không chứng minh đã có test. Không thêm thư viện chỉ để làm POM dài hơn.

Tham khảo: [Maven lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html), [standard layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html).
