# Transaction và đặt hàng

## Khái niệm giải quyết vấn đề gì?
Gom tạo order, tạo dòng hàng và giảm kho thành một đơn vị: thành công toàn bộ hoặc không giữ thay đổi nào.

## SQL hoạt động như thế nào?
- BEGIN mở transaction; COMMIT giữ thay đổi; ROLLBACK bỏ thay đổi chưa commit.
- Lỗi statement trong transaction làm transaction bị aborted; cần ROLLBACK hoặc ROLLBACK TO SAVEPOINT.
- SELECT FOR UPDATE khóa dòng được chọn đến cuối transaction, giúp kiểm tra stock và giảm stock cùng một thứ tự.
- Kiểm tra tồn tại, quantity dương, đủ stock trước mutation; ứng dụng phải kiểm tra số dòng affected.
- Sequence/IDENTITY không rollback số đã cấp. Gap ID không chứng minh thiếu dữ liệu.
- Transaction không tự giải mọi race: cần locking hoặc UPDATE có điều kiện, cùng kiểm tra affected rows.

## Ví dụ
```sql
BEGIN;
SELECT id, stock FROM products WHERE id = 1 FOR UPDATE;
UPDATE products SET stock = stock - 1 WHERE id = 1 AND stock >= 1 RETURNING id, stock;
ROLLBACK;
```

## Lỗi người mới hay mắc
- Đọc stock ở ngoài transaction rồi giảm ở transaction khác.
- Tạo order nhưng lỗi giảm kho vẫn COMMIT; hoặc quên kiểm tra UPDATE trả 0 dòng.
- Dùng MAX(id) để tìm order vừa INSERT trong hệ thống nhiều request.
- Sau lỗi vẫn chạy thêm SQL mà không ROLLBACK; nghĩ ID phải liên tục.

## Câu hỏi kiểm tra hiểu biết
1. Lỗi tạo order_items thì order mới có được giữ lại không?
2. Vì sao SELECT stock rồi UPDATE không khóa có thể bán vượt tồn?
3. RETURNING giải quyết vấn đề gì khi lấy ID?
4. Khi nào khóa row được giải phóng?
5. Vì sao ROLLBACK không khôi phục sequence về số cũ?

## Ba bài tập từ dễ đến khó
1. Dễ: đặt 2 sản phẩm id=1 cho user1: BEGIN, lấy giá/khóa dòng, tạo order và items, giảm stock rồi COMMIT. Giải thích vì sao phải chung transaction.
2. Vừa: cố đặt 999 sản phẩm id=1; phát hiện thiếu stock rồi ROLLBACK. Kiểm tra số order/items và stock không đổi, giải thích ảnh hưởng của row lock.
3. Khó: tạo order rồi chèn quantity=0 để cố tình vi phạm CHECK; quan sát transaction aborted và ROLLBACK. Sau đó tự thiết kế hai session đặt hàng đồng thời và giải thích không bán vượt kho.

Đọc demo, ghi dự đoán trước khi chạy. Tự làm `exercise.sql`; chỉ mở
`../solutions/19-transaction.sql` sau khi đã thử và viết giải thích.

## Các file chạy thật
- `demo.sql`: luồng đặt hàng có row lock, kết thúc ROLLBACK để giữ seed.
- `commit_order.sql`: cùng luồng nhưng COMMIT, stock product1 giảm 2 và có thêm một order/dòng hàng.
- `rollback_failure.sql`: cố tình lỗi CHECK giữa chừng; chạy với ON_ERROR_STOP=0 để thực hiện ROLLBACK cuối file.

Ví dụ psql (từ gốc workspace):
```powershell
psql -X -h localhost -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f 19-transaction/commit_order.sql
psql -X -h localhost -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=0 -f 19-transaction/rollback_failure.sql
```
Giá và ID được đọc trong transaction, không hard-code ID đơn mới. Bảng tạm giữ ID chỉ để minh họa
SQL thuần; sau này JDBC dùng RETURNING/getGeneratedKeys và commit/rollback trên cùng Connection.
DO block trong demo chỉ làm guard báo lỗi, chưa yêu cầu học PL/pgSQL sâu.
