# Linux — thứ tự học cho Java Backend

Cần hiểu file Java, một lệnh main và HTTP URL. Lệnh trong nhánh này dành cho Bash/Linux hoặc WSL đã có sẵn; đọc trước, không tự cài đặt môi trường. Không cần học quản trị hệ thống để hoàn thành.

1. [filesystem](filesystem/README.md): absolute/relative path, working directory, đọc file.
2. [terminal](terminal/README.md): arguments, stdout/stderr, exit code, curl.
3. [process](process/README.md): program khác process, PID, JVM và DB server.
4. [port](port/README.md): listener, host:port, HTTP khác PostgreSQL protocol.
5. [environment-variable](environment-variable/README.md): cấu hình được process kế thừa.
6. [logs](logs/README.md): đọc bằng chứng để xác định lớp lỗi.

Mỗi bài có demo, exercise TODO, solution tách riêng và notes. Dự đoán trước command, giải thích vì sao và liên hệ Java Core/HTTP/SQL. Chỉ dùng thư mục tạm và dữ liệu giả.

Sẵn sàng [sang Docker](../docker/README.md) khi vẽ được hai process Java/PostgreSQL và giải thích vì sao build thành công chưa có HTTP listener. Sau Docker làm [bài tổng hợp](../exercises/README.md), tự ghi [notes](../notes.md).
