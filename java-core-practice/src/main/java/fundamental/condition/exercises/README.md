# Tự làm: Rẽ nhánh

[Về mục học](../README.md)

## Trước khi làm

Sau variables/operators; đã đọc ConditionDemo. Viết trực tiếp trong main với if/else, ?: và switch. Chưa dùng method tự viết, mảng hoặc vòng lặp.

Bài cũ [ConditionExercise.java](../ConditionExercise.java) gồm dấu của số, xếp loại điểm và năm nhuận. Bộ này chuyển sang phí, lỗi nhánh và cách cộng theo bậc.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.condition.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.condition.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### CON-01 — Phí vào thư viện · Dễ · Cơ bản

- **Kiến thức luyện:** If/else; điều kiện biên.
- **Bối cảnh và yêu cầu:** Tuổi int ngoài [0,120] in INVALID; dưới 6 miễn phí; từ 6 tới dưới 18 giá 10000; còn lại giá 20000. Mỗi lần chạy chỉ in một kết quả.
- **Dữ liệu / kết quả / ví dụ:** age=5 -> 0; 6 -> 10000; 18 -> 20000.
- **Trường hợp biên:** Thử -1,0,17,120,121; tuổi ngoài miền không được nhận nhầm ưu đãi.
- **Tiêu chí hoàn thành:** Có đúng một kết quả ở mọi ca; bảng biên có cả hai bên của mốc 6 và 18. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### CON-02 — Hai kiểu switch · Vừa · Suy luận

- **Kiến thức luyện:** Fall-through; break; switch expression.
- **Bối cảnh và yêu cầu:** Dự đoán bản truyền thống: `int fee=0; switch(level){case 1: fee+=10; case 2: fee+=20; break; default: fee=99;}`. Sau đó viết bản dùng -> để level 1 chỉ nhận 10, level 2 chỉ nhận 20, còn lại 99. Giải thích khác biệt.
- **Dữ liệu / kết quả / ví dụ:** Thử level=1,2,3; ghi kết quả của cả hai bản trước chạy.
- **Trường hợp biên:** level=0 phải đi default; không suy rằng mọi switch đều tự break.
- **Tiêu chí hoàn thành:** Giải thích vì sao bản cũ level=1 nhận tổng hai nhánh; bản mới đúng mỗi mức. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### CON-03 — Dấu chấm phẩy phá điều kiện · Dễ · Tìm lỗi

- **Kiến thức luyện:** Thân if; nhánh độc lập.
- **Bối cảnh và yêu cầu:** Tìm lỗi trong `int stock=0; if(stock>0); { System.out.println("SELL"); }`. Sửa để stock>0 chỉ in SELL, stock==0 in EMPTY và stock<0 in INVALID. Không xóa luôn chức năng SELL.
- **Dữ liệu / kết quả / ví dụ:** stock=2 -> SELL; 0 -> EMPTY; -1 -> INVALID.
- **Trường hợp biên:** Thử 2147483647 và -2147483648 (hai biên int); không cần cộng/trừ stock.
- **Tiêu chí hoàn thành:** Chỉ ra ý nghĩa thân rỗng sau if và block độc lập; cả ba trạng thái chạy đúng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### CON-04 — Bộ kiểm tra tam giác · Vừa · Vận dụng

- **Kiến thức luyện:** Điều kiện đồng thời; kiểm tra miền trước phân loại.
- **Bối cảnh và yêu cầu:** Ba cạnh int trong [1,1000000]. Ngoài miền hoặc không thỏa cả ba bất đẳng thức tam giác in INVALID. Hợp lệ thì in EQUILATERAL nếu đều, ISOSCELES nếu cân, còn lại SCALENE. Chưa cần tính góc/diện tích.
- **Dữ liệu / kết quả / ví dụ:** (3,3,3)->EQUILATERAL; (3,3,2)->ISOSCELES; (3,4,5)->SCALENE.
- **Trường hợp biên:** (1,2,3),(0,2,2),(-1,2,2) đều INVALID; (1000000,1000000,1000000) hợp lệ.
- **Tiêu chí hoàn thành:** Không phân loại tam giác trước khi xác nhận tồn tại; dấu > nghiêm ngặt cho tổng hai cạnh. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### CON-05 — Tiền điện theo bậc · Vừa · Tổng kết

- **Kiến thức luyện:** Rẽ nhánh; long; tính theo từng khoảng.
- **Bối cảnh và yêu cầu:** kWh là int trong [0,1000000], ngoài miền in INVALID. 50 kWh đầu giá 1700/kWh; 50 kWh kế tiếp giá 2000; phần trên 100 giá 2500. In tổng tiền long theo đồng, không VAT. Tự viết bảng tính từng phần cho hai ca bất kỳ.
- **Dữ liệu / kết quả / ví dụ:** 0->0; 50->85000; 51->87000; 100->185000; 120->235000.
- **Trường hợp biên:** Thử 49,99,101,1000000 và -1; giá cao chỉ áp cho phần vượt ngưỡng.
- **Tiêu chí hoàn thành:** Đúng mọi ngưỡng; mức lớn nhất không tràn int; giải thích các hằng tiền cố định của nhánh cuối. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
