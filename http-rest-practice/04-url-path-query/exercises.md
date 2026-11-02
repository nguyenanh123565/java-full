# Bài tập 04 — URL, path, query

## TODO 1 — Dễ: đọc URL

Phân tích `https://shop.example.test:8443/users/83/orders?status=pending&page=2#latest`.

- Ghi scheme, host, port, path, query và fragment.
- Viết request target theo dạng HTTP/1.1 gửi trực tiếp tới origin.
- Giải thích phần nào không được gửi tới backend và vì sao.
- Đây là URL minh họa, không phải dịch vụ cần truy cập.

**Bài làm của tôi:** TODO

## TODO 2 — Vừa: dữ liệu đặt ở đâu?

Thiết kế API cho ba nhu cầu: xem sản phẩm 83; tìm theo tên và khoảng giá; tạo một sản phẩm với tên, giá và stock.

- Chọn method/URI rồi xác định path, query hay body cho từng dữ liệu.
- Nêu lý do, không chỉ ghi URL.
- Nếu giá nhỏ nhất lớn hơn giá lớn nhất, backend cần quyết định gì? Vì sao query hợp lệ về cú pháp vẫn có thể không hợp lệ về nghiệp vụ?

**Bài làm của tôi:** TODO

## TODO 3 — Khó: ký tự đặc biệt và phân trang

Người dùng tìm tên `Arm & Sensor`, chỉ lấy trang 3 với kích thước 12, sắp xếp theo giá tăng dần.

- Tự viết URL đã encode phù hợp với một contract bạn chọn.
- Định nghĩa trang bắt đầu từ 0 hay 1, kích thước tối đa, sort hợp lệ và thứ tự phụ khi hai giá bằng nhau.
- Dự đoán backend đọc tên ra sao nếu bạn quên encode dấu `&`.
- Có thể dùng `/echo` để kiểm tra raw query; giải thích vì sao echo không chứng minh phân trang nghiệp vụ đã đúng.

**Bài làm của tôi:** TODO
