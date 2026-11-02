# Bài tập tự làm: Đóng gói và trạng thái hợp lệ

Làm sau README/tutorial và Demo của mục. Giữ bài làm, code cũ và ghi chú của bạn tại chỗ; bộ này nằm riêng để bổ sung phần tự kiểm tra.

## Tiên quyết và bài đã có

Đã học fundamental, class_object và constructor. Không bắt dùng exception/final; API từ chối bằng boolean. Các lời giải Wallet cũ dùng exception/Math.addExact: chỉ đọc phần đó sau exception.

Bài cũ [EncapsulationExercise.java](../EncapsulationExercise.java) đã có Student tuổi, Wallet và defensive copy Scores. Bộ này thêm bất biến nhiều field và cập nhật nguyên vẹn trong kho/phòng họp.

## Cách học và chạy

Đọc đề → tự làm → chạy kiểm tra → giải thích bằng lời → xem gợi ý nếu bí → đối chiếu lời giải sau cùng. Với bài suy luận, ghi dự đoán trước khi chạy; với bài tìm lỗi, lưu đoạn lỗi trong comment để project vẫn build được. Ghi chú có thể là comment riêng hoặc một file bạn tự đặt tên, không ghi đè notes hiện có.

Làm theo thứ tự mã bên dưới. Tự viết code trong [starter/Starter.java](starter/Starter.java), có thể thêm các class cùng package `oop.encapsulation.exercises.starter`. Starter chỉ có TODO và không gọi lời giải. Tự thêm kiểm tra theo đề, đừng coi việc main chạy xong là chứng minh đúng.

Từ thư mục gốc `java-core-practice` (xem [hướng dẫn JDK/build](../../../../../../README.md)), chạy bằng JDK 17+ và source Java 17:

```powershell
.\build.ps1
java -cp target/classes oop.encapsulation.exercises.starter.Starter
```


Sau mỗi thay đổi Java, build lại. Starter ban đầu biên dịch được nhưng chưa thực hiện bài. Không thêm dependency/framework kiểm thử. Gợi ý nằm ở [hints.md](hints.md); hoàn thành và trả lời [review.md](review.md) trước khi mở thư mục `solutions/`.

Giới hạn chung: dữ liệu chỉ trong bộ nhớ; không đọc file, không mạng/database/framework. Mảng đầu vào của các bài có tối đa 1000 phần tử, trừ khi bài quy định sức chứa nhỏ hơn; không yêu cầu xử lý ngoài miền này. Với thiết kế mở, tên class và cách chia object có thể khác miễn đạt hành vi và giải thích trách nhiệm. Có thể dùng `String.isEmpty()` (tương đương `length() == 0`), `length()`, `charAt()`, `equals()` đã quen; riêng parsing enum được dùng `trim()` và `equalsIgnoreCase()` để so mã không phân biệt hoa/thường.

## ENC-01 — Kho có sức chứa

- **Mức độ:** Cơ bản.
- **Kiến thức luyện:** private, getter, bất biến.
- **Bối cảnh và yêu cầu:** Tạo Bin có capacity cố định theo hành vi và quantity private. Constructor nhận capacity 1..100, sai dùng 1; quantity bắt đầu 0. add(int amount) và remove(int amount) chỉ nhận số dương, giữ 0 <= quantity <= capacity; trả boolean và không có setQuantity.
- **Dữ liệu / ví dụ sử dụng:** Bin(5): add(3) → true; add(3) → false, quantity=3; remove(3) → true, quantity=0.
- **Trường hợp biên:** Thêm 0/âm; đầy đúng sức chứa; rút nhiều hơn tồn; capacity 0 và 100.
- **Hoàn thành khi:** Mọi thao tác sai giữ trạng thái, đọc bằng getter; từ code ngoài không sửa trực tiếp quantity.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENC-02 — Hai field liên quan nhau

