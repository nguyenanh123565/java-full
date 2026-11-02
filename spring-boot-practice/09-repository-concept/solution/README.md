# Tham khảo sau khi tự làm — Repository là ranh giới lưu trữ

Memory implementation mất dữ liệu khi process dừng. ConcurrentHashMap an toàn cho từng thao tác riêng nhưng một chuỗi check-then-write vẫn cần suy nghĩ về race; reference dùng computeIfPresent cho update. Interface không hứa transaction database. Optional biểu diễn không có item mà không bắt controller đọc null.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
