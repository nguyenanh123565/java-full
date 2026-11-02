# Tham khảo: Toán tử

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## OPR-01 — Chia kiện hàng

full=items/capacity; remainder=items%capacity. Với dữ liệu không âm, remainder luôn nhỏ hơn capacity.

**Lỗi thường gặp:** Dùng chia double rồi thu hẹp để thay thế phép chia nguyên một cách khó đọc.

## OPR-02 — Vế phải có được chạy?

Bản gốc: false,true,true,1. Đổi && đầu thành &: false,true,false,2. Khi khởi đầu 1 ở bản gốc: false,true,false,2.

**Lỗi thường gặp:** Chỉ nhìn kết quả false của a rồi cho rằng attempts chắc chắn không đổi với cả &.

## OPR-03 — Khoảng hợp lệ bị mở rộng

age>=18 && age<=60. Dùng || khiến mọi int đều thỏa ít nhất một vế.

**Lỗi thường gặp:** Sửa một dấu bằng nhưng vẫn giữ ||.

## OPR-04 — Đọc ba chữ số

Phép chia nguyên bỏ phần lẻ, %10 giữ chữ số cuối. Tổng là ba chữ số cộng lại.

**Lỗi thường gặp:** Dùng code%100 làm chữ số hàng chục dù kết quả có thể hai chữ số.

## OPR-05 — Hóa đơn và cờ miễn phí giao

Tính long subtotal=1L*unitPrice*quantity. Nhân phần trăm bằng long rồi chia nguyên 100; điều kiện đúng như yêu cầu.

**Lỗi thường gặp:** Đặt điều kiện member bên ngoài ngoặc rồi vô tình yêu cầu thành viên cho cả hóa đơn >=300000.
