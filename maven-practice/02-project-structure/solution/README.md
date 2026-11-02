# Đối chiếu — Cấu trúc project: source khác output

JAR mặc định chứa class đã compile và resource, không chứa source .java hay test class thông thường. `app.properties` ở classpath root. Đường dẫn tương đối phụ thuộc working directory; classloader đọc từ classpath/JAR, nên không yêu cầu thư mục source tồn tại trên máy chạy.

Dùng output và nội dung artifact làm bằng chứng; không chỉ kết luận BUILD SUCCESS. Mở solution sau khi đã ghi dự đoán và tự thử.
