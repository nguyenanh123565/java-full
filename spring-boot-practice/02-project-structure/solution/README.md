# Tham khảo sau khi tự làm — Cấu trúc project Spring Boot

Cây đúng đặt main tại `learn.products`, các lớp phụ trong cùng package hoặc package con. Maven compile theo source roots; Spring quét theo package runtime. Một class có thể compile thành công nhưng không được phát hiện nếu nằm ngoài vùng quét. 404 không đủ chứng minh Java compile sai.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
