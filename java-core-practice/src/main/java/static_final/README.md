# StaticFinal

## Dùng để làm gì?
Phân biệt dữ liệu thuộc lớp, dữ liệu từng object và giới hạn việc gán lại biến.

## Những ý bắt buộc phải hiểu
- static thuộc lớp; field instance thuộc từng object.
- static method không có this và không trực tiếp truy cập field instance.
- final ngăn gán lại biến; final reference không làm object trở thành immutable.
- static final thường dùng cho hằng số; chỉ một số biểu thức là compile-time constant.

## Lỗi người mới thường gặp
- Dùng static cho mọi field khiến các object dùng chung dữ liệu ngoài ý muốn.
- Hiểu final array là mảng không thay đổi được.
- Trả thẳng mảng nội bộ làm mất đóng gói.

## Câu hỏi tự kiểm tra
1. Tạo hai object thì field static có bao nhiêu bản trong cùng lớp đã nạp?
2. Vì sao static method không dùng this?
3. final int[] có sửa được phần tử không?
4. Sao chép mảng trong constructor và getter giúp gì?

## Ba bài tập từ dễ đến khó
1. Dễ: tạo Counter có static tổng số object và instance id; tạo hai object, giải thích dữ liệu nào dùng chung.
2. Vừa: tạo static final PI và static area(radius), từ chối bán kính âm; thử 0 và 2, giải thích vì sao method có thể static.
3. Khó: chứng minh final int[] vẫn sửa phần tử được, rồi viết Scores sao chép đầu vào và đầu ra. Giải thích final khác defensive copy thế nào.

## Cách học
Đọc `StaticFinalDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`StaticFinalExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `StaticFinalSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes static_final.StaticFinalDemo` (sau khi biên dịch).


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
