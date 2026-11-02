# Tự làm cuối mục: Stream

Tiên quyết: Collections, equals/hashCode, Comparator và lambda; dùng Stream tuần tự, không parallelStream, không thư viện ngoài.

Đã có: StreamExercise.java đã có bình phương số chẵn, tần suất từ và top3 không trùng. Bộ mới kiểm tra lazy execution, reuse, reduce và báo cáo object. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes stream.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## STM-01 — Tổng độ dài tên hợp lệ

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** filter/mapToInt/sum.
- **Bối cảnh và yêu cầu:** Viết totalNameLength(List<String>): bỏ null, trim, bỏ chuỗi rỗng rồi tính tổng độ dài bằng Stream. Không sửa list nguồn, không dùng biến tổng bên ngoài pipeline.
- **Đầu vào / kết quả / ví dụ sử dụng:** [" An ",null,"","Bao"] →5.
- **Biên và chính sách:** Rỗng; toàn null/trắng; tên một ký tự; input size nhỏ để tổng int không tràn.
- **Hoàn thành khi:** Pipeline đúng thứ tự null-check trước trim và sum=0 cho nguồn rỗng.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## STM-02 — Lười tới terminal thực sự

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Intermediate/terminal và thứ tự pipeline.
- **Bối cảnh và yêu cầu:** Đoán trace trước và sau pipeline.toList() trong snippet. Không đổi terminal thành count vì một số pipeline đếm có thể tối ưu bỏ bước map. Tác dụng phụ ở đây chỉ để quan sát trong thí nghiệm; không dùng nó làm logic nghiệp vụ.
- **Đầu vào / kết quả / ví dụ sử dụng:** Input [1,2,3]; tự ghi list kết quả và trace.
- **Biên và chính sách:** Nguồn rỗng; bỏ terminal không có trace; chỉ dùng stream tuần tự.
- **Hoàn thành khi:** Dự đoán thời điểm và thứ tự filter/map theo từng phần tử, kèm giải thích intermediate/terminal.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
List<String> trace = new ArrayList<>();
Stream<Integer> pipeline = List.of(1,2,3).stream()
    .filter(n -> { trace.add("f" + n); return n % 2 != 0; })
    .map(n -> { trace.add("m" + n); return n * 10; });
```

## STM-03 — Dùng lại stream đã kết thúc

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Stream single-use.
- **Bối cảnh và yêu cầu:** Code tính sum rồi count trên cùng stream. Chỉ ra IllegalStateException và sửa bằng stream mới từ cùng nguồn cho mỗi báo cáo; không catch để trả count giả.
- **Đầu vào / kết quả / ví dụ sử dụng:** List [1,2,3] → sum6 và count3.
- **Biên và chính sách:** Nguồn rỗng→sum0,count0; không sửa nguồn; stream không phải nơi lưu dữ liệu.
- **Hoàn thành khi:** Hai terminal dùng hai pipeline mới; giải thích vì sao biến Collection có thể dùng lại còn Stream thì không.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
Stream<Integer> stream = values.stream();
int sum = stream.mapToInt(Integer::intValue).sum();
long count = stream.count();
```

## STM-04 — Tổng tồn kho đủ điều kiện

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Object pipeline, reduce với identity.
- **Bối cảnh và yêu cầu:** Product có id, long price>=0 và int stock>=0. inventoryValue(products) cộng price*stock cho sản phẩm stock>0 bằng map và reduce(0L,Long::sum). Giới hạn price<=1_000_000,stock<=1_000_000,size<=1000, đủ nằm trong long. Không làm tròn bằng double.
- **Đầu vào / kết quả / ví dụ sử dụng:** A(price100,stock2),B(50,0),C(30,3) →290.
- **Biên và chính sách:** Rỗng; toàn hết hàng; price0; giới hạn hợp lệ; sản phẩm không null.
- **Hoàn thành khi:** Dùng long từ phép nhân, identity đúng và không mutation object.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## STM-05 — Báo cáo sản phẩm theo danh mục

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** OOP, grouping/counting, sort/limit, reduce.
- **Bối cảnh và yêu cầu:** Tự thiết kế Product(id,category,price,stock) hợp lệ. report(products,k) tạo: tổng giá trị tồn kho; Map danh mục→số sản phẩm còn hàng; tối đa k id còn hàng theo price giảm rồi id tăng. Giữ nguồn, không dùng parallel và không sửa trạng thái trong pipeline. Reject duplicate id; k<0 không hợp lệ. Đếm sản phẩm, không đếm tổng stock.
- **Đầu vào / kết quả / ví dụ sử dụng:** A(book,100,2),B(book,50,0),C(tool,30,3),D(book,100,1),k2 → total390; counts={book=2,tool=1}; ids=[A,D].
- **Biên và chính sách:** Rỗng; tất cả hết hàng; giá hòa; k0/>size; duplicate id; dữ liệu trong giới hạn STM-04.
- **Hoàn thành khi:** Ba kết quả đúng và có kiểm tra nguồn không đổi; giải thích terminal riêng cần stream mới. Thiết kế Report có thể khác.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
