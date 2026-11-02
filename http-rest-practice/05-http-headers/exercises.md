# Bài tập 05 — Headers

## TODO 1 — Dễ: metadata sai

Một client gửi body JSON nhưng đặt `Accept: application/json` và `Content-Type: text/plain`. Backend nghiệp vụ chỉ nhận JSON; đây không phải giới hạn của echo lab.

- Giải thích mỗi header đang nói về nội dung nào.
- Sửa metadata theo ý định gửi JSON và nhận JSON.
- Vì sao sửa header vẫn chưa chứng minh JSON hợp lệ hoặc dữ liệu đúng nghiệp vụ?

**Bài làm của tôi:** TODO

## TODO 2 — Vừa: dự đoán trước khi gửi

Tự tạo GET `/echo` với hai headers `AcCePt: application/json` và `X-Lab-Header: MiXeD-Value`.

- Dự đoán tên và giá trị sẽ xuất hiện trong JSON response thế nào.
- Gửi request rồi ghi lại quan sát.
- Vì sao quy tắc không phân biệt hoa thường của tên header không cho phép sửa tùy tiện giá trị token hoặc chuỗi tùy chỉnh?

**Dự đoán:** TODO

**Quan sát và giải thích:** TODO

## TODO 3 — Khó: contract metadata

Thiết kế một request tạo user với JSON có tên tiếng Việt, yêu cầu xác thực bằng token giả; server trả URI user vừa tạo.

- Viết request/response minh họa và các headers cần thiết; không tự ghi Content-Length.
- Tách thông tin về kiểu nội dung, xác thực và resource mới.
- Giải thích ai nên tính độ dài body, và token cần được kiểm chứng như thế nào trước khi thực hiện nghiệp vụ.
- Đây là bài thiết kế; lab chưa có POST users hoặc xác thực thật.

**Bài làm của tôi:** TODO
