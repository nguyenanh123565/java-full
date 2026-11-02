# Tham khảo sau khi tự làm — BCrypt và kiểm tra mật khẩu

Hai hash thường khác do salt ngẫu nhiên; matches(input đúng, first) trả true, input sai false. Salt được lưu trong biểu diễn hash để hàm verify tái tạo phép kiểm tra. Không cần “decrypt”. Work factor phải đo trên phần cứng thực; giới hạn đầu vào BCrypt khoảng 72 byte cần được cân nhắc trong chính sách password, không tự cắt password. Reference lấy mật khẩu demo qua environment và hash trong bộ nhớ khi startup.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
