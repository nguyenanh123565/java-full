# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## MAX-01 — Theo dõi dữ liệu từng bước

`best=-4`, `count=2`: hai lần bằng ứng viên đầu, -9 không đổi trạng thái.

## MAX-02 — Phản ví dụ và sửa lỗi

Khởi tạo từ phần tử đầu sau khi kiểm mảng không rỗng; 0 không luôn thuộc dữ liệu. Không cần cộng/trừ để so sánh.

## MAX-03 — Tự viết biến thể

Giữ best và count. Gặp giá trị lớn hơn thì thay best/reset count=1; gặp bằng thì tăng count. O(n) thời gian, O(1) phụ cho một ngày; tổng O(tổng số phần tử) cho báo cáo. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## MAX-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) thời gian, O(1) phụ cho một ngày; tổng O(tổng số phần tử) cho báo cáo.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
