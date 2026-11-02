# Solution tham khảo — 12 Authentication / authorization

## 1. Response

Trong giao kèo Bearer mẫu, thiếu token hoặc token không hợp lệ/hết hạn trả `401`, kèm `WWW-Authenticate: Bearer realm="api"` và lỗi an toàn. Token hợp lệ nhưng thiếu quyền admin trả `403`. Không gửi chi tiết token hoặc stack trace trong lỗi.

403 rộng hơn “đã đăng nhập nhưng thiếu role”; đây là cách dùng trong giao kèo mẫu. Backend có thể trả 404 để che giấu resource nhạy cảm theo chính sách nhất quán.

## 2. Ownership

Lấy principal từ cơ chế xác thực đáng tin. Với `GET /users/12/orders`, principal phải tương ứng user 12 hoặc có quyền quản trị. Với `GET /orders/73`, đọc/định vị order và so sánh owner với principal trước khi trả dữ liệu. Có thể ràng buộc owner ngay trong truy vấn, vẫn cần xác định chính sách không tìm thấy/thiếu quyền. Không tin userId do client khai trong body.

## 3. Ma trận mẫu

| Thao tác | Customer | Admin | Điều kiện bổ sung |
|---|---|---|---|
| Đọc orders | Chỉ của mình | Toàn hệ thống | Pagination, giới hạn dữ liệu |
| Tạo/sửa/xóa product | Không | Có | Validation, quan hệ lịch sử orders |
| Hủy order | Chỉ của mình | Theo quyền đã cấp | Chỉ pending; shipped bị từ chối |

Thiếu authn → 401; thiếu quyền → 403/404 theo chính sách; có quyền nhưng order không pending → 409 theo giao kèo. Kiểm tra và đổi trạng thái cần nguyên tử để tránh vượt qua điều kiện bởi cạnh tranh.

Không trả password/hash, token, dữ liệu thanh toán nhạy cảm. Admin có quyền nghiệp vụ cũng không được bỏ qua validation hoặc điều kiện trạng thái.
