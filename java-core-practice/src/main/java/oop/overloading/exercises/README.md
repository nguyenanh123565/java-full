# Bài tập tự làm: Nạp chồng rõ ý định

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau methods và các mục OOP trước overloading. Dùng int,long,String,Object và instance method; không bắt Integer/boxing/varargs. Bài choose(String)/choose(Integer) cũ quay lại sau wrapper.

Bài cũ [OverloadingExercise.java](../OverloadingExercise.java) đã có sum, describe(Object/String) và null ambiguous. Bộ mới dùng API ghi nhãn, widening và tác động của thứ tự kiểu tham số.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.overloading.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.overloading.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## OVL-01 — Nhãn một hoặc nhiều bản

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Khác số lượng tham số, ủy quyền.
- **Bối cảnh và yêu cầu:** Tạo Labeler.label(String text) và label(String text,int copies), trả chuỗi các bản nối bằng dấu |. Một tham số tương đương copies=1; text null xem rỗng. copies ngoài 0..5 trả "INVALID"; 0 trả rỗng. Không có dấu | ở cuối.
- **Dữ liệu / ví dụ sử dụng:** label("A") → A; label("A",3) → A|A|A; label("A",0) → "".
- **Trường hợp biên:** copies=-1,5,6; text="" hoặc null, copies=2 → "|".
- **Hoàn thành khi:** Hai overload gọi được, quy tắc nằm ở overload đủ tham số; chỉ dùng loop và String.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVL-02 — Mở rộng primitive

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Widening và chọn overload khi compile.
- **Bối cảnh và yêu cầu:** Đọc class Chooser có pick(int)= "int" và pick(long)= "long". Dự đoán pick(3), pick(3L), và short s=3; pick(s). Không thêm overload khác; giải thích widening từ short và ý nghĩa hậu tố L.
- **Dữ liệu / ví dụ sử dụng:** Các đối số: literal int, literal long và biến short.
- **Trường hợp biên:** Không thu hẹp long về int tự động; pick(2147483648L) vẫn chọn long.
- **Hoàn thành khi:** Ghi dự đoán trước khi chạy và quy tắc chọn từ kiểu đối số lúc compile.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVL-03 — Đổi tên tham số không đủ

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Signature không gồm tên tham số/return.
- **Bối cảnh và yêu cầu:** Hai cặp khai báo đều sai nếu ở cùng class: `String tag(int count)` và `String tag(int copies)`; `int size(String s)` và `long size(String s)`. Giải thích riêng từng lỗi. Sửa bằng cách giữ một tag(int) và thêm tag(String,int) có ý nghĩa; size chỉ giữ một kiểu trả về. Không để bản lỗi vào source đang build.
- **Dữ liệu / ví dụ sử dụng:** tag(2) → X|X; tag("A",2) → A|A; size("AB") →2, size(null) →0.
- **Trường hợp biên:** count ngoài 0..5 theo OVL-01; String rỗng/null.
- **Hoàn thành khi:** Giữ một chữ ký cho mỗi tập tham số, code compile và giải thích vì sao return không cứu được overload.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVL-04 — Thứ tự kiểu tham số

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Overload theo thứ tự kiểu, API dễ hiểu.
- **Bối cảnh và yêu cầu:** Tạo PairFormatter.format(String text,int count) trả text+":"+count và format(int count,String text) trả count+":"+text. text null chuẩn hóa ""; count được in nguyên trạng. Thử cùng dữ liệu ở hai thứ tự rồi viết một trường hợp chỉ đổi thứ tự tên hai tham số int,int không tạo overload. Nhận xét khi nào nên dùng tên method rõ hơn.
- **Dữ liệu / ví dụ sử dụng:** format("A",2) → A:2; format(2,"A") →2:A.
- **Trường hợp biên:** count=0,-1; text null; hai kiểu cùng int không phân biệt bằng tên tham số.
- **Hoàn thành khi:** Hai overload compile, mô tả chữ ký và nhận xét tính dễ đọc thay vì tạo overload tùy tiện.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVL-05 — Overload trước, override sau

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Hai giai đoạn chọn method.
- **Bối cảnh và yêu cầu:** Tạo Formatter có format(Object) trả "base-object", format(String) trả "base-string". FancyFormatter override chỉ format(Object) trả "fancy-object". Với Formatter f=new FancyFormatter(); String s="A"; Object o=s; dự đoán f.format(s), f.format(o), f.format(null). Giải thích cả bước compile và runtime; không cần Integer hoặc boxing.
- **Dữ liệu / ví dụ sử dụng:** Đối số lần lượt kiểu String, Object, literal null.
- **Trường hợp biên:** Null khớp String/Object nhưng String cụ thể hơn; không dereference input.
- **Hoàn thành khi:** Output đúng, có bảng chữ ký chọn và implementation chạy; không cho rằng object thực tế của đối số quyết định overload.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
