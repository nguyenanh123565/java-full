# CRUD bằng JDBC

## 1. Problem — vì sao cần khái niệm này?
Ứng dụng cần tạo, đọc, sửa và xóa dữ liệu; mỗi thao tác có kết quả khác nhau và phải báo đúng khi id không tồn tại.

## 2. Mental model
INSERT/UPDATE/DELETE thường dùng executeUpdate() trả số hàng; SELECT dùng executeQuery(). PostgreSQL INSERT ... RETURNING id trả ResultSet vì có dữ liệu đầu ra.

## 3. Ví dụ nhỏ
`UPDATE learning_jdbc.products SET price = ? WHERE id = ?` → count 1 là sửa một hàng, count 0 là id không tồn tại.

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: Optional diễn đạt không tìm thấy. HTTP: POST tương ứng tạo mới, GET đọc, PUT/PATCH sửa, DELETE xóa nhưng DAO không tự chọn HTTP status. SQL WHERE là ranh giới dữ liệu bị tác động.

## 5. Những lỗi thường gặp
UPDATE/DELETE thiếu WHERE; coi count 0 là thành công có dữ liệu; dùng double cho tiền; lấy id mới bằng MAX(id) gây race.

## 6. Câu hỏi tự kiểm tra
Vì sao MAX(id) không xác định được hàng vừa thêm khi nhiều client? executeUpdate trả gì khi sửa id không có?

## 7. Exercise
Tạo một product thử nghiệm, đọc lại, sửa giá, xóa theo id và đọc lại lần cuối. Ghi số hàng từng bước; kiểm tra id không có.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
