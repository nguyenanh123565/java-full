# Methods — Phương thức và truyền tham số

## Dùng để làm gì?

Method đặt tên cho một công việc, nhận dữ liệu đầu vào và có thể trả về kết quả. Chia chương trình thành method giúp tái sử dụng và giải thích hành vi rõ hơn.

## Những ý bắt buộc phải hiểu

- Phân biệt tham số trong khai báo với đối số trong lời gọi; kiểu trả về `void` nghĩa là không có giá trị trả về.
- Method trả về giá trị phải `return` trên mọi đường thực thi có thể kết thúc bình thường. Caller quyết định có dùng giá trị trả về hay không.
- Java **luôn pass-by-value**: giá trị đối số được sao chép sang biến tham số.
- Với primitive, giá trị số/boolean/char được sao chép. Với reference, giá trị tham chiếu được sao chép; hai biến có thể dẫn tới cùng object.
- Gán lại biến tham số không gán lại biến caller. Sửa object qua tham chiếu có thể được caller nhìn thấy.
- Biến cục bộ trong method có phạm vi riêng. Các method `static` trong bài gọi trực tiếp từ `main`; method của object được học trong phần OOP.

## Lỗi người mới thường gặp

- Nói “Java truyền object bằng tham chiếu” rồi kỳ vọng gán lại tham số sẽ thay biến caller.
- Tăng primitive trong method `void` và kỳ vọng biến bên ngoài cũng tăng.
- Gọi method trả về kết quả nhưng không lưu lại kết quả khi cần cập nhật biến.
- Nhầm việc gán `values = ...` với việc sửa `values[0]`.

## Tự kiểm tra

1. Tham số và đối số khác nhau ở đâu?
2. Vì sao tăng một tham số `int` không đổi biến caller?
3. Nếu Java pass-by-value, vì sao method sửa phần tử mảng lại thấy ở caller?
4. Gán tham số mảng sang `new int[]{...}` có đổi biến mảng ở caller không? Vì sao?

## Ba bài tập từ dễ đến khó

1. **Dễ — Giá trị trả về:** viết `max(int a, int b)`, không dùng `Math.max`. Thử `(-3,-5)` cho `-3` và `(4,4)` cho `4`. Giải thích vai trò đối số, tham số, `return`.
2. **Vừa — Bản sao primitive:** bắt đầu với `int value = 5`. Viết method `void increment(int value)` rồi gọi: biến caller vẫn `5`. Viết `int incrementAndReturn(int value)` và gán kết quả cho caller: thành `6`. Giải thích vì sao cần phép gán ở caller. Chỉ dùng các giá trị nhỏ để chưa xét tràn số.
3. **Khó — Gán lại và sửa object:** bắt đầu với mảng khác `null`, có hai phần tử `[1,2]`. Method `replaceArray` gán tham số sang `[7,8]`, caller vẫn `[1,2]`. Method `changeFirst` sửa phần tử đầu thành `99`, caller thành `[99,2]`. Vẽ biến caller và tham số ở mỗi bước; giải thích vì sao không trường hợp nào là pass-by-reference.

## Cách học

Đoán output của `MethodDemo.java` và vẽ mũi tên tham chiếu. Tự viết các method trong `MethodExercise.java`, rồi mới mở `MethodSolution.java`.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
