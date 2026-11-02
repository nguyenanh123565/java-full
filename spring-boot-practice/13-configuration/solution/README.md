# Tham khảo sau khi tự làm — Cấu hình và môi trường

PORT=8081 thay endpoint thành `http://localhost:8081/products`, path vẫn `/products`. Bean method cung cấp một dependency cho container, khác việc tạo object cục bộ rồi không ai giữ tham chiếu. Đối với bí mật, cấu hình environment tránh commit nhưng vẫn phải giới hạn log; không in toàn bộ environment để debug.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
