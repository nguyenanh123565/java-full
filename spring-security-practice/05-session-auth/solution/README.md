# Tham khảo sau khi tự làm — Session authentication trước JWT

Trước login, form entry point chuyển hướng tới /login; sau login /me có username; sau logout session không còn xác thực. POST không có CSRF bị 403 ngay cả khi cookie hợp lệ. Token CSRF được đổi/clear khi xác thực hoặc logout nên fetch lại sau login. Session id phải được bảo vệ bằng HTTPS/Secure cookie khi triển khai; localhost HTTP chỉ là demo.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
