# Đối chiếu sau khi tự làm: HashMap

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.hashmap.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS HM: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## HM-01 — Gộp số lượng đặt hàng

Duyệt mảng, validate và tăng số đếm bằng getOrDefault. Không cần merge/lambda.

Đối chiếu đoạn kiểm tra có mã `HM-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HM-02 — Null cản giá trị mặc định

Kết quả null,0,true; unbox null gây NullPointerException. Map số lượng nên cấm value null để tránh nhập nhằng.

Đối chiếu đoạn kiểm tra có mã `HM-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HM-03 — Xuất kho thành số âm

Validate amount; nếu thiếu mã hoặc thiếu hàng trả false; cuối cùng mới trừ và put.

Đối chiếu đoạn kiểm tra có mã `HM-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HM-04 — Danh bạ có mã duy nhất

Một phương án: class giữ Map private, add kiểm tra containsKey rồi put, rename làm ngược điều kiện tồn tại.

Đối chiếu đoạn kiểm tra có mã `HM-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## HM-05 — Thống kê phiếu theo lớp

Một phương án: Map mới, mỗi lớp gắn ArrayList riêng; kiểm tra độ dài và dữ liệu trước khi trả. Lỗi hay gặp là tái sử dụng cùng list.

Đối chiếu đoạn kiểm tra có mã `HM-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
