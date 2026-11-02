# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## BIN-01 — Theo dõi dữ liệu từng bước

mid=1 tình cờ là lần đầu, nhưng không chứng minh quy tắc. `[2,2,2,8]` có cùng mid=1 trong khi đáp án đầu là 0.

## BIN-02 — Phản ví dụ và sửa lỗi

Khoảng đóng phải giảm nghiêm ngặt: left=mid+1 hoặc right=mid-1. Khi tìm lần đầu, lưu đáp án và tiếp tục sang trái.

## BIN-03 — Tự viết biến thể

Giữ answer=-1; khi a[mid]>=target thu hẹp phải về mid-1, đồng thời lưu mid nếu bằng. Khi nhỏ hơn tăng left. O(log n) cho một tìm kiếm, O(q log n) cho q truy vấn; O(1) phụ mỗi lần. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## BIN-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(log n) cho một tìm kiếm, O(q log n) cho q truy vấn; O(1) phụ mỗi lần.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
