# Tham khảo: Phương thức

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## MET-01 — Giới hạn giá trị vào khoảng

if(value<min)return min; if(value>max)return max; return value. Không tính chênh lệch nên không có overflow phép trừ.

**Lỗi thường gặp:** Đảo min và max trong lời gọi hoặc thiếu return cho giá trị nằm trong khoảng.

## MET-02 — Đối số được tính trước lời gọi

result=6,n=4; với n=-1: result=-2,n=0. Gán left=100 trong add không sửa n của caller.

**Lỗi thường gặp:** Cho rằng đối số thứ nhất cũng trở thành 4 khi đối số thứ hai tăng n.

## MET-03 — Return còn thiếu

Đường không âm phải trả value. MIN_VALUE không thể đổi dấu thành số dương int; miền đề tránh vấn đề này.

**Lỗi thường gặp:** Thêm return 0 cho mọi số không âm khiến input 7 sai.

## MET-04 — Đếm bội số trong đoạn

Vòng for tự bỏ qua khi from>to; zero có phần dư 0. Dùng biến cục bộ riêng để các lần gọi không ảnh hưởng nhau.

**Lỗi thường gặp:** Dùng i%divisor>0 làm điều kiện không chia hết, sai ở số âm.

## MET-05 — Báo giá qua các hàm nhỏ

subtotal tạo tiền gốc; discounted chỉ tính tiền còn lại; invoice cộng kết quả hai dòng. Tách hàm giúp kiểm tra độc lập.

**Lỗi thường gặp:** Gọi discounted rồi bỏ kết quả và cộng tiền gốc.
