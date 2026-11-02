# Tham khảo sau khi tự làm — Authentication: bạn là ai?

Server chỉ dùng principal được framework thiết lập sau xác thực. Một người đăng nhập USER vẫn không được ghi dữ liệu chỉ dành ADMIN. Trong reference form login, khách chưa đăng nhập gặp redirect tới /login thay vì luôn nhận 401 JSON; authenticated thiếu role nhận 403. Cách biểu diễn HTTP tùy entry point được chọn.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
