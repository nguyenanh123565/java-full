# Gợi ý: Class và object

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## OBJ-01

**Mức 1 — khái niệm:** Tách bản mô tả Counter với từng lần new.

**Mức 2 — hướng triển khai:** Mỗi field instance thuộc một object; main tạo dữ liệu và gọi hành vi.

## OBJ-02

**Mức 1 — khái niệm:** Theo dõi c độc lập với a và b.

**Mức 2 — hướng triển khai:** Đếm new ngay cả khi object sau đó không còn được giữ ở caller.

## OBJ-03

**Mức 1 — khái niệm:** Tạo mảng reference khác tạo object cho từng phần tử.

**Mức 2 — hướng triển khai:** Kiểm tra null hoặc khởi tạo từng ô trước khi gọi method.

## OBJ-04

**Mức 1 — khái niệm:** Đánh giá dữ liệu trước khi ghi field.

**Mức 2 — hướng triển khai:** Kết quả boolean báo thành công; read chỉ quan sát.

## OBJ-05

**Mức 1 — khái niệm:** Tách kiểm tra mảng và từng phần tử.

**Mức 2 — hướng triển khai:** Mỗi lượt duyệt là một ô; cùng identity không tự động bị loại trùng.
