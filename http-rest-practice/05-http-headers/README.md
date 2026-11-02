# 05 — Headers: metadata của thông điệp

## 1. Vấn đề cần giải quyết

Chỉ gửi một body là chưa đủ: người nhận cần biết cách đọc dữ liệu, kiểu response mong muốn, thông tin xác thực hoặc chính sách cache. Headers mang metadata phục vụ những quyết định đó.

## 2. Vị trí trong luồng

```text
Client → HTTP Request [headers] → Backend [đọc metadata] → Database → HTTP Response [headers] → Client
```

Backend có thể kiểm tra kiểu nội dung hoặc xác thực trước khi truy cập database. Response headers hướng dẫn client cách hiểu response. Chưa có xác thực thật trong lab.

## 3. Kiến thức bắt buộc

| Header | Thường thấy ở đâu? | Ý nghĩa |
| --- | --- | --- |
| Host | Request HTTP/1.1 | Địa chỉ đích, có thể kèm port |
| Content-Type | Request/response có nội dung | Media type của nội dung đang gửi |
| Accept | Request | Các media type response client chấp nhận |
| Authorization | Request | Credentials theo scheme, ví dụ Bearer |
| Content-Length | Request/response khi phù hợp | Độ dài nội dung theo byte |
| Location | Response | URI liên quan, ví dụ resource vừa tạo hoặc đích redirect |
| Cache-Control | Request/response | Chỉ dẫn cache |

Tên header không phân biệt hoa thường. Giá trị header có quy tắc riêng; đừng tùy tiện chuyển mọi giá trị thành chữ thường. HTTP/1.1 cần Host theo quy tắc của phiên bản; HTTP/2 và HTTP/3 có cấu trúc authority khác.

`Content-Type` không kiểm chứng body. `Accept` không đảm bảo mọi server hỗ trợ loại client yêu cầu. Content-Length thường được HTTP client tự tính; số byte UTF-8 của tiếng Việt có thể lớn hơn số ký tự. Lab echo chỉ phản chiếu một số headers: `content-type`, `accept`, `authorization`, `cookie`, `origin`, `x-lab-header`.

## 4. Ví dụ request/response

Ví dụ HTTP/1.1:

```http
GET /products/10 HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"data":{"id":10,"name":"Robot Demo","category":"robot","price":7500000,"stock":18}}
```

Chạy [demo.http](demo.http) để thấy tên header được phản chiếu thành chữ thường. Token trong demo là chuỗi giả chỉ dùng quan sát; lab không xác thực nó.

## 5. Lỗi thường gặp

- Dùng Accept để mô tả request body thay vì Content-Type.
- Nghĩ header có chữ Authorization chứng minh user đã đăng nhập.
- Ghi token thật vào file học hoặc đưa vào echo, log, ảnh chụp màn hình.
- Đặt Content-Length bằng số ký tự của JSON và làm sai framing.

## 6. Tự kiểm tra

1. Khi gửi JSON và muốn nhận JSON, cần phân biệt hai headers nào?
2. `content-type` và `Content-Type` có phải hai tên khác nhau không?
3. Vì sao body chứa tiếng Việt làm việc tự đếm Content-Length dễ sai?
4. Backend phải làm gì trước khi tin Authorization?

## 7. Ba bài tập

1. **Dễ:** Sửa metadata bị dùng nhầm mà không thay dữ liệu nghiệp vụ.
2. **Vừa:** Dự đoán cách echo phản chiếu tên và giá trị headers.
3. **Khó:** Thiết kế headers cho một request tạo tài nguyên và response tương ứng.

Làm [exercises.md](exercises.md). [Solution riêng](../solutions/05-http-headers.md).

Tham khảo: [RFC 9110 — fields](https://www.rfc-editor.org/rfc/rfc9110.html#section-5), [Content-Type](https://www.rfc-editor.org/rfc/rfc9110.html#section-8.3), [Accept](https://www.rfc-editor.org/rfc/rfc9110.html#section-12.5.1).
