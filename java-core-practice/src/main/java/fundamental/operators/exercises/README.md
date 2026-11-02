# Tự làm: Toán tử

[Về mục học](../README.md)

## Trước khi làm

Sau variables; đọc OperatorDemo. Dùng biểu thức số học, so sánh, boolean, ++ và println. Chưa cần if, vòng lặp, mảng hoặc method tự viết.

Bài cũ [OperatorExercise.java](../OperatorExercise.java) đã luyện giảm giá, kiểm tra null và a++ + ++a. Bộ mới luyện phần dư, miền hợp lệ, tác dụng phụ của short-circuit và hóa đơn nguyên đồng.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.operators.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.operators.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### OPR-01 — Chia kiện hàng · Dễ · Cơ bản

- **Kiến thức luyện:** Chia nguyên; phần dư; biểu thức boolean.
- **Bối cảnh và yêu cầu:** Có items sản phẩm và capacity sản phẩm/kiện. Tính số kiện đầy, số sản phẩm dư và cờ có cần kiện lẻ. Chỉ in kết quả biểu thức; chưa viết if.
- **Dữ liệu / kết quả / ví dụ:** items=29, capacity=6 -> 4 / 5 / true; 12,6 -> 2 / 0 / false.
- **Trường hợp biên:** items trong [0,1000000], capacity trong [1,1000]; thử items=0 và capacity=1. Chia cho 0 nằm ngoài hợp đồng.
- **Tiêu chí hoàn thành:** Kết quả đúng và giải thích items = full*capacity + remainder. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### OPR-02 — Vế phải có được chạy? · Vừa · Suy luận

- **Kiến thức luyện:** Short-circuit; ++; đánh giá toán hạng.
- **Bối cảnh và yêu cầu:** Dự đoán từng biến sau: `int attempts=0; boolean a=false && ++attempts>0; boolean b=true || ++attempts>0; boolean c=true && ++attempts==1;`. Ghi a,b,c,attempts trước khi chạy; thử đổi && đầu thành & và giải thích.
- **Dữ liệu / kết quả / ví dụ:** Tự ghi bốn kết quả trước chạy; không có exception trong đoạn này.
- **Trường hợp biên:** Thử thêm attempts ban đầu bằng 1; không giả sử vế có ++ luôn được thực hiện.
- **Tiêu chí hoàn thành:** Nêu được từng lần tăng hoặc không tăng, phân biệt kết quả boolean và tác dụng phụ. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### OPR-03 — Khoảng hợp lệ bị mở rộng · Dễ · Tìm lỗi

- **Kiến thức luyện:** Kết hợp so sánh bằng && và ||.
- **Bối cảnh và yêu cầu:** Một độ tuổi hợp lệ phải thuộc [18,60]. Biểu thức `age >= 18 || age <= 60` cho kết quả sai. Tìm giá trị phản ví dụ, sửa biểu thức và giải thích ý nghĩa hai vế.
- **Dữ liệu / kết quả / ví dụ:** 17 -> false; 18 -> true; 60 -> true; 61 -> false.
- **Trường hợp biên:** Thử -1 và 100; số nguyên có thể nằm ngoài miền tuổi đời thực, cần biểu thức vẫn loại được.
- **Tiêu chí hoàn thành:** Có phản ví dụ cho bản cũ và bảng sáu ca cho bản sửa; chưa dùng if. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### OPR-04 — Đọc ba chữ số · Vừa · Vận dụng

- **Kiến thức luyện:** Chia; phần dư; độ ưu tiên.
- **Bối cảnh và yêu cầu:** Cho mã int trong [0,999], tách chữ số hàng trăm, chục, đơn vị và tính tổng chữ số. In từng chữ số bằng ba println để thể hiện mã có số 0 đứng đầu; chưa định dạng chuỗi hoặc dùng loop.
- **Dữ liệu / kết quả / ví dụ:** 507 -> 5 / 0 / 7 / 12; 7 -> 0 / 0 / 7 / 7.
- **Trường hợp biên:** 0 -> 0/0/0/0; 999 -> 9/9/9/27. Không nhận mã âm hoặc trên 999.
- **Tiêu chí hoàn thành:** Ba chữ số dựng lại được đúng mã; giải thích vì sao lấy phần dư trước/sau chia. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### OPR-05 — Hóa đơn và cờ miễn phí giao · Vừa · Tổng kết

- **Kiến thức luyện:** Long; phép tính phần trăm; &&/||; ngoặc.
- **Bối cảnh và yêu cầu:** Tính subtotal=unitPrice*quantity, discount=subtotal*discountPercent/100, payable=subtotal-discount theo đồng nguyên (giảm lẻ đồng thì bỏ phần lẻ). Miễn phí giao nếu (là thành viên và payable>=100000) hoặc payable>=300000. In ba số và boolean.
- **Dữ liệu / kết quả / ví dụ:** unitPrice=60000, quantity=2, discountPercent=10, member=true -> 120000 / 12000 / 108000 / true.
- **Trường hợp biên:** unitPrice [0,1000000], quantity [0,10000], percent [0,100]; thử payable=99999,100000,299999,300000 với member false/true và hóa đơn 0.
- **Tiêu chí hoàn thành:** Dùng long trước nhân; cờ đúng cả hai ngưỡng và giải thích nhóm điều kiện; tiền không âm. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
