# Vấn đề ORM giải quyết

## 1. Problem — vì sao cần khái niệm này?
Trong JDBC, mỗi query đều cần lặp ResultSet và ánh xạ cột sang object. Khi có nhiều bảng và quan hệ, code mapping lặp lại dễ sai. ORM tự động hóa một phần công việc đó nhưng không thay việc hiểu SQL.

## 2. Mental model
Java Object ↔ Database Row; Class ↔ Table; Field ↔ Column. Một entity là object có identity được persistence context quản lý, không phải mọi object đều tự được lưu.

## 3. Ví dụ nhỏ
JDBC: new Product(rs.getLong("id"), ...). ORM: EntityManager.find(Product.class, id) tạo hoặc lấy entity từ persistence context rồi đọc dữ liệu khi cần.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: object identity khác equals; JDBC: mapping tường minh; SQL: PK/FK vẫn tồn tại. HTTP response nên dùng DTO, tránh đưa thẳng đồ thị entity ra client.

## 5. Những lỗi thường gặp
Nghĩ ORM bỏ SQL; coi List Java như một bảng có transaction; nghĩ sửa field của mọi object đều update database.

## 6. Câu hỏi tự kiểm tra
Trong JDBC ai tạo Product? Với ORM ai thực hiện mapping? Nếu không có table tương ứng thì entity có lưu được không?

## 7. Exercise
Viết mapper JDBC cho ba field rồi mô tả phần ORM làm thay; vẽ ba cặp object/row, class/table, field/column.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
