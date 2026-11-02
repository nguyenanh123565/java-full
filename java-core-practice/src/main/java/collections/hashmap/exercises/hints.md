# Gợi ý: HashMap

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## HM-01 — Gộp số lượng đặt hàng

1. **Mức 1:** Lấy số cũ hoặc 0.
2. **Mức 2:** put(code,getOrDefault(code,0)+1).

## HM-02 — Null cản giá trị mặc định

1. **Mức 1:** getOrDefault chỉ dùng default khi không có mapping.
2. **Mức 2:** A vẫn có mapping; containsKey(A) là true.

## HM-03 — Xuất kho thành số âm

1. **Mức 1:** Đọc tồn trước khi ghi.
2. **Mức 2:** Kiểm tra amount, containsKey và available>=amount rồi mới put.

## HM-04 — Danh bạ có mã duy nhất

1. **Mức 1:** put luôn thay value của key bằng nhau.
2. **Mức 2:** Kiểm tra tồn tại trước mutation; thiết kế Map private.

## HM-05 — Thống kê phiếu theo lớp

1. **Mức 1:** Khi gặp lớp mới cần tạo một list mới.
2. **Mức 2:** Lấy list của key, nếu null thì tạo và put; rồi add tên.
