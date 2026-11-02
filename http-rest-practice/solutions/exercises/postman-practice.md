# Hướng dẫn thao tác Postman, không phải bảng expected outputs

1. Chạy lab theo README gốc và giữ terminal server mở.
2. Tạo collection `HTTP REST Practice`, environment local có biến `baseUrl` bằng `http://localhost:8080`; chọn environment đó.
3. Tạo request GET URL `{{baseUrl}}/health`; lưu vào collection. Trước Send, ghi status/body bạn dự đoán.
4. Với query: nhập tên và giá trị ở Params, quan sát URL được encode. Với headers: nhập `Accept`, custom header; để client tự tính `Content-Length`.
5. Với body: chọn raw → JSON; gửi tới `/echo` để quan sát string trong `receivedBody`. Đây không phải tạo resource hay kiểm tra JSON schema.
6. Sau Send: ghi HTTP status, response headers, raw body; chỉ dùng Pretty để đọc dễ hơn. So sánh với dự đoán và giải thích khác biệt.
7. Lưu những request có status khác 200; tự viết kiểm tra đúng với từng contract, không mặc định tất cả thành công.
8. Nếu dùng web, dùng Desktop Agent khi cần truy cập localhost. Đọc phần chọn agent trong tài liệu chính thức khi giao diện phiên bản của bạn khác.
9. Request mini API của bạn chỉ là hợp đồng cho backend tương lai; chú thích `CHƯA TRIỂN KHAI`, không mong lab xử lý CRUD.

Rubric: collection chạy lại được, không chứa bí mật, dùng biến baseUrl, có dự đoán/quan sát, có một case không body và hai case lỗi, giải thích được giới hạn của echo và khác biệt Postman/browser với CORS.

Tham khảo: [Sending requests](https://learning.postman.com/docs/use/send-requests/requests/), [Variables](https://learning.postman.com/docs/use/send-requests/variables/variables/), [About the Postman Agent](https://learning.postman.com/docs/getting-started/basics/about-postman-agent/).
