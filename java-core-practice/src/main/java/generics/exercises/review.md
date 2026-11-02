# Tự đánh giá: Generics

Mỗi bài chỉ chuyển “Đã giải thích được” khi tự mô tả cách làm, nguyên nhân lỗi và giới hạn. Theo dõi trạng thái ở [bảng tiến độ cấp gốc](../../../../../PROGRESS.md).

- [ ] **GEN-01:** chạy ví dụ và biên; giải thích class generic hai tham số kiểu; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **GEN-02:** chạy ví dụ và biên; giải thích kiểu generic và extends wildcard; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **GEN-03:** chạy ví dụ và biên; giải thích raw type, cast và kiểm tra compile; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **GEN-04:** chạy ví dụ và biên; giải thích giới hạn kiểu <t extends number>; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **GEN-05:** chạy ví dụ và biên; giải thích generic class, generic static factory, invariant; ghi một lỗi hoặc quyết định thiết kế của bản thân.

Câu hỏi về bản chất của mục:

1. Vì sao Pair<int,String> không hợp lệ?
2. Slot<Integer> khác Slot<? extends Number> về khả năng đọc/ghi thế nào?
3. Vì sao static factory cần khai báo <T> riêng?

Các câu tự luận ngắn (trả lời trước khi mở reference):

1. Bất biến hoặc hợp đồng quan trọng nhất của mục này là gì? Dùng một ví dụ và một phản ví dụ từ bài bạn làm.
2. Ở bài suy luận, dự đoán nào của bạn khác lúc chạy? Giải thích theo từng bước và phân biệt kết quả với nguyên nhân.
3. Ở bài tìm lỗi, input nhỏ nhất làm lộ lỗi là gì? Vì sao sửa của bạn xử lý được input đó lẫn trường hợp biên?
4. Ở bài tổng kết, phần nào bảo vệ dữ liệu và phần nào điều phối hành vi? Nếu đổi một yêu cầu, bạn phải sửa ở đâu?
5. Nêu một giới hạn của lời giải đang dùng, một phương án thay thế trong kiến thức đã học và lý do chọn.

Ghi chú học tập: giữ ghi chú/bài làm cũ; viết thêm file ghi chú của bạn trong thư mục bạn chọn. Không đánh dấu hoàn thành chỉ vì đã đọc đáp án.
