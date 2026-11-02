# Tham khảo sau khi tự làm — SecurityFilterChain trước controller

Rule permitAll chỉ bỏ yêu cầu authorization cho route đó; unsafe method vẫn đi qua CSRF. Trong session app, thiếu token có thể tạo 403 trước khi kiểm tra role. Dùng request có CSRF hợp lệ để tách bài kiểm tra authorization. Filter failure trước MVC không thuộc advice dành controller; có entry point/access denied handler của Security.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
