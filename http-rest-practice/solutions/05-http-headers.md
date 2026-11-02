# Đối chiếu 05 — Headers

## Bài 1

Accept nói về response client chấp nhận; Content-Type nói về body đang gửi. Dùng cả `Accept: application/json` và `Content-Type: application/json`. Header chỉ khai báo loại dữ liệu, không parse JSON hay kiểm tra name/price/stock; backend vẫn cần làm các bước đó.

## Bài 2

Lab phản chiếu tên `accept` và `x-lab-header` theo chữ thường, giữ giá trị `application/json` và `MiXeD-Value`. Quy tắc so sánh tên header giúp xử lý `AcCePt` như `Accept`; nó không áp dụng chung cho mọi giá trị. Token và dữ liệu tùy chỉnh có thể phụ thuộc vào từng ký tự.

## Bài 3

Request thiết kế: POST `/users`, Content-Type và Accept đều là `application/json`, Authorization `Bearer example-only`, body `{"name":"Nguyễn An","email":"an@example.test"}`. Response có thể là 201, `Location: /users/83`, Content-Type JSON và body chứa dữ liệu user được phép công khai. HTTP client/server tính Content-Length khi cần dựa trên byte đã mã hóa. Backend phải xác minh token, hạn dùng, nguồn phát hành và quyền theo cơ chế đã chọn; chuỗi có tiền tố Bearer chưa phải bằng chứng hợp lệ.
