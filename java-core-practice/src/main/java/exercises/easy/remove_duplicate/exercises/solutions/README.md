# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## DUP-01 — Theo dõi dữ liệu từng bước

a=true,b=true,c=false; s có thứ tự [8,3]. Lần add trùng không chèn vị trí mới.

## DUP-02 — Phản ví dụ và sửa lỗi

HashSet không bảo đảm thứ tự. Dùng LinkedHashSet hoặc duyệt nguồn và set kiểm đã gặp. Không lấy một output tình cờ làm hợp đồng.

## DUP-03 — Tự viết biến thể

Đếm vào LinkedHashMap theo lượt đầu rồi duyệt entry có count>=2. Với report, Set cho distinct và repeated().length cho Y. O(n) kỳ vọng, O(k) bộ nhớ với k số mã khác nhau. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## DUP-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) kỳ vọng, O(k) bộ nhớ với k số mã khác nhau.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
