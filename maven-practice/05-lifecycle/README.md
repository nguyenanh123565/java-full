# Lifecycle: chọn kết quả cần đến

## 1. Problem — tại sao khái niệm tồn tại

Build có thứ tự: source phải compile trước test, artifact cần có trước khi đưa vào local repo. Cần một chuỗi nhất quán.

## 2. Mental model

Lifecycle chứa phase; phase gọi goal của plugin. Gọi một phase ở default lifecycle sẽ chạy các phase trước nó theo thứ tự. Clean là lifecycle khác. Phase có chạy test thật hay không còn tùy plugin/test đã cấu hình.

## 3. Ví dụ nhỏ

`mvn package` đi qua compile, test-compile, test rồi package. `mvn clean package` dọn output trước, sau đó chạy default lifecycle đến package.

Đọc [demo](demo/README.md), dự đoán trước khi chạy. Các bài dùng một [project Java 17 nhỏ](../01-why-build-tool/demo/project/README.md) để không nhân bản code.

## 4. Liên hệ kiến thức đã học

Java: compile khác chạy main. HTTP: package không start web server. SQL: install artifact không cài DB, không đồng nghĩa commit transaction.

## 5. Những lỗi thường gặp

Gọi compile test package liên tiếp làm lặp phase; nghĩ package tự clean; thấy no tests rồi vẫn khẳng định đã kiểm tra logic.

## 6. Câu hỏi tự kiểm tra

`mvn install` gửi lên remote repo chưa? clean có chạy test không? Vì sao test main tự viết không được Surefire nhận làm JUnit test?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), tự giải thích rồi mới mở [solution](solution/README.md).
