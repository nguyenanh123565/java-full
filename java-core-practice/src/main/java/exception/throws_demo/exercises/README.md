# Tự làm cuối mục: Throw, throws và lan truyền

Tiên quyết: OOP và try_catch; dùng ParseException từ bài hiện tại, chưa cần Collections/generics.

Đã có: ThrowsExercise.java đã có parseCount và requirePositive. Bộ mới dùng parser bản ghi có tên, giữ cause và hợp đồng không trả kết quả giả. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes exception.throws_demo.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## TH-01 — Parser mã số có ngữ cảnh

- **Dạng / mức độ:** Cơ bản · Vừa.
- **Kiến thức luyện:** Checked exception và cause.
- **Bối cảnh và yêu cầu:** Viết parseId(String) throws ParseException: chuỗi biểu diễn int>=0 thì trả id; lỗi định dạng chuyển thành ParseException, message chứa input, cause giữ NumberFormatException; số âm dùng IllegalArgumentException.
- **Đầu vào / kết quả / ví dụ sử dụng:** "42"→42; "forty"→ParseException có cause; "-1"→IllegalArgumentException.
- **Biên và chính sách:** "0" hợp lệ; null là lỗi định dạng; vượt int; không tự trim.
- **Hoàn thành khi:** Caller bắt đúng loại, checked có cause; không catch nhầm IllegalArgumentException rồi đổi cả lỗi âm thành lỗi định dạng.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## TH-02 — Throws không tự chạy catch

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Chuỗi caller và chữ ký method.
- **Bối cảnh và yêu cầu:** Mô tả đường gọi outer→middle→parseId. Cả outer/middle chỉ khai báo throws ParseException. Với "x", catch ở main ghi ERROR rồi in END; xác định method nào tạo lỗi, method nào chỉ truyền và dòng sau lời gọi nào bị bỏ qua.
- **Đầu vào / kết quả / ví dụ sử dụng:** main gọi outer("x"), sau đó dự định in OK; catch in ERROR; sau catch in END.
- **Biên và chính sách:** outer("1") không ném dù có throws; lỗi âm không được catch ParseException bắt.
- **Hoàn thành khi:** Dự đoán đủ các nhánh hợp lệ và lỗi; phân biệt throw/throws và chỉ rõ dòng nào bị bỏ qua.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## TH-03 — Bắt rồi trả id giả

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Bảo toàn hợp đồng và nguyên nhân.
- **Bối cảnh và yêu cầu:** Hàm service phải để caller biết input sai nhưng code catch ParseException rồi trả 0. Sửa bằng cách truyền đúng checked exception; giải thích vì sao trả 0 làm nhầm với id hợp lệ.
- **Đầu vào / kết quả / ví dụ sử dụng:** service("0")→0; service("x") phải ném ParseException, không trả0.
- **Biên và chính sách:** Cause không mất khi truyền; không đổi thành throws Exception quá rộng.
- **Hoàn thành khi:** Chữ ký cụ thể và không có fallback che lỗi; caller xử lý được dữ liệu sai.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
static int service(String text) {
    try { return parseId(text); }
    catch (ParseException e) { return 0; }
}
```

## TH-04 — Đọc một cặp tọa độ

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Validation cấu trúc và checked parsing.
- **Bối cảnh và yêu cầu:** Viết parsePoint(String) throws ParseException cho đúng hai số int phân cách dấu phẩy, không trim. Trả int[2]; định dạng cấu trúc hoặc thành phần sai dùng ParseException; khi parseInt gây lỗi thì giữ cause. Tọa độ âm được phép.
- **Đầu vào / kết quả / ví dụ sử dụng:** "3,-2"→[3,-2]; "3," và "a,2"→ParseException.
- **Biên và chính sách:** Chuỗi rỗng/null; hơn hai thành phần; dấu phẩy cuối cần split(",",-1) để không mất phần rỗng.
- **Hoàn thành khi:** Không có kết quả cặp thiếu; định dạng cấu trúc sai có message rõ; chỉ lỗi số có cause NumberFormatException.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## TH-05 — Dừng cả lô hay tiếp từng dòng?

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Thiết kế trách nhiệm caller và xử lý batch.
- **Bối cảnh và yêu cầu:** Viết readAll(String[]) throws ParseException trả int[][] tọa độ; gặp bản ghi sai đầu tiên thì ném lỗi với số dòng (1-based) và cause là ParseException gốc. Không trả mảng chứa giá trị mặc định như kết quả thành công. Main xử lý một lần cho cả lô; giải thích khác policy TC-05 tiếp tục.
- **Đầu vào / kết quả / ví dụ sử dụng:** ["1,2","x,3","4,5"]→lỗi dòng2, có chuỗi cause; lô hợp lệ trả đủ số điểm.
- **Biên và chính sách:** Mảng rỗng→int[0][]; lỗi đầu/cuối; null dòng; không dùng Collections.
- **Hoàn thành khi:** Cause giữ hai tầng khi lỗi parse số; caller biết đúng dòng và không in báo cáo thành công khi lỗi.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
