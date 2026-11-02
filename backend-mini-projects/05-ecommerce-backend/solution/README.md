# Đối chiếu thiết kế sau lần tự làm

Một hướng vừa đủ: một app Spring Boot, một PostgreSQL, package theo controller,
service, repository, entity, DTO. Không cần nhiều service triển khai độc lập.
Users có unique username và password_hash; products có category_id, price NUMERIC,
stock integer; orders có user_id, total, created_at; order_items có order_id,
product_id, quantity, unit_price. FK bảo vệ tham chiếu; CHECK bảo vệ quantity > 0,
price/stock >= 0; mỗi order/product chỉ có một item trong contract này.

Transaction ở service tạo order bao gồm mọi item. Đọc giá server; dùng BigDecimal;
lưu unit_price tại thời điểm đặt. Để tránh oversell, có thể dùng update điều kiện:

```sql
UPDATE products SET stock = stock - ? WHERE id = ? AND stock >= ?;
```

Kiểm affected rows=1 cho mỗi item; nếu 0, ném lỗi nghiệp vụ và rollback toàn bộ.
Nếu chọn JPA pessimistic lock thay cho atomic update, khóa product theo thứ tự ID
nhất quán rồi kiểm stock trong transaction; không trộn hai cách mà không hiểu.
Rollback không đảm bảo ID sequence liên tục, nên không test ID phải liền nhau.

Không nhận userId từ body để quyết định owner. Service/query kiểm owner hoặc ADMIN
khi đọc orders; role kiểm endpoint chưa đủ cho quyền trên từng object.
Contract của project cuối chọn API chưa xác thực trả 401. Nếu dùng session,
cần cấu hình AuthenticationEntryPoint cho API trả 401; formLogin mặc định có thể
redirect 302 tới trang đăng nhập như demo session, không tự đáp ứng contract này.
GET order DTO có items; quan sát SQL để tránh N+1; không serialize entity vòng lặp.
Giữ schema thủ công nhỏ để hiểu SQL; chưa thêm công cụ migration khi chưa cần.
