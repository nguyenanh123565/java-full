# Tham khảo sau khi tự làm — Path, query và JSON body

Path định danh resource, query thay đổi cách đọc collection, body mang biểu diễn dữ liệu tạo/sửa. `/products/abc` không đổi được thành long sẽ bị từ chối trước khi gọi find. Chuỗi JSON hợp lệ có name rỗng vẫn cần validation. Thiếu Content-Type hoặc media type không được hỗ trợ có thể là 415, không phải lỗi SQL.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
