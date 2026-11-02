# HashSet

## Dùng để làm gì
Lưu các phần tử duy nhất và kiểm tra tồn tại; hữu ích khi loại trùng.

## Bắt buộc phải hiểu
- Set không có index và HashSet không bảo đảm thứ tự duyệt.
- add trả false khi phần tử tương đương đã có.
- hashCode hỗ trợ tìm vùng lưu; equals xác định tương đương giữa các ứng viên.
- Hai object equals nhau phải có hashCode bằng nhau; chiều ngược lại không bắt buộc.
- Không sửa trường tham gia equals/hashCode của phần tử đang trong set.
- Thao tác cơ bản thường O(1) với hàm hash phân tán tốt; đây không phải bảo đảm cho mọi dữ liệu.

## Lỗi thường gặp
Đoán thứ tự in, override equals nhưng quên hashCode, dùng object mutable làm phần tử rồi thay đổi dữ liệu nhận diện.

## Tự kiểm tra
1. Hai String tạo bằng new có thể bị coi là trùng không?
2. HashCode bằng nhau có chứng minh equals không?
3. Vì sao cần sort riêng để in tăng dần?
4. Sửa id của phần tử đang ở trong set có thể gây lỗi gì?

## Ba bài tập
1. **Dễ:** Thêm An, Bình, An; giải thích kết quả add và size.
2. **Vừa:** Loại trùng [3, 1, 3, 2, 1] và in tăng dần; giải thích thứ tự.
3. **Khó:** Tạo Student có id bất biến, override equals/hashCode; thêm hai id giống và một id khác rồi giải thích size.

Tự làm HashSetExercise; đối chiếu HashSetSolution sau.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
