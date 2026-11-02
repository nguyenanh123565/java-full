# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## PAIR-01 — Theo dõi dữ liệu từng bước

Các cặp (0,1),(0,2),(1,2), tổng 3 cặp. Cặp chỉ số khác cặp giá trị.

## PAIR-02 — Phản ví dụ và sửa lỗi

Tra trước put và tính phần bù bằng (long)target-a[i]. Sửa thứ tự thôi chưa sửa lỗi overflow.

## PAIR-03 — Tự viết biến thể

Map<Long,Long> lưu số lần giá trị trước đã gặp. Cộng tần suất phần bù vào long answer rồi mới tăng tần suất hiện tại. Một target: O(n) kỳ vọng, O(k) bộ nhớ; q target: O(q*n). Không cần thuật toán nâng cao. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## PAIR-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. Một target: O(n) kỳ vọng, O(k) bộ nhớ; q target: O(q*n). Không cần thuật toán nâng cao.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
