# Cấu trúc project Spring Boot

## 1. Problem — khái niệm này giải quyết việc gì?

Compiler và container cần biết đâu là source, resource và package được quét. Trộn tất cả file ở thư mục gốc gây khó hiểu cả build lẫn runtime.

## 2. Mental model

Maven tìm Java ở `src/main/java`, cấu hình ở `src/main/resources`, test ở `src/test/java`; output nằm trong `target`. Package `learn.products` chứa main, controller và service. Thư mục và package Java phải khớp.

## 3. Ví dụ nhỏ

```text
pom.xml
src/main/java/learn/products/ProductApplication.java
src/main/resources/application.properties
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: package là namespace của class. HTTP: route khai báo trong controller chứ không lấy từ đường dẫn file. SQL: sau này script/schema vẫn là resource hoặc file SQL, không phải controller.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Đặt controller ngoài cây package quét; sửa file trong target; cho rằng thư mục `/products` tự sinh URL.

## 6. Câu hỏi tự kiểm tra

Di chuyển controller sang package anh em của main ảnh hưởng thế nào? Vì sao target không là nơi viết source?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
