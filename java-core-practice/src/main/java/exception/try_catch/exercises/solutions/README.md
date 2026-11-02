# Đối chiếu sau khi tự làm: Try / catch / finally

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes exception.try_catch.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS TC: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## TC-01 — Đếm bản ghi đọc được

Mỗi lượt try parse, thành công tăng ok, catch tăng errors. Đặt try ngoài vòng lặp sẽ dừng sớm không đúng hợp đồng.

Đối chiếu đoạn kiểm tra có mã `TC-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TC-02 — Luồng thoát khỏi try

Hợp lệ: ABFZ; sai định dạng: ACFZ. Dòng B bị bỏ qua khi parse ném lỗi.

Đối chiếu đoạn kiểm tra có mã `TC-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TC-03 — Finally che kết quả

Return ở finally ghi đè kết quả từ try/catch. Giữ return trong try/catch và không return ở finally.

Đối chiếu đoạn kiểm tra có mã `TC-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TC-04 — Resource có đóng khi lỗi?

Một phương án: Probe p=new Probe(); try(p){parse}; catch NumberFormatException; sau đó check p.closed. JVM sinh logic đóng resource.

Đối chiếu đoạn kiểm tra có mã `TC-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TC-05 — Báo cáo tổng và dữ liệu lỗi

Một phương án: Report bất biến tạo cuối vòng lặp, catch NumberFormatException từng dòng. Dùng long cho tổng, không nuốt lỗi mà đếm rõ.

Đối chiếu đoạn kiểm tra có mã `TC-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
