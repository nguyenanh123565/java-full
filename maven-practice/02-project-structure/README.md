# Cấu trúc project: source khác output

## 1. Problem — tại sao khái niệm tồn tại

Compiler, test runner và packager cần cùng hiểu nơi nào là source app, nơi nào là test và đâu là tài nguyên.

## 2. Mental model

Maven dùng convention. Source được giữ lâu dài; target là sản phẩm có thể sinh lại. Resource trên classpath không được giả định là file ở working directory.

## 3. Ví dụ nhỏ

`src/main/resources/app.properties` được đọc qua `Main.class.getResourceAsStream("/app.properties")`. Đóng gói JAR vẫn dùng classpath resource.

Đọc [demo](demo/README.md), dự đoán trước khi chạy. Các bài dùng một [project Java 17 nhỏ](../01-why-build-tool/demo/project/README.md) để không nhân bản code.

## 4. Liên hệ kiến thức đã học

Java: package learning khớp thư mục learning theo convention. HTTP: application.properties của server là resource, không phải endpoint. SQL: SQL init có thể là resource, nhưng file tồn tại chưa có nghĩa đã chạy.

## 5. Những lỗi thường gặp

Sửa target/classes rồi mất khi build lại; dùng đường dẫn src/main/resources ở runtime; bỏ test source vào main khiến nó bị đóng gói vào app.

## 6. Câu hỏi tự kiểm tra

Vì sao classpath resource đọc được khi ở trong JAR? target có nên commit? File trong src/test/java có đi vào JAR app thông thường không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), tự giải thích rồi mới mở [solution](solution/README.md).
