# Tham khảo sau khi tự làm — Status, header và response body

Create sinh id mới: 201, Location trỏ URI item và body DTO. Delete thành công: 204, không body. Missing id: 404 với thông báo ổn định. Giữ ResponseEntity ở controller giúp service được gọi từ CLI hoặc test mà không phụ thuộc HTTP.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
