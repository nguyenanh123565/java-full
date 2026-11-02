# Tự đánh giá: Nạp chồng rõ ý định

Chọn một trạng thái cho mỗi bài: **Chưa làm / Đang làm / Đã chạy đúng / Đã giải thích được**. Chỉ đánh dấu mức cuối khi bạn giải thích được cơ chế và ít nhất một lỗi thường gặp bằng lời của mình.

| Mã | Bài | Trạng thái | Bằng chứng / điều còn vướng |
| --- | --- | --- | --- |
| OVL-01 | Nhãn một hoặc nhiều bản | Chưa làm | |
| OVL-02 | Mở rộng primitive | Chưa làm | |
| OVL-03 | Đổi tên tham số không đủ | Chưa làm | |
| OVL-04 | Thứ tự kiểu tham số | Chưa làm | |
| OVL-05 | Overload trước, override sau | Chưa làm | |

## Checklist

- [ ] Tự làm trước khi mở gợi ý/lời giải; giữ lại dự đoán ban đầu.
- [ ] Build thành công bằng source Java 17; tự kiểm kết quả từng ca, không chỉ nhìn thông báo main kết thúc.
- [ ] Có ca bình thường, ca biên và ca bị từ chối theo đúng hợp đồng.
- [ ] Giải thích trạng thái trước/sau thao tác sai và nguyên nhân của lỗi đã sửa.
- [ ] Chỉ dùng kiến thức được phép, mô tả trách nhiệm từng phần và một cách làm khác nếu hợp lý.
- [ ] Ghi một điều hiểu sai trước đây và một câu hỏi còn mở vào ghi chú riêng.

## Câu hỏi tự luận

1. Kiểu trả về có tham gia phân biệt overload không?
2. Vì sao đổi kiểu khai báo đối số có thể đổi overload?
3. Khi nào overload thuận tiện trở thành API khó đọc?

Đối chiếu chỉ sau cùng với `solutions/README.md` và `solutions/ReferenceSolution.java`. Câu trả lời tự luận không cần giống câu chữ trong lời giải; cần đúng cơ chế và có ví dụ.
