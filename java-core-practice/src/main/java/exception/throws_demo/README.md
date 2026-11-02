# Throws và lan truyền exception

## Dùng để làm gì
Khai báo một method có thể truyền checked exception cho caller, để caller quyết định xử lý hoặc tiếp tục truyền lên.

## Bắt buộc phải hiểu
- throw ném một exception cụ thể; throws nằm trong chữ ký method.
- throws không bắt lỗi và không tự tạo exception.
- Checked: lớp Exception và các lớp con, trừ RuntimeException và các lớp con của nó; compiler yêu cầu catch hoặc throws.
- Unchecked gồm RuntimeException và Error cùng các lớp con; compiler không bắt buộc catch/throws. Không coi Error là lỗi nghiệp vụ thông thường.
- ParseException là checked; IllegalArgumentException là unchecked.
- Có thể chuyển loại exception để diễn đạt hợp đồng API; cần giữ cause khi có lỗi gốc.
- Khi không được catch, exception truyền lên chuỗi caller; khai báo main throws cũng chỉ tiếp tục truyền.

## Lỗi thường gặp
Nhầm throw/throws, tưởng khai báo throws đồng nghĩa đã xử lý, mất cause khi đổi loại exception, thêm throws Exception cho mọi method thay vì loại cụ thể.

## Tự kiểm tra
1. Khai báo throws có đảm bảo method luôn ném lỗi không?
2. Vì sao parseCount yêu cầu caller xử lý ParseException?
3. Vì sao requirePositive có thể ném IllegalArgumentException mà không khai báo?
4. Cause hữu ích thế nào khi đọc lỗi?
5. main throws khác catch ở main về nơi xử lý ra sao?

## Ba bài tập
1. **Dễ:** parseCount throws ParseException với "12"/"abc"; chuyển lỗi và giữ cause, giải thích checked.
2. **Vừa:** requirePositive từ chối <=0 bằng IllegalArgumentException; thử 2/0, giải thích unchecked.
3. **Khó:** parsePositiveCount kết hợp hai hàm; thử "3"/"abc"/"-1", xử lý hai loại lỗi và vẽ đường truyền.

Tự làm ThrowsExercise trước khi mở ThrowsSolution.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
