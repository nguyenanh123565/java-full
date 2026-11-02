# Bài tập 02 — Request/response

## TODO 1 — Dễ: đọc thông điệp

```http
POST /echo?source=exercise HTTP/1.1
Host: localhost:8080
Content-Type: text/plain
X-Lab-Header: lesson02-1

hello learner
```

- Đánh dấu method, path, query, headers và body.
- Giải thích vì sao `X-Lab-Header` không thuộc body.
- Viết dự đoán của bạn trước khi tự gửi bằng IDE hoặc curl.

**Bài làm của tôi:** TODO

## TODO 2 — Vừa: body có bắt buộc không?

Tự tạo và gửi ba request tới lab: GET `/products`, HEAD `/products`, GET `/status/204`.

- Dự đoán request nào có response body và request nào không.
- Ghi lại status, `Content-Type` nếu có, và body thực tế.
- Giải thích vì sao body trống không tự động đồng nghĩa với lỗi.

**Dự đoán:** TODO

**Quan sát và giải thích:** TODO

## TODO 3 — Khó: nhiều lần trao đổi

Một trang chi tiết sản phẩm cần hiển thị thông tin sản phẩm và số lượng sản phẩm trong giỏ của người dùng. Giả sử hệ thống cung cấp hai API riêng; đây là bài thiết kế trên giấy, lab chưa có giỏ hàng.

- Mô tả hai request/response theo thứ tự bạn chọn.
- Chỉ rõ dữ liệu nào thuộc request và dữ liệu nào thuộc response.
- Giải thích vì sao hai request không nhất thiết dùng hai kết nối TCP riêng.
- Nêu một tình huống chỉ một request thất bại và cách UI có thể phản hồi.

**Bài làm của tôi:** TODO
