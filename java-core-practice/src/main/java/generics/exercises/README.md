# Tự làm cuối mục: Generics

Tiên quyết: OOP, exception, static/final, wrapper và Fundamental. Bài mới chỉ dùng object/mảng; wildcard List ở ví dụ cũ có thể quay lại sau Collections.

Đã có: GenericsExercise.java đã có Box, first và tổng List<? extends Number>. Bộ mới dùng Pair, invariance và giới hạn trên mảng để không cần collection chưa học. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes generics.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## GEN-01 — Cặp hai kiểu độc lập

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** Class generic hai tham số kiểu.
- **Bối cảnh và yêu cầu:** Tạo Pair<L,R> bất biến với constructor và left()/right(). Dùng Pair<String,Integer> và Pair<Integer,String>, không cast về kiểu cụ thể khi lấy dữ liệu.
- **Đầu vào / kết quả / ví dụ sử dụng:** Pair("An",20): left().length()=2, right()+1=21.
- **Biên và chính sách:** Cho phép null ở mỗi vị trí; caller phải kiểm tra trước gọi method; không có Pair<int,...>.
- **Hoàn thành khi:** Code compile và compiler biết riêng kiểu L/R; giải thích vì sao dùng wrapper.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## GEN-02 — Invariance qua biến cha

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Kiểu generic và extends wildcard.
- **Bối cảnh và yêu cầu:** Với Slot<T> chỉ có get, phân loại dòng nào compile trong snippet. Giải thích vì sao Slot<Integer> không thành Slot<Number> nhưng đọc được qua Slot<? extends Number>. Chỉ biên dịch các dòng hợp lệ trong code thật.
- **Đầu vào / kết quả / ví dụ sử dụng:** Slot<Integer> nhận7; biến đọc wildcard lấy Number.doubleValue()→7.0.
- **Biên và chính sách:** Không coi wildcard là Slot<Number>; phân biệt Integer extends Number với container generic.
- **Hoàn thành khi:** Giải thích có ví dụ nếu container có set sẽ mất an toàn khi gán như vậy.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
Slot<Integer> ints = new Slot<>(7);
Slot<Number> n = ints; // Phân loại, không chép vào source đang build.
Slot<? extends Number> view = ints;
Number value = view.get();
```

## GEN-03 — Raw type phá hàng rào kiểu

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Raw type, cast và kiểm tra compile.
- **Bối cảnh và yêu cầu:** Đoạn code dùng Slot raw để thay Integer vào Slot<String>. Chỉ ra vì sao lỗi có thể xuất hiện muộn khi lấy String; sửa bằng tham số kiểu đầy đủ. Không dùng raw trong lời giải.
- **Đầu vào / kết quả / ví dụ sử dụng:** Slot<String>("Java") phải luôn trả String; set(123) phải bị compiler từ chối.
- **Biên và chính sách:** Null vẫn có thể hợp lệ tùy hợp đồng; không ép cast để “sửa” lỗi kiểu.
- **Hoàn thành khi:** Không raw type hoặc unchecked cast; giải thích compile error tốt hơn ClassCastException muộn.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
Slot<String> s = new Slot<>("Java");
Slot raw = s;
raw.set(123);
String value = s.get();
```

## GEN-04 — Tổng bình phương các Number

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Giới hạn kiểu <T extends Number>.
- **Bối cảnh và yêu cầu:** Viết <T extends Number> double sumSquares(T[] values), dùng doubleValue để tính tổng bình phương; null array/phần tử ném IllegalArgumentException. Không dùng List hoặc Stream.
- **Đầu vào / kết quả / ví dụ sử dụng:** Integer[]{2,-3}→13.0; Double[]{1.5,2.0}→6.25.
- **Biên và chính sách:** Mảng rỗng→0; số0; chỉ kiểm tra số hữu hạn có abs<=1_000_000; không nhận String[].
- **Hoàn thành khi:** Một method dùng được cho hai kiểu, không cast về Integer/Double; sai kiểu bị compile từ chối.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## GEN-05 — Kết quả thành công hoặc thất bại

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Generic class, generic static factory, invariant.
- **Bối cảnh và yêu cầu:** Tự thiết kế Result<T> bất biến: success(value khác null), failure(message không trắng), isSuccess, value và error. value khi thất bại ném IllegalStateException; error khi thành công cũng ném IllegalStateException. Dùng cùng API cho String và Integer. Không cần sealed class hay Optional.
- **Đầu vào / kết quả / ví dụ sử dụng:** Result.success("OK").value()→"OK"; Result.<Integer>failure("Không đọc được").isSuccess()→false.
- **Biên và chính sách:** Success(null); failure(""); gọi getter sai trạng thái; không tạo đối tượng vừa có value vừa có error.
- **Hoàn thành khi:** Compiler giữ đúng T, không cast/rawtypes; tự giải thích bất biến và vì sao static factory cần tham số kiểu riêng. Thiết kế có thể khác.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
