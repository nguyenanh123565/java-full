# Bài tổng hợp: từ HTTP đến storage memory

- TODO: Với GET /products/10, vẽ đường đi qua mapping, controller, service, repository, DTO. Đánh dấu nơi parse long và nơi nhận biết missing id.
- TODO: Thiết kế thêm bộ lọc `GET /products?name=...`; dự đoán trước khi chạy với query thiếu, chuỗi trắng và không có kết quả.
- TODO: Thêm trường stock không âm vào một bản sao starter. Giải thích vì sao kiểm tra số không âm khác kiểm tra còn hàng khi đặt đơn.
- TODO: Viết bảng method/path/status/body cho CRUD. Vì sao xóa thành công không trả body với 204?
- TODO: Liên hệ Java Core: thay repository bằng fake nhỏ qua constructor. Liên hệ SQL: viết câu SQL parameterized tương ứng, chưa thêm JDBC vào project này.

Tự làm trước; [solutions](../solutions/README.md) chỉ dẫn cách đối chiếu, không nằm trong exercise.
