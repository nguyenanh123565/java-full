# Tự làm cuối mục: Lambda và functional interface

Tiên quyết: OOP interface, generics, Collections và Comparator. Chỉ xử lý bằng vòng lặp, chưa dùng Stream.

Đã có: LambdaExercise.java đã có nhân3, predicate tuổi và andThen giảm giá/thuế. Bộ mới dùng Function/Consumer/Supplier, đánh giá khi gọi và pipeline cấu hình. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes lambda.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## LAM-01 — Ba vai trò của hành vi

- **Dạng / mức độ:** Cơ bản · Vừa.
- **Kiến thức luyện:** Function, Consumer, Supplier.
- **Bối cảnh và yêu cầu:** Tạo Function<String,Integer> trả độ dài, Consumer<String> thêm vào List log và Supplier<String> trả nhãn DEFAULT. Gọi rõ apply/accept/get và ghi vai trò input/output của mỗi interface.
- **Đầu vào / kết quả / ví dụ sử dụng:** length.apply("Java")→4; log.accept("A") làm logs=[A]; fallback.get()→DEFAULT.
- **Biên và chính sách:** Chuỗi rỗng→độ dài0; input không null; khai báo Consumer chưa tự ghi log.
- **Hoàn thành khi:** Đúng kiểu trả về và gọi đúng method; không nhầm Consumer trả kết quả biến đổi.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## LAM-02 — Khai báo không phải thực thi

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Thời điểm gọi lambda và capture object.
- **Bối cảnh và yêu cầu:** Dự đoán logs sau khai báo op, sau applyAsInt(3), sau applyAsInt(4); phân biệt capture reference list với việc gán lại biến local.
- **Đầu vào / kết quả / ví dụ sử dụng:** Dùng đoạn minh họa và ghi số lần thân lambda chạy trước khi chạy thật.
- **Biên và chính sách:** Không gọi thì log rỗng; biến logs không gán lại, nội dung list có thể thay đổi; chưa nói về đa luồng.
- **Hoàn thành khi:** Giải thích đúng effectively final chỉ ràng buộc biến local tham chiếu.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
List<Integer> logs = new ArrayList<>();
IntUnaryOperator op = value -> { logs.add(value); return value * 2; };
```

## LAM-03 — Capture biến bị gán lại

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Effectively final và scope.
- **Bối cảnh và yêu cầu:** Đoạn code không compile vì bonus bị gán lại sau capture. Sửa theo yêu cầu: op phải giữ bonus lúc tạo là2; bonus hiển thị sau đó có thể là5. Không dùng mảng một phần tử để lách quy tắc.
- **Đầu vào / kết quả / ví dụ sử dụng:** op.applyAsInt(3)→5; bonus hiện tại=5.
- **Biên và chính sách:** Bonus0/âm; cần tạo hành vi mới nếu muốn capture giá trị khác.
- **Hoàn thành khi:** Source hợp lệ và giải thích vì sao biến snapshot final phù hợp ý nghĩa.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
int bonus = 2;
IntUnaryOperator op = value -> value + bonus;
bonus = 5;
```

## LAM-04 — Chính sách kiểm tra kết hợp

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Predicate.and/or/negate và short-circuit.
- **Bối cảnh và yêu cầu:** Tạo Predicate<String> cho mã không null, không trắng và dài<=5 sau trim. Ghép bằng and với kiểm tra null đứng trước; lọc bằng vòng lặp và giữ nguyên chuỗi gốc.
- **Đầu vào / kết quả / ví dụ sử dụng:** [null," A ","      ","ABCDEF","BC"] → [" A ","BC"].
- **Biên và chính sách:** Rỗng; chỉ khoảng trắng; độ dài sau trim=5; tránh NPE bằng short-circuit.
- **Hoàn thành khi:** Dùng Predicate có ý nghĩa, không dùng Stream; giải thích vì sao thứ tự and quan trọng khi dữ liệu null.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## LAM-05 — Pipeline xử lý tên có cấu hình

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Generic method, Predicate, Function, Consumer, Supplier.
- **Bối cảnh và yêu cầu:** Viết <T,R> List<R> process(source,accept,transform,onResult): lặp nguồn, chỉ khi predicate true thì transform, thêm kết quả và gọi consumer đúng một lần. Dùng để nhận tên không null/trắng, trim rồi ghi log tên đã chuẩn hóa. Viết thêm chooseName(name,Supplier<String>) chỉ gọi supplier khi name null/trắng; tên hợp lệ trả trim. Không dùng Stream.
- **Đầu vào / kết quả / ví dụ sử dụng:** source=[" An ","",null,"Bao"] → result=[An,Bao], log=[An,Bao]; chooseName("Chi",fallback) không gọi fallback.
- **Biên và chính sách:** Rỗng; toàn bị loại; không sửa nguồn; giả định các callback khác null và transform trả kết quả khác null; supplier được gọi tối đa1 lần.
- **Hoàn thành khi:** Pipeline không gắn cứng String, callback được gọi đúng thời điểm; mô tả trách nhiệm từng interface; một thiết kế hợp lý là đủ.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
