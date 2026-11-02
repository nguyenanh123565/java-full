# Đối chiếu HTTP thuần

Demo HealthServer là ví dụ runnable về method/path/header/UTF-8. Mở rộng read-only:

1. GET `/products`: trả JSON array từ collection đã có; mảng rỗng là 200 `[]`.
2. GET `/products/{id}`: parse số; không phải số → 400; không có row/object → 404.
3. Method khác trên route tồn tại → 405 và `Allow: GET`; route không có → 404.
4. Byte UTF-8 dùng cho Content-Length; close response body sau khi viết.

Nếu nối chuỗi JSON chứa input tùy ý cần escape đúng. Giữ tên cố định trong demo
nhỏ; khi sang Spring dùng JSON serializer thay vì tự phát minh parser. Bài này
không yêu cầu viết parser POST JSON hoặc thêm thư viện trước khi học build tool.
