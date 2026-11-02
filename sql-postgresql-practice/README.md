# SQL + PostgreSQL Practice cho Java Backend

Workspace dùng **một database `sql_postgresql_practice`** xuyên suốt, với năm bảng
`users`, `categories`, `products`, `orders`, `order_items`. Mục tiêu là giải thích
vì sao query đúng, quan hệ dữ liệu tạo ra bao nhiêu dòng và database bảo vệ điều gì.
Chưa dùng JPA/Hibernate/framework. Sau này có thể dùng cùng schema để học JDBC.

## Cách học
Mỗi bài 01–20 có `README.md`, `demo.sql`, `exercise.sql`. Đọc README, ghi dự đoán
trước khi chạy demo, rồi tự viết query từ các TODO. Mọi `exercise.sql` chỉ có comment,
không chứa đáp án thực thi. Lời giải nằm riêng trong `solutions/`, được đánh số tương ứng.
Các bộ luyện tập cũng có đủ ba file và solution riêng trong `solutions/exercises/`.

Với mỗi query, giải thích: một dòng kết quả đại diện cho gì, vì sao dùng điều kiện đó,
JOIN có nhân dòng không, NULL có làm thay đổi kết quả không, trường hợp không có dữ liệu là gì.
SQL có thứ tự xử lý logic để hiểu nghĩa; planner có thể thực thi bằng kế hoạch khác mà vẫn giữ nghĩa.

## Chạy trên PostgreSQL
Máy hiện tại đã có PostgreSQL 18.4. `psql` chưa nằm trong PATH; trên Windows có thể
gọi trực tiếp executable như bên dưới. Nếu PostgreSQL được cài ở chỗ khác, sửa `$psql`.
Role `postgres`, host `localhost`, port `5432` là ví dụ; dùng cấu hình và mật khẩu của bạn.
Role tạo database cần quyền CREATEDB; nhập mật khẩu khi psql yêu cầu.

Mở PowerShell trong thư mục workspace:
```powershell
cd E:\JAVA_FULL\sql-postgresql-practice
$psql = 'C:\Program Files\PostgreSQL\18\bin\psql.exe'
[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new($false)
```

**1. Tạo database một lần**, đang kết nối database `postgres`:
```powershell
& $psql -X -h localhost -p 5432 -U postgres -d postgres -v ON_ERROR_STOP=1 -f database/create_database.sql
```
Nếu database này đã tồn tại, bỏ qua bước tạo. Không chạy CREATE DATABASE bên trong BEGIN.

**2. Tạo schema**, kết nối database vừa tạo:
```powershell
& $psql -X -h localhost -p 5432 -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f database/schema.sql
```
Schema chạy một lần trên database chưa có năm bảng. File không dùng IF NOT EXISTS để tránh
che giấu schema cũ khác cấu trúc. Nếu đã tạo đúng schema thì chuyển sang seed.

**3. Nạp dữ liệu mẫu**, sau khi schema thành công:
```powershell
& $psql -X -h localhost -p 5432 -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f database/seed.sql
```
Seed cần các bảng rỗng. Có 12 users, 5 categories, 25 products, 24 orders và 48 order_items.
Timestamps cố định để bài tập không thay đổi theo ngày bạn chạy. Xem [database/README.md](database/README.md)
để biết quan hệ, giá lịch sử, trạng thái doanh thu và kiểm tra số dòng.

**4. Chạy demo hoặc query tự viết**:
```powershell
& $psql -X -h localhost -p 5432 -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f 05-select/demo.sql
```
Bạn có thể viết SQL vào `exercise.sql` khi bắt đầu tự giải. Ban đầu chạy file này sẽ không có output.

**5. Khôi phục dữ liệu mẫu khi cần**:
```powershell
& $psql -X -h localhost -p 5432 -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f database/reset.sql
& $psql -X -h localhost -p 5432 -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f database/seed.sql
```
Reset xóa dữ liệu năm bảng học tập, giữ schema và reset identity. Nó không xóa database.
Các file schema/seed/reset kiểm tra tên database trước khi thao tác.

## Nếu dùng pgAdmin
1. Kết nối server của bạn. Mở Query Tool trên database `postgres`, bật auto-commit,
   mở `database/create_database.sql` và chạy một lần.
2. Refresh danh sách databases. Mở Query Tool **trên `sql_postgresql_practice`**.
3. Mở và chạy toàn bộ `schema.sql`, sau đó mở và chạy toàn bộ `seed.sql`.
4. Giữ kết nối database này để chạy demo và tự giải bài. Các file là SQL thuần, không cần lệnh riêng của psql.
5. Nếu một transaction bị lỗi, chạy `ROLLBACK;` trên cùng session trước khi thử tiếp.

