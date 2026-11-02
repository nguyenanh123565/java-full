# Demo — Validation dữ liệu đầu vào

Minh họa có chủ đích, không phải ứng dụng chạy riêng. Dùng project được chỉ ở README workspace nếu cần thực thi. Mỗi lần chỉ đổi một yếu tố.

Request `{ "name": "   ", "price": -1 }` bind được thành DTO nhưng vi phạm constraint. Request JSON hỏng cú pháp thất bại trước constraint. Dùng advice lesson 12 để trả lỗi dễ hiểu.

Trước khi thử, ghi request đầu vào, đối tượng Java được gọi và response dự kiến. Sau khi thử, đối chiếu với HTTP status/body hoặc biến Java quan sát được.
