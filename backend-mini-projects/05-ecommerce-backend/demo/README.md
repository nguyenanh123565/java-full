# Demo trace một order — ví dụ thiết kế, chưa phải server chạy sẵn

Giả sử product 10 có giá 12.50, stock 3. Client user 7 mua quantity 2.

```http
POST /orders
Content-Type: application/json

{"items":[{"productId":10,"quantity":2}]}
```

Server lấy user từ identity đã xác thực; không tin userId/total/price do client gửi.
Sau commit: order_items lưu unit_price=12.50, quantity=2, orders.total=25.00,
products.stock=1. Response 201 có Location `/orders/{id}` và DTO order.
Dự đoán: nếu item thứ hai thiếu stock thì toàn bộ thay đổi phải rollback.
Đối chiếu SQL/transaction ở [JDBC](../../../jdbc-practice/07-transaction/README.md)
và [JPA](../../../jpa-hibernate-practice/13-transaction/README.md).
