# Tham khảo sau khi tự làm — Spring và Spring Boot

Sơ đồ thủ công có `new Repository() → new Service(repository) → new Controller(service)` rồi đăng ký handler với server. Sơ đồ Boot giữ quan hệ phụ thuộc đó nhưng container chọn constructor và tạo bean. GET tới URI chưa đăng ký nhận 404; khởi động server thành công không đồng nghĩa endpoint tồn tại.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
