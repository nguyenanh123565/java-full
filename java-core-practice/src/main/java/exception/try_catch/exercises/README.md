# Tự làm cuối mục: Try / catch / finally

Tiên quyết: Fundamental và OOP. Các import java.io/AutoCloseable chỉ dùng đúng nội dung try-with-resources đã có trong mục; chưa dùng Collections/lambda.

Đã có: TryCatchExercise.java đã có parse fallback, chia hai chuỗi và đọc dòng với reader. Bộ mới luyện xử lý từng phần tử, luồng finally và kiểm chứng đóng resource. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes exception.try_catch.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## TC-01 — Đếm bản ghi đọc được

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** Catch cụ thể trong vòng lặp.
- **Bối cảnh và yêu cầu:** Viết parseStats(String[]) trả int[]{số parse thành công,số lỗi định dạng}. Mỗi phần tử được thử độc lập bằng Integer.parseInt, không trim tự động.
- **Đầu vào / kết quả / ví dụ sử dụng:** ["12","x","-3"," 4 "] → [2,2].
- **Biên và chính sách:** Mảng rỗng; phần tử null; giá trị vượt miền int đều tính lỗi định dạng.
- **Hoàn thành khi:** Một bản ghi sai không bỏ các bản ghi sau; giải thích vì sao catch phải nằm trong lượt lặp.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## TC-02 — Luồng thoát khỏi try

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Điểm ném lỗi và finally.
- **Bối cảnh và yêu cầu:** Viết trace(text) trả chuỗi ký hiệu các bước thay cho println. Đoán trace("5") và trace("bad") từ snippet; giải thích đoạn nào bị bỏ qua.
- **Đầu vào / kết quả / ví dụ sử dụng:** Tự ghi hai chuỗi dự đoán trước khi chạy.
- **Biên và chính sách:** Integer.parseInt(null); finally thông thường vẫn chạy; không mở rộng thành cam kết khi JVM dừng.
- **Hoàn thành khi:** Giải thích bằng luồng điều khiển, không chỉ chép output.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
String trace = "A";
try { Integer.parseInt(text); trace += "B"; }
catch (NumberFormatException e) { trace += "C"; }
finally { trace += "F"; }
trace += "Z";
```

## TC-03 — Finally che kết quả

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Return trong finally.
- **Bối cảnh và yêu cầu:** Hàm muốn trả giá trị parse hoặc -1 khi lỗi nhưng luôn trả 0. Chỉ ra nguyên nhân và sửa; finally chỉ dùng ghi log, không return. Viết lại để bảo toàn kết quả.
- **Đầu vào / kết quả / ví dụ sử dụng:** read("8")→8; read("bad")→-1.
- **Biên và chính sách:** Chuỗi "0" phải ra0; parse giá trị âm hợp lệ; null→-1 theo policy.
- **Hoàn thành khi:** Không còn return trong finally và giải thích vì sao return sau che return trước.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
static int read(String text) {
    try { return Integer.parseInt(text); }
    catch (NumberFormatException e) { return -1; }
    finally { return 0; }
}
```

## TC-04 — Resource có đóng khi lỗi?

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** AutoCloseable và try-with-resources.
- **Bối cảnh và yêu cầu:** Tạo Probe implements AutoCloseable có closed boolean và close đặt true. Viết thử nghiệm parse trong try(probe), kiểm tra closed sau thành công và sau NumberFormatException. close không ném lỗi ở bài này.
- **Đầu vào / kết quả / ví dụ sử dụng:** Parse "6" hoặc "x"; sau khi rời block probe.closed phải true.
- **Biên và chính sách:** Không chỉ kiểm tra đường thành công; không return trong close; mỗi Probe mới chỉ dùng một lần.
- **Hoàn thành khi:** Có kiểm tra cả hai đường; giải thích ai gọi close. Đây là resource giả để quan sát, chưa có file thật.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## TC-05 — Báo cáo tổng và dữ liệu lỗi

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Array, validation và xử lý lỗi có chủ đích.
- **Bối cảnh và yêu cầu:** Tạo Report gồm long sum, int valid, int invalid. summarize(String[]) parse từng chuỗi nguyên; thành công cộng vào long, thất bại tăng invalid và tiếp tục. Không dùng fallback 0 thay cho mọi lỗi; một số 0 hợp lệ vẫn tăng valid.
- **Đầu vào / kết quả / ví dụ sử dụng:** ["10","oops","0","-3"] → sum=7,valid=3,invalid=1.
- **Biên và chính sách:** Rỗng; toàn lỗi; tổng vượt int (hai MAX_VALUE); phần tử null tính lỗi. Mảng không null.
- **Hoàn thành khi:** Phân biệt 0 hợp lệ/lỗi, tổng không tràn int; giải thích vị trí catch và policy bỏ bản ghi sai.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
