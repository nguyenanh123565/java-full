# Chỉ mở sau lần tự làm

Lời giải từng bài nằm trong `../NN-.../solution/README.md`. [Product API tham chiếu](../mini-project/solution/README.md) có source chạy được để đối chiếu xuyên suốt; starter ở thư mục bên cạnh chỉ chứa TODO.

Đối với lọc name, controller lấy `@RequestParam`, service quyết định quy tắc bỏ khoảng trắng/không phân biệt hoa thường, repository lọc dữ liệu. Không có kết quả là collection rỗng với 200; thiếu một item theo id mới là 404. Quy tắc lọc là lựa chọn hợp đồng cần viết trước, không được suy ra tùy tiện từ Map.

Stock không âm có thể là constraint; trừ stock khi đặt đơn còn cần kiểm tra tồn kho và xử lý đồng thời. Memory CRUD chưa phải transaction đặt hàng. Khi thay repository bằng fake qua constructor, HTTP không đổi; khi thay bằng JDBC, SQL parameters nằm ở implementation dữ liệu.
