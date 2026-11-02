# Đối chiếu — Dockerfile: mô tả cách tạo image

RUN thực hiện lúc tạo image; entrypoint thực hiện khi start container. Build context do docker gửi tới builder; .dockerignore chọn nội dung không gửi, còn .gitignore quản lý Git. EXPOSE là metadata; ports trong Compose mới publish host port. App connect DB khi runtime, không cần DB để compile.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
