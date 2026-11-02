# Custom exception

## Dùng để làm gì
Diễn đạt lỗi nghiệp vụ bằng loại exception có tên và dữ liệu rõ ràng, chẳng hạn rút tiền vượt số dư.

## Bắt buộc phải hiểu
- extends Exception tạo checked exception; extends RuntimeException tạo unchecked exception.
- Tên loại exception giúp caller bắt đúng tình huống; message và các trường bổ sung giúp phản hồi.
- Checked/unchecked là lựa chọn thiết kế API. Ví dụ này dùng checked cho thiếu tiền để người học thấy trách nhiệm caller.
- Đầu vào sai như amount <= 0 dùng IllegalArgumentException; thiếu tiền hợp lệ về định dạng nhưng không đủ điều kiện nghiệp vụ.
- Kiểm tra trước khi cập nhật trạng thái để thao tác thất bại giữ nguyên số dư.
- Với ví dụ tiền, dùng long theo đơn vị nhỏ nhất; nếu mở rộng nghiệp vụ cần xác định đơn vị và quy tắc rõ ràng.
- serialVersionUID được khai báo vì Exception triển khai Serializable; chưa cần học serialization ở chủ đề này.

## Lỗi thường gặp
Dùng cùng exception cho mọi lỗi, không truyền message cho super, trừ số dư trước khi kiểm tra, catch rồi tiếp tục như đã rút thành công, dùng double cho phép tính tiền.

## Tự kiểm tra
1. extends Exception khác extends RuntimeException thế nào ở phía caller?
2. Số tiền âm khác rút vượt số dư ở điểm nào?
3. Vì sao balance không đổi nếu helper ném lỗi trước phép gán?
4. Trường amountRequested/currentBalance có ích gì hơn chỉ có message?
5. Vì sao phải kiểm tra trước khi thay đổi trạng thái?

## Ba bài tập
1. **Dễ:** Custom checked exception và withdraw, thử (100,40)/(100,150); giải thích trách nhiệm caller.
2. **Vừa:** Account có số dư private; từ chối số dư âm và amount <=0; thử 0/-10, giải thích loại lỗi.
3. **Khó:** Account(100), rút 30/100/20; bắt lỗi từng lần, in số dư, thêm dữ liệu vào exception và giải thích trạng thái khi thất bại.

Tự làm CustomExceptionExercise trước khi mở CustomExceptionSolution.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
