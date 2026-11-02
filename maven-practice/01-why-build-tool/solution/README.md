# Đối chiếu — Vì sao cần build tool?

Compile chỉ tạo class (và các phase trước có thể copy resource); không gọi main. Chạy `java -cp target/classes learning.Main` mới in kết quả. Compiler kiểm tra Java ở build time; HTTP/DB thường chỉ được chạm lúc app chạy. Maven chuẩn hóa việc gọi các công cụ, JVM vẫn chạy bytecode.

Dùng output và nội dung artifact làm bằng chứng; không chỉ kết luận BUILD SUCCESS. Mở solution sau khi đã ghi dự đoán và tự thử.
