# Plugin: ai thực hiện công việc của phase?

## 1. Problem — tại sao khái niệm tồn tại

Phase chỉ định “đến bước compile”; cần công cụ thực hiện compile và cấu hình cách nó làm. Dependency runtime không làm việc này.

## 2. Mental model

Plugin có goal, ví dụ compiler:compile. Lifecycle phase gắn goal tùy packaging/cấu hình. Khai báo plugin version giúp build bớt phụ thuộc mặc định; không phải plugin nào khai báo cũng tự chạy nếu chưa có binding.

## 3. Ví dụ nhỏ

POM demo chốt maven-compiler-plugin và maven.compiler.release=17. Với packaging jar, compile phase đã có compiler goal binding.

Đọc [demo](demo/README.md), dự đoán trước khi chạy. Các bài dùng một [project Java 17 nhỏ](../01-why-build-tool/demo/project/README.md) để không nhân bản code.

## 4. Liên hệ kiến thức đã học

Java: compiler plugin gọi compiler, không phải thư viện import trong Main. HTTP: plugin package Boot JAR không phải controller xử lý request. SQL: JDBC driver thuộc runtime dependency, không phải build plugin.

## 5. Những lỗi thường gặp

Đặt plugin dưới dependencies; coi phase và goal là một; thêm exec plugin chỉ để chạy một main khi java -cp đã đủ; quên version plugin.

## 6. Câu hỏi tự kiểm tra

compile phase khác compiler:compile goal ở đâu? Vì sao plugin version ảnh hưởng tính lặp lại? Dependency và plugin cùng tải từ repo thì có cùng vai trò không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), tự giải thích rồi mới mở [solution](solution/README.md).
