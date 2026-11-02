# Tự làm cuối mục: Comparable và Comparator

Tiên quyết: Đã học Collections và enum theo README gốc. Lời giải mới dùng anonymous class Comparator, chưa yêu cầu lambda/method reference.

Đã có: ComparableComparatorExercise.java đã có Product theo id/giá và reversed. Bộ mới có version nhiều thành phần, equality khác ordering, overflow và bảng xếp hạng. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes comparable_comparator.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## CMP-01 — Thứ tự phiên bản hai số

- **Dạng / mức độ:** Cơ bản · Vừa.
- **Kiến thức luyện:** Comparable, lexicographic ordering.
- **Bối cảnh và yêu cầu:** Tạo Version(major,minor), hai số không âm, implements Comparable<Version>: major tăng trước, nếu bằng thì minor tăng; equals/hashCode cũng theo cả hai. Không so chuỗi version hoặc trừ hai int.
- **Đầu vào / kết quả / ví dụ sử dụng:** [2.0,1.10,1.2] → [1.2,1.10,2.0].
- **Biên và chính sách:** 0.0; hai version bằng nhau; MIN không hợp lệ; MAX_VALUE hợp lệ.
- **Hoàn thành khi:** Tự nhiên đúng cả 1.10 và1.2; dấu compare nhất quán, không tràn.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## CMP-02 — Compare bằng không có xóa object?

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Comparator, equality, List.sort.
- **Bối cảnh và yêu cầu:** Hai Runner có id khác nhau nhưng score=10, equals theo id. Comparator chỉ theo score trả0. Dự đoán List sau sort còn mấy runner và quan hệ equals của hai object; nêu vì sao List.sort không tự loại phần tử.
- **Đầu vào / kết quả / ví dụ sử dụng:** Runner A=10,B=10,C=5; sắp score tăng; tự ghi size và thứ tự các điểm.
- **Biên và chính sách:** Hai runner cùng id nhưng khác điểm; không suy ra compare0 luôn bằng equals; không dùng TreeSet nếu chưa muốn mở rộng.
- **Hoàn thành khi:** Dự đoán size, quan hệ equals và thứ tự đúng theo hợp đồng; hiểu tie thuộc thứ tự chứ không tự gộp identity.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## CMP-03 — Phép trừ phá comparator

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Overflow và hợp đồng so sánh.
- **Bối cảnh và yêu cầu:** Comparator int trả a-b. Dùng a=Integer.MIN_VALUE,b=1 để chứng minh sai dấu, rồi sửa. Kiểm tra cặp ngược, bằng nhau và tính bắc cầu với bộ MIN_VALUE,0,MAX_VALUE.
- **Đầu vào / kết quả / ví dụ sử dụng:** So MIN_VALUE với1 phải âm; so1 với MIN_VALUE phải dương.
- **Biên và chính sách:** Cực trị; hai số bằng; không ép long rồi cast lại int.
- **Hoàn thành khi:** Dùng Integer.compare hoặc Long.compare đúng kiểu, có test dấu và bắc cầu.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
Comparator<Integer> broken = new Comparator<Integer>() {
    public int compare(Integer a, Integer b) { return a - b; }
};
```

## CMP-04 — Lịch công việc theo chính sách

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Comparator bên ngoài và tie-break.
- **Bối cảnh và yêu cầu:** Task có id String không trắng và estimatedMinutes int>=0. Viết hai Comparator: id tăng; thời lượng tăng rồi id tăng. Sắp bản sao của cùng nguồn theo hai chính sách; không đổi class để thay thứ tự.
- **Đầu vào / kết quả / ví dụ sử dụng:** [B=20,A=20,C=5] → theo id [A,B,C]; theo thời lượng [C,A,B].
- **Biên và chính sách:** Rỗng; bằng thời lượng; thời lượng MAX_VALUE; không null.
- **Hoàn thành khi:** Không sửa nguồn, quy tắc độc lập và tie-break rõ. Dùng anonymous class hoặc class riêng, chưa cần lambda.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## CMP-05 — Bảng xếp hạng có thứ tự ổn định

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** OOP, equality, comparator và snapshot.
- **Bối cảnh và yêu cầu:** Tự thiết kế Runner(id,score) id duy nhất, score int>=0. rank(source,limit) trả tối đa limit runner theo score giảm, hòa id tăng, giữ nguồn. Từ chối duplicate id thay vì lặng lẽ gộp; limit<0 ném IllegalArgumentException. Giải thích dữ liệu nhận diện và tiêu chí ranking độc lập.
- **Đầu vào / kết quả / ví dụ sử dụng:** [B=10,A=10,C=20],limit2 → [C,A].
- **Biên và chính sách:** limit0; limit>size; rỗng; duplicate id dù khác score; MAX_VALUE; không null.
- **Hoàn thành khi:** Thứ tự, tie-break, duplicate policy và nguồn giữ nguyên; không bắt buộc Runner implements Comparable nếu không có natural order hợp lý.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
