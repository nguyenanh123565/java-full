# PreparedStatement và SQL parameter

## 1. Problem — vì sao cần khái niệm này?
Tên sản phẩm có dấu nháy phải được coi là dữ liệu. Giá trị người dùng không được quyền thay đổi điều kiện WHERE.

## 2. Mental model
SQL là khuôn có dấu ?. setString/setBigDecimal gắn giá trị vào vị trí 1-based. Tham số bảo vệ giá trị trong query này; nó không đại diện được tên table, tên column, ASC hoặc DESC.

## 3. Ví dụ nhỏ
`WHERE name = ?` cùng `ps.setString(1, "O'Reilly")`. Chuỗi đó vẫn là một giá trị. Muốn chọn sort column phải ánh xạ lựa chọn đã cho phép sang SQL cố định.

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: dữ liệu và điều khiển là hai vai trò khác nhau. HTTP: request query chứa tên tìm kiếm. SQL: so sánh bằng cần bind giá trị đúng kiểu.

## 5. Những lỗi thường gặp
Đặt ? trong dấu nháy; bắt đầu index bằng 0; dùng ? cho table name; vẫn nối input ở ORDER BY rồi tưởng cả query đã an toàn.

## 6. Câu hỏi tự kiểm tra
Vì sao SELECT * FROM ? không có nghĩa mong muốn? PreparedStatement có tự kiểm tra price dương không?

## 7. Exercise
Viết tìm theo tên chính xác bằng parameter. Dự đoán với tên chứa dấu nháy và chuỗi giống điều kiện SQL. Thêm whitelist hai cột sắp xếp trên giấy.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
