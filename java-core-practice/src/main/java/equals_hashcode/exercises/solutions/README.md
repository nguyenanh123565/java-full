# Đối chiếu sau khi tự làm: Equals và hashCode

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes equals_hashcode.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS EQ: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## EQ-01 — Tọa độ theo giá trị

Một phương án: final int x,y; equals kiểm tra instanceof Point rồi x/y; hash=31*Integer.hashCode(x)+Integer.hashCode(y). Collision không phá equality.

Đối chiếu đoạn kiểm tra có mã `EQ-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EQ-02 — Bộ ba hợp đồng

Các phép equals cùng tọa độ true, null false, hash cùng true. Hash khác loại khả năng equals; hash giống không chứng minh equals.

Đối chiếu đoạn kiểm tra có mã `EQ-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EQ-03 — Overload bị tưởng là override

Đổi thành public boolean equals(Object other), instanceof đúng class, so id.equals và override hashCode theo id. Cast caller không sửa hợp đồng.

Đối chiếu đoạn kiểm tra có mã `EQ-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EQ-04 — Định danh ấn bản sách

Một phương án: final class với isbn final và edition final, constructor validate; equals/hashCode đều dùng hai field.

Đối chiếu đoạn kiểm tra có mã `EQ-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## EQ-05 — Đếm giá trị duy nhất không dùng Set

Duyệt i, tìm j<i bằng nhau; nếu không tìm thì tăng count. Khi dùng HashSet về sau, hashCode giúp tìm ứng viên nên phải cùng hợp đồng với equals.

Đối chiếu đoạn kiểm tra có mã `EQ-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