- **Mức độ:** Suy luận.
- **Kiến thức luyện:** Bất biến và thứ tự cập nhật.
- **Bối cảnh và yêu cầu:** Phòng có capacity=5 và booked=4. Người viết thêm `boolean resize(int next) { capacity = next; return booked <= capacity; }`. Dự đoán kết quả resize(3), rồi trạng thái cuối; giải thích getter không tự bảo vệ object. Nêu hành vi đúng mong muốn.
- **Dữ liệu / ví dụ sử dụng:** Dữ liệu đầu: capacity 5, booked 4; yêu cầu mới capacity 3.
- **Trường hợp biên:** Thử next=4,5,0; capacity hợp lệ 1..100.
- **Hoàn thành khi:** Ghi output trước khi chạy và chỉ rõ điều kiện bị phá, đề xuất sửa giữ nguyên toàn bộ khi false.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENC-03 — Đặt chỗ rồi mới kiểm tra

- **Mức độ:** Tìm lỗi.
- **Kiến thức luyện:** Cập nhật nguyên vẹn.
- **Bối cảnh và yêu cầu:** Sửa `booked += seats; if (seats <= 0 || booked > capacity) return false; return true;`. Dùng capacity=5, booked=4, gọi book(2). Giải thích vì sao chỉ trừ lại ở một nhánh vẫn dễ bỏ sót, rồi viết cách cập nhật sau kiểm tra.
- **Dữ liệu / ví dụ sử dụng:** Bản đúng book(2) → false và booked vẫn 4; book(1) → true và booked=5.
- **Trường hợp biên:** seats=-1,0; đã đầy; đặt đúng phần còn lại.
- **Hoàn thành khi:** Mỗi ca false giữ cả capacity và booked, không dựa vào try/catch.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENC-04 — Khung giờ luôn hợp lệ

- **Mức độ:** Vận dụng.
- **Kiến thức luyện:** Validation nhiều field, API hành vi.
- **Bối cảnh và yêu cầu:** Tạo TimeWindow với start=0, end=1 ban đầu; luôn 0 <= start < end <= 24. Chỉ cung cấp reschedule(int start,int end) thay đồng thời hai mốc, trả boolean; getter đọc. Không có setter riêng làm trạng thái trung gian sai.
- **Dữ liệu / ví dụ sử dụng:** reschedule(9,12) → true; reschedule(14,13) → false và vẫn 9..12.
- **Trường hợp biên:** 0..24 hợp lệ, 12..12 sai, -1..5 sai, 23..25 sai.
- **Hoàn thành khi:** Bất biến đúng từ lúc tạo tới sau mọi thao tác; giải thích chọn hành vi thay vì setter tự động.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.

## ENC-05 — Phòng họp đổi sức chứa

- **Mức độ:** Tổng kết.
- **Kiến thức luyện:** Constructor, đóng gói, mảng và bất biến.
- **Bối cảnh và yêu cầu:** Tạo Room dùng quy tắc capacity như ENC-01, booked=0; có book theo ENC-03, resize theo ENC-02 và cancel(int seats) không cho hủy hơn đã đặt. Chạy chuỗi thao tác rồi viết totalBooked(Room[]) bỏ null, mảng null trả 0. Không cho bên ngoài chỉnh field.
- **Dữ liệu / ví dụ sử dụng:** Room(5): book(4)=true; resize(3)=false; cancel(2)=true; resize(3)=true → capacity=3,booked=2. Thêm Room(2) book(1): tổng=3.
- **Trường hợp biên:** cancel 0/âm/quá số đã đặt; mảng rỗng/null; resize đúng booked; capacity tối đa 100.
- **Hoàn thành khi:** Kiểm tra toàn chuỗi và trạng thái sau từng thất bại; giải thích trách nhiệm Room và hàm tổng.
- **Được dùng / giới hạn:** Chỉ dùng kiến thức tiên quyết và nội dung của mục; không dùng thư viện ngoài.
