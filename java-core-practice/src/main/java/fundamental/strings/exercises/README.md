# Tự làm: Chuỗi

[Về mục học](../README.md)

## Trước khi làm

Sau arrays; đọc StringDemo. Dùng String, StringBuilder, Locale.ROOT, loop, charAt, length, trim, toUpperCase, equals. Bài giới hạn ASCII; không dùng regex, stream hoặc collection.

Bài cũ [StringExercise.java](../StringExercise.java) đã chuẩn hóa, so identity/content và String qua method. Giữ nguyên StringSolution.java đang có phần tự thử; bộ mới xử lý văn bản nhiều phần tử và kiểm tra hợp đồng.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.strings.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.strings.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### STR-01 — Đếm nguyên âm ASCII · Dễ · Cơ bản

- **Kiến thức luyện:** Duyệt char; chuẩn hóa hoa/thường; không sửa nguồn.
- **Bối cảnh và yêu cầu:** Viết countVowels(String text) khác null, đếm a,e,i,o,u không phân biệt hoa/thường. Dùng Locale.ROOT nếu đổi kiểu chữ; chỉ xét ASCII, y không là nguyên âm.
- **Dữ liệu / kết quả / ví dụ:** "Java CORE"->4; "rhythm"->0; "AEIOU"->5.
- **Trường hợp biên:** Chuỗi rỗng, toàn dấu cách, nguyên âm lặp; chuỗi gốc phải giữ nguyên.
- **Tiêu chí hoàn thành:** Đúng số đếm, đọc từng char an toàn, nêu giới hạn ASCII trong ghi chú. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STR-02 — Alias của builder sau khi gán lại · Vừa · Suy luận

- **Kiến thức luyện:** Mutation; gán lại reference; String snapshot.
- **Bối cảnh và yêu cầu:** Dự đoán `StringBuilder a=new StringBuilder("A"); StringBuilder b=a; String saved=a.toString(); b.append("B"); b=new StringBuilder("C"); b.append("D");` rồi in a,b,saved,a==b. Giải thích quan hệ sau từng bước.
- **Dữ liệu / kết quả / ví dụ:** Ghi bốn output dự đoán trước chạy; đổi chuỗi ban đầu thành rỗng để thử.
- **Trường hợp biên:** Không đếm số object String trong JVM; saved là giá trị String tại lúc gọi toString.
- **Tiêu chí hoàn thành:** Phân biệt tác động append với phép gán b; giải thích vì sao saved không đổi. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STR-03 — Lệnh EXIT không được nhận · Dễ · Tìm lỗi

- **Kiến thức luyện:** Kết quả trim; equals; null guard.
- **Bối cảnh và yêu cầu:** Sửa hàm boolean isExit(String text) đang làm `text.trim(); return text == "EXIT";`. Hợp đồng: chấp nhận ASCII "exit" không phân biệt hoa/thường và khoảng trắng hai đầu; null trả false. Không dùng so identity cho nội dung.
- **Dữ liệu / kết quả / ví dụ:** new String(" EXIT ")->true; "exit"->true; null->false; "EX IT"->false.
- **Trường hợp biên:** "" và toàn khoảng trắng ->false; không xóa khoảng trắng bên trong lệnh.
- **Tiêu chí hoàn thành:** Chỉ ra ba nguyên nhân: null, bỏ kết quả trim và ==; bản sửa không có exception. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STR-04 — Ghép nhãn có chọn lọc · Vừa · Vận dụng

- **Kiến thức luyện:** StringBuilder; mảng; dấu phân cách.
- **Bối cảnh và yêu cầu:** Viết joinLabels(String[] labels) khác null: bỏ phần tử null hoặc trim thành rỗng; ghép phần còn lại đã trim bằng |, giữ chữ hoa/thường và thứ tự. Không có dấu | đầu/cuối; không sửa mảng gốc.
- **Dữ liệu / kết quả / ví dụ:** [" A ",null," ","B"] -> "A|B"; ["A","A"]->"A|A".
- **Trường hợp biên:** [] và toàn nhãn trống ->""; một nhãn; ký tự | không xuất hiện trong nhãn đầu vào.
- **Tiêu chí hoàn thành:** Đúng thứ tự và dấu phân cách; phần tử trùng không bị loại; dùng StringBuilder cho phần ghép. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STR-05 — Sổ mã ba chữ cái · Vừa · Tổng kết

- **Kiến thức luyện:** Chuẩn hóa; kiểm tra từng char; method; ghép có lọc.
- **Bối cảnh và yêu cầu:** Viết validCode(String) và codeReport(String[]): trim, đổi hoa bằng Locale.ROOT, chỉ nhận đúng ba char A..Z. Bỏ null/mã sai, giữ mã trùng và thứ tự; trả chuỗi hợp lệ ngăn bằng |. Không sửa đầu vào và không dùng regex.
- **Dữ liệu / kết quả / ví dụ:** [" abC ","b-2",null," xyz ","   ","JAVA","ABC"] -> "ABC|XYZ|ABC".
- **Trường hợp biên:** Mảng rỗng/toàn sai ->""; mã dài 2 hoặc 4; chứa chữ số, khoảng trắng ở giữa; chỉ ASCII.
- **Tiêu chí hoàn thành:** Hàm kiểm tra tách khỏi hàm báo cáo; bảng test đủ ngắn/dài/ký tự sai/null; giải thích vì sao không loại trùng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
