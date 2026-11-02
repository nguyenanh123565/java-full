# Đối chiếu sau khi tự làm: Queue FIFO

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.queue.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS QU: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## QU-01 — Xử lý theo lô

Lặp khi count<max và !isEmpty; add poll vào kết quả. Không dùng peek để xử lý xong.

Đối chiếu đoạn kiểm tra có mã `QU-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## QU-02 — Peek hai lần không tiến hàng

Kết quả A,A,A,B,1. Hai peek đầu không làm tiến hàng.

Đối chiếu đoạn kiểm tra có mã `QU-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## QU-03 — Retry vô hạn

Một phương án: Job có attempts; poll, tăng attempts, quyết định SUCCESS/requeue/FAILED. Có giới hạn mới đảm bảo kết thúc.

Đối chiếu đoạn kiểm tra có mã `QU-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## QU-04 — Quầy phục vụ theo lượt

Một phương án: Queue private, validate ở join, poll khi phục vụ. Không cần xem null như tên hợp lệ.

Đối chiếu đoạn kiểm tra có mã `QU-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## QU-05 — Lịch chạy công việc không trùng

Một phương án: Queue pendingOrder và Set pendingIds. next lấy đầu rồi xóa id trong set, nhờ đó có thể submit lại.

Đối chiếu đoạn kiểm tra có mã `QU-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
