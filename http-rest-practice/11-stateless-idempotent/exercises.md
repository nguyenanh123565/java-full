# Bài tập 11 — Stateless và idempotent

## 1. Dễ — Phân loại ý định

Có các nghiệp vụ: đọc product; thay thế đầy đủ thông tin product; xóa product; tăng stock thêm 2; tạo một order mới.

TODO:
- Chọn method và phân loại safe/idempotent.
- Viết trạng thái trước/sau khi gửi cùng request hai lần.
- Nêu giả định khiến kết luận thay đổi.
- Giải thích logging có làm GET mất ngữ nghĩa safe không.

## 2. Vừa — Hai giao kèo PATCH

Giao kèo A đặt stock thành giá trị trong body. Giao kèo B nhận chỉ dẫn tăng stock theo số lượng trong body. Stock ban đầu bằng 10.

TODO:
- Tự viết request cho mỗi giao kèo với giá trị 3.
- Dự đoán stock sau một và hai lần gửi.
- Giải thích tính idempotent dựa trên ý nghĩa thao tác, không chỉ tên method.
- Nêu một vấn đề cạnh tranh mà retry idempotent vẫn chưa giải quyết.

## 3. Khó — Tạo order nhưng mất response

Backend có thể đã tạo order, giảm stock và commit, nhưng client không nhận response. Hai request cùng key cũng có thể tới cùng lúc.

TODO:
- Đề xuất giao kèo idempotency key cho thao tác tạo order.
- Nêu phạm vi key, thời hạn, request cùng/khác payload và kết quả retry.
- Mô tả yêu cầu nguyên tử ở backend bằng lời.
- Giải thích vì sao chỉ thêm header ở client chưa đủ.
