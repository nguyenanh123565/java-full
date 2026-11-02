# Tham khảo sau khi tự làm — JWT: cấu trúc đọc được chưa phải đáng tin

Sửa payload làm chữ ký không còn khớp; decode vẫn đọc được nên không là phép kiểm tra. exp là giới hạn thời gian, iss là nhà phát hành được tin, aud xác định API nhận token. Server phải kiểm tra trước khi tạo Authentication; client tự kiểm expiry chỉ hỗ trợ UX. Thu hồi JWT đã phát hành đòi hỏi chính sách riêng hoặc lifetime ngắn; dừng session không tự thu hồi JWT.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
