# Đối chiếu sau cùng: Đóng gói và trạng thái hợp lệ

Lời giải chỉ là **một phương án**, đặc biệt với bài thiết kế mở. Đánh giá bằng hợp đồng hành vi, trạng thái và ca biên của đề; không cần ép tên class hoặc phân cấp giống mẫu. Giữ bài tự làm để so sánh khác biệt.

[ReferenceSolution.java](ReferenceSolution.java) là bản tích hợp các bài của mục; class/method dùng chung có thể được mở rộng qua các bài. Đoạn suy luận hoặc lỗi được đối chiếu riêng bên dưới. Các method `check`/`main` và `AssertionError` chỉ là công cụ chạy kiểm tra có sẵn, không phải yêu cầu tự học exception/static trước thứ tự trong roadmap.

Từ gốc `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes oop.encapsulation.exercises.solutions.ReferenceSolution
```

Code có điều kiện kiểm tra tường minh và ném AssertionError nếu sai, nên không cần bật `-ea` hay cài framework. Chạy lời giải chỉ chứng minh ca trong mẫu chạy được; hãy tự thêm ca của bạn theo đề. Phần đánh giá thiết kế/câu tự luận vẫn cần người học tự giải thích.

## ENC-01 — Kho có sức chứa

**Cách làm / kết quả đối chiếu:** add kiểm tra amount > 0 và amount <= capacity - quantity; remove kiểm tra amount <= quantity. Validation trước cập nhật.

**Lỗi hay gặp:** Đặt setter công khai cho quantity hoặc cộng trước kiểm tra.

## ENC-02 — Hai field liên quan nhau

**Cách làm / kết quả đối chiếu:** Hàm lỗi trả false nhưng capacity=3, booked=4. Bản đúng kiểm tra 1..100 và next>=booked trước khi gán; resize(3) giữ capacity=5.

**Lỗi hay gặp:** Tưởng return false tự rollback field.

## ENC-03 — Đặt chỗ rồi mới kiểm tra

**Cách làm / kết quả đối chiếu:** book kiểm tra seats > 0 và seats <= capacity-booked. Thành công mới tăng booked; nhánh false không ghi field.

**Lỗi hay gặp:** Chỉ khôi phục trường hợp vượt capacity mà quên seats âm.

## ENC-04 — Khung giờ luôn hợp lệ

**Cách làm / kết quả đối chiếu:** Một method nhận cả hai giá trị và kiểm tra đủ bất biến trước hai phép gán. Điều này cho phép chuyển khung giờ mà không lộ bước trung gian.

**Lỗi hay gặp:** Gọi setStart trước setEnd khiến dữ liệu tạm không hợp lệ.

## ENC-05 — Phòng họp đổi sức chứa

**Cách làm / kết quả đối chiếu:** Room giữ private capacity/booked. Mỗi thao tác kiểm tra trước ghi, hàm tổng duyệt getter. Chuỗi cuối cho 3/2 và tổng 3.

**Lỗi hay gặp:** Hàm tổng hoặc menu tự sửa field để cứu trạng thái sai thay vì API bảo vệ nó.

## Câu hỏi review — điểm cần có

1. **Vì sao cần kiểm tra cả object ở constructor và method cập nhật?** Constructor đặt trạng thái đầu hợp lệ; method phải giữ bất biến sau mọi thay đổi. Bảo vệ một điểm mà bỏ điểm còn lại vẫn làm object sai.
2. **Một setter cho từng field có thể làm hỏng điều kiện liên quan hai field thế nào?** Setter riêng có thể tạo start>=end hoặc booked>capacity. API nhận trọn bộ dữ liệu để kiểm tra cặp trước khi ghi sẽ giữ bất biến.
3. **Từ chối thao tác có được đổi một phần trạng thái không?** Không theo hợp đồng các bài này. Boolean false nghĩa thao tác bị từ chối và mọi field liên quan giữ nguyên; return false không tự rollback.

Quay lại [review](../review.md) và nâng trạng thái khi đã tự giải thích được. Không chép lời giải thay cho phần suy luận ban đầu.
