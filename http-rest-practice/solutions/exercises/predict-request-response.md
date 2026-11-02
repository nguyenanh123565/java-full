# Gợi ý chọn lọc — dự đoán request/response

Chỉ mở sau khi đã viết dự đoán. File này giải mẫu TODO 1 và gợi ý phần còn lại; bạn tự ghi outputs thực tế theo phiên bản lab.

## Một mẫu: TODO 1

Method là GET, path `/echo`, query thô `name=An%20Binh&limit=2`, không có request body. `Accept` là mong muốn về representation response, `X-Lab-Header` là custom request header. Trường `rawQuery` vẫn chứa `%20` vì lab lấy query thô, không parse thành tên đã giải mã.

Đừng khẳng định chính xác toàn bộ headers từ file mẫu: client có thể tự thêm `Host`, `User-Agent` hoặc headers khác. Quan sát request thực tế; lab chỉ echo một nhóm headers dưới tên lowercase, không phản chiếu Host/User-Agent.

## Tự đối chiếu phần còn lại

- TODO 2: Xem kiểu của `receivedBody` trong JSON phản chiếu; JSON string cần escape dấu ngoặc kép. `/echo` không có bước parse JSON.
- TODO 3–4: Đọc quy tắc HEAD và 204; với 401 kiểm tra `WWW-Authenticate`. Route simulator không triển khai đăng nhập.
- TODO 5: HTTP status nằm ở metadata response, không lấy từ một field tên `status` trong JSON.
- TODO 6: Đọc đúng endpoint contract của lab; lọc collection chỉ tồn tại khi backend triển khai.
- TODO 7–8: Tách trạng thái cuối, response, hợp đồng và giả định. Idempotency không đòi response giống hệt.

Đạt khi bạn giải thích chênh lệch dự đoán/quan sát bằng request thực tế hoặc hợp đồng, không chỉ chép output.

Tham khảo: [RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html).
