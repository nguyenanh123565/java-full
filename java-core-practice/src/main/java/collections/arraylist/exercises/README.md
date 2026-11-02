# Tự làm cuối mục: ArrayList

Tiên quyết: Fundamental, OOP, exception, wrapper, generics và equals/hashCode; chưa cần lambda hay Stream.

Đã có: ArrayListExercise.java đã luyện thêm/sửa/xóa, overload remove và alias. Bộ mới kiểm tra lọc an toàn, phần tử mutable và snapshot. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.arraylist.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## AL-01 — Lọc điểm hợp lệ

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** size/get/add và thứ tự List.
- **Bối cảnh và yêu cầu:** Viết validScores(List<Integer>) trả list mới chỉ chứa điểm 0..10, giữ thứ tự và số lần xuất hiện; không sửa list đầu vào.
- **Đầu vào / kết quả / ví dụ sử dụng:** [8,-1,10,8,11,0] → [8,10,8,0].
- **Biên và chính sách:** List rỗng; mọi điểm bị loại; 0 và 10. Input không null, không chứa null.
- **Hoàn thành khi:** Kết quả đúng cả biên và nguồn giữ nguyên; giải thích vì sao cần list mới.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## AL-02 — Bản sao nông với object

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Alias, copy cấu trúc, object mutable.
- **Bối cảnh và yêu cầu:** Cho Item có field int value; dự đoán ba giá trị và size trước khi chạy đoạn minh họa. Giải thích thao tác nào tác động cấu trúc và thao tác nào tác động object.
- **Đầu vào / kết quả / ví dụ sử dụng:** In lần lượt a.get(0).value, b.get(0).value và a.size(); tự ghi dự đoán.
- **Biên và chính sách:** Thêm Item mới vào b sau khi sửa; thử a rỗng và giải thích vì sao không được get(0).
- **Hoàn thành khi:** Có sơ đồ reference và phân biệt hai list với một object phần tử được chia sẻ.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
Item item = new Item(1);
List<Item> a = new ArrayList<>(); a.add(item);
List<Item> b = new ArrayList<>(a);
b.get(0).value = 7; b.add(new Item(9));
```

## AL-03 — Xóa liên tiếp bị bỏ sót

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Index thay đổi khi remove.
- **Bối cảnh và yêu cầu:** Đoạn code muốn loại tất cả số âm. Chỉ ra input gây sai, sửa bằng vòng lặp index an toàn; không dùng removeIf/lambda.
- **Đầu vào / kết quả / ví dụ sử dụng:** [-1,-2,3,-4] → [3].
- **Biên và chính sách:** Âm liên tiếp ở đầu/cuối; list rỗng; toàn âm.
- **Hoàn thành khi:** Xóa hết số âm, không bỏ phần tử dịch sang; giải thích vì sao tăng i sau remove gây sai.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
for (int i = 0; i < values.size(); i++) {
    if (values.get(i) < 0) values.remove(i);
}
```

## AL-04 — Phân trang danh sách

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Index, giới hạn, bản sao.
- **Bối cảnh và yêu cầu:** Viết page(values, offset, limit) trả list mới từ offset với tối đa limit phần tử. offset/limit âm ném IllegalArgumentException; offset >= size trả rỗng.
- **Đầu vào / kết quả / ví dụ sử dụng:** [A,B,C,D], offset=1, limit=2 → [B,C]; offset=3, limit=8 → [D].
- **Biên và chính sách:** limit=0; offset=size; limit=Integer.MAX_VALUE; nguồn rỗng. Tránh overflow offset+limit.
- **Hoàn thành khi:** Sửa kết quả không làm nguồn đổi; không có index lỗi hoặc overflow.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## AL-05 — Sổ điểm và báo cáo độc lập

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Method, validation, List snapshot.
- **Bối cảnh và yêu cầu:** Tạo GradeBook.addScore(int) từ chối điểm ngoài 0..10; snapshot() trả bản sao list. Thêm điểm, lấy snapshot, thêm điểm mới, rồi thử sửa snapshot. Giải thích cách bảo vệ trạng thái.
- **Đầu vào / kết quả / ví dụ sử dụng:** Thêm 8,10 → snapshot [8,10]; thêm 7 → sổ [8,10,7], snapshot cũ [8,10].
- **Biên và chính sách:** Điểm -1/11 không đổi sổ; sổ rỗng; caller clear snapshot.
- **Hoàn thành khi:** Object giữ trạng thái hợp lệ và không lộ list nội bộ; tự mô tả trách nhiệm class. Thiết kế tự chọn.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
