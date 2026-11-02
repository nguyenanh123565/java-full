# Tự đánh giá: HashMap

Mỗi bài chỉ chuyển “Đã giải thích được” khi tự mô tả cách làm, nguyên nhân lỗi và giới hạn. Theo dõi trạng thái ở [bảng tiến độ cấp gốc](../../../../../../PROGRESS.md).

- [ ] **HM-01:** chạy ví dụ và biên; giải thích getordefault/put và map key; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **HM-02:** chạy ví dụ và biên; giải thích getordefault và mapping null; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **HM-03:** chạy ví dụ và biên; giải thích validation trước cập nhật; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **HM-04:** chạy ví dụ và biên; giải thích map crud và hợp đồng tồn tại; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **HM-05:** chạy ví dụ và biên; giải thích map kết hợp list, snapshot cấu trúc; ghi một lỗi hoặc quyết định thiết kế của bản thân.

Câu hỏi về bản chất của mục:

1. Vì sao getOrDefault không thay null value bằng default?
2. Hai lớp trong Map<String,List<String>> cần bao nhiêu list độc lập?
3. Vì sao put trước kiểm tra tồn kho có thể phá bất biến?

Các câu tự luận ngắn (trả lời trước khi mở reference):

1. Bất biến hoặc hợp đồng quan trọng nhất của mục này là gì? Dùng một ví dụ và một phản ví dụ từ bài bạn làm.
2. Ở bài suy luận, dự đoán nào của bạn khác lúc chạy? Giải thích theo từng bước và phân biệt kết quả với nguyên nhân.
3. Ở bài tìm lỗi, input nhỏ nhất làm lộ lỗi là gì? Vì sao sửa của bạn xử lý được input đó lẫn trường hợp biên?
4. Ở bài tổng kết, phần nào bảo vệ dữ liệu và phần nào điều phối hành vi? Nếu đổi một yêu cầu, bạn phải sửa ở đâu?
5. Nêu một giới hạn của lời giải đang dùng, một phương án thay thế trong kiến thức đã học và lý do chọn.

Ghi chú học tập: giữ ghi chú/bài làm cũ; viết thêm file ghi chú của bạn trong thư mục bạn chọn. Không đánh dấu hoàn thành chỉ vì đã đọc đáp án.
