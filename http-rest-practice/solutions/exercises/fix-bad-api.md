# Gợi ý chọn lọc — sửa API sai

Chỉ giải mẫu TODO 2; các case còn lại có câu hỏi phản biện để bạn tự sửa.

## Một mẫu: POST dùng để đọc product

Nếu mục đích là đọc một product theo id, có thể dùng `GET /products/10` với `Accept: application/json`, không cần body `{}`. URL định danh resource; GET thể hiện thao tác đọc. Thành công trả 200 và product; thiếu product trả 404 theo hợp đồng. `POST /getProduct?id=10` có thể hoạt động nếu server viết như vậy, nhưng truyền tải ý định kém rõ và không dùng semantics GET cho thao tác đọc này.

## Câu hỏi gợi mở cho phần còn lại

1. GET xóa: link preview hoặc công cụ tự đọc link có thể vô tình gây tác động gì?
2. URL verbs: method nào biểu thị thao tác trước khi đổi tên route?
3. Mọi response 200: client phân biệt duplicate, validation, không đủ quyền và lỗi server bằng cách nào?
4. `admin=true`: ai có quyền tạo ra thông tin authorization đáng tin cậy?
5. JSON mơ hồ: client có biết kiểu, đơn vị tiền và field bí mật không?
6. User A/B: backend kiểm tra chủ sở hữu ở đâu trước khi trả dữ liệu?
7. Stock retry: body đặt giá trị hay cộng thêm? Cơ chế nào ngăn xử lý lại cùng thao tác?
8. Phân trang: có tie-breaker và giới hạn? Dữ liệu thay đổi giữa hai lần đọc có còn tạo sai lệch không?
9. Hủy order: trạng thái nào cho phép, ai được hủy, làm sao hoàn stock đúng một lần?

Tự chấm đạt khi mỗi bản sửa có method/URL, input, success/error, quyền, retry và một lý do cụ thể. Chấp nhận nhiều thiết kế nếu quy tắc nghiệp vụ và HTTP nhất quán.

Tham khảo: [RFC 9110](https://www.rfc-editor.org/rfc/rfc9110.html), [Problem Details — RFC 9457](https://www.rfc-editor.org/rfc/rfc9457.html).
