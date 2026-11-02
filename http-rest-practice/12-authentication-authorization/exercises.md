# Bài tập 12 — Authentication / authorization

## 1. Dễ — Chọn phản hồi

Các trường hợp: không gửi token; gửi token hết hạn; token hợp lệ nhưng không có quyền admin.

TODO:
- Chọn status và JSON lỗi cho từng trường hợp.
- Xác định khi nào có WWW-Authenticate và nội dung challenge giả định.
- Giải thích authentication hay authorization đang thất bại.

## 2. Vừa — Orders thuộc về ai?

Một customer đăng nhập có thể gửi userId/orderId tùy ý trong URL. Orders lưu người sở hữu.

TODO:
- Viết quy trình kiểm tra quyền cho danh sách orders của user và order theo id.
- Nêu nguồn danh tính đáng tin và dữ liệu backend phải đối chiếu.
- Chọn chính sách trả lỗi nếu resource thuộc người khác.
- Giải thích vì sao role customer hoặc URL đúng định dạng chưa đủ.

## 3. Khó — Ma trận quyền

Customer xem đơn của mình, hủy đơn pending của mình. Admin quản lý products và xem orders toàn hệ thống. Đơn shipped không được hủy trong bài này.

TODO:
- Viết bảng role × thao tác × ownership × điều kiện trạng thái.
- Thiết kế response khi thất bại từng lớp kiểm tra.
- Liệt kê dữ liệu nhạy cảm không trả về.
- Giải thích một trường hợp có quyền nhưng vẫn thất bại vì nghiệp vụ.
