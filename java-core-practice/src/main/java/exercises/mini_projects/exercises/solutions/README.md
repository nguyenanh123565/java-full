# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## PROJECTS-01 — Viết hợp đồng trước code

Đối chiếu bảng với hợp đồng bài 04: ca bình thường, rỗng, trùng và giá trị biên; không ép một cấu trúc nếu cách khác giữ được hành vi.

## PROJECTS-02 — Suy luận thất bại ở cuối lô

Vòng xen kẽ đã đổi S1 thành 9 rồi mới từ chối S2, để trạng thái 9,7. Hai pha validation/commit giữ 6,7 nếu bất kỳ yêu cầu sai. Với giỏ hàng phải tính cả tổng tiền và lượng gộp trước commit; với bank phải kiểm phía nhận trước trừ phía gửi.

## PROJECTS-03 — Giao diện báo thành công sau lỗi

Đưa phản hồi OK vào cuối nhánh try, chỉ sau service.apply thành công; catch trả/in ERR duy nhất rồi tiếp tục vòng lệnh. EXIT/EOF có nhánh dừng riêng. Đừng chỉ xóa ERR hoặc nuốt lỗi để giữ output đẹp.

## PROJECTS-04 — Tổng kết nhóm: chọn một hệ thống và đối soát

ReferenceSolution là một phương án triển khai bài 04. Duyệt dữ liệu theo thứ tự nguồn, dùng long cho tổng; không cập nhật đầu vào nên có thể kiểm source sau chạy. Lỗi thường gặp: dùng thứ tự HashMap như hợp đồng hoặc in dữ liệu trước hoàn tất tính toán.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.

Lời giải nghiệp vụ có kiểm trạng thái/snapshot: [sổ điểm](../../student_management/exercises/solutions/README.md), [kho hàng](../../product_management/exercises/solutions/README.md), [ngân hàng](../../banking_simulation/exercises/solutions/README.md). ReferenceSolution tại đây chỉ tính báo cáo mã; chọn một lời giải nghiệp vụ tương ứng để đối chiếu toàn bộ bài tổng kết.
