# ArrayList

## Dùng để làm gì
Lưu danh sách có thứ tự, truy cập bằng index và tự mở rộng kích thước. Dùng khi thường đọc phần tử theo vị trí hoặc thêm ở cuối.

## Bắt buộc phải hiểu
- Index bắt đầu từ 0; `size()` là số phần tử, khác sức chứa bên trong.
- Cho phép trùng lặp và null. Thêm cuối có chi phí trung bình phân bổ O(1); chèn/xóa giữa thường O(n).
- Biến list giữ reference; gán sang biến khác tạo alias.
- `new ArrayList<>(list)` tạo bản sao nông.
- `remove(int)` xóa theo index; `remove(Object)` xóa phần tử khớp đầu tiên.
- `List.of(...)` không cho sửa; bọc trong ArrayList để có list mutable.

## Lỗi thường gặp
Nhầm remove theo index/giá trị, truy cập index bằng size, thay đổi cấu trúc list trong vòng for-each, tưởng bản sao nông sao chép mọi object phần tử.

## Tự kiểm tra
1. Vì sao alias thấy thay đổi của list gốc?
2. Với List<Integer>, remove(2) chọn overload nào?
3. Vì sao thêm ở giữa thường chậm hơn thêm ở cuối?
4. Sau bản sao nông, sửa một object phần tử có thể ảnh hưởng cả hai list không?

## Ba bài tập
1. **Dễ:** Tạo An, Bình, Chi; thêm Dũng, sửa Bình thành Bảo, xóa An. Giải thích index thay đổi.
2. **Vừa:** Với [1, 2, 2, 3], xóa giá trị 2; so sánh hai overload remove và giải thích vì sao kết quả có thể tình cờ giống nhau.
3. **Khó:** Tạo list [An], alias và bản sao; thêm Bình qua alias, Chi qua bản sao. Đoán output và giải thích sao chép nông.

Học bằng ArrayListDemo; tự làm trong ArrayListExercise. Chỉ mở ArrayListSolution sau khi tự giải thích được kết quả.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
