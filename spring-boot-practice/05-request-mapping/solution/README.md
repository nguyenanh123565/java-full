# Tham khảo sau khi tự làm — Ánh xạ method và URI

Bảng phù hợp: GET collection đọc, GET item đọc một, POST collection tạo, PUT item thay dữ liệu có thể sửa, DELETE item xóa. Mini-project chọn PUT chỉ cập nhật item tồn tại, thiếu thì 404. Mapping thành công nhưng method HTTP không được hỗ trợ thường dẫn đến 405; resource nghiệp vụ không tồn tại là 404 từ service/advice.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
