# API contract — phần yêu cầu, tự triển khai

| Method + path | Thành công | Input / lỗi cần xử lý | Quyền |
| --- | --- | --- | --- |
| GET /products | 200, mảng DTO | danh sách rỗng là [] | Public |
| GET /products/{id} | 200 | 400 ID sai, 404 thiếu | Public |
| POST /products | 201 + Location | 400 body/giá/stock sai | ADMIN |
| PUT /products/{id} | 200 DTO | 400 input sai, 404 thiếu | ADMIN |
| DELETE /products/{id} | 204 | 404 thiếu, 409 nếu đang được order tham chiếu | ADMIN |
| POST /orders | 201 + Location | 400 quantity sai/list rỗng/trùng productId; 404 product thiếu; 409 stock thiếu | USER/ADMIN |
| GET /users/{id}/orders | 200, mảng | 400 ID sai; 403 đọc user khác | Owner/ADMIN |
| GET /orders/{id} | 200 | 404 thiếu; 403 đọc order người khác | Owner/ADMIN |

Request protected chưa xác thực trả 401; đã xác thực nhưng thiếu quyền trả 403.
PUT thay toàn bộ trường được phép sửa; DELETE sản phẩm chưa có order được xóa
thật, sản phẩm có lịch sử order trả 409. Chưa cần soft-delete hoặc thanh toán.

- TODO — Thiết kế DTO JSON và schema cho users/categories/products/orders/order_items.
- TODO — Viết request mẫu và dự đoán status/body/row thay đổi trước khi chạy.
- TODO — Vì sao unique(username), FK và CHECK không thể chỉ giao cho annotation validation?
- TODO — Chỉ ra điểm Java exception chuyển thành HTTP 409 và điểm DB rollback.
