# Product Management CLI — Java + JDBC + PostgreSQL

Học sau bài 09. Dùng Java Core, SQL và JDBC; không dùng Spring Boot, JPA hoặc Hibernate.

## Đề bài

Tạo chương trình terminal với menu add/list/find/update/delete/exit. Product: id, name, price BigDecimal, stock. Dùng bảng `learning_jdbc.products` trong database học mới theo README workspace.

- Add: kiểm tra tên không rỗng, tối đa 120 ký tự; price không âm, tối đa hai số thập phân trong NUMERIC(12,2); stock không âm.
- List: có thứ tự id; bảng rỗng có thông báo rõ.
- Find: tìm theo id; không tìm thấy khác lỗi database.
- Update/delete: theo id, hiển thị đúng khi 0 hàng.
- Lỗi input không đóng chương trình; lỗi DB báo thông tin đã lược bỏ secret.

## Cách làm

1. [Starter](starter/README.md): hoàn thành TODO mà không xem reference.
2. Dự đoán SQL, kết quả và số hàng trước khi chạy từng case.
3. Tách CLI (nhập/xuất), DAO (SQL + mapping), model (dữ liệu). Giải thích vì sao menu không nên duyệt ResultSet.
4. Viết notes: nếu CLI thành HTTP API, phần nào có thể tái sử dụng? SQL WHERE và constraint bảo vệ điều gì?
5. Sau khi hoàn thành mới xem [reference](solution/README.md).

## Checklist nghiệm thu

- [ ] CRUD đủ năm thao tác; tên `O'Reilly` không phá query.
- [ ] Bảng rỗng và id không có được xử lý; input `abc` cho id không làm crash.
- [ ] Price dùng BigDecimal; rejected âm hoặc scale > 2.
- [ ] Connection chỉ mở khi cần, không giữ trong lúc chờ nhập.
- [ ] Giải thích được Java → JDBC API → driver → PostgreSQL → ResultSet → object.
- [ ] TODO nâng cấp độc lập: nghiệp vụ chuyển stock có commit/rollback cùng Connection.
