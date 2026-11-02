# HashMap

## Dùng để làm gì
Ánh xạ key tới value để tra cứu, cập nhật và đếm tần suất.

## Bắt buộc phải hiểu
- Một key tương đương chỉ giữ một value; put trả value cũ hoặc null.
- HashMap dùng hash của key để xác định bucket, rồi đối chiếu key bằng equals.
- Collision là nhiều key đi vào cùng bucket; các key không equals vẫn cùng tồn tại.
- equals nhau phải có hashCode bằng nhau; cùng hash không nhất thiết equals.
- HashMap cho phép một null key và các null value; get trả null có thể do thiếu key hoặc value null. Dùng containsKey để phân biệt.
- Không bảo đảm thứ tự; dùng sắp xếp riêng khi cần output ổn định.
- Key nên bất biến: sửa trường tham gia equals/hashCode sau put có thể làm lookup không tìm được mapping.
- Thao tác thường O(1) khi hash phân tán tốt; collision ảnh hưởng hiệu năng. Không cần học chi tiết nội bộ bucket ngay ở bước đầu.

## Lỗi thường gặp
Dùng == để diễn giải key String, tưởng collision ghi đè mọi key, chỉ gọi get để kiểm tra tồn tại, sửa id của key trong map, giả định thứ tự chèn được giữ.

## Tự kiểm tra
1. put với key bằng nhau tạo mapping mới hay thay value?
2. HashCode bằng nhau nhưng equals false có thể cùng tồn tại không?
3. Làm sao phân biệt key không tồn tại với value null?
4. Vì sao lookup bằng một object mới có cùng id vẫn có thể thành công?
5. Vì sao key mutable nguy hiểm dù reference không đổi?

## Ba bài tập
1. **Dễ:** An=8, thay thành 9, Bình=null; dự đoán put, size, get/containsKey cho Bình và Chi, giải thích.
2. **Vừa:** Đếm [java, core, java, map, core] và in theo key tăng dần; giải thích thứ tự.
3. **Khó:** Key id bất biến, hashCode cố định, equals theo id; thêm A/B và lookup bằng Key mới. Giải thích collision và nguy cơ key mutable.

Tự làm HashMapExercise trước khi mở HashMapSolution.


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
