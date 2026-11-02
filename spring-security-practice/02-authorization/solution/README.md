# Tham khảo sau khi tự làm — Authorization: bạn được làm gì?

Public read không yêu cầu user. USER có thể đọc /me nhưng POST /products bị 403 nếu CSRF token hợp lệ và đã đăng nhập. ADMIN được ghi. Để kiểm tra ownership, lấy id từ principal rồi so với chủ sở hữu trong service/repository, không lấy role hoặc owner đáng tin từ body. CSRF có thể từ chối sớm nên phải tách nguyên nhân khi thử quyền.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
