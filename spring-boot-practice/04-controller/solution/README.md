# Tham khảo sau khi tự làm — Controller nhận và trả dữ liệu HTTP

`GET /hello` có thể trả 200 và object JSON chứa message. Request path khác không tự rơi vào method vì tên method giống nhau. Nếu tách một hàm `buildGreeting()` Java thuần, chỉ method có mapping đóng vai trò adapter HTTP; hàm helper vẫn là lời gọi Java.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
