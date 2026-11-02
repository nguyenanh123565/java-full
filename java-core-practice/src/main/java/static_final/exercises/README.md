# Tự làm: Static và final

[Về mục học](../README.md)

## Trước khi làm

Sau fundamental, OOP và exception theo README gốc. Cho phép class/constructor/đóng gói, method, array, static/final và IllegalArgumentException; chưa dùng collection, generics, reflection hoặc thư viện ngoài.

Bài cũ [StaticFinalExercise.java](../StaticFinalExercise.java) gồm Counter, diện tích tròn và Scores defensive copy một chiều. Bộ mới bổ sung trạng thái từng instance, lỗi static và copy cấu trúc hai chiều.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes static_final.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes static_final.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### STF-01 — Hai phòng dùng chung giới hạn · Dễ · Cơ bản

- **Kiến thức luyện:** Static final cấu hình; instance state; validation.
- **Bối cảnh và yêu cầu:** Tạo SeatPool có static final CAPACITY=3, mỗi instance có used riêng và reserve() trả false khi đầy, true khi nhận thêm một chỗ. Không cho bên ngoài gán used trực tiếp. Tạo hai phòng chứng minh giới hạn dùng chung nhưng số chỗ đã dùng độc lập.
- **Dữ liệu / kết quả / ví dụ:** Phòng A reserve ba lần true, lần bốn false; B lần đầu true và used=1 trong khi A used=3.
- **Trường hợp biên:** Lúc mới tạo used=0; gọi nhiều lần sau đầy không làm used tăng; không yêu cầu đa luồng.
- **Tiêu chí hoàn thành:** Hành vi đúng, giải thích tại sao CAPACITY static final và used không static. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STF-02 — Final giữ điều gì? · Vừa · Suy luận

- **Kiến thức luyện:** Final reference; alias; compile-time constant.
- **Bối cảnh và yêu cầu:** Dự đoán `final int[] limits={3}; int[] alias=limits; alias[0]=5;` rồi in limits[0]. Phân loại ba dòng: `limits=new int[]{7};`, `limits[0]=7;`, `final int maximum=3; int x=maximum+1;` dòng nào biên dịch được và vì sao. Chỉ giữ đoạn hợp lệ trong source.
- **Dữ liệu / kết quả / ví dụ:** Ghi kết quả/khả năng biên dịch trước thử; không cần sửa class loader hoặc JVM.
- **Trường hợp biên:** Array rỗng không có phần tử 0; snippet dùng array dài 1. Alias không bị final theo biến limits.
- **Tiêu chí hoàn thành:** Phân biệt biến final với nội dung object; nêu maximum là hằng biểu thức nhưng array không trở thành bất biến. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STF-03 — Số dư của người này sửa người khác · Vừa · Tìm lỗi

- **Kiến thức luyện:** Static field ngoài ý muốn; constructor; instance method.
- **Bối cảnh và yêu cầu:** Lớp Wallet có `private static int balance; Wallet(int initial){balance=initial;}`. Tạo a=Wallet(10),b=Wallet(20), thấy cả hai cùng 20. Sửa để balance riêng từng ví; giữ một static created đếm constructor thành công. Initial trong [0,1000000], ngoài miền ném IllegalArgumentException và không tăng created.
- **Dữ liệu / kết quả / ví dụ:** Tạo A10,B20 -> balance 10,20; số ví tăng 2. Thử Wallet(-1) -> lỗi, số ví giữ nguyên.
- **Trường hợp biên:** Ví 0 hợp lệ; initial quá 1000000 không tạo thành công; tránh reset static count trong mỗi constructor.
- **Tiêu chí hoàn thành:** Giải thích field nào thuộc lớp/instance; ca lỗi không làm số đếm tăng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STF-04 — Lịch có các hàng độc lập · Khá · Vận dụng

- **Kiến thức luyện:** Final field; defensive copy hai chiều; hợp đồng.
- **Bối cảnh và yêu cầu:** Thiết kế Schedule nhận int[][] số chỗ của từng ca, giữ trạng thái không đổi từ bên ngoài. Constructor và snapshot() đều copy array ngoài và từng hàng; hàng lệch/rỗng hợp lệ, null ngoài/hàng hoặc số âm ném IllegalArgumentException. Có total() long. Không ép một cách tổ chức helper duy nhất.
- **Dữ liệu / kết quả / ví dụ:** Input [[1,2],[],[3]] ->total=6. Sửa input[0][0] hoặc snapshot()[2][0] không làm total đổi.
- **Trường hợp biên:** []; mọi hàng rỗng; phần tử [0,1000000], tổng số ô<=10000; null bất kỳ hàng phải bị từ chối.
- **Tiêu chí hoàn thành:** Không lộ reference array nội bộ, không chia sẻ hàng nguồn/đích; giải thích vì sao chỉ final hoặc copy ngoài chưa đủ. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### STF-05 — Hai giỏ hàng và bộ đếm chung · Khá · Tổng kết

- **Kiến thức luyện:** Encapsulation; static/final; bất biến; snapshot.
- **Bối cảnh và yêu cầu:** Tự thiết kế LimitedCart có tối đa 3 slot cố định (static final MAX_SLOTS), int[] quantities private final, mỗi lượng trong [0,99]. add(index,amount) nhận amount>0, index hợp lệ và tổng slot<=99 thì cập nhật/true; sai trả false, trạng thái không đổi. acceptedCalls static đếm tổng lần add thành công trên mọi giỏ. snapshot trả copy. Giải thích trách nhiệm từng field/method.
- **Dữ liệu / kết quả / ví dụ:** A.add(0,2),B.add(1,3) -> snapshots [2,0,0] và [0,3,0], acceptedCalls tăng 2; A.add(0,98)->false, không đổi.
- **Trường hợp biên:** index -1 hoặc 3, amount 0/âm/MAX_VALUE, tổng đúng 99, hai giỏ độc lập, sửa snapshot không ảnh hưởng giỏ; không yêu cầu đa luồng.
- **Tiêu chí hoàn thành:** Bất biến được bảo vệ; đếm chỉ tăng sau thao tác thành công; không có overflow khi amount quá lớn; nêu vì sao final quantities vẫn sửa được ô. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
