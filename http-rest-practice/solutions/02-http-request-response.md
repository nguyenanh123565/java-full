# Đối chiếu 02 — Request/response

## Bài 1

Method là POST; path `/echo`; query `source=exercise`. Ba headers là Host, Content-Type và X-Lab-Header. Body là chuỗi `hello learner` sau dòng trống. Echo trả JSON chứa thông tin request, trong đó trường `receivedBody` là chuỗi; header tùy chỉnh vẫn nằm trong phần headers, không tự trở thành trường body. Lab chỉ phản chiếu các headers được chọn, chẳng hạn `x-lab-header`; Host không được liệt kê trong response echo.

## Bài 2

GET `/products` có JSON body nếu thành công. HEAD `/products` chỉ trả status và headers. GET `/status/204` trả 204 và không có body. HEAD kiểm tra metadata mà không tải representation; 204 cho biết xử lý thành công và không có nội dung để gửi. Chép header thực tế từ lab thay vì giả định header luôn giống nhau.

## Bài 3

Một cách thiết kế là GET `/products/27`, rồi GET `/users/me/cart` với thông tin xác thực theo contract tương lai. Request mang định danh tài nguyên và thông tin xác thực; response mang sản phẩm hoặc nội dung giỏ. Các request có thể tái sử dụng kết nối HTTP; request không tương đương một kết nối TCP mới. Nếu API giỏ lỗi, UI vẫn có thể hiển thị sản phẩm và báo chưa tải được giỏ. URI và chính sách UI này là ví dụ thiết kế, không phải route lab đã triển khai.
