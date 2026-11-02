# Tự đánh giá: ArrayList

Mỗi bài chỉ chuyển “Đã giải thích được” khi tự mô tả cách làm, nguyên nhân lỗi và giới hạn. Theo dõi trạng thái ở [bảng tiến độ cấp gốc](../../../../../../PROGRESS.md).

- [ ] **AL-01:** chạy ví dụ và biên; giải thích size/get/add và thứ tự list; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **AL-02:** chạy ví dụ và biên; giải thích alias, copy cấu trúc, object mutable; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **AL-03:** chạy ví dụ và biên; giải thích index thay đổi khi remove; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **AL-04:** chạy ví dụ và biên; giải thích index, giới hạn, bản sao; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **AL-05:** chạy ví dụ và biên; giải thích method, validation, list snapshot; ghi một lỗi hoặc quyết định thiết kế của bản thân.

Câu hỏi về bản chất của mục:

1. Vì sao copy list chứa Item mutable vẫn có thể làm object của nguồn đổi?
2. Xóa khi duyệt index từ cuối giải quyết việc dịch phần tử như thế nào?
3. Vì sao Integer trong snapshot không cần deep copy?

Các câu tự luận ngắn (trả lời trước khi mở reference):

1. Bất biến hoặc hợp đồng quan trọng nhất của mục này là gì? Dùng một ví dụ và một phản ví dụ từ bài bạn làm.
2. Ở bài suy luận, dự đoán nào của bạn khác lúc chạy? Giải thích theo từng bước và phân biệt kết quả với nguyên nhân.
3. Ở bài tìm lỗi, input nhỏ nhất làm lộ lỗi là gì? Vì sao sửa của bạn xử lý được input đó lẫn trường hợp biên?
4. Ở bài tổng kết, phần nào bảo vệ dữ liệu và phần nào điều phối hành vi? Nếu đổi một yêu cầu, bạn phải sửa ở đâu?
5. Nêu một giới hạn của lời giải đang dùng, một phương án thay thế trong kiến thức đã học và lý do chọn.

Ghi chú học tập: giữ ghi chú/bài làm cũ; viết thêm file ghi chú của bạn trong thư mục bạn chọn. Không đánh dấu hoàn thành chỉ vì đã đọc đáp án.
