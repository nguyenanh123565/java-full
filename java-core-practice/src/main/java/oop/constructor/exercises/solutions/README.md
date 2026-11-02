# Đối chiếu sau cùng: Constructor và this

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.constructor.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## CTOR-01 — Hẹn giờ mặc định

**Cách làm / kết quả đối chiếu:** Constructor gán this.label bằng label hợp lệ hoặc Timer và this.minutes bằng phút hợp lệ hoặc 0.

**Lỗi hay gặp:** Dùng label = label, minutes = minutes nên chỉ tự gán tham số.

## CTOR-02 — Một object qua hai constructor

**Cách làm / kết quả đối chiếu:** Lần đầu in 1A23 và tạo một Ticket; new Ticket("B") riêng in 1B và tạo một object khác.

**Lỗi hay gặp:** Đếm số constructor chạy thành số object.

## CTOR-03 — Method giả constructor

**Cách làm / kết quả đối chiếu:** Viết Timer(int minutes) { this.minutes = minutes; }. Không có constructor mặc định được sinh khi đã khai báo constructor này.

**Lỗi hay gặp:** Chỉ bỏ void nhưng vẫn để tự gán tham số.

## CTOR-04 — Cấu hình ghế ngồi

**Cách làm / kết quả đối chiếu:** Seat() ủy quyền cho Seat("A",1), Seat(row) cho Seat(row,1); constructor đầy đủ chuẩn hóa và gán field.

**Lỗi hay gặp:** Đặt lệnh khác trước this(...) hoặc tạo Seat phụ rồi bỏ nó.

## CTOR-05 — Lịch hẹn độc lập

**Cách làm / kết quả đối chiếu:** Copy constructor lấy title/minutes hoặc mặc định và gọi constructor đầy đủ. Hai Appointment độc lập; tổng duyệt mảng cộng field minutes.

**Lỗi hay gặp:** Gán copy = original thay vì new Appointment(original).

## Tên và dấu mốc kiểm tra

FixedTimer ở CTOR-03 chính là constructor Timer(int minutes) đã sửa, đổi tên để cùng tồn tại với Timer(String,int) của CTOR-01. Ticket ở bản chạy lưu dấu mốc 1A/2 vào trace thay cho in ngay trong constructor để kiểm tra thứ tự tự động; chuỗi đối chiếu vẫn là 1A23 và lời giải giải thích một object. Bạn có thể in trực tiếp theo đúng đoạn đề để quan sát.

## Câu hỏi review — điểm cần có

1. **Constructor có kiểu trả về không?** Không có kiểu trả về, kể cả void; tên phải trùng class. void Timer(...) là method.
2. **this.field và field tham số khác nhau lúc nào?** Khi tham số trùng tên field, this.minutes chỉ field của object hiện tại còn minutes chỉ tham số.
3. **Một chuỗi this(...) tương ứng bao nhiêu object?** Một lần new tạo một object; this(...) nối các bước khởi tạo của cùng object đó, không tạo object thứ hai.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
