# Tham khảo sau khi tự làm — DTO định hình dữ liệu qua biên HTTP

Request có name/price; response có thêm id; model có thể thay đổi độc lập. Client gửi id lạ trong JSON không được dùng để ghi đè id vì method create lấy id từ repository. BigDecimal giữ biểu diễn thập phân phù hợp bài tiền; đây không giải quyết tự động currency/rounding của hệ thống thực tế.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
