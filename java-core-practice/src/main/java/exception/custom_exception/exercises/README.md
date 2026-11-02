# Tự làm cuối mục: Custom exception

Tiên quyết: OOP, try_catch, throws_demo; chưa dùng Collections và framework.

Đã có: CustomExceptionExercise.java đã dùng tài khoản/rút tiền. Bộ mới chuyển sang đăng ký chỗ, dữ liệu exception và giữ trạng thái hợp lệ. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes exception.custom_exception.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## CE-01 — Ngoại lệ hết chỗ

- **Dạng / mức độ:** Cơ bản · Dễ.
- **Kiến thức luyện:** Checked exception và field dữ liệu.
- **Bối cảnh và yêu cầu:** Tạo checked SeatsUnavailableException(requested,available) có getter và message rõ. reserve(available,requested) trả số còn lại; requested<=0 hoặc available<0 dùng IllegalArgumentException, thiếu chỗ dùng custom exception.
- **Đầu vào / kết quả / ví dụ sử dụng:** (available=5,requested=2)→3; (2,3)→exception có requested3,available2.
- **Biên và chính sách:** Đặt đúng hết; available=0; requested=0/âm; không dùng âm làm tín hiệu lỗi.
- **Hoàn thành khi:** Caller bắt được đúng loại và đọc dữ liệu không phải phân tích chuỗi message.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## CE-02 — Catch quyết định có tiếp tục

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Exception trong vòng lặp và mutation.
- **Bối cảnh và yêu cầu:** Workshop còn 4 chỗ, lần lượt reserve 3,2,1; mỗi lần catch SeatsUnavailableException độc lập. Dự đoán số chỗ sau mỗi lượt và lần nào thành công.
- **Đầu vào / kết quả / ví dụ sử dụng:** Ghi ba trạng thái và ba nhãn OK/FAIL trước khi chạy.
- **Biên và chính sách:** Nếu đặt try ngoài vòng lặp, lượt cuối có chạy không? requested<=0 phải catch khác.
- **Hoàn thành khi:** Nêu vì sao lượt thất bại không giảm chỗ và cách bố trí catch ảnh hưởng batch.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## CE-03 — Trừ trước khi kiểm tra

- **Dạng / mức độ:** Tìm lỗi · Vừa.
- **Kiến thức luyện:** Bất biến trạng thái.
- **Bối cảnh và yêu cầu:** Hàm làm remaining âm rồi mới throw. Sửa để khi thất bại trạng thái và field available trong exception vẫn phản ánh số chỗ trước yêu cầu.
- **Đầu vào / kết quả / ví dụ sử dụng:** remaining=2, reserve3→FAIL, remaining vẫn2, exception.available=2.
- **Biên và chính sách:** Đặt đúng hết; request âm; nhiều lần thất bại liên tiếp.
- **Hoàn thành khi:** Không có remaining âm ở bất kỳ đường đi bình thường nào; validate trước mutation.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

Đoạn code cần đọc hoặc tìm lỗi (minh họa, chỉ chép bản đã sửa vào source khi đề yêu cầu):

```java
remaining -= requested;
if (remaining < 0) throw new SeatsUnavailableException(requested, remaining);
```

## CE-04 — Huỷ chỗ không vượt sức chứa

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Encapsulation, capacity và validation.
- **Bối cảnh và yêu cầu:** Tạo Workshop(capacity>=0), reserve và cancel(count>0). cancel lớn hơn số đã đặt thì ném IllegalArgumentException; cập nhật không được làm available vượt capacity. Reserve thiếu chỗ dùng custom exception.
- **Đầu vào / kết quả / ví dụ sử dụng:** capacity5; reserve3→available2; cancel2→available4; cancel2 nữa bị từ chối, vẫn4.
- **Biên và chính sách:** capacity0; cancel khi chưa đặt; count<=0; lỗi không đổi trạng thái.
- **Hoàn thành khi:** Luôn 0<=available<=capacity và không có setter cho available.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## CE-05 — Hai khu chỗ phối hợp

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** Composition, kiểm tra trước cập nhật.
- **Bối cảnh và yêu cầu:** Tự thiết kế Booking cho hai khu A/B và bookPair(a,b), a/b>=0 nhưng tổng ít nhất1. Chỉ đặt cả cặp khi hai khu đều đủ; nếu một khu thiếu phải giữ nguyên cả hai, exception chứa khu thiếu, requested,available. Không dùng database/transaction; đây là một thread trong bộ nhớ.
- **Đầu vào / kết quả / ví dụ sử dụng:** A=2,B=1; bookPair(1,2)→FAIL, vẫn2/1; bookPair(1,1)→OK, còn1/0.
- **Biên và chính sách:** Một yêu cầu=0; cả hai0; số âm; A thiếu hoặc B thiếu; thất bại không để A đã trừ.
- **Hoàn thành khi:** Có kiểm tra tính nguyên vẹn hai object/trạng thái; giải thích tại sao không reserve A rồi mới thử B. Thiết kế tùy chọn.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
