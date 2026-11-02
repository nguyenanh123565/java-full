# Bài tập 14 — CORS / HTTPS

## 1. Dễ — Origin nào?

Trang gốc: http://localhost:3000. Các URL: http://localhost:8080/products; https://localhost:3000/products; http://127.0.0.1:3000/products; http://localhost:3000/help.

TODO:
- Phân loại same-origin/cross-origin và giải thích từng thành phần.
- Giải thích same-origin khác same-site ở mức cơ bản.
- Nêu vì sao CORS liên quan browser, không chỉ HTTP server.

## 2. Vừa — Quan sát preflight

Từ origin http://localhost:3000, cần POST JSON tới /cors với X-Lab-Header. Sau đó thử một origin khác allowlist.

TODO:
- Viết preflight và request thật, không copy demo ngay.
- Ghi dự đoán headers, status và bước browser cho phép/chặn.
- Quan sát bằng .http/Postman và browser Network/Console.
- Giải thích vì sao client ngoài browser có thể vẫn đọc được response khi thiếu allow-origin.
- Nêu khi nào một request cross-origin có thể đến backend dù script không đọc được response.

## 3. Khó — Credentialed request qua HTTPS

Frontend ở một origin gọi API khác origin bằng cookie để đổi thông tin user. Hệ thống yêu cầu HTTPS.

TODO:
- Xác định điều kiện CORS và credentials ở client/server.
- Phân tích thuộc tính cookie, cross-site và CSRF.
- Nêu nơi backend kiểm tra authentication, ownership và validation.
- Giải thích HTTPS không thay thế các kiểm tra còn lại.
