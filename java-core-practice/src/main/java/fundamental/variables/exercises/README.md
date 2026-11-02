# Tự làm: Biến và kiểu dữ liệu

[Về mục học](../README.md)

## Trước khi làm

Đọc README và VariableDemo. Chỉ dùng khai báo/gán biến, literal, ép kiểu, phép tính số đã minh họa và println trong main. Chưa cần if, vòng lặp, mảng, method tự viết, Scanner hay exception.

Ba bài diện tích, chia/ép kiểu và tràn số đã có trong [VariableExercise.java](../VariableExercise.java). Giữ bài làm cũ; bộ này bổ sung chọn kiểu, chuyển kiểu mất thông tin và báo cáo nhiều đại lượng.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.variables.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.variables.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### VAR-01 — Bản ghi cảm biến · Dễ · Cơ bản

- **Kiến thức luyện:** Kiểu primitive; literal; lựa chọn miền giá trị.
- **Bối cảnh và yêu cầu:** Trong main khai báo số thứ tự 12, tổng số bản ghi 3_000_000_000, nhiệt độ 26.5, mã khu A và cờ đang hoạt động true. Chọn kiểu primitive phù hợp, in mỗi giá trị trên một dòng; giải thích vì sao tổng bản ghi không dùng int.
- **Dữ liệu / kết quả / ví dụ:** 12 / 3000000000 / 26.5 / A / true (dấu / biểu diễn xuống dòng).
- **Trường hợp biên:** Thay tổng bản ghi bằng 0 và 4_000_000_000; mã khu là đúng một char ASCII, chưa xử lý chuỗi ký tự.
- **Tiêu chí hoàn thành:** Chạy được cả ba tổng bản ghi, ghi rõ kiểu của năm biến và hậu tố literal cần thiết. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### VAR-02 — Thu hẹp rồi gán lại · Vừa · Suy luận

- **Kiến thức luyện:** Ép kiểu narrowing; bản sao primitive.
- **Bối cảnh và yêu cầu:** Không chạy trước: dự đoán từng dòng của `int raw = 130; byte small = (byte) raw; int saved = raw; raw = 5;` rồi in small, saved, raw. Giải thích giá trị nào bị mất thông tin và biến nào độc lập.
- **Dữ liệu / kết quả / ví dụ:** Ba kết quả cần tự dự đoán trước khi đối chiếu lời giải; chạy lại với raw ban đầu bằng 127 và 128.
- **Trường hợp biên:** Phân biệt 127 là biên byte và 128 là giá trị đầu tiên vượt biên dương.
- **Tiêu chí hoàn thành:** Có bảng dự đoán, kết quả thực tế và giải thích phép ép kiểu; không chỉ ghi “bị tràn”. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### VAR-03 — Hai lỗi trước khi chạy · Dễ · Tìm lỗi

- **Kiến thức luyện:** Khởi tạo local; kiểu literal.
- **Bối cảnh và yêu cầu:** Tạo bản thử riêng trong starter và tìm hai lỗi độc lập: `int count; System.out.println(count); long total = 3_000_000_000;`. Sửa để count biểu diễn chưa có bản ghi (0), total giữ đúng giá trị đã cho; giải thích vì sao bản gốc không biên dịch. Không chép đoạn lỗi vào source đang build.
- **Dữ liệu / kết quả / ví dụ:** Sau sửa in 0 và 3000000000.
- **Trường hợp biên:** Thay total bằng 0L vẫn phải chủ động khởi tạo count; bỏ dòng println không được coi là sửa yêu cầu.
- **Tiêu chí hoàn thành:** Chỉ ra được cả lỗi definite assignment và lỗi literal vượt miền int; bản sửa chạy đúng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### VAR-04 — Tách thời lượng · Vừa · Vận dụng

- **Kiến thức luyện:** Chia nguyên; giữ lại phần còn lại; lựa chọn kiểu.
- **Bối cảnh và yêu cầu:** Từ int totalSeconds trong [0,86400], tự tính giờ, phút và giây bằng phép chia, nhân, trừ rồi in ba dòng. Chưa dùng %, method hoặc rẽ nhánh. Mỗi lần thử đổi literal đầu vào và chạy lại.
- **Dữ liệu / kết quả / ví dụ:** 3661 -> 1 / 1 / 1; 59 -> 0 / 0 / 59.
- **Trường hợp biên:** 0 -> 0/0/0; 3600 -> 1/0/0; 86400 -> 24/0/0. Không nhận số âm.
- **Tiêu chí hoàn thành:** Các mốc đều đúng, phút/giây trong [0,59], giải thích vì sao phép chia nguyên phù hợp. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### VAR-05 — Báo cáo hai kho · Vừa · Tổng kết

- **Kiến thức luyện:** Long trước phép nhân; double trước chia; sao chép giá trị.
- **Bối cảnh và yêu cầu:** Kho A có 120_000 kiện, mỗi kiện 25_000 sản phẩm; kho B có 0 sản phẩm. Tính tổng, trung bình sản phẩm trên hai kho và lưu một bản snapshot của số kiện. Đổi biến số kiện hiện tại về 0 rồi in snapshot, tổng và trung bình. Giải thích kiểu của từng biểu thức.
- **Dữ liệu / kết quả / ví dụ:** 120000 / 3000000000 / 1.5E9 (hoặc cách hiển thị double tương đương).
- **Trường hợp biên:** Số kiện [0,200000], sản phẩm/kiện [0,30000]; thử 0 kiện và mức lớn nhất 6_000_000_000 sản phẩm. Trung bình luôn chia cho hai kho.
- **Tiêu chí hoàn thành:** Không có tích trung gian int bị tràn; snapshot không đổi khi biến nguồn được gán lại; tự ghi kết quả cho ca lớn nhất. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
