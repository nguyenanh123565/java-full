# Xử lý ngoại lệ

## Dùng để làm gì?
Tách luồng thành công và thất bại, truyền lỗi tới nơi có thể xử lý.

## Thứ tự học
1. [try_catch](try_catch/README.md)
2. [throws_demo](throws_demo/README.md)
3. [custom_exception](custom_exception/README.md)

## Những ý bắt buộc phải hiểu
- Checked exception phải catch hoặc khai báo throws; unchecked không bắt buộc.
- throw ném một exception; throws khai báo trên method.
- Catch cụ thể trước tổng quát; không nuốt lỗi.

## Lỗi người mới thường gặp
- Catch Exception cho mọi lỗi mà không xử lý.
- Nhầm throws với đã xử lý exception.

## Câu hỏi tự kiểm tra
1. Lỗi nào compiler bắt buộc xử lý?
2. throw và throws khác nhau thế nào?
3. Vì sao lỗi không nên để trạng thái bị cập nhật một nửa?

## Ba bài tập từ dễ đến khó
1. Dễ: xử lý parse input sai.
2. Vừa: lan truyền checked exception đúng tầng.
3. Khó: thiết kế custom exception cho validation rồi giải thích quyết định checked/unchecked.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
