# Solution tham khảo — 11 Stateless và idempotent

## 1. Phân loại

GET product safe/idempotent. PUT replacement không safe, idempotent theo ý định đặt cùng trạng thái. DELETE không safe, idempotent theo ý định bỏ resource. Tăng stock không safe và không idempotent nếu mỗi lần tăng thêm 2. Tạo order bằng POST không safe, không có bảo đảm idempotent mặc định. Không đồng nhất method với một implementation bất kỳ: backend dùng GET để sửa stock là vi phạm ngữ nghĩa GET.

## 2. PATCH

A: đặt stock thành 3, sau hai lần vẫn 3. B: tăng thêm 3, từ 10 thành 13 rồi 16. Cả hai có thể dùng PATCH với định dạng/giao kèo phù hợp; không được công bố định dạng chuẩn rồi xử lý tùy ý. Đặt stock lặp lại có thể idempotent nhưng vẫn ghi đè thay đổi vừa thực hiện bởi người khác; ETag/If-Match là một cách kiểm soát.

## 3. Retry POST

Một giao kèo mẫu: `POST /orders`, header `Idempotency-Key: <unique-value>`. Server gắn key với danh tính đã xác thực và thao tác; giữ hash payload cùng kết quả trong 24 giờ. Cùng key/cùng payload trả lại kết quả đã lưu, không tạo order hoặc giảm stock lần nữa. Cùng key/payload khác từ chối, chẳng hạn `409`. Hai request cùng lúc phải được điều phối bằng cơ chế nguyên tử/unique constraint và transaction; một request xử lý, request kia chờ hoặc nhận trạng thái đang xử lý theo giao kèo.

Thời hạn 24 giờ là lựa chọn của ví dụ, không phải quy tắc HTTP. Sau hết hạn, client không được tự giả định key vẫn chống trùng. Backend nên có cách tra cứu order để client xử lý kết quả không chắc chắn.
