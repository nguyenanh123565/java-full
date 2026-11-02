# Bài tập 07 — Status codes

## TODO 1 — Dễ: kết quả thành công

Thiết kế response cho bốn tình huống: đọc sản phẩm 27 thành công; tạo sản phẩm mới; xóa thành công mà không trả representation; đọc id chưa từng tồn tại.

- Chọn status, quyết định body có hay không và header nào cần thiết.
- Giải thích vì sao status bạn chọn giúp client biết bước tiếp theo.
- Đây là thiết kế; lab chưa tạo hoặc xóa sản phẩm nghiệp vụ.

**Bài làm của tôi:** TODO

## TODO 2 — Vừa: sáu lỗi khác nhau

Chọn status cho: JSON sai cú pháp; chưa đăng nhập vào API yêu cầu credentials; user đã đăng nhập nhưng thiếu quyền; backend chỉ nhận JSON nhưng client gửi kiểu khác; email tạo mới trùng dữ liệu hiện có; JSON hợp lệ nhưng quantity bằng 0 theo contract yêu cầu quantity dương.

- Nêu giả định giúp bạn lựa chọn; định nghĩa quy ước 400/422 cho validation.
- Phân biệt thiếu quyền và thiếu credentials hợp lệ.
- Giải thích vì sao bạn không dùng 500 cho tất cả các tình huống.

**Bài làm của tôi:** TODO

## TODO 3 — Khó: sửa response sai

Ba response được một backend đề xuất:

```http
HTTP/1.1 401 Unauthorized
Content-Type: application/json

{"message":"login required"}
```

```http
HTTP/1.1 204 No Content
Content-Type: application/json

{"message":"deleted"}
```

```http
HTTP/1.1 405 Method Not Allowed
Content-Type: application/json

{"message":"method rejected"}
```

- Tìm lỗi cấu trúc hoặc header bị thiếu ở mỗi response và tự sửa.
- Đề xuất error body nhất quán có mã lỗi ổn định; giải thích vì sao client không nên phụ thuộc vào nguyên câu message.
- Nếu client gặp lỗi mạng và không nhận được response, vì sao không được tự ghi nhận đó là status 500 từ backend?

**Bài làm của tôi:** TODO
