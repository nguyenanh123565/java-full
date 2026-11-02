# Đối chiếu — Terminal: gọi command và quan sát kết quả

Connection refused thường là không tới được process nghe port, nên không nhận HTTP response. Route 404 là đã tới server và nhận response. `curl -i` in header, nhưng mặc định không coi HTTP 404 là lỗi transfer; `--fail-with-body` có thể dùng khi muốn HTTP 4xx/5xx tạo exit code lỗi mà vẫn đọc body.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
