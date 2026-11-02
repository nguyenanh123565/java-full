# Tham khảo sau khi tự làm — Dependency Injection bằng constructor

Truyền repository vào constructor service và service vào constructor controller là DI ngay cả khi tự `new`. `@Service`/`@Component` giúp container phát hiện lớp, không biến mọi method thành endpoint. `final` bảo đảm field tham chiếu không bị gán lại sau constructor, không làm object được tham chiếu tự trở thành immutable.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
