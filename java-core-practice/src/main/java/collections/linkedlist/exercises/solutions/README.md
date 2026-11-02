# Đối chiếu sau khi tự làm: LinkedList

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.linkedlist.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS LL: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## LL-01 — Xoay danh sách một lần

Nếu không rỗng, addLast(removeFirst()). Không lặp get(i) cho thao tác hai đầu.

Đối chiếu đoạn kiểm tra có mã `LL-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LL-02 — Null có nghĩa là rỗng?

Lần một trả null nhưng size còn 1; lần hai trả A, size=0. Chính sách không nhận null làm API rõ hơn.

Đối chiếu đoạn kiểm tra có mã `LL-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LL-03 — Vòng quay không kết thúc

Lưu n=list.size(); lặp n lần, mỗi lần removeFirst rồi addLast. Không dùng isEmpty làm điều kiện khi luôn thêm lại.

Đối chiếu đoạn kiểm tra có mã `LL-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LL-04 — Bộ đệm ba thông báo

Một phương án: LinkedList private, addLast và removeFirst khi size>capacity, snapshot mới.

Đối chiếu đoạn kiểm tra có mã `LL-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## LL-05 — Chia lượt trực tuần

Một phương án: copy list, validate tên, next dùng removeFirst/addLast. Rỗng trả null theo hợp đồng.

Đối chiếu đoạn kiểm tra có mã `LL-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
