# Đối chiếu sau khi tự làm: HashSet

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.hashset.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS HS: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## HS-01 — Giao hai nhóm

Duyệt a, kiểm tra b.contains. So sánh kết quả bằng Set.equals thay vì chuỗi in.

Đối chiếu đoạn kiểm tra có mã `HS-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HS-02 — Cùng hash vẫn khác

Kết quả true,true,false và size=2. Hash cố định hợp lệ về hợp đồng nhưng làm giảm hiệu năng.

Đối chiếu đoạn kiểm tra có mã `HS-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HS-03 — Kiểm tra đã tham gia sai

Kiểm tra tên rồi tăng khi add thành công. Không lấy số lần gọi làm số người duy nhất.

Đối chiếu đoạn kiểm tra có mã `HS-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HS-04 — Thiếu ai trong buổi học?

Copy registered và removeAll(present), hoặc lặp và contains. Cả hai đều hợp lý.

Đối chiếu đoạn kiểm tra có mã `HS-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HS-05 — Điểm danh nhiều buổi

Một phương án: registered/seen bằng HashSet và order bằng ArrayList. HashSet không dùng để tái tạo thứ tự.

Đối chiếu đoạn kiểm tra có mã `HS-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
