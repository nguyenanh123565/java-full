# 05 — SELECT và hình dạng kết quả

## Khái niệm giải quyết vấn đề gì?

`SELECT` đọc dữ liệu và chọn hình dạng kết quả mà người gọi cần. Backend có thể chỉ cần ID, tên và giá để trả danh sách sản phẩm; không phải endpoint nào cũng cần mọi cột. SQL mô tả kết quả mong muốn, không yêu cầu bạn tự viết vòng lặp duyệt từng dòng như trong Java.

## SQL hoạt động như thế nào?

`FROM` xác định nguồn dòng; danh sách sau `SELECT` chiếu cột hoặc tính biểu thức cho từng dòng. Alias bằng `AS` đặt tên cột kết quả, không đổi tên cột trong bảng. `DISTINCT` bỏ các dòng trùng nhau xét trên toàn bộ danh sách cột được chọn. SELECT không thay đổi dữ liệu nguồn.

Thứ tự logic đọc câu SELECT hữu ích là nguồn dữ liệu trước, biểu thức kết quả sau. Đây là cách hiểu ngữ nghĩa; PostgreSQL có thể chọn thứ tự thực thi vật lý khác để tối ưu. Chỉ `ORDER BY` mới bảo đảm thứ tự trả về.

## Ví dụ

```sql
SELECT id, name, price * stock AS inventory_value
FROM public.products
ORDER BY id;
```

`inventory_value` là phép tính giá bán nhân tồn kho, không phải doanh thu đã bán và không phải cột mới được lưu. Đoán giá trị của sản phẩm hết hàng trước khi chạy demo.

## Lỗi người mới hay mắc

- Dùng `SELECT *` cho mọi API rồi vô tình trả các cột không cần thiết.
- Nghĩ alias tạo thêm cột thật trong bảng.
- Nghĩ `DISTINCT category_id, name` chỉ loại trùng category_id.
- Nhầm giá trị hàng đang tồn với doanh thu đơn hàng.
- Tin rằng SELECT không ORDER BY sẽ luôn giữ thứ tự ID.

## Câu hỏi kiểm tra hiểu biết

1. Alias khác tên cột thật ở đâu?
2. Vì sao SELECT giá nhân stock không thay đổi giá và stock?
3. DISTINCT xét một cột hay toàn bộ dòng kết quả?
4. SELECT * gây khó khăn gì khi schema thêm cột?

## Ba bài tập từ dễ đến khó

1. Đọc ID, tên và giá của mọi sản phẩm theo ID; giải thích dữ liệu API cần.
2. Tính giá trị tồn kho trên mỗi sản phẩm, đặt alias; giải thích vì sao đây chưa phải doanh thu.
3. Lấy danh sách category_id đang được products sử dụng không lặp; so sánh DISTINCT một cột với DISTINCT hai cột.

Đối chiếu riêng tại `../solutions/05-select.sql`.
