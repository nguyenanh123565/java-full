# Bài tập tự làm: Ghi đè giữ hợp đồng

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Sau inheritance, abstraction, polymorphism và interface_demo. Không bắt static hiding/final hay checked exception; các phần đó trong bài cũ quay lại sau static_final và exception.

Bài cũ [OverridingExercise.java](../OverridingExercise.java) đã có Animal/Dog, Parent/Child super.describe và static/field hiding. Bộ mới dùng phí dịch vụ, chữ ký và hợp đồng giá trị.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.overriding.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.overriding.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## OVR-01 — Phí dịch vụ ưu tiên

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** Override và @Override.
- **Bối cảnh và yêu cầu:** Tạo Service fee(int units): units 0..100 thì 10+units, ngoài miền -1. PriorityService ghi đè fee để cộng 5 vào phí hợp lệ. Gọi qua Service và không sửa hành vi của Service thường.
- **Dữ liệu / ví dụ sử dụng:** Service fee(3)=13; PriorityService qua biến Service fee(3)=18.
- **Trường hợp biên:** units 0,100,-1,101; -1 không được cộng thành 4.
- **Hoàn thành khi:** Có @Override, giữ validation và giải thích runtime chọn implementation nào.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVR-02 — Method cha gọi method con

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Dispatch qua this ngầm.
- **Bối cảnh và yêu cầu:** Tạo Service như OVR-01 thêm String describe(int n) { return "fee="+fee(n); }. PriorityService override fee. Dự đoán Service s=new PriorityService(); s.describe(3). Giải thích vì sao describe không override vẫn quan sát fee con.
- **Dữ liệu / ví dụ sử dụng:** Lời gọi describe(3), rồi describe(-1).
- **Trường hợp biên:** Không gọi describe trong constructor; phân biệt super.fee gọi trực tiếp với fee gọi trên object hiện tại.
- **Hoàn thành khi:** Có output dự đoán và giải thích chuỗi lời gọi theo object thực tế.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVR-03 — Chữ hoa làm khác method

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Tên và chữ ký override.
- **Bối cảnh và yêu cầu:** PriorityService viết `int Fee(int units) { return 15+units; }` nên Service s=new PriorityService(); s.fee(3) ra 13. Sửa để đúng 18 và từ chối units sai. Giữ bản lỗi comment và thêm @Override.
- **Dữ liệu / ví dụ sử dụng:** Sau sửa fee(3)=18, fee(-1)=-1.
- **Trường hợp biên:** Tên Java phân biệt hoa/thường; không đổi tham số thành long.
- **Hoàn thành khi:** Giải thích compiler không coi Fee là fee và @Override phát hiện lỗi trước khi chạy.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVR-04 — Mở rộng không tự gọi lại

- **Mức độ:** Vận dụng + tìm lỗi.
- **Kiến thức luyện:** super, bảo toàn hợp đồng.
- **Bối cảnh và yêu cầu:** Sửa `PriorityService.fee(int n) { return this.fee(n)+5; }` để tái dùng phí cha, giữ miền 0..100 và không đệ quy. Thêm PremiumService cộng 10 vào phí Service thường, độc lập với PriorityService; giải thích chọn extends Service thay vì PriorityService.
- **Dữ liệu / ví dụ sử dụng:** units=3: Priority 18, Premium 23; units=-1: cả hai -1.
- **Trường hợp biên:** 0,100; không thực sự chạy vòng đệ quy vô hạn để thử.
- **Hoàn thành khi:** Dùng super hợp lý, viết giải thích lookup method và ý nghĩa từng quan hệ kế thừa.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## OVR-05 — Bảng giá giữ lời hứa

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Override, mảng đa hình, biên và review hợp đồng.
- **Bối cảnh và yêu cầu:** Tạo Service[] gồm thường, Priority và Premium. Viết fees(Service[],int) trả int[] cùng thứ tự, ô null=-1, mảng null→rỗng. Thử một BadService trả -5 cho input hợp lệ: giải thích vì sao compiler vẫn cho phép và vì sao thiết kế vi phạm hợp đồng fee>=0. Không đưa BadService vào sản phẩm cuối.
- **Dữ liệu / ví dụ sử dụng:** units=3 → [13,18,23]; units=101 → [-1,-1,-1].
- **Trường hợp biên:** Mảng rỗng/null, ô null, units=0/100; giữ code lỗi dưới comment hoặc class riêng chỉ kiểm chứng.
- **Hoàn thành khi:** Đủ output và review hành vi; phân biệt lỗi compiler với lỗi hợp đồng cần ca kiểm tra.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
