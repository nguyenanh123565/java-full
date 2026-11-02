# Tự làm cuối mục: Queue FIFO

Tiên quyết: Các mục List/Set/Map và kiến thức trước Collections; ArrayDeque dùng qua Queue, chưa cần Deque riêng.

Đã có: QueueExercise.java đã luyện API rỗng và thêm D khi xử lý A. Bộ mới có xử lý theo lượt hữu hạn, retry và chặn trùng. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.queue.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## QU-01 — Xử lý theo lô

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** offer/poll, giới hạn lượt.
- **Bối cảnh và yêu cầu:** Viết drain(queue,max) lấy tối đa max phần tử đầu vào một List, phần dư vẫn nằm trong queue; max<0 ném IllegalArgumentException.
- **Đầu vào / kết quả / ví dụ sử dụng:** queue=[A,B,C], max=2 → kết quả [A,B], queue=[C].
- **Biên và chính sách:** max=0; max lớn hơn size; queue rỗng; không chứa null.
- **Hoàn thành khi:** FIFO đúng, chỉ xóa số phần tử thực sự trả.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## QU-02 — Peek hai lần không tiến hàng

- **Dạng / mức độ:** Suy luận · Dễ.
- **Kiến thức luyện:** Phân biệt đọc và lấy.
- **Bối cảnh và yêu cầu:** Từ queue=[A,B], gọi peek, peek, poll, peek rồi size. Ghi từng kết quả và trạng thái sau mỗi lệnh trước khi chạy.
- **Đầu vào / kết quả / ví dụ sử dụng:** Tự ghi chuỗi năm kết quả và giải thích.
- **Biên và chính sách:** So sánh queue rỗng với một phần tử.
- **Hoàn thành khi:** Giải thích được vì sao hai lần xem không bỏ qua B.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## QU-03 — Retry vô hạn

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Vòng lặp, retry giới hạn.
- **Bối cảnh và yêu cầu:** Code cứ đưa BAD về cuối nên không bao giờ dừng. Sửa để mỗi Job được thử tối đa 2 lần; BAD luôn thất bại, OK luôn thành công; trả danh sách mã đã kết thúc kèm SUCCESS/FAILED.
- **Đầu vào / kết quả / ví dụ sử dụng:** [BAD,OK] → thứ tự kết thúc [OK:SUCCESS,BAD:FAILED].
- **Biên và chính sách:** Rỗng; toàn BAD; attempts tăng đúng một lần mỗi lần xử lý.
- **Hoàn thành khi:** Dừng hữu hạn, không retry sau mức giới hạn và không mất job thành công.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
while (!jobs.isEmpty()) {
    String job = jobs.poll();
    if (job.equals("BAD")) jobs.offer(job);
}
```

## QU-04 — Quầy phục vụ theo lượt

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Encapsulation và FIFO.
- **Bối cảnh và yêu cầu:** Tạo ServiceDesk.join(name) và serveNext(); serveNext trả null khi hết khách, tên null/trắng bị từ chối. sizePending() chỉ đếm người chờ.
- **Đầu vào / kết quả / ví dụ sử dụng:** join An,Bao; serveNext→An; join Chi; phục vụ tiếp Bao,Chi,null.
- **Biên và chính sách:** Phục vụ ngay từ đầu; hai người trùng tên vẫn là hai lượt; dữ liệu sai không thêm khách.
- **Hoàn thành khi:** Thứ tự đúng và không dùng cấu trúc global; giải thích chính sách trùng tên.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## QU-05 — Lịch chạy công việc không trùng

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Queue + Set và trạng thái pending.
- **Bối cảnh và yêu cầu:** Tạo Scheduler.submit(id) trả false khi id đã đang chờ; next() lấy/xóa id đầu và cho phép submit lại id sau khi đã lấy. id null/trắng không hợp lệ. Không giữ lịch sử chạy vĩnh viễn.
- **Đầu vào / kết quả / ví dụ sử dụng:** submit A,B,A → true,true,false; next→A; submit A→true; tiếp theo B,A.
- **Biên và chính sách:** next khi rỗng; submit lặp nhiều lần; hủy ràng buộc pending đúng khi lấy job.
- **Hoàn thành khi:** Queue và Set nhất quán sau mọi thao tác; giải thích vì sao chỉ Set hoặc chỉ List chưa biểu đạt đủ yêu cầu thuận tiện.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
