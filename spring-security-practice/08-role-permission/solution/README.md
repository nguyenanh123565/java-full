# Tham khảo sau khi tự làm — Role và permission có chủ đích

Reference admin khai USER,ADMIN rõ ràng; không dựa vào kế thừa role ẩn. `hasAuthority("product:write")` chỉ pass nếu principal có chính xác quyền đó; ROLE_ADMIN đơn lẻ không tự suy ra product:write. Dùng ít role ở bài đầu; bổ sung permission khi có nhu cầu thật và vẫn kiểm ownership cho dữ liệu riêng.

## Cách đánh giá lời giải của bạn

Đối chiếu kết quả với mental model của lesson, không chỉ so tên class. Với HTTP, kiểm tra cả method, URI, status và body; với logic Java, kiểm tra trạng thái trước/sau. Một cách đặt tên khác vẫn đúng nếu trách nhiệm và kết quả được giải thích rõ.

Nếu kết quả khác dự đoán, tìm lớp đầu tiên làm thay đổi luồng: chuyển đổi dữ liệu, validation, security hay service. Ghi nguyên nhân và một trường hợp chứng minh vào notes.
