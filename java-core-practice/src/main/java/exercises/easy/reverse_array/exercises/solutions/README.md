# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## REV-01 — Theo dõi dữ liệu từng bước

a và b cùng là [7,5,3], vì hai reference trỏ một mảng. Biến t giữ 3 trước khi ghi đè.

## REV-02 — Phản ví dụ và sửa lỗi

Lưu một phía vào biến tạm trước ghi; dùng [from,to) thống nhất, right=to-1. Validate trước mutation.

## REV-03 — Tự viết biến thể

Đổi chỗ hai đầu đoạn đến khi gặp nhau. Để xoay trái: đảo [0,k), đảo [k,n), đảo cả mảng. O(n) thời gian và O(1) bộ nhớ phụ. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## REV-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) thời gian và O(1) bộ nhớ phụ.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
