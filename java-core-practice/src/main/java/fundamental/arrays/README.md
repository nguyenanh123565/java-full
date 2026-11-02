# Arrays — Mảng và tham chiếu mảng

## Dùng để làm gì?

Mảng giữ một dãy phần tử cùng kiểu, truy cập theo chỉ số. Đây là nền tảng để luyện vòng lặp, xử lý dãy và học DSA.

## Những ý bắt buộc phải hiểu

- Mảng là object; biến `int[]` giữ tham chiếu tới mảng hoặc `null`.
- Độ dài cố định khi tạo mảng. `length` là field, không phải method; chỉ số hợp lệ là `0..length-1`.
- Mảng rỗng có `length == 0`; nó khác `null`. Mảng primitive có phần tử mặc định, ví dụ `int` là `0`.
- `int[] b = a` tạo alias tới cùng mảng. `Arrays.copyOf` tạo mảng mới; với `int[]`, phần tử primitive được sao chép độc lập.
- `==` kiểm tra cùng object. `Arrays.equals` so sánh phần tử; `Arrays.toString` hiển thị mảng một chiều.
- `int[][]` là mảng chứa tham chiếu tới các mảng hàng; các hàng có thể khác độ dài hoặc dùng chung một mảng.
- Sao chép mảng object hoặc mảng hai chiều bằng `copyOf` chỉ sao chép lớp ngoài: các tham chiếu phần tử vẫn có thể dùng chung object.

## Lỗi người mới thường gặp

- Duyệt tới `i <= array.length`, gây `ArrayIndexOutOfBoundsException`.
- Gán mảng sang biến khác rồi nghĩ có hai mảng độc lập.
- Dùng `array.equals(other)` hoặc `==` để so sánh nội dung mảng.
- In trực tiếp mảng rồi kỳ vọng thấy các phần tử; dùng `Arrays.toString` hoặc `deepToString`.

## Tự kiểm tra

1. `a.length` khác chỉ số phần tử cuối thế nào?
2. Với `int[] b = a`, sửa `b[0]` có ảnh hưởng `a[0]` không? Vì sao?
3. `Arrays.copyOf` trên `int[]` và trên `Object[]` có điểm gì khác về tính độc lập của object phần tử?
4. Vì sao `int[][] matrix = {row, row}` có thể làm hai hàng cùng thay đổi?

## Ba bài tập từ dễ đến khó

1. **Dễ — Tổng:** viết method nhận `int[]` khác `null`, dùng vòng lặp và trả `long`. `[-2,3,5]` cho `6`, `[]` cho `0`. Giải thích điều kiện chỉ số và vì sao mảng rỗng không phải lỗi.
2. **Vừa — Alias và copy:** tạo `original=[1,2,3]`, `alias=original` và bản sao `copy` bằng `Arrays.copyOf`. Sửa `alias[0]=99`; in `original=[99,2,3]`, `alias=[99,2,3]`, `copy=[1,2,3]`. Giải thích hai phép so sánh `original == alias` (`true`) và `original == copy` (`false`).
3. **Khó — Hàng dùng chung:** tạo `shared` với hai hàng cùng tham chiếu tới `[1,2]`; sửa `[0][0]=9`, in `[[9,2],[9,2]]`. Sau đó tạo `independent` với hai bản sao riêng của `[1,2]`; sửa tương tự, in `[[9,2],[1,2]]`. Dùng `Arrays.deepToString`; vẽ mảng ngoài và từng hàng để giải thích khác biệt.

## Cách học

Đoán `ArrayDemo.java`; tự làm `ArrayExercise.java`; chỉ mở `ArraySolution.java` khi cần đối chiếu. Sau chủ đề này có thể luyện Find Max, Find Min, Reverse Array trong `exercises/easy`.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
