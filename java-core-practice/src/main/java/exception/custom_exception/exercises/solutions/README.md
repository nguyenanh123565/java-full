# Đối chiếu sau khi tự làm: Custom exception

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes exception.custom_exception.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS CE: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## CE-01 — Ngoại lệ hết chỗ

Exception extends Exception có hai field final; reserve kiểm tra và chỉ trừ sau khi hợp lệ.

Đối chiếu đoạn kiểm tra có mã `CE-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CE-02 — Catch quyết định có tiếp tục

Trạng thái 1,1,0; nhãn OK,FAIL,OK. Catch ngoài cả loop sẽ bỏ phần còn lại sau exception.

Đối chiếu đoạn kiểm tra có mã `CE-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CE-03 — Trừ trước khi kiểm tra

Đưa validation và kiểm tra thiếu chỗ lên trước phép trừ. Exception không khôi phục trạng thái giúp bạn.

Đối chiếu đoạn kiểm tra có mã `CE-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CE-04 — Huỷ chỗ không vượt sức chứa

Một phương án: capacity final, available private; reserve kiểm tra đủ, cancel kiểm tra số đang đặt, rồi cập nhật.

Đối chiếu đoạn kiểm tra có mã `CE-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CE-05 — Hai khu chỗ phối hợp

Một phương án: Booking giữ hai số remaining và custom exception có section. Validate cặp, kiểm tra A và B, cuối cùng mới trừ cả hai; không cần ép kế thừa.

Đối chiếu đoạn kiểm tra có mã `CE-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
