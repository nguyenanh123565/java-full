# Tự làm cuối mục: Equals và hashCode

Tiên quyết: OOP, reference, String, exception và generics. Bài mới kiểm tra hợp đồng trực tiếp bằng object/mảng, không yêu cầu học Set/Map trước.

Đã có: EqualsHashCodeExercise.java đã có StudentKey theo id, Set và Map. Bộ mới dùng khóa ghép, lỗi overload và kiểm tra hợp đồng; quay lại bài cũ về collection sau Collections. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes equals_hashcode.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## EQ-01 — Tọa độ theo giá trị

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** Equality nhiều field, immutable.
- **Bối cảnh và yêu cầu:** Tạo Point(x,y) bất biến, equals và hashCode dựa cả x,y. Hai instance (2,3) bằng nhau dù identity khác; (3,2) khác. Class final để giới hạn equality rõ ràng.
- **Đầu vào / kết quả / ví dụ sử dụng:** new Point(2,3).equals(new Point(2,3))→true; == giữa hai instance→false.
- **Biên và chính sách:** Số âm; 0; MIN_VALUE/MAX_VALUE; null và object kiểu khác phải false.
- **Hoàn thành khi:** Override đúng equals(Object), hashCode nhất quán; không dùng tổng x+y làm tiêu chí bằng nhau.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## EQ-02 — Bộ ba hợp đồng

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Phản xạ, đối xứng, bắc cầu, hash.
- **Bối cảnh và yêu cầu:** Tạo a,b,c cùng tọa độ; d tọa độ khác. Trước khi chạy, viết kết quả a.equals(a),a.equals(b),b.equals(a),a.equals(c),a.equals(null),hash a==hash b. Có thể suy ra !a.equals(d) chỉ từ hash khác/giống không?
- **Đầu vào / kết quả / ví dụ sử dụng:** a,b,c=(1,1),d=(2,2).
- **Biên và chính sách:** Cùng hash nhưng khác tọa độ; không yêu cầu hash khác nhau cho mọi object khác.
- **Hoàn thành khi:** Phân biệt chiều bắt buộc equals→cùng hash và chiều ngược không đúng.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## EQ-03 — Overload bị tưởng là override

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Chữ ký equals(Object) và dispatch.
- **Bối cảnh và yêu cầu:** Code định nghĩa equals(BadKey) nhưng không equals(Object). Dự đoán so qua biến Object rồi sửa bằng @Override đúng chữ ký và hashCode cùng dữ liệu. Code lỗi minh họa chỉ ở Markdown.
- **Đầu vào / kết quả / ví dụ sử dụng:** BadKey a,b khác instance cùng id; a.equals(b) có thể true nhưng ((Object)a).equals(b) vẫn false trước sửa.
- **Biên và chính sách:** null; kiểu khác; id không null; không sửa bằng cast tại mọi điểm gọi.
- **Hoàn thành khi:** So qua Object và kiểu cụ thể nhất quán; @Override giúp compiler phát hiện chữ ký sai.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
class BadKey {
    final String id;
    BadKey(String id) { this.id = id; }
    public boolean equals(BadKey other) { return other != null && id.equals(other.id); }
}
```

## EQ-04 — Định danh ấn bản sách

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Key ghép và dữ liệu mô tả.
- **Bối cảnh và yêu cầu:** Tạo EditionKey(isbn,edition) bất biến; isbn không null/trắng, edition>0; bằng nhau khi cả hai giống. Không chuẩn hóa ISBN hay ép dùng record. Tên sách không thuộc key và có thể đổi riêng.
- **Đầu vào / kết quả / ví dụ sử dụng:** ("ISBN-A",1) bằng bản sao cùng dữ liệu; khác edition2 thì không bằng.
- **Biên và chính sách:** Null/trắng ISBN; edition0/âm; String khác instance nhưng cùng giá trị.
- **Hoàn thành khi:** Equality đúng theo key ghép; giải thích tại sao đổi tên không phải đổi định danh.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## EQ-05 — Đếm giá trị duy nhất không dùng Set

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Equality, mảng, vòng lặp và null.
- **Bối cảnh và yêu cầu:** Viết uniqueCount(Object[]) đếm số giá trị khác nhau bằng equals, null tính một giá trị riêng; không dùng Collection. Dùng EditionKey và String để kiểm tra, không sửa mảng. Chỉ yêu cầu đúng, O(n²) chấp nhận được ở thời điểm này.
- **Đầu vào / kết quả / ví dụ sử dụng:** [key(A,1),key(A,1),key(A,2),null,null]→3; [new String("A"),"A"]→1.
- **Biên và chính sách:** Rỗng→0; toàn null→1; object khác kiểu; equality của input phải tuân hợp đồng.
- **Hoàn thành khi:** Không dùng == để thay equality giá trị, không NPE khi null; giải thích khi chuyển sang HashSet sẽ cần hashCode đúng.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
