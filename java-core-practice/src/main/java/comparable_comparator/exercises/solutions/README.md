# Đối chiếu sau khi tự làm: Comparable và Comparator

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes comparable_comparator.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS CMP: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## CMP-01 — Thứ tự phiên bản hai số

Một phương án: Comparable so hai int bằng Integer.compare. So chuỗi sẽ đặt 1.10 trước1.2 sai ý nghĩa số.

Đối chiếu đoạn kiểm tra có mã `CMP-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CMP-02 — Compare bằng không có xóa object?

Score tăng ra C,A,B, size3; A/B không equals. Compare0 là ngang theo tiêu chí đang chọn.

Đối chiếu đoạn kiểm tra có mã `CMP-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CMP-03 — Phép trừ phá comparator

Integer.compare(a,b) thay phép trừ. Ép (int)((long)a-b) vẫn có thể làm sai dấu.

Đối chiếu đoạn kiểm tra có mã `CMP-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CMP-04 — Lịch công việc theo chính sách

Một phương án: hai anonymous Comparator<Task>, copy bằng ArrayList trước sort; không lạm dụng một natural order cho mọi use case.

Đối chiếu đoạn kiểm tra có mã `CMP-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## CMP-05 — Bảng xếp hạng có thứ tự ổn định

Một phương án: Runner equals/hashCode theo id, rank validate id duy nhất, sort bản sao bằng comparator riêng rồi lấy limit. Không cần ép bốn tính chất OOP.

Đối chiếu đoạn kiểm tra có mã `CMP-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
