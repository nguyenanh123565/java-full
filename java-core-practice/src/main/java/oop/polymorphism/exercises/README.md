# Bài tập tự làm: Đa hình qua lớp cha

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau abstraction. Bài mới dùng lớp cha abstract, mảng, override và null; chưa bắt interface, exception/downcast. Bài cast lỗi trong PolymorphismExercise cũ chỉ thực hiện phần try/catch sau khi học exception.

Bài cũ [PolymorphismExercise.java](../PolymorphismExercise.java) đã có Animal, Payment và cast. Bộ mới dùng quy tắc giảm giá, caller ổn định khi thêm kiểu mới và kiểm tra hợp đồng.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.polymorphism.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.polymorphism.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## POLY-01 — Quy tắc giảm giá

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Reference lớp cha và dispatch.
- **Bối cảnh và yêu cầu:** Tạo abstract Discount với apply(int price). NoDiscount trả nguyên giá; HalfDiscount trả price/2 (chia nguyên). Price hợp lệ 0..10000, sai trả -1. Gọi cả hai qua Discount, không dùng instanceof.
- **Dữ liệu / ví dụ sử dụng:** price=101 → NoDiscount 101, HalfDiscount 50.
- **Trường hợp biên:** 0,1,10000 hợp lệ; -1,10001 sai.
- **Hoàn thành khi:** Cùng lời gọi apply có kết quả khác theo object nhưng giữ hợp đồng chung.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## POLY-02 — Đổi biến giữ object

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Identity, kiểu khai báo và runtime.
- **Bối cảnh và yêu cầu:** Dùng POLY-01, dự đoán: Discount a=new HalfDiscount(); Discount b=a; a=new NoDiscount(); in a.apply(100), b.apply(100), a==b. Vẽ reference sau mỗi phép gán.
- **Dữ liệu / ví dụ sử dụng:** Dữ liệu đầu 100; hai lần new.
- **Trường hợp biên:** Đối chiếu trước khi gán lại a thì a==b; không thực hiện cast.
- **Hoàn thành khi:** Có output dự đoán và giải thích tại sao gán a không làm b trỏ sang object mới.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## POLY-03 — Chữ ký sai làm mất đa hình

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Override đúng chữ ký.
- **Bối cảnh và yêu cầu:** Sửa NoDiscount cơ sở không abstract có apply(int)=price, HalfDiscount lại viết apply(long)=price/2; `Discount d = new HalfDiscount(); d.apply(100)` vẫn 100. Chỉ ra overload ngoài ý muốn; sửa để ra 50 và thêm @Override. Bản kiểm chứng có thể dùng lớp Discount cụ thể riêng trong starter, không sửa lời giải cũ.
- **Dữ liệu / ví dụ sử dụng:** Qua biến Discount với int 100, sau sửa →50.
- **Trường hợp biên:** 0,101; giữ output -1 cho giá ngoài miền theo POLY-01.
- **Hoàn thành khi:** Giải thích bước compiler chọn chữ ký và runtime chọn implementation; code lỗi nằm comment sau kiểm tra.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## POLY-04 — Bảng so sánh ưu đãi

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Caller dùng hợp đồng chung.
- **Bối cảnh và yêu cầu:** Viết quote(Discount[] discounts,int price) trả int[] cùng số ô, mỗi ô là giá sau giảm; discount null →-1. Mảng discounts null trả mảng rỗng. Không đổi mảng đầu vào và không if tên lớp.
- **Dữ liệu / ví dụ sử dụng:** [NoDiscount,HalfDiscount,null], price=101 → [101,50,-1].
- **Trường hợp biên:** Mảng rỗng; giá sai làm mọi ô -1; cùng reference hai ô vẫn hai kết quả.
- **Hoàn thành khi:** Có kiểm tra độ dài, thứ tự và input không đổi; từng implementation giữ trách nhiệm tính giá.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## POLY-05 — Thêm ưu đãi mới

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Mở rộng đa hình, validation và biên.
- **Bối cảnh và yêu cầu:** Thêm MinusTenDiscount: giá hợp lệ giảm 10 nhưng thấp nhất 0, vẫn từ chối ngoài 0..10000. Dùng nguyên quote của POLY-04 với ba loại. Giải thích code nào cần thêm/sửa và vì sao caller không phụ thuộc kiểu cụ thể. Không cần tạo hierarchy phức tạp hơn.
- **Dữ liệu / ví dụ sử dụng:** price=9 với [NoDiscount,HalfDiscount,MinusTenDiscount] → [9,4,0]; price=101 → [101,50,91].
- **Trường hợp biên:** price=0,10,10000,-1,10001; kiểm tra quote cũ vẫn đúng.
- **Hoàn thành khi:** Thêm class và phần lắp dữ liệu; quote không cần sửa; viết 3–5 dòng giải thích dispatch.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
