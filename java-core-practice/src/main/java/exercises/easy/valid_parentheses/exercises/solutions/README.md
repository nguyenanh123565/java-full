# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## BRACK-01 — Theo dõi dữ liệu từng bước

Stack tăng tới 3 rồi giảm về 0 ở chuỗi đầu. Chuỗi sau sai tại ] vì đỉnh lúc đó là (. Chỉ đếm số lượng không đủ.

## BRACK-02 — Phản ví dụ và sửa lỗi

Kiểm tra isEmpty trước pop; không return true ở giữa vòng lặp. Chỉ kết luận hợp lệ khi đã đọc hết và stack rỗng.

## BRACK-03 — Tự viết biến thể

Dùng ArrayDeque giữ ngoặc mở, cập nhật max khi push; pop đối chiếu loại khi đóng; hết chuỗi kiểm stack rỗng. O(n) thời gian, O(n) stack cho chuỗi có toàn dấu mở. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## BRACK-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) thời gian, O(n) stack cho chuỗi có toàn dấu mở.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
