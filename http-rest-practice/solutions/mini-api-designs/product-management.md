# Rubric — Product Management

Không có ma trận tám thao tác mẫu. Chấm mỗi mục 0/1/2: thiếu/còn mơ hồ/có hợp đồng và giải thích.

1. **Đọc:** list, id, search, category/price filter có semantics; price có kiểu và currency; empty/not-found khác nhau.
2. **Dữ liệu lớn:** limit tối đa, sort ổn định với tie-breaker, query sai và min > max có cách xử lý.
3. **Tạo:** field bắt buộc rõ; id/role không do client tùy ý cấp; category/price/stock validation; response chỉ tài nguyên mới.
4. **Cập nhật:** thay toàn bộ và sửa một phần phân biệt rõ; field thiếu/null/lạ và stock đặt/cộng thêm được công bố.
5. **Quyền và retry:** admin mới được ghi; retry, timeout và cập nhật đồng thời có quy tắc.
6. **Lịch sử:** xóa/ngừng bán không phá thông tin order cũ; lần thao tác lặp có trạng thái cuối nhất quán.

Gợi ý: đưa cùng một update vào thiết kế hai lần rồi mô tả trạng thái cuối. Kiểm tra xem đơn giá order có bị đổi theo giá product hiện tại không. Sort ổn định giúp phá hòa nhưng không tự tạo snapshot khi dữ liệu thay đổi giữa các trang.

Đạt tối thiểu 10/12 và không có thao tác GET ghi dữ liệu, stock âm không kiểm tra hoặc lộ quyền ghi cho mọi user.
