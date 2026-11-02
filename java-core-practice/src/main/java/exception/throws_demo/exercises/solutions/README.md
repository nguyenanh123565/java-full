# Đối chiếu sau khi tự làm: Throw, throws và lan truyền

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes exception.throws_demo.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS TH: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## TH-01 — Parser mã số có ngữ cảnh

Parse trong try, chuyển NumberFormatException và giữ cause. Kiểm tra âm riêng ngoài catch để không lẫn hợp đồng.

Đối chiếu đoạn kiểm tra có mã `TH-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TH-02 — Throws không tự chạy catch

parseId tạo ParseException; middle/outer chỉ truyền. Với x dòng OK bị bỏ qua; throws không đảm bảo luôn có lỗi.

Đối chiếu đoạn kiểm tra có mã `TH-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TH-03 — Bắt rồi trả id giả

Service chỉ return parseId(text) với throws ParseException. Không cần bọc thêm khi không thêm ngữ cảnh.

Đối chiếu đoạn kiểm tra có mã `TH-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TH-04 — Đọc một cặp tọa độ

Kiểm tra null, split(",",-1), đòi đúng hai phần; chuyển lỗi số thành ParseException với cause. Không gọi parseId vì tọa độ âm hợp lệ.

Đối chiếu đoạn kiểm tra có mã `TH-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## TH-05 — Dừng cả lô hay tiếp từng dòng?

Một phương án: cấp mảng kết quả đúng độ dài, parse từng dòng; khi lỗi bọc thêm dòng và ném. Mảng chưa hoàn chỉnh không thoát ra ngoài.

Đối chiếu đoạn kiểm tra có mã `TH-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
