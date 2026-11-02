# Solution tham khảo — 09 REST basics

## 1. Resource

User có identity user id, representation có tên và email công khai theo quyền. Product có identity product id, representation có giá/tồn kho. Báo cáo doanh thu có identity theo kỳ và tiêu chí, representation là số tổng hợp từ orders/items. Resource là khái niệm được nhận diện; JSON chỉ là một cách biểu diễn và có thể đổi theo thời điểm/quyền.

## 2. RPC sang HTTP theo tài nguyên

Giả định chỉ đọc product: `GET /products/10`, không cần request body. GET truyền đạt ý định đọc dữ liệu và có ngữ nghĩa safe; POST không truyền đạt ý định này và không có bảo đảm idempotent mặc định. Có thể trả `200` với representation hoặc `404` nếu không tồn tại. Không dùng `GET /getProduct` rồi chỉ đổi method: cần suy nghĩ identity và giao kèo trước.

## 3. Ràng buộc

Một lựa chọn là `GET /users/12/orders`; request xác định user và mang thông tin xác thực khi cần. Backend kiểm tra quyền với user 12, không dựa vào một bước “chọn user” trước đó. Dữ liệu orders vẫn có thể lưu trong database.

API thiếu hypermedia nên chỉ nên gọi là HTTP API theo tài nguyên trong phạm vi bài. Thiếu mô tả cache khiến client chưa biết response có thể dùng lại ra sao; có thể dùng `Cache-Control: no-store` cho nội dung nhạy cảm theo giao kèo. Danh từ và JSON không thay thế các ràng buộc REST.
