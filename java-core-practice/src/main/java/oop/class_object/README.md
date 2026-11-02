# Class và object

## Dùng để làm gì?
Class mô tả cấu trúc và hành vi; object là một thể hiện có trạng thái và identity riêng. Dùng chúng để mô hình hóa sinh viên, tài khoản, sản phẩm.

## Bắt buộc hiểu
- Field lưu trạng thái; method biểu diễn hành vi.
- `new` tạo object; biến kiểu class giữ một giá trị reference hoặc `null`.
- `b = a` sao chép reference, không tạo object mới.
- `==` với reference kiểm tra cùng object. `equals` mặc định từ `Object` cũng kiểm tra identity, trừ khi class ghi đè.

## Lỗi thường gặp
- Tưởng mỗi biến reference tương ứng với một object mới.
- Quên khởi tạo object trước khi truy cập field, gây `NullPointerException`.
- Tưởng sao chép vài field luôn là deep copy; field mutable dạng reference vẫn có thể được chia sẻ.

## Tự kiểm tra
1. Class khác object ở điểm nào?
2. Sau `Student b = a`, có object Student mới không? Vì sao?
3. Hai object có cùng dữ liệu có chắc `==` không?
4. Tại sao sửa field qua b có thể ảnh hưởng giá trị đọc qua a?

## Bài tập từ dễ đến khó
1. Tạo Student với name, age, introduce(); tạo hai object và giải thích trạng thái riêng.
2. Tạo a, b cùng reference; thay đổi age, dự đoán output và đếm object Student.
3. Tạo object c độc lập, sao chép field; sửa c và giải thích giới hạn của cách sao chép này.

Đọc `ClassObjectDemo.java`, dự đoán trước khi chạy. Tự làm trong `ClassObjectExercise.java`; chỉ mở `ClassObjectSolution.java` khi cần đối chiếu.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
