# Đối chiếu sau khi tự làm: Stream

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes stream.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS STM: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## STM-01 — Tổng độ dài tên hợp lệ

Một phương án: pipeline null-filter→trim→nonblank→mapToInt(length)→sum. Không đặt tổng mutable ngoài forEach.

Đối chiếu đoạn kiểm tra có mã `STM-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## STM-02 — Lười tới terminal thực sự

Sau khai báo trace=[], sau toList trace=[f1,m1,f2,f3,m3], result=[10,30]. Đây là thí nghiệm, logic production nên tránh phụ thuộc side effect.

Đối chiếu đoạn kiểm tra có mã `STM-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## STM-03 — Dùng lại stream đã kết thúc

Tạo stream mới để tính count sau khi sum. Supplier<Stream<Integer>> cũng hợp lý nhưng không cần cho một bài nhỏ.

Đối chiếu đoạn kiểm tra có mã `STM-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## STM-04 — Tổng tồn kho đủ điều kiện

Lọc stock>0, map giá trị long rồi reduce0. Dùng identity1 sẽ sai tổng và dữ liệu rỗng.

Đối chiếu đoạn kiểm tra có mã `STM-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## STM-05 — Báo cáo sản phẩm theo danh mục

ReferenceSolution dùng Report với total,counts,ids, validate duplicate bằng Set rồi tạo các pipeline riêng. Đây chỉ là một phương án; counts theo số object còn hàng.

Đối chiếu đoạn kiểm tra có mã `STM-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
