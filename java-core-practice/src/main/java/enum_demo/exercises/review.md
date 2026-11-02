# Tự đánh giá: Enum có dữ liệu và hành vi

Chọn một trạng thái cho mỗi bài: **Chưa làm / Đang làm / Đã chạy đúng / Đã giải thích được**. Chỉ đánh dấu mức cuối khi bạn giải thích được cơ chế và ít nhất một lỗi thường gặp bằng lời của mình.

| Mã | Bài | Trạng thái | Bằng chứng / điều còn vướng |
| --- | --- | --- | --- |
| ENUM-01 | Hướng di chuyển | Chưa làm | |
| ENUM-02 | Mã ổn định qua đổi thứ tự | Chưa làm | |
| ENUM-03 | Đọc mã không phải tên enum | Chưa làm | |
| ENUM-04 | Phiếu hỗ trợ có trạng thái | Chưa làm | |
| ENUM-05 | Tổng kết phân luồng phiếu | Chưa làm | |

## Checklist

- [ ] Tự làm trước khi mở gợi ý/lời giải; giữ lại dự đoán ban đầu.
- [ ] Build thành công bằng source Java 17; tự kiểm kết quả từng ca, không chỉ nhìn thông báo main kết thúc.
- [ ] Có ca bình thường, ca biên và ca bị từ chối theo đúng hợp đồng.
- [ ] Giải thích trạng thái trước/sau thao tác sai và nguyên nhân của lỗi đã sửa.
- [ ] Chỉ dùng kiến thức được phép, mô tả trách nhiệm từng phần và một cách làm khác nếu hợp lý.
- [ ] Ghi một điều hiểu sai trước đây và một câu hỏi còn mở vào ghi chú riêng.

## Câu hỏi tự luận

1. Enum khác một nhóm String ở khả năng kiểm tra kiểu như thế nào?
2. Vì sao mã nghiệp vụ không dùng ordinal?
3. valueOf có chuẩn hóa khoảng trắng hoặc chữ thường tự động không?

Đối chiếu chỉ sau cùng với `solutions/README.md` và `solutions/ReferenceSolution.java`. Câu trả lời tự luận không cần giống câu chữ trong lời giải; cần đúng cơ chế và có ví dụ.