## Thứ tự học
| Bước | Chủ đề |
|---:|---|
| 01 | [Database basics](01-database-basics/README.md): database, schema, bảng, dòng và khóa |
| 02 | [Data types](02-data-types/README.md): số, chuỗi, thời gian và NULL |
| 03 | [Create table](03-create-table/README.md): cấu trúc và mặc định |
| 04 | [Insert](04-insert/README.md): thêm dữ liệu và RETURNING |
| 05 | [Select](05-select/README.md): chiếu cột và ý nghĩa kết quả |
| 06 | [Update/delete](06-update-delete/README.md): phạm vi thay đổi |
| 07 | [Where](07-where-filtering/README.md): điều kiện, logic và NULL |
| 08 | [Order/limit](08-order-limit/README.md): thứ tự ổn định, phân trang |
| 09 | [Primary key](09-primary-key/README.md): danh tính dòng |
| 10 | [Foreign key](10-foreign-key/README.md): toàn vẹn tham chiếu |
| 11 | [Constraints](11-constraints/README.md): dữ liệu hợp lệ |
| 12 | [Relationships](12-relationships/README.md): 1–n và n–n |
| 13 | [Inner join](13-inner-join/README.md): ghép dòng có khớp |
| 14 | [Left join](14-left-join/README.md): giữ cả phía chưa có dữ liệu |
| 15 | [Aggregate functions](15-aggregate-functions/README.md): tổng hợp và NULL |
| 16 | [Group by/having](16-group-by-having/README.md): nhóm và lọc nhóm |
| 17 | [Subquery](17-subquery/README.md): chia vấn đề và EXISTS |
| 18 | [Index](18-index/README.md): plan trên 200000 dòng tạm |
| 19 | [Transaction](19-transaction/README.md): đặt hàng, khóa kho và rollback |
| 20 | [PostgreSQL features](20-postgresql-features/README.md): IDENTITY, SEQUENCE, kiểu dữ liệu, JSONB |

Sau bài 05–08 làm [beginner](exercises/beginner/README.md) và [filtering](exercises/filtering/README.md).
Sau bài 13–17 làm [joins](exercises/joins/README.md), [aggregation](exercises/aggregation/README.md),
[backend-usecases](exercises/backend-usecases/README.md) và [debug-sql](exercises/debug-sql/README.md).
Backend-usecases có đủ năm endpoint bạn yêu cầu; query mẫu dùng giá trị cố định để chạy trực tiếp.
Khi học JDBC, thay giá trị đầu vào bằng tham số PreparedStatement; không nối chuỗi input thành SQL.

## Index và transaction: chạy đúng file
`18-index/demo.sql` tự tạo bảng tạm **200000 dòng trong cùng database**, chạy EXPLAIN và
EXPLAIN ANALYZE trước/sau index rồi ROLLBACK. Không thêm dữ liệu giả vào products gốc.
Đọc plan, rows và buffers, không chỉ so thời gian một lần chạy.

Demo DDL/DML thông thường và solutions dùng bảng tạm hoặc BEGIN/ROLLBACK để giữ seed.
Riêng `19-transaction/commit_order.sql` **COMMIT thật**, tạo đơn và giảm stock product1 đi 2.
Để quan sát lỗi giữa chừng, chạy file này với ON_ERROR_STOP=0 cho phép đi tới ROLLBACK cuối file:
```powershell
& $psql -X -h localhost -p 5432 -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=0 -f 19-transaction/rollback_failure.sql
```
Hai lỗi CHECK violation / transaction aborted là output dự kiến của file trên. Mọi file khác dùng ON_ERROR_STOP=1.
Trong pgAdmin, chạy từng đoạn của tình huống lỗi trên cùng session, cuối cùng chạy ROLLBACK.

## Debug SQL
Query sai nằm **trong comment của exercise.sql**, kèm TODO và tình huống. Đọc từng query,
giải thích lỗi rồi tự viết bản sửa. Khi muốn thử lỗi, chỉ sao chép một query vào session học tập;
UPDATE/DELETE cần bắt đầu bằng BEGIN và kết thúc ROLLBACK.
Các bài bao gồm JOIN sai khóa, `= NULL`, GROUP BY sai, UPDATE thiếu WHERE, DELETE rộng và JOIN nhân dòng.

## Cây thư mục và tài liệu tham khảo
Xem [STRUCTURE.md](STRUCTURE.md) để có cây đầy đủ và [solutions/README.md](solutions/README.md)
để hiểu cách đối chiếu đáp án sau khi tự làm.
Nội dung được đối chiếu với tài liệu PostgreSQL:
[CREATE TABLE và constraints](https://www.postgresql.org/docs/18/sql-createtable.html),
[transactions](https://www.postgresql.org/docs/18/tutorial-transactions.html),
[EXPLAIN](https://www.postgresql.org/docs/18/using-explain.html),
[JSON types](https://www.postgresql.org/docs/18/datatype-json.html).
