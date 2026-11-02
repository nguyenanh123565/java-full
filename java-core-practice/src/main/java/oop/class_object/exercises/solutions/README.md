# Đối chiếu sau cùng: Class và object

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.class_object.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## OBJ-01 — Hai bộ đếm độc lập

**Cách làm / kết quả đối chiếu:** Counter giữ int value; increment tăng field của object nhận lời gọi. Hai lần new cho hai trạng thái độc lập.

**Lỗi hay gặp:** Đặt một biến đếm ngoài object khiến hai cửa chia sẻ trạng thái.

## OBJ-02 — Reference đi qua method

**Cách làm / kết quả đối chiếu:** Output 4:true, hai object được tạo. Gán c chỉ đổi bản sao reference; biến thể sửa c.value làm a và b đọc 99.

**Lỗi hay gặp:** Tưởng Java truyền biến b theo reference.

## OBJ-03 — Ô mảng chưa có thiết bị

**Cách làm / kết quả đối chiếu:** Tạo mảng rồi dùng vòng lặp gán mỗi ô bằng new Counter(). Đây là hai object Counter độc lập.

**Lỗi hay gặp:** Gán cùng một Counter cho hai ô để né null nhưng tạo alias ngoài ý muốn.

## OBJ-04 — Cảm biến chấp nhận số đo

**Cách làm / kết quả đối chiếu:** Kiểm tra khoảng trước phép gán; chỉ gán reading khi hợp lệ. Đây mới là hành vi cơ bản, private sẽ học ở encapsulation.

**Lỗi hay gặp:** Ghi số đo trước rồi trả false làm thay đổi trạng thái dù báo thất bại.

## OBJ-05 — Bảng theo dõi cảm biến

**Cách làm / kết quả đối chiếu:** Nếu mảng null trả 0; duyệt từng Sensor khác null và tăng count khi read() > threshold. Không loại trùng identity vì hợp đồng đếm theo ô.

**Lỗi hay gặp:** Đếm theo object duy nhất dù đề yêu cầu số ô hoặc dùng >= thay >.

## Câu hỏi review — điểm cần có

1. **Vì sao đổi tham số reference trong method không đổi biến ở caller?** Tham số là bản sao giá trị reference. Gán lại tham số chỉ đổi biến cục bộ; sửa field tác động object mà caller cũng giữ.
2. **Mảng dài 3 có luôn chứa 3 object không?** Mảng reference mới có ba ô null, chưa có object Counter/Sensor. Cần new từng object trước khi gọi method.
3. **Trạng thái bằng nhau có chứng minh cùng identity không?** Không. Hai Counter cùng value=0 vẫn khác identity nếu tạo bằng hai lần new; == kiểm tra cùng object.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
