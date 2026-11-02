# Tham khảo sau khi tự làm — Dịch exception thành HTTP response

Find/update/delete id không tồn tại ném ProductNotFound, handler trả 404 có body thông báo. Validation error trả 400 và field errors. Không có blanket catch Exception nên lỗi lập trình vẫn là server error; log giúp chẩn đoán. Khi học Security, lỗi trước DispatcherServlet cần cơ chế entry point/access denied handler, không dựa vào MVC advice.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
