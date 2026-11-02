# Đối chiếu sau khi tự làm: Deque

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.deque.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS DQ: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## DQ-01 — Ghép hai đầu

Nếu không rỗng add pollFirst; kiểm tra tiếp trước pollLast. Không lặp lại phần tử khi chỉ có một.

Đối chiếu đoạn kiểm tra có mã `DQ-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## DQ-02 — Trộn stack và queue

pop trả B, pollLast trả C, còn A. Những thao tác này chủ ý dùng cả hai đầu.

Đối chiếu đoạn kiểm tra có mã `DQ-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## DQ-03 — Redo bị đảo thứ tự

Dùng push/pop cho cả hai stack. Khi undo: redo.push(text), text=undo.pop(); redo làm ngược lại. append mới clear redo.

Đối chiếu đoạn kiểm tra có mã `DQ-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## DQ-04 — Kiểm tra chuỗi đối xứng bằng deque

Nạp Character vào ArrayDeque; pollFirst/pollLast và equals; sai một cặp trả false.

Đối chiếu đoạn kiểm tra có mã `DQ-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## DQ-05 — Editor undo/redo bằng snapshot

Một phương án: hai ArrayDeque<String> private. append đẩy text cũ vào undo, nối chuỗi rồi clear redo; undo/redo chuyển snapshot qua hai stack.

Đối chiếu đoạn kiểm tra có mã `DQ-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
