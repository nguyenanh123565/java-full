# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## EASY-01 — Viết hợp đồng trước code

Đối chiếu bảng với hợp đồng bài 04: ca bình thường, rỗng, trùng và giá trị biên; không ép một cấu trúc nếu cách khác giữ được hành vi.

## EASY-02 — Bất biến của báo cáo một lượt

Ba trạng thái (lo,hi,sum) là (-2,-2,-2), (-2,4,2), (-2,4,6). Cực trị có thể giữ nguyên khi gặp 4 lần hai nhưng tổng vẫn tăng 4. Bất biến áp dụng cho đúng đoạn tiền tố đã duyệt; không khởi tạo cực trị bằng 0.

## EASY-03 — Báo cáo bị tràn số

Đổi biến total thành long trước phép cộng; `(long)total` sau khi đã tràn không phục hồi dữ liệu. Với tổng int[] trong bộ nhớ, long đủ miền cho số phần tử int.

## EASY-04 — Tổng kết nhóm: Thống kê mảng không sửa nguồn

ReferenceSolution là một phương án triển khai bài 04. Duyệt dữ liệu theo thứ tự nguồn, dùng long cho tổng; không cập nhật đầu vào nên có thể kiểm source sau chạy. Lỗi thường gặp: dùng thứ tự HashMap như hợp đồng hoặc in dữ liệu trước hoàn tất tính toán.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
