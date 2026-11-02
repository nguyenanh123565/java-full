# 01 — Web hoạt động như thế nào?

## 1. Vấn đề cần giải quyết

Một trang web hoặc ứng dụng điện thoại cần trao đổi dữ liệu với chương trình chạy ở máy khác. Client gửi yêu cầu; server nhận, xử lý rồi trả kết quả. HTTP quy định ý nghĩa của việc trao đổi này, còn Java là một lựa chọn để viết backend.

## 2. Vị trí trong luồng

```text
Client → HTTP Request → Backend → Database → HTTP Response → Client
```

Client có thể là trình duyệt, Postman, curl hoặc một ứng dụng Java. Backend có thể trả dữ liệu có sẵn mà không truy cập database. Lab của workspace dùng dữ liệu trong bộ nhớ; chưa kết nối database.

Với một tên miền thật, client thường cần phân giải DNS để tìm địa chỉ server. Với HTTP/1.1, client mở kết nối TCP; HTTPS thêm TLS để bảo vệ dữ liệu. DNS, TCP, TLS và HTTP giải quyết những việc khác nhau. HTTP/2 cũng thường dùng TCP; HTTP/3 dùng QUIC. Các bài đầu chỉ cần quan sát ý nghĩa HTTP.

## 3. Kiến thức bắt buộc

- Phân biệt client, server, frontend và backend. Client/server là vai trò trong một lần trao đổi.
- URL cho biết giao thức, địa chỉ, cổng và tài nguyên cần truy cập.
- `localhost` chỉ máy đang gửi request; điện thoại của bạn có `localhost` khác máy tính.
- Server phải chạy và lắng nghe đúng cổng trước khi client có thể kết nối.
- HTML, JSON và hình ảnh đều có thể được gửi qua HTTP; HTTP không bắt buộc JSON.
- Gõ URL trong trình duyệt thường gửi GET; chưa đủ để kiểm tra mọi thao tác của API.

## 4. Ví dụ request/response

Ví dụ HTTP/1.1 ở dạng văn bản; một số header được lược. HTTP/2 và HTTP/3 giữ ý nghĩa HTTP nhưng không truyền nguyên văn cấu trúc này.

```http
GET /health HTTP/1.1
Host: localhost:8080
Accept: application/json

```

Response minh họa:

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"status":"ok"}
```

Chạy server theo README gốc rồi mở [demo.http](demo.http). Ghi lại response thực tế; lab có thể thêm header mà ví dụ không liệt kê.

## 5. Lỗi thường gặp

- Cho rằng database trả HTTP trực tiếp cho trình duyệt.
- Nhầm lỗi kết nối với response HTTP 404: lỗi kết nối có thể chưa có response HTTP nào.
- Dùng `localhost` trên thiết bị khác và mong truy cập được backend của máy tính.
- Nghĩ cứ mở trang web là chỉ có một request; trang có thể tải thêm CSS, JS, ảnh và gọi API.

## 6. Tự kiểm tra

1. Client có nhất thiết phải là trình duyệt không? Nêu hai ví dụ khác.
2. Ai tạo HTTP response khi backend dùng database?
3. Khi nào một request có thể thành công mà không chạm database?
4. Vì sao thay cổng từ 8080 sang 8081 có thể làm kết nối thất bại?

## 7. Ba bài tập

1. **Dễ:** Vẽ luồng lấy danh sách người dùng từ ứng dụng điện thoại.
2. **Vừa:** Phân loại lỗi server chưa chạy, sai path và lỗi database.
3. **Khó:** Giải thích cách điện thoại và máy tính trao đổi trên cùng mạng; xác định các giả định cần kiểm tra.

Làm trong [exercises.md](exercises.md), luôn giải thích vì sao. Đối chiếu khi cần ở [solution riêng](../solutions/01-web-basics.md).

Tham khảo: [RFC 9110 — kiến trúc HTTP](https://www.rfc-editor.org/rfc/rfc9110.html#section-3).
