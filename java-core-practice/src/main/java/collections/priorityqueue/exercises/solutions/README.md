# Đối chiếu sau khi tự làm: PriorityQueue theo số tự nhiên

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.priorityqueue.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS PQ: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## PQ-01 — Lấy k phần tử nhỏ nhất

Nạp vào PriorityQueue<Integer>, poll có giới hạn. Chi phí tổng có thể O(n log n), không cần tối ưu thêm.

Đối chiếu đoạn kiểm tra có mã `PQ-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## PQ-02 — Peek sau khi chèn mới

Kết quả poll=3, peek=1, poll=1, size=2. Đây là ưu tiên, không phải thời gian tới.

Đối chiếu đoạn kiểm tra có mã `PQ-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## PQ-03 — Xem trước làm mất dữ liệu

Poll bản sao PriorityQueue<Integer>. Sao chép nông đủ vì Integer bất biến.

Đối chiếu đoạn kiểm tra có mã `PQ-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## PQ-04 — Ghép hai đoạn ngắn nhất

Validate độ dài và tổng trước nạp; lấy hai min, ghép và offer lại. Chi phí long tránh overflow tổng nhiều lượt.

Đối chiếu đoạn kiểm tra có mã `PQ-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## PQ-05 — Bộ lịch đợi theo thời điểm

Một phương án: class giữ PriorityQueue<Integer>. add validate; takeDue lặp kiểm tra peek rồi poll vào ArrayList, không cần Map.

Đối chiếu đoạn kiểm tra có mã `PQ-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
