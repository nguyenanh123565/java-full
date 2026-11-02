# Tự làm cuối mục: HashSet

Tiên quyết: ArrayList, LinkedList, equals/hashCode; chỉ dùng vòng lặp, chưa cần Map, lambda hay Stream.

Đã có: HashSetExercise.java đã luyện add trùng, sắp tăng và Student theo id. Bộ mới luyện phép tập hợp, collision và danh sách điểm danh. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.hashset.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## HS-01 — Giao hai nhóm

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** contains/add, ngữ nghĩa tập hợp.
- **Bối cảnh và yêu cầu:** Viết intersection(Set<String> a, Set<String> b) trả set mới chứa tên có ở cả hai; không sửa nguồn.
- **Đầu vào / kết quả / ví dụ sử dụng:** {An,Bao,Chi} và {Bao,Dung} → tập {Bao}, không yêu cầu thứ tự in.
- **Biên và chính sách:** Một/hai tập rỗng; hai tập giống nhau; không chứa null.
- **Hoàn thành khi:** Set kết quả đúng, nguồn giữ nguyên; không dựa vào thứ tự HashSet.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## HS-02 — Cùng hash vẫn khác

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Collision và equals.
- **Bối cảnh và yêu cầu:** Tạo Key bất biến theo mã, hashCode luôn bằng 1 cho thí nghiệm. Thêm Key(A), Key(B), Key(A) và dự đoán từng add cùng size.
- **Đầu vào / kết quả / ví dụ sử dụng:** Ba mã A,B,A; tự ghi ba boolean và size trước khi chạy.
- **Biên và chính sách:** Key mới cùng mã; equals(null) phải false. Hash cố định chỉ dùng học.
- **Hoàn thành khi:** Giải thích được hash trùng không đồng nghĩa giá trị bằng nhau.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## HS-03 — Kiểm tra đã tham gia sai

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Dùng kết quả add thay đếm lần gọi.
- **Bối cảnh và yêu cầu:** Mỗi tên chỉ được ghi nhận một lần. Code tăng accepted bất kể add thành công. Sửa và giải thích; từ chối tên null/trắng, không cần chuẩn hóa chữ hoa.
- **Đầu vào / kết quả / ví dụ sử dụng:** [An,An,Bao] → accepted=2, set={An,Bao}.
- **Biên và chính sách:** Toàn trùng; rỗng; tên trắng; An và an được xem khác.
- **Hoàn thành khi:** accepted bằng số phần tử mới thực sự được thêm; input sai không đổi set.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
for (String name : names) {
    joined.add(name); accepted++;
}
```

## HS-04 — Thiếu ai trong buổi học?

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Hiệu tập hợp, validation.
- **Bối cảnh và yêu cầu:** Viết absent(registered,present) trả set người đăng ký nhưng chưa có mặt; present ngoài danh sách không được làm mất người khác. Không sửa nguồn.
- **Đầu vào / kết quả / ví dụ sử dụng:** registered={An,Bao,Chi}, present={An,Khach} → {Bao,Chi}.
- **Biên và chính sách:** Không ai đến; tất cả đến; khách lạ; set rỗng.
- **Hoàn thành khi:** Đúng hiệu registered\present; giải thích tại sao không dùng thứ tự làm tiêu chí.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## HS-05 — Điểm danh nhiều buổi

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** List thứ tự, Set duy nhất, encapsulation.
- **Bối cảnh và yêu cầu:** Tạo Attendance từ registered. checkIn(name) trả true đúng lần đầu của người đã đăng ký, false khi lặp hoặc khách; firstArrivalOrder() trả list tên được chấp nhận theo thứ tự đầu tiên. Tên null/trắng ném IllegalArgumentException.
- **Đầu vào / kết quả / ví dụ sử dụng:** Đăng ký An,Bao; đến Bao,An,Bao,Khach → [Bao,An], boolean true,true,false,false.
- **Biên và chính sách:** Chưa ai đến; danh sách đăng ký rỗng; caller sửa bản snapshot.
- **Hoàn thành khi:** Không ghi nhận lặp/khách, giữ thứ tự đầu tiên mà không giả định HashSet có thứ tự; mô tả trách nhiệm class.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
