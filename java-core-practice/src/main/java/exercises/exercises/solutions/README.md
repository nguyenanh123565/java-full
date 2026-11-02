# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## PRACT-01 — Viết hợp đồng trước code

Đối chiếu bảng với hợp đồng bài 04: ca bình thường, rỗng, trùng và giá trị biên; không ép một cấu trúc nếu cách khác giữ được hành vi.

## PRACT-02 — Hai báo cáo liên tiếp

Sau lần đầu counts={3=2,1=1}; sau lần hai {3=2,1=2}, trong khi hợp đồng cần riêng {1=1}. Nếu trả cùng Map, biến giữ kết quả cũ cũng nhìn thấy lần cập nhật sau. Đặt bộ đếm local ở mỗi lần gọi, trả báo cáo từ dữ liệu riêng.

## PRACT-03 — Báo cáo bị tràn số

Đổi biến total thành long trước phép cộng; `(long)total` sau khi đã tràn không phục hồi dữ liệu. Với tổng int[] trong bộ nhớ, long đủ miền cho số phần tử int.

## PRACT-04 — Tổng kết nhóm: Tần suất và tổng lần nhập

ReferenceSolution là một phương án triển khai bài 04. Duyệt dữ liệu theo thứ tự nguồn, dùng long cho tổng; không cập nhật đầu vào nên có thể kiểm source sau chạy. Lỗi thường gặp: dùng thứ tự HashMap như hợp đồng hoặc in dữ liệu trước hoàn tất tính toán.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
