# Vì sao cần build tool?

## 1. Problem — tại sao khái niệm tồn tại

Compile một file bằng javac dễ; nhiều package, resource và test khiến mỗi người nhớ một chuỗi command khác nhau. Cần mô tả build để người khác lặp lại.

## 2. Mental model

Source và POM là đầu vào; plugin thực hiện tác vụ; target chứa đầu ra. Build có thể cần tải artifact về local cache, nhưng Java app vẫn chạy bằng JVM.

## 3. Ví dụ nhỏ

Project demo tính tiền product bằng BigDecimal và đọc nhãn từ resource. Không có Spring, PostgreSQL driver hoặc JUnit.

Đọc [demo](demo/README.md), dự đoán trước khi chạy. Các bài dùng một [project Java 17 nhỏ](../01-why-build-tool/demo/project/README.md) để không nhân bản code.

## 4. Liên hệ kiến thức đã học

Java Core: javac dịch source thành bytecode, java chạy class. HTTP: build API không có nghĩa server đã nghe port. SQL: build code JDBC không tự tạo database hay chạy transaction.

## 5. Những lỗi thường gặp

Nhầm Maven là framework runtime; thấy BUILD SUCCESS rồi nghĩ app đã chạy; commit target/; thêm dependency khi Java chuẩn đã đủ.

## 6. Câu hỏi tự kiểm tra

Maven thay JVM ở bước nào? Nếu compile thành công thì HTTP server đã start chưa? Vì sao build cần tái lặp?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), tự giải thích rồi mới mở [solution](solution/README.md).
