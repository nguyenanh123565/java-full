# Tự làm cuối mục: Deque

Tiên quyết: Các mục Collections đến Queue; chưa cần comparator, lambda hay Stream.

Đã có: DequeExercise.java đã luyện FIFO/LIFO và lịch sử undo chỉ mô phỏng. Bộ mới thêm palindrome, sửa sai đầu và undo/redo thực sự. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.deque.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## DQ-01 — Ghép hai đầu

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** offerFirst/offerLast/pollFirst/pollLast.
- **Bối cảnh và yêu cầu:** Từ deque rỗng, thêm cuối B, thêm đầu A, thêm cuối C; viết takeEnds trả List gồm phần tử đầu rồi cuối, lấy tối đa hai phần tử.
- **Đầu vào / kết quả / ví dụ sử dụng:** [A,B,C] → [A,C], deque còn [B].
- **Biên và chính sách:** Rỗng → []; một phần tử → [A], không lấy hai lần cùng phần tử.
- **Hoàn thành khi:** Sử dụng đúng đầu và size giảm theo số phần tử trả.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## DQ-02 — Trộn stack và queue

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** push/pop ở đầu deque.
- **Bối cảnh và yêu cầu:** Dự đoán lần lượt deque sau offerLast(A), push(B), offerLast(C), rồi giá trị pop và pollLast; nêu phần còn lại.
- **Đầu vào / kết quả / ví dụ sử dụng:** Tự vẽ deque đầu→cuối sau mỗi bước.
- **Biên và chính sách:** Thử chỉ có một phần tử; pop rỗng là ngoại lệ.
- **Hoàn thành khi:** Nêu đúng đầu thao tác, không diễn giải push như thêm cuối.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## DQ-03 — Redo bị đảo thứ tự

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Hai stack, lịch sử thao tác.
- **Bối cảnh và yêu cầu:** Mô hình editor có text string và hai stack. Sau append A, append B, undo hai lần, redo hai lần phải khôi phục AB. Code undo đẩy bản cũ sang CUỐI redo trong khi redo lấy ĐẦU. Sửa quy ước thống nhất.
- **Đầu vào / kết quả / ví dụ sử dụng:** AB → undo A → undo chuỗi rỗng → redo A → redo AB.
- **Biên và chính sách:** Undo/redo rỗng không đổi text; sau undo rồi append C phải xóa redo.
- **Hoàn thành khi:** Thứ tự khôi phục đúng và không làm mất bản mới nhất.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
// Lỗi quy ước trong undo; giả sử history không rỗng:
redo.offerLast(text);
text = undo.pop();
// redo lại dùng redo.pop() ở đầu.
```

## DQ-04 — Kiểm tra chuỗi đối xứng bằng deque

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Hai đầu, String, vòng lặp.
- **Bối cảnh và yêu cầu:** Viết palindrome(String) cho chuỗi ASCII: phân biệt hoa/thường và tính cả khoảng trắng; đưa ký tự vào deque, so đầu/cuối đến khi còn <=1. Không dùng đảo chuỗi có sẵn.
- **Đầu vào / kết quả / ví dụ sử dụng:** abba→true; abcba→true; Abba→false; ab→false.
- **Biên và chính sách:** Chuỗi rỗng/một ký tự →true; input không null; chỉ ASCII để không phải học Unicode code point.
- **Hoàn thành khi:** Trả đúng và giải thích điều kiện dừng; không mất ký tự giữa.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## DQ-05 — Editor undo/redo bằng snapshot

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Class, trạng thái, hai stack.
- **Bối cảnh và yêu cầu:** Tạo Editor.text(), append(nonEmptyText), undo(), redo(). undo/redo trả boolean có thay đổi không. Mỗi append lưu toàn bộ chuỗi trước đó; append sau undo xóa nhánh redo. Không cần editor GUI hay tối ưu bộ nhớ.
- **Đầu vào / kết quả / ví dụ sử dụng:** append A,B → AB; undo→A; append C→AC; redo→false, text vẫn AC.
- **Biên và chính sách:** Editor mới undo/redo=false; append null/rỗng ném IllegalArgumentException không đổi history; nhiều lượt qua lại.
- **Hoàn thành khi:** Khôi phục đúng text thực sự, có test lịch sử rẽ nhánh; giải thích trách nhiệm hai stack. Thiết kế có thể khác.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
