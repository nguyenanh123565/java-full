# Solution tham khảo — 08 API basics

Chỉ đối chiếu sau khi đã viết giả định của bạn. Đây là một giao kèo mẫu; các API bên dưới là bài thiết kế, lab không triển khai CRUD.

## 1. Đọc product

Một lựa chọn: `GET /products/42`; id là số nguyên dương ở path. Thành công `200` với `{"id":42,"name":"Robot A","price":6500000,"stock":3}`. Giao kèo quy định price dùng VND nguyên và stock không âm. Id sai định dạng có thể `400`; không tìm thấy có thể `404`. Client dựa vào ý nghĩa các trường, không dựa vào tên bảng hay framework.

## 2. Tạo user

Một lựa chọn: `POST /users` nhận name, email, password qua HTTPS. Backend sinh id/createdAt và hash password bằng giải pháp phù hợp; response `201`, `Location: /users/43`, chỉ trả id/name/email/createdAt. Không trả password hoặc hash. Email trùng có thể `409`; JSON hỏng `400`; dữ liệu không hợp lệ có thể `422` theo giao kèo. Không gửi password trong URL vì có thể xuất hiện trong log hoặc history.

Đây là quyết định giao kèo, không phải yêu cầu tự triển khai cryptography.

## 3. Pagination

Đổi array thành `{"items":[...],"total":24}` làm client cũ đọc array hỏng. Có thể giữ endpoint cũ và thêm phiên bản giao kèo mới; hoặc giữ body array, bổ sung header/link phân trang đã được mô tả. Cách thứ hai ít phá vỡ body nhưng client cần đọc headers; browser cross-origin có thể cần expose header. Không giả định thêm bất kỳ trường nào luôn tương thích: phụ thuộc cách client kiểm tra schema.

Tự chấm: có đủ input/output/lỗi? Có phân biệt dữ liệu nhạy cảm? Có giải thích compatibility?
