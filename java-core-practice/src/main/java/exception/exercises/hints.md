# Gợi ý: Tổng kết exception

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## EX-01 — Phân loại và chọn nơi xử lý

1. **Mức 1:** Checked loại trừ RuntimeException và con.
2. **Mức 2:** ParseException/custom extends Exception cần catch hoặc throws.

## EX-02 — Một catch cho cả batch

1. **Mức 1:** Exception thoát khỏi try hiện tại.
2. **Mức 2:** Catch ngoài loop không quay lại lượt sau.

## EX-03 — Mất nguyên nhân và báo thành công giả

1. **Mức 1:** Một số hợp lệ không nên làm tín hiệu lỗi.
2. **Mức 2:** initCause(e) và propagate tới nơi có chính sách phản hồi.

## EX-04 — Đổi hồ sơ nguyên vẹn

1. **Mức 1:** Dùng biến local chứa giá trị mới.
2. **Mức 2:** Parse + validate vào local xong mới gán cả hai field.

## EX-05 — Nhập kho theo dòng có báo lỗi

1. **Mức 1:** So số yêu cầu với capacity-stored.
2. **Mức 2:** Parse thành local, validate dương, kiểm tra chỗ, cuối cùng mới cộng.
