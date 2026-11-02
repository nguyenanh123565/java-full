# Tự làm: Phương thức

[Về mục học](../README.md)

## Trước khi làm

Sau loops; đọc MethodDemo. Bài mới chỉ yêu cầu primitive, return, rẽ nhánh, loop và static method gọi từ main. Chưa yêu cầu mảng, class tự thiết kế hoặc exception; input sai được loại bằng hợp đồng ghi ở đề.

Bài cũ [MethodExercise.java](../MethodExercise.java) đã có max, increment và sửa/gán lại mảng. Bộ mới luyện hợp đồng, đường return và chia việc thành hàm; không bắt buộc dùng mảng trước bài arrays.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.methods.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.methods.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### MET-01 — Giới hạn giá trị vào khoảng · Dễ · Cơ bản

- **Kiến thức luyện:** Tham số; return; hợp đồng.
- **Bối cảnh và yêu cầu:** Viết clamp(int value,int min,int max): trả min nếu dưới cận, max nếu trên cận, còn lại giữ value. Hợp đồng min<=max; không dùng Math.min/max.
- **Dữ liệu / kết quả / ví dụ:** clamp(-2,0,10)->0; clamp(7,0,10)->7; clamp(12,0,10)->10.
- **Trường hợp biên:** Thử value đúng hai cận; min==max; toàn bộ khoảng có thể âm.
- **Tiêu chí hoàn thành:** Caller không bị sửa biến nguồn; method trả đúng mọi nhánh và giải thích từng tham số. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MET-02 — Đối số được tính trước lời gọi · Vừa · Suy luận

- **Kiến thức luyện:** Đánh giá đối số; pass-by-value; scope.
- **Bối cảnh và yêu cầu:** Cho add(int left,int right) trả left+right. Dự đoán `int n=3; int result=add(n,n++);` rồi in result,n. Trong add gán lại left=100 sau khi lưu tổng vào biến cục bộ, kết quả caller có đổi không? Giải thích bằng giá trị từng đối số.
- **Dữ liệu / kết quả / ví dụ:** Ghi dự đoán trước chạy; thử n ban đầu bằng -1.
- **Trường hợp biên:** Chỉ dùng n trong [-100,100] để không bị overflow; phân biệt ++ xảy ra ở caller với gán tham số ở callee.
- **Tiêu chí hoàn thành:** Chỉ rõ thời điểm n++ tăng n và giá trị 3 được sao chép vào cả hai tham số. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MET-03 — Return còn thiếu · Dễ · Tìm lỗi

- **Kiến thức luyện:** Đường thực thi; kiểu trả về.
- **Bối cảnh và yêu cầu:** Sửa snippet `static int magnitude(int value){if(value<0)return -value;}` để nhận int trong [-1000000,1000000] và trả độ lớn. Nêu vì sao bản gốc không biên dịch. Chỉ đặt bản đã sửa vào starter.
- **Dữ liệu / kết quả / ví dụ:** magnitude(-7)->7; magnitude(0)->0; magnitude(7)->7.
- **Trường hợp biên:** Hai đầu miền -1000000 và 1000000; MIN_VALUE nằm ngoài hợp đồng, giải thích lý do không mở rộng tùy tiện.
- **Tiêu chí hoàn thành:** Có return cho đường value>=0; không sửa bằng cách đổi void làm mất kết quả. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MET-04 — Đếm bội số trong đoạn · Vừa · Vận dụng

- **Kiến thức luyện:** Method tái sử dụng; loop; chia dư.
- **Bối cảnh và yêu cầu:** Viết countMultiples(int from,int to,int divisor) bằng loop; hai đầu đoạn được tính. from,to thuộc [-100,100], divisor trong [1,100]. Nếu from>to trả 0. Chưa dùng stream/array.
- **Dữ liệu / kết quả / ví dụ:** (-3,3,2)->3 vì -2,0,2; (1,10,3)->3; (5,4,2)->0.
- **Trường hợp biên:** Đoạn một điểm; 0 là bội số của mọi divisor khác 0; đầu đoạn có thể âm.
- **Tiêu chí hoàn thành:** Gọi lại được từ main với ít nhất năm bộ đối số, không dùng biến đếm dùng chung toàn cục. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MET-05 — Báo giá qua các hàm nhỏ · Vừa · Tổng kết

- **Kiến thức luyện:** Tách trách nhiệm; kiểu trả về long; dùng kết quả.
- **Bối cảnh và yêu cầu:** Viết subtotal(int price,int quantity), discounted(long subtotal,int percent), invoice(...) tính tổng hai dòng đã giảm riêng. price trong [0,1000000], quantity trong [0,10000], percent trong [0,100]; tiền giảm lẻ đồng bỏ phần lẻ. invoice gọi hai hàm nhỏ, không dùng array.
- **Dữ liệu / kết quả / ví dụ:** Dòng 1: 2000*3 giảm 10%; dòng 2:10000*2 giảm 0% -> invoice=25400.
- **Trường hợp biên:** Giá/số lượng 0; giảm 100%; subtotal lớn nhất 10000000000; invoice tối đa 20000000000.
- **Tiêu chí hoàn thành:** Đúng kết quả và miền lớn; caller nhận return; giải thích vì sao discounted không thay biến subtotal ở caller. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
