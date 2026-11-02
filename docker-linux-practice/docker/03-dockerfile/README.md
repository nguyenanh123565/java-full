# Dockerfile: mô tả cách tạo image

## 1. Problem — tại sao khái niệm tồn tại

Phải mô tả copy gì, build ở đâu, Java chạy thế nào để không dựa vào thao tác thủ công trên máy riêng.

## 2. Mental model

Dockerfile là recipe build image. FROM chọn nền; WORKDIR đặt cwd; COPY lấy file từ build context; RUN chạy lúc build; ENTRYPOINT chạy khi container start. EXPOSE chỉ tài liệu port nội bộ, chưa publish.

## 3. Ví dụ nhỏ

`RUN mvn -B package` tạo Boot JAR trong build stage. `ENTRYPOINT ["java","-jar","/app/app.jar"]` mới start JVM khi chạy container.

Đọc [demo](demo/README.md), viết dự đoán trước khi thử. Các lệnh Linux dành cho Bash trong Linux/WSL đã có sẵn; các lệnh Docker dùng Compose v 2. Không có bước cài đặt tự động.

## 4. Liên hệ kiến thức đã học

Java: package tạo bytecode/JAR, java -jar chạy main của Boot. HTTP: server chỉ bind khi entrypoint process start. SQL: build image không có DB connection nghiệp vụ; app mới kết nối khi runtime.

## 5. Những lỗi thường gặp

Đặt java -jar ở RUN làm server chạy lúc build; nhầm context với đường dẫn bất kỳ trên host; copy .env vào image; tưởng EXPOSE là port mapping.

## 6. Câu hỏi tự kiểm tra

RUN và ENTRYPOINT khác thời điểm nào? COPY có truy cập file ngoài context tùy ý không? .dockerignore khác .gitignore ở đâu?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi [notes](notes.md), rồi mới mở [solution](solution/README.md).
