# Tổng hợp — kiểm tra niềm tin trong request

- TODO: Vẽ hai flow song song session và JWT; đánh dấu trạng thái server/client. Dự đoán khi server restart.
- TODO: Ma trận khách/USER/ADMIN cho GET products, GET me, POST products. Vì sao phải dùng CSRF hợp lệ khi muốn kiểm tra role?
- TODO: Thử login sai/đúng, request trước/sau logout, thiếu CSRF và thiếu quyền. Trước khi chạy ghi status/redirect dự đoán; phân biệt filter failure với controller validation.
- TODO: Liên hệ Java: tự viết hàm predicate kiểm tra một Set authority giả; không dùng nó thay security framework.
- TODO: Liên hệ SQL: thiết kế users/password_hash/user_roles và query orders theo principal. Không lấy role đáng tin từ request JSON.

Lời giải từng lesson ở solution riêng; reference mini-project chỉ mở sau lần tự làm. JWT guided là tùy chọn đọc, không cần tải thêm gì để hoàn thành bài session.
