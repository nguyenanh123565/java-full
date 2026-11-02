# Gợi ý: Try / catch / finally

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## TC-01 — Đếm bản ghi đọc được

1. **Mức 1:** Đặt try/catch quanh một parse.
2. **Mức 2:** Bắt NumberFormatException và tăng đúng một trong hai bộ đếm.

## TC-02 — Luồng thoát khỏi try

1. **Mức 1:** Exception chuyển thẳng tới catch phù hợp.
2. **Mức 2:** A luôn trước parse; B chỉ khi parse thành công; F trong finally.

## TC-03 — Finally che kết quả

1. **Mức 1:** finally chạy khi chuẩn bị rời try/catch.
2. **Mức 2:** Bỏ return ở finally; log không cần thay kết quả.

## TC-04 — Resource có đóng khi lỗi?

1. **Mức 1:** Giữ reference Probe ngoài block để quan sát closed.
2. **Mức 2:** Catch bên ngoài try-with-resources rồi kiểm tra trạng thái.

## TC-05 — Báo cáo tổng và dữ liệu lỗi

1. **Mức 1:** Bộ đếm và tổng cập nhật sau parse thành công.
2. **Mức 2:** Parse vào int trước, cộng dồn vào long.
