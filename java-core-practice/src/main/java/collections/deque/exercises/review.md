# Tự đánh giá: Deque

Mỗi bài chỉ chuyển “Đã giải thích được” khi tự mô tả cách làm, nguyên nhân lỗi và giới hạn. Theo dõi trạng thái ở [bảng tiến độ cấp gốc](../../../../../../PROGRESS.md).

- [ ] **DQ-01:** chạy ví dụ và biên; giải thích offerfirst/offerlast/pollfirst/polllast; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **DQ-02:** chạy ví dụ và biên; giải thích push/pop ở đầu deque; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **DQ-03:** chạy ví dụ và biên; giải thích hai stack, lịch sử thao tác; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **DQ-04:** chạy ví dụ và biên; giải thích hai đầu, string, vòng lặp; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **DQ-05:** chạy ví dụ và biên; giải thích class, trạng thái, hai stack; ghi một lỗi hoặc quyết định thiết kế của bản thân.

Câu hỏi về bản chất của mục:

1. Vì sao append sau undo phải xóa nhánh redo?
2. push/pop tương ứng với đầu nào của deque?
3. Vì sao lưu tên thao tác chưa đủ để undo trạng thái thật?

Các câu tự luận ngắn (trả lời trước khi mở reference):

1. Bất biến hoặc hợp đồng quan trọng nhất của mục này là gì? Dùng một ví dụ và một phản ví dụ từ bài bạn làm.
2. Ở bài suy luận, dự đoán nào của bạn khác lúc chạy? Giải thích theo từng bước và phân biệt kết quả với nguyên nhân.
3. Ở bài tìm lỗi, input nhỏ nhất làm lộ lỗi là gì? Vì sao sửa của bạn xử lý được input đó lẫn trường hợp biên?
4. Ở bài tổng kết, phần nào bảo vệ dữ liệu và phần nào điều phối hành vi? Nếu đổi một yêu cầu, bạn phải sửa ở đâu?
5. Nêu một giới hạn của lời giải đang dùng, một phương án thay thế trong kiến thức đã học và lý do chọn.

Ghi chú học tập: giữ ghi chú/bài làm cũ; viết thêm file ghi chú của bạn trong thư mục bạn chọn. Không đánh dấu hoàn thành chỉ vì đã đọc đáp án.
