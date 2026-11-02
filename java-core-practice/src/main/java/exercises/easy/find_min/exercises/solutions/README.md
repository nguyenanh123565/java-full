# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## MIN-01 — Theo dõi dữ liệu từng bước

`p` lần lượt 0,1,1,1; trả vị trí đầu của giá trị 2.

## MIN-02 — Phản ví dụ và sửa lỗi

Dùng < để giữ vị trí sớm nhất; xử lý rỗng trước việc đọc a[0]. Không lấy hiệu để so sánh.

## MIN-03 — Tự viết biến thể

Duyệt giữ index tốt nhất; chỉ thay index khi nhỏ hơn nghiêm ngặt. Tách lựa chọn index khỏi tra tên. O(n) thời gian, O(1) phụ. Lỗi thường gặp: bỏ qua quy tắc thứ tự hoặc sửa input trái hợp đồng.

## MIN-04 — Báo cáo từ dữ liệu thực hành

Áp dụng hàm bài 03 cho từng dữ liệu trong ví dụ; kết quả phải đúng như đề. Phần main tham khảo có kiểm tra trực tiếp; không giấu nghiệp vụ trong thao tác in. O(n) thời gian, O(1) phụ.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
