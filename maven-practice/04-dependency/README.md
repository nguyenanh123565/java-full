# Dependency, classpath và repository

## 1. Problem — tại sao khái niệm tồn tại

JDBC API có sẵn trong Java nhưng PostgreSQL driver là implementation bên ngoài. Cần nhận diện đúng thư viện, phiên bản và classpath.

## 2. Mental model

Dependency là thư viện app dùng. Maven repository lưu artifact/POM theo tọa độ; local repository thường ở ~/.m2/repository, Maven lấy từ đó hoặc tải từ remote repository. Remote Maven repository khác Git repository.

## 3. Ví dụ nhỏ

Demo không cần dependency vì BigDecimal, Properties nằm trong JDK. Khi app JDBC cần driver, khai báo dependency PostgreSQL đúng phạm vi là có lý do; không thêm vào project tính tổng này.

Đọc [demo](demo/README.md), dự đoán trước khi chạy. Các bài dùng một [project Java 17 nhỏ](../01-why-build-tool/demo/project/README.md) để không nhân bản code.

## 4. Liên hệ kiến thức đã học

Java: import không tự tải thư viện, classpath phải có class. HTTP: Maven có thể tải artifact qua HTTPS, khác app gửi request nghiệp vụ. SQL: driver nói giao thức PostgreSQL; dependency driver không cài PostgreSQL server.

## 5. Những lỗi thường gặp

Thêm mọi thư viện từng thấy; nhầm Maven Central với GitHub repo source; nghĩ dependency cài DB; quên transitive dependencies.

## 6. Câu hỏi tự kiểm tra

Vì sao import không đủ? Transitive dependency là gì? JAR thường có tự gói hết thư viện phụ thuộc không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), tự giải thích rồi mới mở [solution](solution/README.md).
