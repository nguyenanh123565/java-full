# Tự làm cuối mục: LinkedList

Tiên quyết: Đã học ArrayList và các kiến thức trước Collections; chưa cần Queue/Deque theo interface.

Đã có: LinkedListExercise.java đã luyện hai đầu, FIFO và API rỗng. Bộ mới dùng xoay vòng, phần tử null và bộ đệm có giới hạn. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.linkedlist.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## LL-01 — Xoay danh sách một lần

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** pollFirst/addLast, thao tác hai đầu.
- **Bối cảnh và yêu cầu:** Viết rotateOnce(LinkedList<String>) chuyển đầu về cuối khi list không rỗng; sửa trực tiếp list.
- **Đầu vào / kết quả / ví dụ sử dụng:** [A,B,C] → [B,C,A].
- **Biên và chính sách:** Rỗng; một phần tử; không nhận null.
- **Hoàn thành khi:** Đúng thứ tự và size giữ nguyên.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## LL-02 — Null có nghĩa là rỗng?

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** LinkedList cho null, tín hiệu API.
- **Bối cảnh và yêu cầu:** Dự đoán hai kết quả pollFirst và size sau mỗi lần; giải thích vì sao chỉ nhìn null là chưa đủ biết rỗng.
- **Đầu vào / kết quả / ví dụ sử dụng:** List chứa [null,A]; gọi pollFirst, kiểm tra size, rồi pollFirst lần nữa.
- **Biên và chính sách:** So sánh list thực sự rỗng; không gán cùng quy tắc cho ArrayDeque.
- **Hoàn thành khi:** Nêu đúng khác biệt phần tử null với không có phần tử.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## LL-03 — Vòng quay không kết thúc

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Điều kiện dừng, kích thước không đổi.
- **Bối cảnh và yêu cầu:** Code muốn in mỗi người đúng một lần nhưng cứ chuyển đầu về cuối. Giải thích vòng lặp không dừng và sửa để chỉ xử lý n người ban đầu.
- **Đầu vào / kết quả / ví dụ sử dụng:** [An,Bao,Chi] → An,Bao,Chi đúng một lượt, list trở lại ban đầu.
- **Biên và chính sách:** List rỗng/một người; không có người mới tham gia trong lượt.
- **Hoàn thành khi:** Không lặp vô hạn và không làm mất người.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
while (!people.isEmpty()) {
    String p = people.removeFirst();
    System.out.println(p); people.addLast(p);
}
```

## LL-04 — Bộ đệm ba thông báo

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** addLast/removeFirst, giới hạn kích thước.
- **Bối cảnh và yêu cầu:** Tạo RecentMessages(capacity>0), add(message) giữ tối đa capacity thông báo mới nhất theo thứ tự cũ→mới. Từ chối null; trả snapshot độc lập.
- **Đầu vào / kết quả / ví dụ sử dụng:** capacity=3, thêm A,B,C,D → [B,C,D].
- **Biên và chính sách:** capacity=1; capacity<=0; null; thêm trùng được phép.
- **Hoàn thành khi:** Size không vượt capacity và caller không sửa được list nội bộ.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## LL-05 — Chia lượt trực tuần

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Class, validation, xoay vòng, snapshot.
- **Bối cảnh và yêu cầu:** Tạo DutyRoster từ danh sách tên không null/không rỗng; next() trả người đầu và chuyển họ xuống cuối; khi không có người trả null. Chạy k lượt bằng vòng lặp, không loại người.
- **Đầu vào / kết quả / ví dụ sử dụng:** [An,Bao,Chi], k=5 → [An,Bao,Chi,An,Bao], roster còn [Chi,An,Bao].
- **Biên và chính sách:** Danh sách ban đầu rỗng; k=0; tên trùng là hai lượt riêng; từ chối tên trắng.
- **Hoàn thành khi:** Thứ tự luân phiên đúng, không sửa nguồn truyền vào; giải thích vì sao LinkedList không tự nhanh cho get(i).
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
