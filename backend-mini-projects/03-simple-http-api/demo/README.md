# Demo Java HTTP thuần

Từ thư mục gốc chạy, sau đó dùng terminal khác gửi request:

```powershell
java --add-modules jdk.httpserver backend-mini-projects/03-simple-http-api/demo/HealthServer.java
curl.exe -i http://localhost:8081/health
curl.exe -i -X POST http://localhost:8081/health
curl.exe -i http://localhost:8081/missing
```

Dự đoán 200/405/404 và Content-Type trước. Dừng bằng Ctrl+C. Chỉ bind loopback.
Port 8081 phải rảnh; không tự dừng process khác để lấy port.
