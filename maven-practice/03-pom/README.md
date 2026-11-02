# POM: mô tả project và tọa độ artifact

## 1. Problem — tại sao khái niệm tồn tại

Một file JAR cần tên/phiên bản rõ; build cần biết Java release và plugin. Ghi bằng command rời dễ thiếu thông tin.

## 2. Mental model

POM là XML model. `groupId:artifactId:version` nhận diện artifact; packaging mặc định jar. properties giúp dùng một giá trị thống nhất. POM không phải Java source.

## 3. Ví dụ nhỏ

`learning.backend:product-total:1.0.0`, release 17, UTF-8. Đổi artifactId hoặc version sẽ đổi tên artifact mặc định.

Đọc [demo](demo/README.md), dự đoán trước khi chạy. Các bài dùng một [project Java 17 nhỏ](../01-why-build-tool/demo/project/README.md) để không nhân bản code.

## 4. Liên hệ kiến thức đã học

Java: release17 quy định ngôn ngữ/API/bytecode mục tiêu, cần JDK hỗ trợ release đó. HTTP: version artifact không tự đổi URL /v1. SQL: version artifact cũng không tự áp dụng migration.

## 5. Những lỗi thường gặp

Nhầm modelVersion 4.0.0 là Maven runtime version; đổi version trong tên file nhưng quên POM; dùng JDK thấp hơn target release.

## 6. Câu hỏi tự kiểm tra

groupId khác package Java bắt buộc không? Version POM thay schema PostgreSQL không? release 17 có bắt buộc JVM runtime đúng 17 duy nhất không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), tự giải thích rồi mới mở [solution](solution/README.md).
