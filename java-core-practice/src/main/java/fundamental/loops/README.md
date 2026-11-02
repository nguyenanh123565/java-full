# Loops — Vòng lặp

## Dùng để làm gì?

Vòng lặp xử lý một công việc nhiều lần: tính tổng, duyệt dữ liệu, tạo bảng và thực hiện thuật toán có bước lặp.

## Những ý bắt buộc phải hiểu

- `for` gồm khởi tạo, điều kiện, cập nhật. Điều kiện được kiểm tra trước mỗi lượt.
- `while` kiểm tra điều kiện trước thân; `do-while` kiểm tra sau thân và chạy ít nhất một lần.
- `break` dừng vòng lặp gần nhất. `continue` chuyển sang lượt tiếp theo; trong `for`, bước cập nhật vẫn diễn ra.
- Phải có tiến triển tới điều kiện dừng. Vòng lặp có thể chạy `0` lần.
- Vòng lặp lồng nhau không luôn có số lượt cố định bằng nhau; tam giác có tổng lượt `1 + 2 + ... + n`.
- Với tổng lớn, chọn `long` trước khi cộng dồn để tránh tràn `int`.

## Lỗi người mới thường gặp

- Sai một đơn vị ở `<` và `<=`, đặc biệt khi duyệt mảng có chỉ số `0..length-1`.
- Quên cập nhật biến trong `while`, hoặc `continue` trước cập nhật nên vòng lặp không dừng.
- Nhầm `break` với `continue` hoặc tưởng `break` dừng tất cả vòng lặp lồng nhau.
- Gán lại tổng thay vì cộng dồn, hoặc khởi tạo tổng lại bên trong vòng lặp.

## Tự kiểm tra

1. Với điều kiện ban đầu `false`, `while` và `do-while` khác nhau thế nào?
2. Khi gặp `continue` trong `for`, biểu thức cập nhật có chạy không?
3. Vòng `for (int i = 0; i < 3; i++)` chạy mấy lượt? Vì sao?
4. Vì sao hai vòng lặp lồng nhau trong tam giác vẫn có độ phức tạp `O(n^2)`?

## Ba bài tập từ dễ đến khó

1. **Dễ — Tổng từ 1 đến n:** `0 <= n <= 1_000_000`; dùng vòng lặp và tổng `long`. Với `n=5` in `15`, với `n=0` in `0`. Giải thích điều kiện dừng và miền giá trị của tổng. Không thay vòng lặp bằng công thức trong bài này.
2. **Vừa — Bỏ số chẵn:** duyệt `1..10`, dùng `continue` bỏ số chẵn rồi cộng các số lẻ; in `25`. Giải thích nếu đổi thành `break` thì tổng sẽ là `1` vì vòng lặp dừng tại `2`.
3. **Khó — Tam giác sao:** dùng hai vòng lặp với `0 <= n <= 10`. `n=4` in đúng bốn dòng dưới đây; `n=0` không in dòng sao nào. Giải thích số lượt của vòng trong ở mỗi dòng và độ phức tạp theo `n`.

```text
*
**
***
****
```

## Cách học

Đoán output của `LoopDemo.java`; tự làm các TODO trong `LoopExercise.java`; đối chiếu `LoopSolution.java` sau khi đã thử cả `n=0`.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
