# Đối chiếu sau khi tự làm: Tổng kết exception

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes exception.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS EX: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## EX-01 — Phân loại và chọn nơi xử lý

NumberFormatException/IllegalArgumentException unchecked; hai loại còn lại checked. Chỗ hiểu cách phản hồi dữ liệu lỗi là nơi catch hợp lý.

Đối chiếu đoạn kiểm tra có mã `EX-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EX-02 — Một catch cho cả batch

Try ngoài loop dừng ở bad nên không parse5; try từng lượt tiếp tới5. Policy phải do yêu cầu quyết định.

Đối chiếu đoạn kiểm tra có mã `EX-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EX-03 — Mất nguyên nhân và báo thành công giả

Sửa parser giữ cause; caller catch ParseException và trả thông báo lỗi rõ. Không ép tất cả lỗi thành dữ liệu hợp lệ.

Đối chiếu đoạn kiểm tra có mã `EX-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EX-04 — Đổi hồ sơ nguyên vẹn

Một phương án: parser checked cho định dạng, validate miền tuổi/tên, rồi gán name và age ở cuối.

Đối chiếu đoạn kiểm tra có mã `EX-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EX-05 — Nhập kho theo dòng có báo lỗi

ReferenceSolution dùng Warehouse có addLine; parser giữ cause; custom exception chứa dữ liệu; main xử lý từng dòng. Không cần framework hay transaction.

Đối chiếu đoạn kiểm tra có mã `EX-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
