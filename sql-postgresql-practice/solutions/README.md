# Lời giải mẫu — chỉ mở sau khi tự làm

Mỗi file `01-database-basics.sql` đến `20-postgresql-features.sql` ứng với lesson cùng tên.
Trong `exercises/`, mỗi file ứng với một bộ bài ở `../exercises/` của workspace.
Mỗi lời giải có comment đánh số; đây là một cách làm để đối chiếu cơ chế và trường hợp biên.

Chạy khi kết nối `sql_postgresql_practice`, sau schema/seed. Solutions ghi dữ liệu dùng
transaction và ROLLBACK, còn SELECT chỉ đọc dữ liệu. Không chép đáp án vào bài tập trước khi tự thử.
Bài transaction có file COMMIT riêng trong `19-transaction/commit_order.sql`.
Các query cố tình sai của debug-sql ở dạng comment; solution chạy được, không chứa thao tác phá dữ liệu có COMMIT.

Ví dụ từ gốc workspace:
```powershell
psql -X -h localhost -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f solutions/13-inner-join.sql
```
