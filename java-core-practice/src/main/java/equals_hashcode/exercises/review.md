# Tự đánh giá: Equals và hashCode

Mỗi bài chỉ chuyển “Đã giải thích được” khi tự mô tả cách làm, nguyên nhân lỗi và giới hạn. Theo dõi trạng thái ở [bảng tiến độ cấp gốc](../../../../../PROGRESS.md).

- [ ] **EQ-01:** chạy ví dụ và biên; giải thích equality nhiều field, immutable; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **EQ-02:** chạy ví dụ và biên; giải thích phản xạ, đối xứng, bắc cầu, hash; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **EQ-03:** chạy ví dụ và biên; giải thích chữ ký equals(object) và dispatch; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **EQ-04:** chạy ví dụ và biên; giải thích key ghép và dữ liệu mô tả; ghi một lỗi hoặc quyết định thiết kế của bản thân.
- [ ] **EQ-05:** chạy ví dụ và biên; giải thích equality, mảng, vòng lặp và null; ghi một lỗi hoặc quyết định thiết kế của bản thân.

Câu hỏi về bản chất của mục:

1. equals(Key) khác equals(Object) ở dispatch ra sao?
2. Cùng hashCode có chứng minh equality không?
3. Tại sao equals và hashCode phải dùng cùng các field định danh?

Các câu tự luận ngắn (trả lời trước khi mở reference):

1. Bất biến hoặc hợp đồng quan trọng nhất của mục này là gì? Dùng một ví dụ và một phản ví dụ từ bài bạn làm.
2. Ở bài suy luận, dự đoán nào của bạn khác lúc chạy? Giải thích theo từng bước và phân biệt kết quả với nguyên nhân.
3. Ở bài tìm lỗi, input nhỏ nhất làm lộ lỗi là gì? Vì sao sửa của bạn xử lý được input đó lẫn trường hợp biên?
4. Ở bài tổng kết, phần nào bảo vệ dữ liệu và phần nào điều phối hành vi? Nếu đổi một yêu cầu, bạn phải sửa ở đâu?
5. Nêu một giới hạn của lời giải đang dùng, một phương án thay thế trong kiến thức đã học và lý do chọn.

Ghi chú học tập: giữ ghi chú/bài làm cũ; viết thêm file ghi chú của bạn trong thư mục bạn chọn. Không đánh dấu hoàn thành chỉ vì đã đọc đáp án.
