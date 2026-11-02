# Gợi ý: Throw, throws và lan truyền

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## TH-01 — Parser mã số có ngữ cảnh

1. **Mức 1:** Chỉ bao parseInt trong catch NumberFormatException.
2. **Mức 2:** Sau parse thành công mới kiểm tra âm; initCause khi tạo ParseException.

## TH-02 — Throws không tự chạy catch

1. **Mức 1:** Khai báo không phải câu lệnh thực thi.
2. **Mức 2:** Exception lan tới catch phù hợp đầu tiên.

## TH-03 — Bắt rồi trả id giả

1. **Mức 1:** 0 đã có ý nghĩa hợp lệ.
2. **Mức 2:** Bỏ catch không có chính sách xử lý và thêm throws ParseException.

## TH-04 — Đọc một cặp tọa độ

1. **Mức 1:** Kiểm tra số thành phần trước truy cập.
2. **Mức 2:** Dùng split giữ phần rỗng, parse từng thành phần trong try.

## TH-05 — Dừng cả lô hay tiếp từng dòng?

1. **Mức 1:** Catch tại tầng biết chỉ số dòng để thêm ngữ cảnh.
2. **Mức 2:** Tạo ParseException("Dòng "+(i+1),i), initCause(e), throw.
