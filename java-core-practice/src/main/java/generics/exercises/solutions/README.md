# Đối chiếu sau khi tự làm: Generics

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes generics.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS GEN: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## GEN-01 — Cặp hai kiểu độc lập

Một phương án: class Pair<L,R> có hai field final. Generic dùng kiểu tham chiếu, int phải thành Integer.

Đối chiếu đoạn kiểm tra có mã `GEN-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## GEN-02 — Invariance qua biến cha

Dòng Slot<Number> n=ints không compile; Slot<? extends Number> view=ints compile và đọc Number được.

Đối chiếu đoạn kiểm tra có mã `GEN-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## GEN-03 — Raw type phá hàng rào kiểu

Dùng Slot<String> typed=s; chỉ set String. Generic chuyển lỗi sai kiểu sang compile; không giải quyết bằng cast.

Đối chiếu đoạn kiểm tra có mã `GEN-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## GEN-04 — Tổng bình phương các Number

Duyệt T, đọc doubleValue rồi cộng x*x. Bound Number là khả năng cần dùng, không phải kiểm tra instanceof từng wrapper.

Đối chiếu đoạn kiểm tra có mã `GEN-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## GEN-05 — Kết quả thành công hoặc thất bại

Một phương án: private constructor với boolean,value,error và hai static <T> factory; getter kiểm tra trạng thái. Lỗi thường gặp: static dùng T của class trực tiếp.

Đối chiếu đoạn kiểm tra có mã `GEN-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
