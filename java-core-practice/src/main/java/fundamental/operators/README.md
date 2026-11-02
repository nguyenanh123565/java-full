# Operators — Toán tử

## Dùng để làm gì?

Toán tử dùng để tính toán, so sánh, gán và kết hợp điều kiện. Hiểu thứ tự đánh giá giúp đọc đúng biểu thức và tránh tác dụng phụ khó thấy.

## Những ý bắt buộc phải hiểu

- `+`, `-`, `*`, `/`, `%` thực hiện phép toán; `%` lấy phần dư.
- `=`, `==`, `!=`, `<`, `>=` có vai trò khác nhau. `=` gán; `==` so sánh primitive hoặc danh tính object.
- `&&` và `||` có short-circuit. `&` và `|` dùng được với boolean nhưng luôn tính cả hai vế; với số nguyên chúng là toán tử bit.
- `x++` dùng giá trị cũ rồi tăng; `++x` tăng rồi dùng giá trị mới.
- Độ ưu tiên quyết định cách nhóm biểu thức; Java đánh giá toán hạng từ trái sang phải. Nên dùng ngoặc và tránh nhiều phép tăng trong cùng biểu thức.

## Lỗi người mới thường gặp

- Dùng `20 / 100` trong công thức phần trăm rồi nhận `0`.
- Đổi `&&` thành `&` trong kiểm tra `null`, hoặc đặt phép truy cập object trước kiểm tra `null`.
- Nhầm giá trị biểu thức `x++` với giá trị cuối của biến `x`.
- Dựa vào độ ưu tiên khi biểu thức đã khó đọc thay vì thêm ngoặc.

## Tự kiểm tra

1. `2 + 3 * 4` khác `(2 + 3) * 4` thế nào?
2. Khi nào vế phải của `&&` được đánh giá?
3. `&` với boolean có thể gây lỗi gì trong kiểm tra `null`?
4. Sau `int y = x++;`, quan hệ giữa `y` và giá trị mới của `x` là gì?

## Ba bài tập từ dễ đến khó

1. **Dễ — Giảm giá:** với giá gốc `100.0` và tỷ lệ `20`, in `80.0`. Tỷ lệ trong khoảng `0..100`; giải thích vì sao cần phép chia thập phân trong công thức.
2. **Vừa — Short-circuit:** kiểm tra chuỗi khác `null` và không rỗng với đầu vào `null`, `""`, `"Java"`; in `false`, `false`, `true`. Giải thích vì sao kiểm tra `null` phải đứng trước và vì sao không đổi `&&` thành `&`.
3. **Khó — Tác dụng phụ:** dự đoán rồi chạy `int a = 5; int b = a++ + ++a;`; kết quả cuối là `a=7, b=12`. Viết lại bằng các câu lệnh cập nhật riêng mà giữ nguyên kết quả; giải thích giá trị từng toán hạng. Biểu thức này phục vụ học thứ tự đánh giá, không phải phong cách code nên dùng hàng ngày.

## Cách học

Đoán output trong `OperatorDemo.java`, tự làm `OperatorExercise.java`, rồi mới đối chiếu `OperatorSolution.java`.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
