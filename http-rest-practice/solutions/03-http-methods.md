# Đối chiếu 03 — Methods

## Bài 1

GET `/products/45`; POST `/products`; PUT `/products/45`; PATCH `/products/45`; DELETE `/products/45`. GET/DELETE thường không cần body. POST gửi các field tạo sản phẩm. PUT gửi đủ representation của các field có thể sửa theo contract; id và createdAt có thể do server quản lý. PATCH phải định nghĩa định dạng body, chẳng hạn contract đặt `stock` theo giá trị được gửi, không tự suy ra phép tăng.

## Bài 2

A cho stock 9 rồi 9. B cho stock 13 rồi 22. A idempotent theo hiệu ứng, B không. PATCH không đảm bảo idempotence; phải đọc ý nghĩa patch document và quy tắc xử lý. Response lần hai có thể khác vì điều kiện hoặc lịch sử thay đổi, miễn hiệu ứng mong muốn của cùng request vẫn phù hợp.

## Bài 3

GET không nên yêu cầu xóa nghiệp vụ; URL có thể bị truy cập tự động. DELETE `/products/45` diễn đạt ý định rõ hơn. Có thể trả 204 lần đầu, 404 khi tài nguyên không còn, hoặc giữ 204 theo contract; trạng thái cuối vẫn không có sản phẩm đó. POST tạo order lặp lại có thể tạo hai order nên cần thiết kế chống tạo trùng riêng. Backend vẫn phải xác định đúng sản phẩm và kiểm tra quyền; method không sửa được một truy vấn DELETE thiếu điều kiện.
