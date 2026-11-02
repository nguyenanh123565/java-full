# Bài tập 06 — Body/JSON

## TODO 1 — Dễ: ba loại vấn đề

Với API sản phẩm giả định nhận `name` là string, `price` là số không âm và `stock` là số nguyên không âm, phân tích từng body:

```text
A: {'name': 'Arm Kit', 'price': 1200000}
B: {"name":"Arm Kit","price":"1200000","stock":4}
C: {"name":"Arm Kit","price":1200000,"stock":-4}
```

- Phân biệt lỗi cú pháp JSON, lỗi kiểu dữ liệu theo contract và lỗi điều kiện dữ liệu.
- Tự sửa từng body theo contract; giải thích vì sao sửa đúng cú pháp chưa đủ.
- Dự đoán echo lab sẽ xử lý ra sao nếu nhận nguyên từng chuỗi này.

**Bài làm của tôi:** TODO

## TODO 2 — Vừa: tạo sản phẩm

Thiết kế JSON request tạo một sản phẩm tên `Arm Kit`, giá 1.200.000 VND, stock 4, category `robot`.

- Chọn field, kiểu dữ liệu và đơn vị giá; quyết định category dùng id hay mã và giải thích.
- Thiết kế response thành công có định danh sản phẩm do server cấp.
- Nêu những field client không được tùy ý quyết định và các lỗi validation cần kiểm tra.
- Đây là thiết kế trên giấy; không gửi tới POST `/products` của lab.

**Bài làm của tôi:** TODO

## TODO 3 — Khó: input đặt hàng

User đăng nhập chọn sản phẩm 27 số lượng 2 và sản phẩm 31 số lượng 1. Client đề xuất gửi cả total, unitPrice, role và userId.

- Thiết kế body tối thiểu bạn chấp nhận cho thao tác đặt hàng.
- Đánh dấu dữ liệu nên lấy từ danh tính đã xác thực, dữ liệu sản phẩm và dữ liệu client.
- Giải thích backend nên làm gì khi giá thay đổi hoặc stock không đủ.
- Vì sao tổng tiền client tự tính chỉ nên dùng hiển thị hoặc kiểm tra lệch, không tự động là giá trị được lưu?

**Bài làm của tôi:** TODO
