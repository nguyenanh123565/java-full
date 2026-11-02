# Gợi ý: Lambda và functional interface

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## LAM-01 — Ba vai trò của hành vi

1. **Mức 1:** Function có input/output, Consumer có input, Supplier chỉ output.
2. **Mức 2:** Viết lambda ngắn cho mỗi vai trò rồi gọi riêng.

## LAM-02 — Khai báo không phải thực thi

1. **Mức 1:** Lambda lưu hành vi và chỉ chạy khi apply được gọi.
2. **Mức 2:** logs.add thay object, không gán lại biến logs.

## LAM-03 — Capture biến bị gán lại

1. **Mức 1:** Tạo biến local riêng cho giá trị lúc tạo hành vi.
2. **Mức 2:** int capturedBonus=bonus; lambda dùng capturedBonus; bonus cũ có thể đổi.

## LAM-04 — Chính sách kiểm tra kết hợp

1. **Mức 1:** Kiểm tra null phải chạy trước gọi method String.
2. **Mức 2:** nonNull.and(nonBlank).and(shortEnough).

## LAM-05 — Pipeline xử lý tên có cấu hình

1. **Mức 1:** Generic method tách kiểu đầu vào T và đầu ra R.
2. **Mức 2:** Chỉ transform/consume sau predicate; chooseName gọi fallback.get trong nhánh thiếu.
