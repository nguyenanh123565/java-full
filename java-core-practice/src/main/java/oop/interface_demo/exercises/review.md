# Tự đánh giá: Hợp đồng bằng interface

Chọn một trạng thái cho mỗi bài: **Chưa làm / Đang làm / Đã chạy đúng / Đã giải thích được**. Chỉ đánh dấu mức cuối khi bạn giải thích được cơ chế và ít nhất một lỗi thường gặp bằng lời của mình.

| Mã | Bài | Trạng thái | Bằng chứng / điều còn vướng |
| --- | --- | --- | --- |
| INT-01 | Định dạng mã | Chưa làm | |
| INT-02 | Một object hai vai trò | Chưa làm | |
| INT-03 | Hợp đồng public | Chưa làm | |
| INT-04 | Ghép bộ định dạng | Chưa làm | |
| INT-05 | Kiểm tra biểu mẫu mở rộng | Chưa làm | |

## Checklist

- [ ] Tự làm trước khi mở gợi ý/lời giải; giữ lại dự đoán ban đầu.
- [ ] Build thành công bằng source Java 17; tự kiểm kết quả từng ca, không chỉ nhìn thông báo main kết thúc.
- [ ] Có ca bình thường, ca biên và ca bị từ chối theo đúng hợp đồng.
- [ ] Giải thích trạng thái trước/sau thao tác sai và nguyên nhân của lỗi đã sửa.
- [ ] Chỉ dùng kiến thức được phép, mô tả trách nhiệm từng phần và một cách làm khác nếu hợp lý.
- [ ] Ghi một điều hiểu sai trước đây và một câu hỏi còn mở vào ghi chú riêng.

## Câu hỏi tự luận

1. Vì sao implementation không được giảm quyền public?
2. Interface chia sẻ trạng thái instance như abstract class được không?
3. Caller có cần biết tên class triển khai không?

Đối chiếu chỉ sau cùng với `solutions/README.md` và `solutions/ReferenceSolution.java`. Câu trả lời tự luận không cần giống câu chữ trong lời giải; cần đúng cơ chế và có ví dụ.
