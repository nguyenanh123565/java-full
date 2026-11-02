# Tự làm cuối mục: PriorityQueue theo số tự nhiên

Tiên quyết: Collections đến Deque; chỉ dùng PriorityQueue<Integer> theo thứ tự tự nhiên. Comparator/job có thứ tự riêng trong bài cũ chỉ làm lại sau comparable_comparator.

Đã có: PriorityQueueExercise.java đã luyện min/max và Job comparator. Bộ mới tránh kiến thức đến sau, luyện sao chép heap, lấy k nhỏ nhất và ghép chi phí. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.priorityqueue.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## PQ-01 — Lấy k phần tử nhỏ nhất

- **Dạng / mức độ:** Cơ bản · Vừa.
- **Kiến thức luyện:** Natural ordering, poll và bản sao queue.
- **Bối cảnh và yêu cầu:** Viết smallest(values,k) trả tối đa k số nhỏ nhất theo tăng dần, giữ phần tử trùng; không sửa List nguồn. k<0 ném IllegalArgumentException.
- **Đầu vào / kết quả / ví dụ sử dụng:** [7,2,5,2],k=3 → [2,2,5].
- **Biên và chính sách:** k=0; k>size; rỗng; số âm; không null.
- **Hoàn thành khi:** Đúng thứ tự/trùng và không dùng iterator làm kết quả đã sắp.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## PQ-02 — Peek sau khi chèn mới

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Ưu tiên khác FIFO.
- **Bối cảnh và yêu cầu:** Từ queue=[6,3,8], lấy poll, thêm 1 rồi peek, poll, size. Dự đoán kết quả; không suy luận từ toString.
- **Đầu vào / kết quả / ví dụ sử dụng:** Tự ghi bốn giá trị trước khi chạy.
- **Biên và chính sách:** Thêm giá trị bằng min hiện tại; rỗng thì peek=null.
- **Hoàn thành khi:** Giải thích phần tử mới có thể được lấy trước phần tử cũ.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## PQ-03 — Xem trước làm mất dữ liệu

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Mutation khi poll, copy constructor.
- **Bối cảnh và yêu cầu:** Hàm preview phải trả toàn bộ giá trị tăng dần nhưng giữ nguyên queue đầu vào. Sửa đoạn code đang poll trực tiếp nguồn. Không ép toString/for-each thành dữ liệu sắp xếp.
- **Đầu vào / kết quả / ví dụ sử dụng:** Queue 4,1,3 → preview [1,3,4], queue vẫn size=3, peek=1.
- **Biên và chính sách:** Rỗng; toàn trùng; gọi preview hai lần phải ra cùng kết quả.
- **Hoàn thành khi:** Không làm thay đổi nguồn và không dựa vào thứ tự iterator.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
List<Integer> result = new ArrayList<>();
while (!queue.isEmpty()) result.add(queue.poll());
return result;
```

## PQ-04 — Ghép hai đoạn ngắn nhất

- **Dạng / mức độ:** Vận dụng · Khó.
- **Kiến thức luyện:** Heap, vòng lặp và tổng long.
- **Bối cảnh và yêu cầu:** Cho độ dài int không âm. Mỗi lượt lấy hai đoạn ngắn nhất, ghép thành đoạn tổng, cộng tổng này vào chi phí rồi đưa lại vào heap. Trả chi phí long. Để không cần heap Long, giới hạn tổng mọi độ dài <= Integer.MAX_VALUE; vượt giới hạn ném IllegalArgumentException.
- **Đầu vào / kết quả / ví dụ sử dụng:** [1,2,3,4] → ghép 1+2=3,3+3=6,4+6=10, tổng chi phí 19.
- **Biên và chính sách:** 0/1 đoạn →0; độ dài 0; số âm; tổng quá giới hạn. Không yêu cầu chứng minh tối ưu tổng quát.
- **Hoàn thành khi:** Mỗi lượt đúng hai min, không overflow kiểm tra tổng, kết thúc còn tối đa một đoạn.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## PQ-05 — Bộ lịch đợi theo thời điểm

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** PriorityQueue + List + OOP.
- **Bối cảnh và yêu cầu:** Nhập mảng deadline int không âm, mỗi giá trị là phút hẹn tương đối; nhiều lịch cùng phút là các sự kiện riêng. Viết due(deadlines,now) trả tất cả phút <=now theo tăng dần, remaining giữ các phút còn lại trong queue. Dùng class có add và takeDue; không cần Job/comparator.
- **Đầu vào / kết quả / ví dụ sử dụng:** Thêm 9,3,3,12; takeDue(8)→[3,3]; takeDue(20)→[9,12].
- **Biên và chính sách:** now<0 từ chối; queue rỗng; deadline=now được lấy; deadline âm không được thêm.
- **Hoàn thành khi:** Không bỏ trùng và không lấy sớm; trả list mới; giải thích khác Queue FIFO. Không bắt buộc Map nếu thiết kế không cần.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
