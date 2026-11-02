# Tự đánh giá: Đóng gói và trạng thái hợp lệ

Chọn một trạng thái cho mỗi bài: **Chưa làm / Đang làm / Đã chạy đúng / Đã giải thích được**. Chỉ đánh dấu mức cuối khi bạn giải thích được cơ chế và ít nhất một lỗi thường gặp bằng lời của mình.

| Mã | Bài | Trạng thái | Bằng chứng / điều còn vướng |
| --- | --- | --- | --- |
| ENC-01 | Kho có sức chứa | Chưa làm | |
| ENC-02 | Hai field liên quan nhau | Chưa làm | |
| ENC-03 | Đặt chỗ rồi mới kiểm tra | Chưa làm | |
| ENC-04 | Khung giờ luôn hợp lệ | Chưa làm | |
| ENC-05 | Phòng họp đổi sức chứa | Chưa làm | |

## Checklist

- [ ] Tự làm trước khi mở gợi ý/lời giải; giữ lại dự đoán ban đầu.
- [ ] Build thành công bằng source Java 17; tự kiểm kết quả từng ca, không chỉ nhìn thông báo main kết thúc.
- [ ] Có ca bình thường, ca biên và ca bị từ chối theo đúng hợp đồng.
- [ ] Giải thích trạng thái trước/sau thao tác sai và nguyên nhân của lỗi đã sửa.
- [ ] Chỉ dùng kiến thức được phép, mô tả trách nhiệm từng phần và một cách làm khác nếu hợp lý.
- [ ] Ghi một điều hiểu sai trước đây và một câu hỏi còn mở vào ghi chú riêng.

## Câu hỏi tự luận

1. Vì sao cần kiểm tra cả object ở constructor và method cập nhật?
2. Một setter cho từng field có thể làm hỏng điều kiện liên quan hai field thế nào?
3. Từ chối thao tác có được đổi một phần trạng thái không?

Đối chiếu chỉ sau cùng với `solutions/README.md` và `solutions/ReferenceSolution.java`. Câu trả lời tự luận không cần giống câu chữ trong lời giải; cần đúng cơ chế và có ví dụ.
