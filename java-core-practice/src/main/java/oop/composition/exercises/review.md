# Tự đánh giá: Phối hợp object bằng composition

Chọn một trạng thái cho mỗi bài: **Chưa làm / Đang làm / Đã chạy đúng / Đã giải thích được**. Chỉ đánh dấu mức cuối khi bạn giải thích được cơ chế và ít nhất một lỗi thường gặp bằng lời của mình.

| Mã | Bài | Trạng thái | Bằng chứng / điều còn vướng |
| --- | --- | --- | --- |
| COMP-01 | Máy in sở hữu hộp mực | Chưa làm | |
| COMP-02 | Chia sẻ hay sở hữu riêng | Chưa làm | |
| COMP-03 | Máy tính giá không phải quy tắc giá | Chưa làm | |
| COMP-04 | Bản sao danh sách công việc | Chưa làm | |
| COMP-05 | Quầy in phối hợp các thành phần | Chưa làm | |

## Checklist

- [ ] Tự làm trước khi mở gợi ý/lời giải; giữ lại dự đoán ban đầu.
- [ ] Build thành công bằng source Java 17; tự kiểm kết quả từng ca, không chỉ nhìn thông báo main kết thúc.
- [ ] Có ca bình thường, ca biên và ca bị từ chối theo đúng hợp đồng.
- [ ] Giải thích trạng thái trước/sau thao tác sai và nguyên nhân của lỗi đã sửa.
- [ ] Chỉ dùng kiến thức được phép, mô tả trách nhiệm từng phần và một cách làm khác nếu hợp lý.
- [ ] Ghi một điều hiểu sai trước đây và một câu hỏi còn mở vào ghi chú riêng.

## Câu hỏi tự luận

1. Object sở hữu và object cộng tác được chia sẻ khác nhau thế nào?
2. Vì sao copy mảng object chưa chắc cô lập các object?
3. Một object dùng object khác có cần extends không?

Đối chiếu chỉ sau cùng với `solutions/README.md` và `solutions/ReferenceSolution.java`. Câu trả lời tự luận không cần giống câu chữ trong lời giải; cần đúng cơ chế và có ví dụ.
