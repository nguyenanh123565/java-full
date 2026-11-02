# Condition — Rẽ nhánh

## Dùng để làm gì?

Rẽ nhánh chọn hành vi dựa trên dữ liệu: kiểm tra điều kiện, phân loại giá trị và xử lý trường hợp hợp lệ hoặc không hợp lệ.

## Những ý bắt buộc phải hiểu

- Điều kiện `if` phải có kiểu `boolean`; Java không tự coi số `0` là `false`.
- Trong chuỗi `if / else if / else`, chỉ nhánh đầu tiên thỏa điều kiện chạy.
- Nhiều `if` độc lập có thể cùng chạy; chúng không tương đương một chuỗi `else if`.
- Toán tử `?:` chọn một giá trị; chỉ một nhánh được đánh giá.
- `switch` với `->` không rơi xuống nhánh tiếp theo. `switch` truyền thống với `:` thường cần `break`.
- Điều kiện biên và thứ tự kiểm tra quyết định đúng sai; `NaN` không lớn hơn hay nhỏ hơn bất kỳ số nào.

## Lỗi người mới thường gặp

- Kiểm tra `score >= 5` trước `score >= 8.5` trong cùng chuỗi rồi không bao giờ đến nhánh giỏi.
- Bỏ sót dấu bằng ở mốc như `5`, `7`, `8.5` hoặc trường hợp `0`.
- Đặt dấu `;` ngay sau `if`, khiến phần thân phía sau chạy độc lập.
- Dùng nhiều `if` khi yêu cầu chỉ chọn một loại kết quả.

## Tự kiểm tra

1. Hai `if` độc lập khác `if ... else if` thế nào?
2. Vì sao phải thử đúng giá trị ngưỡng và hai bên ngưỡng?
3. `switch` với `->` có cần `break` để tránh fall-through không?
4. Vì sao `score < 0 || score > 10` chưa loại được `NaN`?

## Ba bài tập từ dễ đến khó

1. **Dễ — Dấu của số:** phân loại các `int` `-3`, `0`, `4`; in lần lượt `Âm`, `Không`, `Dương`. Giải thích vì sao cần xử lý số `0` riêng.
2. **Vừa — Xếp loại:** điểm `double` trong `[0,10]`: từ `8.5` là `Giỏi`, từ `7` là `Khá`, từ `5` là `Đạt`, còn lại `Chưa đạt`. Ngoài miền hoặc `NaN` là `Không hợp lệ`. Thử `8.5, 7.0, 5.0, 4.9, -1.0, NaN`; output tương ứng là `Giỏi, Khá, Đạt, Chưa đạt, Không hợp lệ, Không hợp lệ`. Giải thích thứ tự xét và điều kiện biên.
3. **Khó — Năm nhuận:** với năm `int` dương theo lịch Gregorian, in kết quả cho `1900, 2000, 2024, 2023`: `false, true, true, false`. Quy tắc: chia hết cho `400`, hoặc chia hết cho `4` nhưng không chia hết cho `100`. Giải thích vì sao xét chia hết cho `4` đơn thuần là sai.

## Cách học

Đọc và đoán `ConditionDemo.java`; tự thực hiện `ConditionExercise.java`; chỉ xem `ConditionSolution.java` sau khi kiểm tra các trường hợp biên.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
