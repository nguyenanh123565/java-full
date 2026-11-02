# Rubric — User Management

Không có bảng endpoint đáp án. Chấm từng tiêu chí 0/1/2: thiếu/còn mơ hồ/có quy tắc và ví dụ.

1. **Định danh và đọc:** phân biệt collection với resource theo id; pagination, filter và sort rõ; phân biệt không tồn tại với collection rỗng.
2. **Representation:** request/response tách khỏi dữ liệu nội bộ; email/name có kiểu và validation; không lộ password hash/token.
3. **Ghi dữ liệu:** uniqueness email rõ; field server quản lý được bảo vệ; field thiếu/null của update có nghĩa cụ thể.
4. **Quyền:** ma trận guest/customer/admin rõ; token hợp lệ chưa đủ để đọc user khác; kiểm tra chủ sở hữu trước khi trả dữ liệu.
5. **Vòng đời:** user ngừng hoạt động không làm mất order lịch sử; retry và cập nhật đồng thời có quy tắc.
6. **Giao tiếp:** success/error status, headers, JSON nhất quán; hợp đồng đủ để người khác viết client.

Gợi ý: rà soát từng field theo câu hỏi “client có được đọc/sửa field này không?”. Khi user A đổi id trên URL sang B, hãy kiểm tra cả quyền trước query và field trước response. API có thể chọn che giấu tồn tại hoặc trả lỗi quyền; ghi chính sách nhất quán.

Đạt tối thiểu 10/12 và không có lỗi lộ dữ liệu bí mật hoặc bỏ qua quyền sở hữu. Đây là tiêu chí học của workspace, không phải chứng nhận bảo mật.
