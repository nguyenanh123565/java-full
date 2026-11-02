# Tự làm: Tham chiếu

[Về mục học](../README.md)

## Trước khi làm

Sau strings; đọc ReferenceDemo. Cho phép Box nhỏ giống demo, có int value và constructor để quan sát; không yêu cầu thiết kế OOP, kế thừa, collection, exception hoặc override equals.

Bài cũ [ReferenceExercise.java](../ReferenceExercise.java) đã có alias, hai object cùng giá trị và swap. Bộ mới thêm snapshot primitive, array chứa reference và hợp đồng mutation.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.reference.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.reference.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### REF-01 — Ảnh chụp số và alias · Dễ · Cơ bản

- **Kiến thức luyện:** Sao chép primitive so với reference.
- **Bối cảnh và yêu cầu:** Tạo Box a có value=5; int saved=a.value; Box alias=a. Sửa alias.value=8 rồi in a.value,saved,a==alias. Sau đó gán alias sang Box mới 9 và in lại a.value,saved. Vẽ sơ đồ.
- **Dữ liệu / kết quả / ví dụ:** Sau lần sửa: 8 / 5 / true; sau gán lại: 8 / 5.
- **Trường hợp biên:** Thử value ban đầu bằng 0 hoặc số âm; saved là int độc lập, không tự theo dõi Box.
- **Tiêu chí hoàn thành:** Chỉ ra thời điểm có một hoặc hai Box theo các biểu thức new trong đoạn. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### REF-02 — Hai slot rồi tách một slot · Vừa · Suy luận

- **Kiến thức luyện:** Array reference; gán lại slot; alias.
- **Bối cảnh và yêu cầu:** Dự đoán `Box shared=new Box(1); Box[] boxes={shared,shared}; boxes[0].value=7; boxes[0]=new Box(9);` rồi in boxes[0].value,boxes[1].value,shared.value và boxes[0]==boxes[1].
- **Dữ liệu / kết quả / ví dụ:** Tự ghi bốn output; sau đó gán shared=null, dự đoán boxes[1].value.
- **Trường hợp biên:** Không truy cập shared.value sau shared=null; mỗi slot vẫn có reference riêng.
- **Tiêu chí hoàn thành:** Giải thích vì sao thay slot 0 không sửa slot 1 hoặc biến shared. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### REF-03 — Reset không tới caller · Vừa · Tìm lỗi

- **Kiến thức luyện:** Pass-by-value; hợp đồng mutation; null guard.
- **Bối cảnh và yêu cầu:** Một hàm `reset(Box box){box=null;}` được kỳ vọng đưa value của Box ở caller về 0. Viết resetValue(Box) đúng hợp đồng: khác null thì sửa value=0, null thì không làm gì. Giữ object cũ; không đổi biến caller sang null.
- **Dữ liệu / kết quả / ví dụ:** a=Box(9), alias=a; sau resetValue(a), cả hai value=0 và a==alias vẫn true.
- **Trường hợp biên:** null không gây exception; Box đã value=0; nhiều alias cùng thấy reset.
- **Tiêu chí hoàn thành:** Nêu vì sao bản cũ chỉ đổi biến tham số; bản sửa không tạo Box mới. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### REF-04 — Copy từng Box theo slot · Vừa · Vận dụng

- **Kiến thức luyện:** Copy sâu theo hợp đồng; null; độc lập trạng thái.
- **Bối cảnh và yêu cầu:** Viết copyBoxes(Box[] source) khác null: tạo array mới, mỗi slot khác null tạo Box mới chứa cùng value; slot null giữ null. Dù hai slot nguồn cùng Box, hai slot đích phải là hai Box độc lập theo yêu cầu này. Không dùng clone cho Box.
- **Dữ liệu / kết quả / ví dụ:** source=[shared(4),shared(4),null]; copy có value [4,4,null]. Sửa copy[0].value=99: source và copy[1] vẫn 4.
- **Trường hợp biên:** []; toàn null; Box có value âm; không sửa nguồn.
- **Tiêu chí hoàn thành:** Array đích khác nguồn, mọi Box đích khác Box nguồn và các slot đích không chia sẻ khi được tạo riêng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### REF-05 — Chuyển giá trị giữa hai hộp · Vừa · Tổng kết

- **Kiến thức luyện:** Hợp đồng; alias; kiểm tra trước mutation.
- **Bối cảnh và yêu cầu:** Viết transfer(Box from,Box to,int amount) trả boolean. Input Box có value trong [0,1000000], amount trong [0,1000000]. null hoặc from thiếu số lượng ->false và không đổi gì; đủ thì trừ from/cộng to. Nếu hai reference cùng Box và đủ lượng thì true, value giữ nguyên. Không dùng biến toàn cục.
- **Dữ liệu / kết quả / ví dụ:** from=10,to=3,amount=4 ->true,(6,7); amount=20 ->false,không đổi; cùng Box10,amount=4 ->true,10.
- **Trường hợp biên:** amount=0; from/to=null; số lượng đúng bằng amount; cùng Box nhưng thiếu lượng phải false. Không nhận amount âm.
- **Tiêu chí hoàn thành:** Kiểm tra mọi điều kiện trước sửa field; giải thích khi nào caller/alias thấy thay đổi và tính bảo toàn tổng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
