# Spring và Spring Boot

## 1. Problem — khái niệm này giải quyết việc gì?

Tự tạo web server, nối các object và cấu hình chuyển JSON là nhiều công việc lặp lại. Spring cung cấp container và thư viện; Boot giúp khởi động ứng dụng Spring với các mặc định phụ thuộc vào classpath và cấu hình.

## 2. Mental model

Spring là các khả năng nền; Boot là cách lắp ráp và khởi chạy thuận tiện. Auto-configuration có điều kiện, không phải mọi thư viện đều tự xuất hiện. `@SpringBootApplication` bật cấu hình, quét component từ package hiện tại xuống dưới và auto-configuration. Nếu làm thủ công, ta tạo server, đăng ký handler và khởi tạo object. Annotation này chưa khai báo một route HTTP.

## 3. Ví dụ nhỏ

```text
main → SpringApplication.run → tạo bean + MVC + server
GET /products → route MVC → controller → service
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: `new` và object graph vẫn tồn tại, container quản lý chúng. HTTP: embedded server nhận request. SQL: chưa cần database để hiểu đường đi của request.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Đồng nhất Boot với toàn bộ Spring; nghĩ annotation tự tạo nghiệp vụ; thêm JPA chỉ để có REST endpoint.

## 6. Câu hỏi tự kiểm tra

Boot làm bớt công việc lắp ráp nào? Nếu bỏ web starter, có chắc còn HTTP server không? Vì sao class main đặt ở package cha?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
