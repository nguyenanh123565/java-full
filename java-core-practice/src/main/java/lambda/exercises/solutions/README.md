# Đối chiếu sau khi tự làm: Lambda và functional interface

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes lambda.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS LAM: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## LAM-01 — Ba vai trò của hành vi

Một phương án: text->text.length(), text->logs.add(text), ()->"DEFAULT"; Consumer vẫn trả void ở hợp đồng dù List.add có giá trị.

Đối chiếu đoạn kiểm tra có mã `LAM-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LAM-02 — Khai báo không phải thực thi

Sau khai báo [], sau lần1 [3], sau lần2 [3,4]; kết quả 6 và8. Reference capture effectively final không làm list bất biến.

Đối chiếu đoạn kiểm tra có mã `LAM-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LAM-03 — Capture biến bị gán lại

Lưu snapshot vào local final/effectively final rồi lambda capture snapshot. Đây là chọn semantics, không phải ép mutable holder.

Đối chiếu đoạn kiểm tra có mã `LAM-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LAM-04 — Chính sách kiểm tra kết hợp

Một phương án: ba Predicate và and theo thứ tự an toàn. and ngắn mạch nên không gọi trim khi null.

Đối chiếu đoạn kiểm tra có mã `LAM-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LAM-05 — Pipeline xử lý tên có cấu hình

ReferenceSolution duyệt từng T, test predicate, apply function, add và accept. chooseName chỉ get supplier khi thiếu. Không gọi supplier trước khi biết cần.

Đối chiếu đoạn kiểm tra có mã `LAM-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
