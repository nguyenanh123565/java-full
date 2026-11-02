# Rubric — Order Management

Chỉ có tiêu chí và gợi ý; tự hoàn thành endpoint, JSON và bảng chuyển trạng thái. Chấm mỗi mục 0/1/2: thiếu/còn mơ hồ/có quy tắc và ví dụ.

1. **Đọc và quyền:** id/collection rõ; pagination/filter; customer chỉ xem order được phép; thiếu xác thực, thiếu quyền, not-found được phân biệt.
2. **Dữ liệu tin cậy:** backend quyết định giá, total và chủ sở hữu; quantity và products được kiểm tra; đơn giá tại thời điểm mua giữ riêng.
3. **Transaction:** order, items và stock thành công cùng nhau hoặc rollback; lỗi giữa chừng không để order một phần.
4. **Trạng thái:** có bảng chuyển trạng thái và người được yêu cầu; hủy PENDING khác hoàn tiền PAID và không cho hủy SHIPPED tùy ý.
5. **Retry/đồng thời:** timeout không được mặc định là request thất bại; cùng yêu cầu không tạo order/hoàn stock nhiều lần; có cách báo xung đột.
6. **Contract:** status, headers, request/response JSON và error rõ; client biết khi nào retry và khi nào sửa dữ liệu.

Gợi ý: hủy có thể được mô hình hóa bằng cập nhật status hoặc một resource cancellation có id/vòng đời riêng; chọn theo nhu cầu audit/refund/trạng thái, không theo khẩu hiệu URL. Thao tác database chống lặp cần được thực thi nguyên tử; header chống lặp chỉ hữu ích khi backend thực hiện hợp đồng của nó.

Đạt tối thiểu 10/12 và không tin total/userId client tùy ý gửi, không bỏ quyền sở hữu, không hoàn stock hai lần. Liên hệ bài transaction của workspace SQL trước khi hiện thực Java/JDBC sau này.
