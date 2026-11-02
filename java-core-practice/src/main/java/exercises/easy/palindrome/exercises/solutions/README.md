# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## PAL-01 — Theo dõi dữ liệu từng bước

So A/A, b/b, bỏ dấu cách giữa; kết quả true. Không được đổi A thành a theo hợp đồng mới.

## PAL-02 — Phản ví dụ và sửa lỗi

Hai đầu bằng nhau chưa chứng minh phần giữa. Duyệt mọi cặp bằng hai con trỏ, bỏ space trước so sánh và kiểm điều kiện còn cặp.

## PAL-03 — Tự viết biến thể

Hai con trỏ bỏ space ở mỗi phía rồi so sánh khi left<right. Không dùng trim đơn thuần vì còn space ở giữa. O(n) thời gian, O(1) phụ một chuỗi; báo cáo O(tổng độ dài). Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## PAL-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) thời gian, O(1) phụ một chuỗi; báo cáo O(tổng độ dài).

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
