# Tham khảo sau khi tự làm — Service giữ quy tắc nghiệp vụ

Service xác định không tìm thấy bằng exception nghiệp vụ; advice chọn 404. Controller chỉ lấy id/body và gọi use case. Khi chuyển memory sang JDBC, service không cần biết cách bind SQL parameters. Với nhiều thao tác database, transaction phải bao cùng nghiệp vụ; đó là bước học tiếp ở JPA/JDBC, chưa có ở bài memory.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
