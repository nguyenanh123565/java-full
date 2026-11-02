# Gợi ý: Comparable và Comparator

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## CMP-01 — Thứ tự phiên bản hai số

1. **Mức 1:** So thành phần thứ nhất, chỉ dùng thành phần hai khi hòa.
2. **Mức 2:** Integer.compare cho major rồi minor.

## CMP-02 — Compare bằng không có xóa object?

1. **Mức 1:** Sort thay vị trí, không phải loại trùng.
2. **Mức 2:** List.sort ổn định nên A/B giữ thứ tự cũ khi comparator trả0.

## CMP-03 — Phép trừ phá comparator

1. **Mức 1:** MIN_VALUE-1 không còn nằm trong int.
2. **Mức 2:** Compare sẵn có không phụ thuộc hiệu số bị tràn.

## CMP-04 — Lịch công việc theo chính sách

1. **Mức 1:** Mỗi Comparator biểu diễn một lựa chọn của người dùng.
2. **Mức 2:** Tính c=Integer.compare(duration...); khi c=0 so id.

## CMP-05 — Bảng xếp hạng có thứ tự ổn định

1. **Mức 1:** Validate id bằng Set trước sort.
2. **Mức 2:** Comparator giảm score dùng Integer.compare(right.score,left.score), hòa so id tăng.
