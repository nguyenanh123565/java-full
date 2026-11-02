# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## CHAR-01 — Theo dõi dữ liệu từng bước

b=2, a=2, space=1 theo thứ tự b,a,space. Tổng value=5 bằng length trong phạm vi ASCII.

## CHAR-02 — Phản ví dụ và sửa lỗi

Bỏ điều kiện lọc space. Hợp đồng này tính khoảng trắng và phân biệt hoa/thường; không tự chuẩn hóa.

## CHAR-03 — Tự viết biến thể

Đếm bằng LinkedHashMap, duyệt entry thứ tự đầu, chỉ thay best khi count lớn hơn nghiêm ngặt. O(n) kỳ vọng, O(k) phụ, k<=128 trong phạm vi ASCII. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## CHAR-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) kỳ vọng, O(k) phụ, k<=128 trong phạm vi ASCII.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
