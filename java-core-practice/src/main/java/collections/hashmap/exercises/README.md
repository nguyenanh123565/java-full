# Tự làm cuối mục: HashMap

Tiên quyết: List, Set, equals/hashCode và kiến thức trước Collections; chưa dùng lambda, merge method reference hay Stream.

Đã có: HashMapExercise.java đã luyện null, tần suất từ và key collision. Bộ mới dùng dữ liệu tồn kho, vắng mặt và cập nhật an toàn. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.hashmap.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## HM-01 — Gộp số lượng đặt hàng

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** getOrDefault/put và Map key.
- **Bối cảnh và yêu cầu:** Viết counts(String[] codes) trả Map mã→số lần xuất hiện; không cần thứ tự in. Mỗi mã phải khác null/trắng, không chuẩn hóa chữ hoa.
- **Đầu vào / kết quả / ví dụ sử dụng:** [P1,P2,P1,P3,P2,P1] → {P1=3,P2=2,P3=1}.
- **Biên và chính sách:** Mảng rỗng; một mã; mã trùng liên tiếp; từ chối mã trắng.
- **Hoàn thành khi:** Map đúng theo equals, không dùng một vòng lặp phụ quét lại toàn bộ mảng cho mỗi mã.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## HM-02 — Null cản giá trị mặc định

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** getOrDefault và mapping null.
- **Bối cảnh và yêu cầu:** Map chứa A→null và B→2. Dự đoán getOrDefault(A,0), getOrDefault(C,0), containsKey(A); giải thích khác nhau giữa thiếu mapping với value null.
- **Đầu vào / kết quả / ví dụ sử dụng:** Tự ghi ba kết quả trước khi chạy; sau đó unbox getOrDefault(A,0) vào int sẽ ra sao?
- **Biên và chính sách:** Thử map rỗng; không xem null là 0 nếu hợp đồng chưa quy định.
- **Hoàn thành khi:** Giải thích đúng NullPointerException khi unbox null, không suy ra key vắng mặt từ get null.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## HM-03 — Xuất kho thành số âm

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Validation trước cập nhật.
- **Bối cảnh và yêu cầu:** Sửa hàm take để mã thiếu hoặc số lượng không đủ trả false, amount<=0 ném IllegalArgumentException; thất bại không đổi Map. Tồn kho không có null value và không âm.
- **Đầu vào / kết quả / ví dụ sử dụng:** {P1=3}, take(P1,5) → false và vẫn 3; take(P1,2) → true và còn 1.
- **Biên và chính sách:** Mã chưa có; amount=0/âm; lấy đúng hết; không xóa key khi còn 0.
- **Hoàn thành khi:** Không có tồn âm, không tự tạo mã mới và không thay đổi trạng thái khi lỗi.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
stock.put(code, stock.getOrDefault(code, 0) - amount);
return true;
```

## HM-04 — Danh bạ có mã duy nhất

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Map CRUD và hợp đồng tồn tại.
- **Bối cảnh và yêu cầu:** Tạo Directory.add(id,name) không ghi đè id đã có và trả false khi trùng; rename chỉ thành công với id tồn tại; find trả null nếu thiếu. Từ chối id/name null/trắng.
- **Đầu vào / kết quả / ví dụ sử dụng:** add(S1,An)=true; add(S1,Bao)=false; find(S1)=An; rename(S1,Chi)=true.
- **Biên và chính sách:** Danh bạ rỗng; đổi tên id chưa có; dữ liệu sai không tạo mapping.
- **Hoàn thành khi:** Không ghi đè ngoài ý muốn; nêu vì sao containsKey phù hợp với policy.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## HM-05 — Thống kê phiếu theo lớp

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Map kết hợp List, snapshot cấu trúc.
- **Bối cảnh và yêu cầu:** Viết groupNames(String[] classes,String[] names) trả Map<String,List<String>> theo lớp. Hai mảng cùng độ dài; từ chối null/trắng; giữ thứ tự tên trong từng lớp, cho phép trùng; không cần thứ tự các key.
- **Đầu vào / kết quả / ví dụ sử dụng:** classes=[A,B,A], names=[An,Bao,Chi] → A=[An,Chi], B=[Bao].
- **Biên và chính sách:** Hai mảng rỗng; khác độ dài; một lớp nhiều người; không dùng chung một list cho mọi key.
- **Hoàn thành khi:** Mỗi key có list riêng và dữ liệu không bị lẫn lớp; giải thích trách nhiệm Map và List.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
