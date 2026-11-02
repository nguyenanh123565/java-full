# Tự đánh giá: Ghi đè giữ hợp đồng

Chọn một trạng thái cho mỗi bài: **Chưa làm / Đang làm / Đã chạy đúng / Đã giải thích được**. Chỉ đánh dấu mức cuối khi bạn giải thích được cơ chế và ít nhất một lỗi thường gặp bằng lời của mình.

| Mã | Bài | Trạng thái | Bằng chứng / điều còn vướng |
| --- | --- | --- | --- |
| OVR-01 | Phí dịch vụ ưu tiên | Chưa làm | |
| OVR-02 | Method cha gọi method con | Chưa làm | |
| OVR-03 | Chữ hoa làm khác method | Chưa làm | |
| OVR-04 | Mở rộng không tự gọi lại | Chưa làm | |
| OVR-05 | Bảng giá giữ lời hứa | Chưa làm | |

## Checklist

- [ ] Tự làm trước khi mở gợi ý/lời giải; giữ lại dự đoán ban đầu.
- [ ] Build thành công bằng source Java 17; tự kiểm kết quả từng ca, không chỉ nhìn thông báo main kết thúc.
- [ ] Có ca bình thường, ca biên và ca bị từ chối theo đúng hợp đồng.
- [ ] Giải thích trạng thái trước/sau thao tác sai và nguyên nhân của lỗi đã sửa.
- [ ] Chỉ dùng kiến thức được phép, mô tả trách nhiệm từng phần và một cách làm khác nếu hợp lý.
- [ ] Ghi một điều hiểu sai trước đây và một câu hỏi còn mở vào ghi chú riêng.

## Câu hỏi tự luận

1. @Override giúp phát hiện gì ngay khi biên dịch?
2. super.fee và this.fee trong fee của con đi đâu?
3. Override đúng chữ ký đã đủ giữ đúng hành vi chưa?

Đối chiếu chỉ sau cùng với `solutions/README.md` và `solutions/ReferenceSolution.java`. Câu trả lời tự luận không cần giống câu chữ trong lời giải; cần đúng cơ chế và có ví dụ.
