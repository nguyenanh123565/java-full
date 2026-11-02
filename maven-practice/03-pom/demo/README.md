# Demo — đọc POM trước command

Mở [pom.xml](../../01-why-build-tool/demo/project/pom.xml). Đánh dấu modelVersion, tọa độ, properties, build/plugins. POM nhỏ không có dependencies vì code chỉ dùng Java chuẩn.

Nếu đã có Maven, từ project dùng `mvn help:effective-pom` để quan sát cấu hình kế thừa và mặc định. Đây là plugin goal; có thể tải plugin nếu cache chưa có, nên không cần chạy để hoàn thành phần đọc.
