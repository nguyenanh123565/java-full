# Bài tập 03 — Methods

Các endpoint nghiệp vụ dưới đây là yêu cầu thiết kế; không phải tất cả đều được Java lab triển khai.

## TODO 1 — Dễ: chọn method

Với sản phẩm id 45, tự chọn method và URI cho: đọc thông tin; tạo sản phẩm mới; thay thế toàn bộ dữ liệu có thể chỉnh sửa; chỉ đặt stock thành 9; xóa sản phẩm.

- Viết năm cặp method/URI và mô tả body có cần không.
- Giải thích vì sao method phù hợp với ý định; chỉ rõ field nào server quản lý.
- Đừng chỉ chọn theo tên một câu SQL.

**Bài làm của tôi:** TODO

## TODO 2 — Vừa: lặp request

Hai contract được đề xuất:

- A: đặt stock của sản phẩm 45 bằng 9.
- B: tăng stock của sản phẩm 45 thêm 9.

Stock ban đầu bằng 4. Dự đoán trạng thái sau khi gửi **cùng request hai lần** cho từng contract.

- Contract nào có hiệu ứng idempotent? Vì sao?
- Nếu server dùng PATCH cho cả hai, method có đủ để quyết định khả năng retry không?
- Status lần hai có bắt buộc giống lần đầu không? Giải thích.

**Bài làm của tôi:** TODO

## TODO 3 — Khó: sửa API có tác dụng phụ

Một API đang dùng `GET /deleteProduct?id=45`. Trình duyệt, bot hoặc hệ thống prefetch có thể mở URL.

- Nhận xét ý nghĩa method và tác dụng phụ.
- Thiết kế lại method/URI và contract khi sản phẩm đã bị xóa.
- Giải thích sự khác nhau giữa gửi lại request xóa và gửi lại request tạo một đơn hàng mới.
- Nêu vì sao đổi method mà giữ backend xóa mọi sản phẩm vẫn chưa sửa được lỗi thiết kế.

**Bài làm của tôi:** TODO
