# Demo — command và bằng chứng

Từ [project](../../01-why-build-tool/demo/project/README.md), khi đã có Maven:

| Command | Bằng chứng cần quan sát |
|---|---|
| `mvn clean` | target được dọn, không có output compile mới |
| `mvn compile` | target/classes có class và resource; main chưa chạy |
| `mvn test` | test source có thể compile; demo không có JUnit/provider nên không có suite tự động |
| `mvn package` | JAR xuất hiện; test class không vào JAR app |
| `mvn install` | artifact/POM có trong local repo theo tọa độ |

Không cần chạy cả năm command lặp lại để có JAR; `mvn package` đã đi qua phase trước. Dùng `mvn clean package` khi muốn một lần build từ output sạch. Chưa tự chạy bất kỳ command tải plugin/dependency nào trong quá trình tạo workspace.
