# Tham khảo sau khi tự làm — Validation dữ liệu đầu vào

Name khoảng trắng bị NotBlank từ chối; price âm bị DecimalMin từ chối; price null bị NotNull từ chối; giá 0 được phép bởi ngưỡng inclusive mặc định. Bean Validation không biết id đã tồn tại hay hàng còn tồn kho; những điều đó thuộc service/repository. Constraint database vẫn cần khi bổ sung storage bền vững.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
