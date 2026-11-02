# Tham khảo sau khi tự làm — Xác minh JWT bằng Resource Server

Framework nên chịu trách nhiệm kiểm chữ ký và exp/nbf/iss; audience API khai báo rõ. Scope mặc định thành authority có tiền tố SCOPE_, không tự thành ROLE_ADMIN. Một token chữ ký đúng nhưng audience khác vẫn bị từ chối. Guided snippet dùng issuer placeholder nên không thể chạy ngay; reference session vẫn hoạt động độc lập và không tải metadata issuer.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
