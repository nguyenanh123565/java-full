# Tự làm: Tổng kết nền tảng

[Về mục học](../README.md)

## Trước khi làm

Chỉ làm sau đủ chín mục: variables -> operators -> condition -> loops -> methods -> arrays -> strings -> reference -> memory. Cho phép primitive, String/StringBuilder, array, method và Locale.ROOT; chưa cần OOP thiết kế, collection, exception, wrapper parsing, stream hoặc thư viện ngoài.

Ba bài ở [README nhóm](../README.md) là chỉ dẫn ôn các mục. Bộ này tạo đầu ra độc lập để tổng hợp chín mục; không lặp các TODO riêng lẻ.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### FUN-01 — Đọc số đếm ASCII bằng tay · Vừa · Cơ bản + vận dụng

- **Kiến thức luyện:** Char; loop; kiểm tra hợp đồng; method.
- **Bối cảnh và yêu cầu:** Viết readCount(String text) trả int trong [0,999999]. Chỉ chấp nhận 1..6 chữ số ASCII 0..9, không khoảng trắng hoặc dấu +/-; null/rỗng/sai trả -1. Không dùng Integer.parseInt để tránh phụ thuộc wrapper chưa học.
- **Dữ liệu / kết quả / ví dụ:** "0042"->42; "0"->0; "999999"->999999; "12a"->-1.
- **Trường hợp biên:** null,"","1234567"," 12","-1" đều -1; số 0 đứng đầu hợp lệ.
- **Tiêu chí hoàn thành:** Kiểm tra từng char, không có truy cập quá chỉ số; giải thích vì sao tối đa 6 số không tràn int. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### FUN-02 — Text, data và snapshot qua hàm · Vừa · Suy luận

- **Kiến thức luyện:** Pass-by-value; String immutable; mutation; copy.
- **Bối cảnh và yêu cầu:** Hàm inspect(String name,int[] values) gán name=name+"!", tăng values[0], rồi gán values sang array mới [99]. Caller có name="A", data=[1], copy=Arrays.copyOf(data,1). Dự đoán name,data,copy sau gọi, vẽ reference của tham số trước/sau khi gán lại.
- **Dữ liệu / kết quả / ví dụ:** Ghi ba kết quả trước chạy; kiểm chứng bằng so nội dung, không dùng == để so String.
- **Trường hợp biên:** data luôn có ít nhất một ô và khác null; không suy luận số String object do concat tạo ra.
- **Tiêu chí hoàn thành:** Giải thích từng thay đổi và vì sao array copy không đổi. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### FUN-03 — Trung bình bị âm · Vừa · Tìm lỗi

- **Kiến thức luyện:** Overflow; long; chia thực; mảng rỗng.
- **Bối cảnh và yêu cầu:** Hàm average(int[] values) dùng int sum rồi return sum/values.length dưới kiểu double. Sửa cho int[] khác null, không rỗng, phần tử trong [0,2000000000], số phần tử <=10000. Không sửa input; nêu hai lỗi độc lập trong bản cũ.
- **Dữ liệu / kết quả / ví dụ:** [2000000000,2000000000]->2000000000.0; [1,2]->1.5.
- **Trường hợp biên:** [0]->0.0; một phần tử; mảng rỗng nằm ngoài hợp đồng và cần ghi rõ điều đó.
- **Tiêu chí hoàn thành:** Cộng dồn long, chuyển kiểu trước chia, giải thích giới hạn tổng 20_000_000_000_000. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### FUN-04 — Báo cáo điểm có dữ liệu sai · Vừa · Vận dụng

- **Kiến thức luyện:** Lọc theo hợp đồng; count; StringBuilder; sentinel.
- **Bối cảnh và yêu cầu:** Viết gradeReport(int[] scores) khác null. Điểm hợp lệ [0,100], đạt khi >=50. Đếm valid,pass,invalid và tổng long của điểm hợp lệ. Trả chuỗi theo đúng định dạng; không sửa mảng.
- **Dữ liệu / kết quả / ví dụ:** [100,-1,50,49,101] -> "valid=3;pass=2;invalid=2;sum=199".
- **Trường hợp biên:** []->"valid=0;pass=0;invalid=0;sum=0"; toàn sai; điểm đúng 0,49,50,100; length<=10000.
- **Tiêu chí hoàn thành:** Điểm sai không được cộng tổng/tính đạt; đúng định dạng và bảng biên; giải thích vì sao 0 là điểm thật. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### FUN-05 — Phiếu bán hàng bằng mảng song song · Khá · Tổng kết

- **Kiến thức luyện:** Hợp đồng; nhiều method; array; String; long; không mutation.
- **Bối cảnh và yêu cầu:** Viết receipt(String[] names,int[] quantities,int[] prices). Ba array khác null, cùng length<=1000. Tên sau trim không rỗng và chỉ gồm chữ ASCII/dấu cách; lượng [0,1000], giá [0,1000000]. Nếu có input sai trả "INVALID", cả bộ rỗng trả "EMPTY". Với dữ liệu hợp lệ, chuẩn hóa tên sang hoa và ghép TÊN=thành_tiền bằng |, cuối cùng ;TOTAL=tổng. Tự tách method, nêu trách nhiệm và vẽ snapshot input.
- **Dữ liệu / kết quả / ví dụ:** names=[" pen ","book"], quantities=[3,2], prices=[2000,10000] -> "PEN=6000|BOOK=20000;TOTAL=26000".
- **Trường hợp biên:** null array/tên; lệch length; tên trống; giá/lượng âm hoặc quá miền; một dòng 0; tổng có thể vượt int; không sửa các array.
- **Tiêu chí hoàn thành:** Ca sai không tạo phiếu dở dang; long trước nhân; test source giữ nguyên; giải thích quan hệ array/slot và độ phức tạp theo số dòng/ký tự. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
