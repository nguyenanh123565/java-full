# Từ yêu cầu API tới SQL

## Khái niệm giải quyết vấn đề gì?

Một API xác định dữ liệu cần trả về; SQL đọc dữ liệu đó. Không cần JPA hoặc Hibernate để hiểu hợp đồng dữ liệu, quan hệ, phân trang và báo cáo. Bộ này chỉ chạy SQL; chưa tạo HTTP server.

## SQL hoạt động như thế nào?

Trước mỗi query, xác định dữ liệu đầu vào, một dòng kết quả đại diện cho gì, thứ tự và trường hợp không tìm thấy. Chi tiết đơn hàng lấy giá từ `order_items.price`, vì `products.price` có thể thay đổi. Báo cáo top products tổng hợp `quantity`, không đếm số dòng hàng; loại `cancelled`. Ở đây “được đặt” gồm `pending`, `paid`, `shipped`, không đồng nghĩa doanh thu đã thanh toán.

`GET /users/{id}/orders` có thể dùng hai query cho cả danh sách: một query trả các đơn, một query trả tất cả dòng hàng của các đơn đó. Backend nhóm dòng hàng theo `order_id`. Không cần truy vấn từng đơn riêng, và không cộng `orders.total` sau JOIN dòng hàng. SQL dưới đây là ví dụ về dạng dữ liệu, không phải lời giải toàn bộ API:

```sql
SELECT id, user_id, total, status, created_at
FROM orders
WHERE user_id = 1
ORDER BY created_at DESC, id DESC;
```

## Tham số, phân trang và JDBC sau này

- `page` bắt đầu từ 0, `size` từ 1 tới 100; từ chối số âm, size bằng 0 và số vượt giới hạn. `offset = page * size`; kiểm tra tràn số ở backend.
- Sắp xếp danh sách sản phẩm bằng `id ASC` để có thứ tự xác định. OFFSET có thể thay đổi khi dữ liệu được thêm/xóa giữa hai request; sau này có thể học phân trang theo khóa.
- `id` phải là số nguyên dương; `minPrice` phải không âm và được biểu diễn bằng `BigDecimal` trong Java. Không dùng `double` cho tiền.
- Dùng `PreparedStatement` khi học JDBC; ví dụ `WHERE p.id = ?` là placeholder, không ghép chuỗi từ input. JDBC `?` không phải SQL có thể dán trực tiếp vào psql.
- Tên cột, tên bảng và hướng sắp xếp không bind bằng `?`; nếu cần sort động, dùng danh sách tên cho phép.
- Solutions dùng `WITH params AS (...)` chứa giá trị mẫu để chạy ngay trong PostgreSQL. Khi viết JDBC, thay giá trị đầu vào bằng tham số bind.

## Ví dụ và cách chạy

Đoán số dòng trả về khi `page = 0`, `size = 3`, rồi chạy demo sau khi nạp database:

```powershell
psql -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f exercises/backend-usecases/demo.sql
```

## Lỗi người mới hay mắc

- Phân trang bằng LIMIT/OFFSET nhưng không có ORDER BY.
- Ghép chuỗi SQL từ query parameter.
- Dùng INNER JOIN dòng hàng rồi không thấy đơn chưa có dòng hàng.
- Dùng giá hiện tại để tính lại hóa đơn cũ.
- Dùng `SUM(o.total)` sau JOIN `order_items`, làm tổng tiền lặp theo số dòng hàng.
- Xem danh sách rỗng là lỗi SQL; backend cần quyết định API trả danh sách rỗng hay 404 tùy endpoint.

## Câu hỏi kiểm tra hiểu biết

1. Vì sao endpoint danh sách cần ORDER BY ổn định trước LIMIT/OFFSET?
2. Một query chi tiết dòng hàng có thể trả nhiều dòng cho cùng order_id vì sao?
3. Có thể cộng `SUM(DISTINCT orders.total)` để tránh nhân tổng không? Vì sao?
4. Tại sao tham số số tiền nên dùng BigDecimal khi học JDBC?
5. Báo cáo “đặt nhiều nhất” khác “doanh thu đã thu” ở quy tắc trạng thái nào?

## Bài tập API

| API | Câu hỏi cần giải quyết |
| --- | --- |
| `GET /products?page=0&size=5` | Cột nào trả về, thứ tự nào, tính offset và kiểm tra input ra sao? |
| `GET /products/1` | Lấy sản phẩm và tên danh mục; không có id thì xử lý gì? |
| `GET /users/1/orders` | Lấy tóm tắt đơn, dòng hàng và giá lịch sử mà không nhân tổng tiền. |
| `GET /products?category=robot&minPrice=5000000` | Nối danh mục theo khóa nào, lọc tên và giá tại giai đoạn nào? |
| `GET /reports/top-products` | Xếp theo tổng quantity, loại cancelled, giải quyết đồng hạng. |

Viết SQL của năm TODO trong `exercise.sql`. Tự mô tả các trường response; chỉ đối chiếu `../../solutions/exercises/backend-usecases.sql` khi cần.
