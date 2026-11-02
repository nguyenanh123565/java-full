# Đối chiếu 04 — URL, path, query

## Bài 1

Scheme `https`, host `shop.example.test`, port `8443`, path `/users/83/orders`, query `status=pending&page=2`, fragment `latest`. Request target trực tiếp: `/users/83/orders?status=pending&page=2`. Fragment phục vụ client, không được đưa vào request target; backend không nhận `latest` qua URL này.

## Bài 2

Một thiết kế: GET `/products/83`; GET `/products?q=sensor&minPrice=1000000&maxPrice=4000000`; POST `/products` với JSON `name`, `price`, `stock`. Path định danh một sản phẩm; query chọn một tập sản phẩm; body mang dữ liệu tạo mới. Khoảng giá đảo ngược cần bị từ chối hoặc được xử lý theo quy tắc công bố; cú pháp URL chỉ cho biết chuỗi có thể đọc được, chưa đảm bảo ý nghĩa nghiệp vụ.

## Bài 3

Ví dụ `/products?q=Arm%20%26%20Sensor&page=3&size=12&sort=price,asc`. Chọn page bắt đầu từ 1, size từ 1 đến 100, whitelist sort, thứ tự phụ `id` tăng dần. Chưa encode `&` sẽ tách query thành các phần, khiến tên đọc được không còn đầy đủ. Echo chỉ trả rawQuery; cần backend có parser, validation và truy vấn đúng thì bộ lọc/phân trang mới hoạt động.
