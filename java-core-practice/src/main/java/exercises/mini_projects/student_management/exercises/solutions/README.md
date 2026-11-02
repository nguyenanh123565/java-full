# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## STU-01 — Quy tắc đạt và điểm hợp lệ

Quy ước score>=5 là đạt, 0<=score<=10 và hữu hạn. 4.9 không đạt, 5 đạt, 10 đạt; NaN/infinity bị từ chối. Không dùng làm tròn để xét đạt.

## STU-02 — Map sao chép và điểm chung

Map copy chứa cùng Student nên cập nhật điểm object ảnh hưởng cả hai Map. Xóa entry khỏi copy không xóa entry map gốc. Muốn snapshot phải copy dữ liệu hoặc dùng giá trị bất biến.

## STU-03 — Điểm NaN vượt qua validation

`score<0 || score>10` không bắt được NaN vì mọi so sánh với NaN đều false. Thêm `!Double.isFinite(score)` trước mutation; đừng gán điểm rồi mới kiểm.

## STU-04 — Cập nhật điểm toàn bộ hoặc không đổi

Service kiểm độ dài, ID tồn tại, ID cập nhật không trùng và tất cả điểm hợp lệ trước vòng commit. O(m) kỳ vọng cho m yêu cầu; lỗi ở phần tử cuối cũng không đổi người đầu.

## STU-05 — Bảng xếp hạng độc lập

Snapshot chứa id/name/score bất biến, sort score giảm rồi id tăng bằng Comparator class và Double.compare/String.compareTo, không cần lambda. Chuẩn hóa -0.0 về 0.0 vì hai điểm này ngang nhau theo hợp đồng. Sau khi sửa service, snapshot cũ giữ nguyên. Không trả object mutable nội bộ.

## STU-06 — Lệnh lỗi không làm dừng buổi học

Dùng split(";",-1), kiểm số trường, parseDouble và bắt IllegalArgumentException ở biên console. SCORE sai trả ERR, lần LIST sau vẫn chạy; EXIT trả BYE. Không bắt lỗi rồi trả OK.

## STU-07 — Báo cáo lớp và thay đổi có kiểm soát

Tham khảo bên dưới kết hợp bulk update, snapshot, báo cáo số đạt và trung bình (EMPTY khi chưa có ai), các lệnh console nhỏ. Validation là trách nhiệm model/service; console chỉ chuyển đổi dữ liệu và trình bày. Thiết kế khác đạt cùng hành vi được chấp nhận.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
