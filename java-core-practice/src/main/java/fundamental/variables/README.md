# Variables — Biến và kiểu dữ liệu

## Dùng để làm gì?

Biến giữ dữ liệu để tính toán và biểu diễn trạng thái. Hiểu kiểu dữ liệu giúp chọn miền giá trị phù hợp và tránh mất thông tin khi tính toán.

## Những ý bắt buộc phải hiểu

- Java có 8 kiểu primitive: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`. Biến tham chiếu giữ giá trị tham chiếu đến object hoặc `null`.
- Gán primitive là sao chép giá trị. Thay đổi biến nhận bản sao không thay đổi biến nguồn.
- Biến cục bộ phải được gán trước khi đọc; field và phần tử mảng có giá trị mặc định.
- Kiểu toán hạng quyết định kiểu phép tính: `7 / 2` là chia nguyên. Ép kiểu sau phép tính có thể quá muộn.:    

//nâng biến còn lại lên mức cao hơn và lấy phần nguyên nếu k ép kiểu, ép cho 1 biến, ép cho phép chia khi gán, ép kiểu cho thương
- Số nguyên có miền hữu hạn; phép toán `int` không tự nâng thành `long` khi tràn. Literal `50_000L` có kiểu `long`.// cân thẩn overflow

## Lỗi người mới thường gặp

- Gán kết quả phép nhân `int` vào biến `long` rồi cho rằng không thể tràn.//
- Cho rằng `double result = 7 / 2` sẽ giữ phần lẻ.//
- Dùng biến cục bộ chưa khởi tạo hoặc cho rằng `char` là cả một chuỗi.
- Dùng `float`/`double` khi cần biểu diễn tiền chính xác; phần này chỉ dùng để luyện kiểu dữ liệu, chưa xử lý tiền thực tế.

## Tự kiểm tra

1. `int a = 10; int b = a; b = 20;` có làm `a` thay đổi không? Vì sao?
k vì biến pri chỉ copy giá trị k thay doi gtri của bien gốc
2. Vì sao `(double) (7 / 2)` khác `(double) 7 / 2`?
vì cái 1 là chia lấy phần nguyên rồi ép kiểu double, còn cái ki là ép kiểu về double mới chia
3. Biến cục bộ `int x;` đã có giá trị mặc định để đọc chưa? chưa, nên khai báo như này trong method hoặc block sẽ lỗi
4. Vì sao `long x = 50_000 * 50_000` vẫn có thể sai? vì truoc khi ép kieur long, phep nhan kia tien hanh trc và sẽ sai gia tri vì int có gioi han mien gia tri

## Ba bài tập từ dễ đến khó

1. **Dễ — Diện tích:** đầu vào cố định chiều dài `7`, chiều rộng `5`, đều là `int`; in `35`. Giải thích vì sao kiểu này đủ với dữ liệu đã cho. Chưa cần đọc từ bàn phím.
// 7 và 5 là với int là đủ rồi
2. **Vừa — Chia và ép kiểu:** với `total = 7`, `people = 2`, dự đoán rồi in lần lượt `total / people`, `(double) total / people`, `(double) (total / people)`. Kết quả để đối chiếu: `3`, `3.5`, `3.0`. Giải thích thời điểm ép kiểu; mẫu số phải khác `0`.
3,3.5,3.0// cái 1 là lấy phân nguyên, cái 2 là ép 1 cái về double thi cái kia dc nâng len double ,cái kia là chia dc phan nguyen rôi moi ép kieu về double
3. **Khó — Tràn số:** tính `50_000 * 50_000` bằng `int`, gán phép nhân đó vào `long`, rồi tính bằng toán hạng `long`. Hai phép đầu cho `-1794967296`, phép cuối cho `2500000000`. Thêm trường hợp `byte` từ `127` tăng lên thành `-128`. Giải thích mỗi kết quả thay vì chỉ in số.
//cái này là nhan trc mới gán nên int*int có thể gây tràn và ket qua sai, nên kéo theo long dc gán sẽ sai ket qua đúng
## Cách học

Đọc `VariableDemo.java`, đoán output trước khi chạy. Tự làm trong `VariableExercise.java`; chỉ mở `VariableSolution.java` để đối chiếu sau đó. Các solution được tách riêng và không được gọi từ exercise.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
