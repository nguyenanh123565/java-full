# Tự làm: Wrapper

[Về mục học](../README.md)

## Trước khi làm

Sau fundamental/OOP/exception/static_final. Dùng Integer/Double, boxing/unboxing, equals, parseInt/valueOf, try/catch và array. Không yêu cầu generics, List/Map, stream hoặc kiến thức equals/hashCode tự định nghĩa; bài remove của tài liệu cũ có thể quay lại sau Collections.

Bài cũ [WrapperExercise.java](../WrapperExercise.java) gồm parse ba chuỗi, valueOrZero và List.remove. Bộ mới phân biệt thiếu dữ liệu với 0, tránh unboxing ngầm trong ?: và làm báo cáo array không cần Collections.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes wrapper.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes wrapper.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### WRP-01 — Primitive hay object từ văn bản · Dễ · Cơ bản

- **Kiến thức luyện:** parseInt; valueOf; kiểu trả về; lỗi parse.
- **Bối cảnh và yêu cầu:** Với từng chuỗi "12","+12","-7","2147483647","2147483648", thử Integer.parseInt và Integer.valueOf. Ghi kiểu biến nhận, giá trị hoặc loại lỗi; xử lý từng chuỗi riêng để một lỗi không chặn chuỗi sau. Chưa trim tự động.
- **Dữ liệu / kết quả / ví dụ:** "12" -> int 12 và Integer 12; "2147483648" -> NumberFormatException ở cả hai cách.
- **Trường hợp biên:** "", " 12 ", "-2147483648"; parseInt không nhận khoảng trắng hai đầu; không truyền null trong bài này.
- **Tiêu chí hoàn thành:** Phân biệt return int/Integer, các giá trị biên và exception; không nói valueOf chỉ là đổi tên parseInt. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### WRP-02 — Kết luận nào độc lập cache? · Vừa · Suy luận

- **Kiến thức luyện:** Equals; identity; khác kiểu wrapper.
- **Bối cảnh và yêu cầu:** Tạo Integer a=1000,b=1000; Long c=1000L. Phân tích a==b, a.equals(b), a.equals(c), a.intValue()==c.longValue(). Với == giữa hai Integer ngoài vùng bảo đảm, không khẳng định một output cố định cho mọi JVM; ghi kết quả máy hiện tại như một quan sát.
- **Dữ liệu / kết quả / ví dụ:** Ba phép so sánh có kết luận ổn định cần tự dự đoán; a==b chỉ ghi quan sát môi trường.
- **Trường hợp biên:** Thử thêm a=127,b=127 bằng autoboxing hằng; không dùng new Integer đã deprecated để ép kết quả.
- **Tiêu chí hoàn thành:** Giải thích identity so với giá trị và Integer so với Long; thuật toán không phụ thuộc cache. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### WRP-03 — Fallback bị unbox thành lỗi · Vừa · Tìm lỗi

- **Kiến thức luyện:** Ternary; boxing/unboxing; giữ dữ liệu thiếu.
- **Bối cảnh và yêu cầu:** Hàm Integer choose(Integer preferred,Integer fallback) dùng `return preferred!=null ? preferred.intValue() : fallback;`. Khi cả hai null lại ném lỗi. Sửa để ưu tiên preferred nếu có, còn lại trả fallback và cho phép kết quả null. Không biến null thành 0.
- **Dữ liệu / kết quả / ví dụ:** (8,3)->8; (null,3)->3; (8,null)->8; (null,null)->null.
- **Trường hợp biên:** 0 là giá trị hợp lệ; thử (0,5); số âm cũng hợp lệ.
- **Tiêu chí hoàn thành:** Giải thích nhánh primitive khiến fallback bị unbox; bản sửa giữ đúng ngữ nghĩa dữ liệu thiếu. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### WRP-04 — Nhập một giá trị có thể vắng · Vừa · Vận dụng

- **Kiến thức luyện:** Null; trim; parse; catch; wrapper return.
- **Bối cảnh và yêu cầu:** Viết importNumber(String text) trả Integer: null, trim rỗng hoặc không parse được int thì trả null; còn lại trả giá trị. Dùng nó cho array văn bản, đếm số hợp lệ và cộng long, không dừng ở chuỗi lỗi.
- **Dữ liệu / kết quả / ví dụ:** [" 8 ","abc",null,"0","-3",""] ->valid=3,sum=5; importNumber("0") không được null.
- **Trường hợp biên:** MIN_VALUE/MAX_VALUE hợp lệ; vượt miền trả null; dữ liệu thiếu và parse sai cùng được xem không có số trong hợp đồng bài này.
- **Tiêu chí hoàn thành:** Unbox chỉ sau null guard; catch đúng NumberFormatException; thử thứ tự lỗi trước/sau số hợp lệ. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### WRP-05 — Báo cáo cảm biến có dữ liệu thiếu · Khá · Tổng kết

- **Kiến thức luyện:** Array wrapper; null; primitive accumulator; min/max; parse.
- **Bối cảnh và yêu cầu:** Viết sensorReport(Integer[] readings) khác null: count là số không null, missing là số null, sum long; min/max theo giá trị có mặt. Không có số nào thì min/max in NA, không tự thay bằng 0. Thêm adapter từ String[] dùng importNumber của WRP-04; không sửa input.
- **Dữ liệu / kết quả / ví dụ:** [0,null,-5,20] -> "count=3;missing=1;sum=15;min=-5;max=20". [null,null] -> "count=0;missing=2;sum=0;min=NA;max=NA".
- **Trường hợp biên:** []; toàn âm; chỉ 0; MAX_VALUE xuất hiện hai lần tổng=4294967294; adapter với chuỗi sai trở thành null theo hợp đồng.
- **Tiêu chí hoàn thành:** Min/max khởi tạo từ số hợp lệ đầu tiên, không từ 0; không NPE; giải thích dữ liệu thiếu và số 0; có test adapter. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
