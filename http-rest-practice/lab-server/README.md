# Server quan sát HTTP bằng JDK

`HttpLabServer.java` dùng module `jdk.httpserver` có trong JDK. Không Maven/dependency/framework.
Mục tiêu là quan sát request/response, không yêu cầu bạn hiểu hết code server trước khi học HTTP.
Chạy `start.ps1` từ hướng dẫn README gốc; cần JDK 17+. Dừng bằng Ctrl+C.

## Contract hỗ trợ
| Endpoint | Method | Hành vi |
|---|---|---|
| `/health` | GET, HEAD, OPTIONS | GET trả `{"status":"ok"}` |
| `/products` | GET, HEAD, OPTIONS | GET trả `{"data":[<product demo>]}` |
| `/products/10` | GET, HEAD, OPTIONS | GET trả `{"data":<product demo>}` |
| `/echo` | GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS | Quan sát method, path, rawQuery, headers và body; không thay đổi nghiệp vụ |
| `/status/{code}` | GET, HEAD, OPTIONS | Trả status mẫu, không thực hiện nghiệp vụ |
| `/cors` | GET, HEAD, POST, OPTIONS | Quan sát CORS allowlist; body `{"message":"CORS lab"}` |

Product demo: `{"id":10,"name":"Robot Demo","category":"robot","price":7500000,"stock":18}`.
Catalog chỉ là ví dụ đọc dữ liệu: query trên `/products`/`/products/10` trả 400 vì filter chưa được triển khai.
Route khác trả 404; method không hỗ trợ trên route có sẵn trả 405 và `Allow`.
HEAD không gửi body; OPTIONS trả 204 và `Allow`. Response lab dùng `Cache-Control: no-store`.

## Echo
Ví dụ POST body `{"note":"xin chào"}` trả dữ liệu dạng:
```json
{
  "method": "POST",
  "path": "/echo",
  "rawQuery": null,
  "headers": {"content-type": "application/json"},
  "receivedBody": "{\"note\":\"xin chào\"}"
}
```
Chỉ các header có mặt trong request và thuộc nhóm dưới đây được echo:
`content-type`, `accept`, `authorization`, `cookie`, `origin`, `x-lab-header`.
Client có thể tự thêm Accept; header names trong JSON được chuẩn hóa chữ thường.
Body đọc như text UTF-8, giới hạn 65536 bytes; vượt giới hạn trả 413.
Echo cả JSON sai cú pháp vì nó không parse JSON. `Accept` được quan sát; lab luôn trả JSON,
không thực hiện content negotiation. Dùng thông tin cookie/token giả trong các ví dụ.

## Status mẫu
Hỗ trợ 200, 201, 204, 400, 401, 403, 404, 405, 406, 409, 413, 415, 422, 500, 503.
200/201 có body `{"status":code}`; 201 thêm `Location: /products/10` chỉ để quan sát header mẫu.
204 không có body. 401 thêm `WWW-Authenticate: Bearer realm="http-lab"`.
405 mẫu thêm `Allow: GET, HEAD, OPTIONS`; lỗi dùng:
```json
{"error":{"code":"DEMO_404","message":"Sample status 404"}}
```
Các status này được yêu cầu rõ bằng URL lab, không phải kết quả validate CRUD hay login.

## CORS lab
Origin được cho phép là **`http://localhost:3000`**, gồm scheme + host + port.
GET/POST/HEAD với Origin đó nhận `Access-Control-Allow-Origin` đúng origin.
Origin khác vẫn có thể nhận HTTP 200 nhưng không có header cho phép browser đọc response.
Preflight OPTIONS với origin đúng cho phép GET/HEAD/POST và headers Content-Type/X-Lab-Header.
Method/header preflight ngoài danh sách trả 403. Không hỗ trợ credentials/session.
Response có `Vary` cho Origin và các header preflight.

Để quan sát browser, giữ HTTP lab chạy và mở terminal thứ hai tại gốc workspace:
```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\lab-server\start-client.ps1
```
Mở **`http://localhost:3000`** trong browser, bật DevTools → Network/Console.
Trang có ba request demo: GET /cors, POST JSON /cors (preflight), GET /health (thiếu CORS header).
Ghi dự đoán rồi mới bấm. Nếu backend chạy port khác, sửa ô Backend trên trang.
Để thử origin không được cho phép, chạy thêm `start-client.ps1 -Port 3001` và mở localhost:3001.
`http://127.0.0.1:3000` cũng là origin khác với `http://localhost:3000`.
Browser demo dùng JDK, không cần Node/Python/framework. Dừng từng server bằng Ctrl+C.

## Liên hệ với luồng học
Client → request → server quan sát → response → client; không có Database trong lab.
Các mini design yêu cầu bạn tự mô hình hóa Backend → Database và các hợp đồng CRUD.
[JDK HttpServer API](https://docs.oracle.com/en/java/javase/17/docs/api/jdk.httpserver/com/sun/net/httpserver/HttpServer.html)
là nguồn tham khảo nếu muốn đọc phần hiện thực.
