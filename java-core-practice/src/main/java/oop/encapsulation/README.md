# Encapsulation

## Dùng để làm gì?
Đóng gói giấu trạng thái nội bộ và cung cấp hành vi có kiểm soát, giữ object luôn thỏa các điều kiện hợp lệ.

## Bắt buộc hiểu
- Field `private` giới hạn truy cập nhưng getter/setter phải được thiết kế có mục đích.
- Validation cần thực hiện trước khi thay đổi trạng thái; constructor cũng cần giữ dữ liệu hợp lệ.
- Không phải field nào cũng cần setter; ví tiền nên cung cấp deposit/withdraw.
- Getter trả mảng hay collection mutable có thể làm lộ reference nội bộ; dùng defensive copy khi phù hợp.
- `final` với array chỉ cấm đổi reference, không cấm đổi phần tử.

## Lỗi thường gặp
- Sinh setter cho mọi field, cho phép đặt số dư âm.
- Sửa trạng thái rồi mới kiểm tra lỗi.
- Tưởng field private hoặc final khiến array tự immutable.
- Dùng `double` cho tiền mà không cân nhắc sai số; bài này dùng `long` cho đơn vị nguyên.

## Tự kiểm tra
1. Vì sao private + getter/setter chưa chắc là đóng gói tốt?
2. Tại sao Wallet không nên có setBalance?
3. Vì sao constructor và getter đều cần sao chép array?
4. `int[].clone()` khác `Object[].clone()` về chia sẻ phần tử ra sao?

## Bài tập từ dễ đến khó
1. Student kiểm tra age trong khoảng 0–150 và giải thích dữ liệu hợp lệ.
2. Wallet kiểm tra nạp/rút tiền, không đổi trạng thái khi thao tác bị từ chối.
3. Scores bảo vệ mảng khỏi sửa qua reference đầu vào và getter; giải thích defensive copy.

Đoán output của `EncapsulationDemo.java`. Tự làm `EncapsulationExercise.java`; xem `EncapsulationSolution.java` khi cần.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
