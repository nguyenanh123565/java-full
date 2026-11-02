# ResultSet và ánh xạ object

## 1. Problem — vì sao cần khái niệm này?
Database trả hàng/cột, trong khi Java dùng object và kiểu dữ liệu. Cần tự duyệt và chuyển đổi có chủ đích.

## 2. Mental model
Con trỏ ban đầu đứng trước hàng đầu tiên. next() trả true khi di chuyển đến một hàng hợp lệ. while(next()) duyệt nhiều hàng; if(next()) chỉ lấy nhiều nhất một hàng.

## 3. Ví dụ nhỏ
`while (rs.next()) { new JdbcProduct(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price"), rs.getInt("stock")); }`

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: vòng lặp, record và List. SQL: ORDER BY mới đảm bảo thứ tự; NUMERIC dùng BigDecimal, không dùng double cho tiền. HTTP: danh sách DTO JSON cần ánh xạ từ dữ liệu đã đọc.

## 5. Những lỗi thường gặp
Gọi getter trước next(); dùng if cho danh sách; giữ ResultSet sau khi đóng Connection; quên wasNull() với getter primitive của cột nullable.

## 6. Câu hỏi tự kiểm tra
Query trả 0 hàng thì while chạy mấy lần? Vì sao không trả ResultSet ra Controller?

## 7. Exercise
Ánh xạ danh sách product, rồi query không có kết quả. Thêm một truy vấn cột nullable và phân biệt SQL NULL với số 0 bằng wasNull().

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
