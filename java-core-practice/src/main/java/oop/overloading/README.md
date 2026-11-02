# Overloading

## Dùng để làm gì?
Nạp chồng cho phép cùng tên method xử lý các danh sách tham số khác nhau, tạo cách gọi tiện dụng mà vẫn có kiểu dữ liệu rõ ràng.

## Bắt buộc hiểu
- Overload khác số lượng, kiểu hoặc thứ tự các kiểu tham số. Đổi tên tham số không đủ.
- Chỉ khác kiểu trả về không được xem là overload.
- Compiler chọn overload từ kiểu khai báo của đối số và các quy tắc chuyển kiểu.
- Sau khi chọn signature, nếu đó là instance method bị override, runtime mới chọn cài đặt theo object thực tế.
- `null` có thể khớp nhiều reference type; các kiểu không liên hệ có thể gây ambiguous call.

## Lỗi thường gặp
- Đoán overload dựa vào kiểu thực tế của object lúc chạy.
- Tưởng đổi kiểu trả về hoặc tên tham số là tạo overload.
- Có nhiều overload reference không liên hệ rồi gọi với null mà không chỉ rõ kiểu.
- Thêm quá nhiều overload khiến API khó đoán khi kết hợp boxing, widening và varargs.

## Tự kiểm tra
1. Overloading khác overriding về thời điểm chọn như thế nào?
2. Vì sao describe(Object o) chạy với Object o = "Java"?
3. Vì sao describe(null) chọn String khi có Object/String overload?
4. Vì sao choose(null) lỗi khi chỉ có String/Integer overload?

## Bài tập từ dễ đến khó
1. Ba overload sum và giải thích signature hợp lệ.
2. Hai overload describe; dự đoán lời gọi dùng cùng object nhưng kiểu đối số khác.
3. Quan sát null ambiguous và dùng cast để chọn rõ overload; giải thích quan hệ kiểu.

Đoán output ở `OverloadingDemo.java`, tự làm `OverloadingExercise.java`, đối chiếu `OverloadingSolution.java`.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
