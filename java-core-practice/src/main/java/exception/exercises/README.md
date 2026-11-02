# Tự làm cuối mục: Tổng kết exception

Tiên quyết: Hoàn thành try_catch, throws_demo, custom_exception; chỉ dùng OOP, arrays, methods và String đã học.

Đã có: README nhóm có ba hướng bài chung, các mục con có TODO riêng. Bộ mới kiểm tra phân loại lỗi, cause và nhập liệu không cập nhật dở. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes exception.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## EX-01 — Phân loại và chọn nơi xử lý

- **Dạng / mức độ:** Cơ bản · Vừa.
- **Kiến thức luyện:** Checked/unchecked và trách nhiệm API.
- **Bối cảnh và yêu cầu:** Viết bảng cho NumberFormatException, IllegalArgumentException, ParseException và custom extends Exception: compiler có bắt buộc xử lý không, ai nên xử lý khi đọc một dòng nhập người dùng. Viết hai caller của hàm checked: một catch, một khai báo throws.
- **Đầu vào / kết quả / ví dụ sử dụng:** Hàm parseAge("20") trả20; parseAge("abc") ném ParseException; age âm dùng IllegalArgumentException.
- **Biên và chính sách:** main có throws vẫn chưa xử lý; Error không xem như lỗi nhập liệu thường.
- **Hoàn thành khi:** Bảng đúng và hai caller đều compile, giải thích caller catch phản hồi khác caller truyền lên.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## EX-02 — Một catch cho cả batch

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Phạm vi try và dòng bị bỏ qua.
- **Bối cảnh và yêu cầu:** Với input ["2","bad","5"], so sánh try quanh cả loop với try bên trong từng lượt; đếm số parse thành công và số thông báo lỗi. Dự đoán trước khi chạy.
- **Đầu vào / kết quả / ví dụ sử dụng:** Cả loop và từng lượt cùng input; ghi khác biệt số thành công.
- **Biên và chính sách:** Sai ở dòng đầu/cuối; mảng rỗng; không có retry tự động.
- **Hoàn thành khi:** Dự đoán số lần thành công/lỗi của từng policy và giải thích vì sao hai phạm vi try làm kết quả khác nhau.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## EX-03 — Mất nguyên nhân và báo thành công giả

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Cause, catch cụ thể, trạng thái.
- **Bối cảnh và yêu cầu:** Tìm hai vấn đề trong importAge: catch rộng trả0 và mất cause khi bọc lỗi ở parser. Sửa parser bọc NumberFormatException thành ParseException giữ cause; caller thông báo lỗi thay vì nói đã nhập0.
- **Đầu vào / kết quả / ví dụ sử dụng:** "abc"→lỗi định dạng với cause; "0"→tuổi0 hợp lệ theo parser.
- **Biên và chính sách:** Chỉ bắt lỗi đúng hợp đồng; không thêm catch(Exception) để che mọi bug.
- **Hoàn thành khi:** Test phân biệt dữ liệu0 và lỗi; cause không null khi lỗi số.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
// Parser lỗi: catch (NumberFormatException e) { throw new ParseException("Sai",0); }
// Caller lỗi: catch (Exception e) { return 0; }
```

## EX-04 — Đổi hồ sơ nguyên vẹn

- **Dạng / mức độ:** Vận dụng · Khó.
- **Kiến thức luyện:** Validation trước mutation.
- **Bối cảnh và yêu cầu:** Tạo Profile có name không trắng và age 0..150. update(nameText,ageText) parse/validate mọi dữ liệu trước khi cập nhật; lỗi định dạng ném ParseException, giá trị sai ném IllegalArgumentException. Thất bại giữ nguyên cả hai field.
- **Đầu vào / kết quả / ví dụ sử dụng:** Profile(An,20), update(Bao,"bad")→FAIL, vẫnAn/20; update(Bao,"25")→Bao/25.
- **Biên và chính sách:** Tên trắng; tuổi-1/151; tuổi0/150; không đổi tên trước khi xác nhận tuổi.
- **Hoàn thành khi:** Không có cập nhật một nửa, caller bắt loại riêng; giải thích thứ tự validate.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## EX-05 — Nhập kho theo dòng có báo lỗi

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Checked parser, custom exception và batch.
- **Bối cảnh và yêu cầu:** Tự thiết kế Warehouse(capacity>=0) và addLine(String). Dòng là số nguyên dương; sai định dạng dùng ParseException giữ cause, không dương dùng IllegalArgumentException, vượt chỗ dùng checked CapacityExceededException(requested,remaining). Mỗi lượt main catch riêng và tiếp tục. Chỉ lưu tổng số lượng trong bộ nhớ, không cần Map/DB.
- **Đầu vào / kết quả / ví dụ sử dụng:** capacity5, dòng ["2","x","4","3"] → kết quả OK,FORMAT,CAPACITY,OK; stored=5.
- **Biên và chính sách:** Capacity0; thêm đúng hết; count0/âm; chuỗi vượt int; lỗi không đổi stored; tránh overflow stored+count bằng so với remaining.
- **Hoàn thành khi:** Đúng policy tiếp tục và bất biến 0<=stored<=capacity; mô tả nơi parse, nơi quản lý trạng thái, nơi phản hồi. Thiết kế chỉ là một phương án.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
