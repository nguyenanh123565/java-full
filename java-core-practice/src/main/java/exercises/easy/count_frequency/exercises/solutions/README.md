# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## FREQ-01 — Theo dõi dữ liệu từng bước

Các entry theo thứ tự gặp đầu: 4=2, 2=1, 9=1. put không đổi vị trí key 4 đã tồn tại.

## FREQ-02 — Phản ví dụ và sửa lỗi

Đọc số cũ bằng getOrDefault(x,0), tăng rồi put; key mới và cũ đều được xử lý.

## FREQ-03 — Tự viết biến thể

Đếm bằng Map rồi duyệt nguồn để lọc count=1. Tổng dùng long ngay từ đầu. O(n) kỳ vọng với hashing tốt; O(k) bộ nhớ đếm và O(n) chỗ cho kết quả. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## FREQ-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) kỳ vọng với hashing tốt; O(k) bộ nhớ đếm và O(n) chỗ cho kết quả.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
