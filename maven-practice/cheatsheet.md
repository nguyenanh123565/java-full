# Maven cheatsheet

| Command | Thực sự làm | Không tự làm |
|---|---|---|
| `mvn clean` | clean lifecycle dọn output (thường target) | compile/test/chạy app |
| `mvn compile` | default lifecycle đến compile, xử lý main resource và main source | chạy main / tạo JAR |
| `mvn test` | đến test: compile main/test và test goal theo cấu hình | bảo đảm có test nếu chưa viết/cấu hình |
| `mvn package` | đến package: tạo artifact theo packaging sau các phase trước | clean / install / start app |
| `mvn install` | đến install: artifact/POM vào local repo | cài JDK / deploy remote / tạo DB |
| `mvn clean package` | clean trước, rồi default lifecycle đến package | khởi chạy app |
| `mvn dependency:tree` | plugin goal xem cây dependency | phân tích logic nghiệp vụ |
| `mvn help:effective-pom` | xem model sau kế thừa/mặc định | đổi source |

Plugin có thể cần tải lần đầu dù app không có dependency. `~/.m2/repository` là local artifact cache, khác Git repository. Dependency phục vụ app; plugin phục vụ build. POM release17 cần JDK hỗ trợ17 trở lên, và chạy bytecode cần runtime tương thích. BUILD SUCCESS không nói có bao nhiêu kiểm tra meaningful đã chạy; đọc report và log.
