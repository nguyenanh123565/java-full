# Tự kiểm tra — Độ sâu ngoặc hợp lệ

**Tiên quyết:** String, switch, Deque/ArrayDeque và bài Valid Parentheses cũ; học Collections trước mục này.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## BRACK-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Độ sâu ngoặc hợp lệ; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. Với `"{[()]}"`, ghi stack sau từng ký tự, chiều push/pop và kích thước lớn nhất. Sau đó thử `"{[(])}"`.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** String, switch, Deque/ArrayDeque và bài Valid Parentheses cũ; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## BRACK-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Độ sâu ngoặc hợp lệ; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `if(isClosing(ch)) return stack.pop()==expectedOpen(ch);` (hai helper xác định loại ngoặc như bài cũ).
- **Đầu vào / kết quả cần đạt:** `"]"` phải trả không hợp lệ, không ném lỗi stack rỗng; `"()[]"` phải đọc hết chuỗi thay vì return sau dấu đóng đầu.
- **Trường hợp biên:** Rỗng; dấu đóng đầu tiên; ngoặc mở thừa; sai loại; ký tự ngoài hợp đồng.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** String, switch, Deque/ArrayDeque và bài Valid Parentheses cũ; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## BRACK-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Độ sâu ngoặc hợp lệ; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `maxDepth(String text)` trả độ sâu lồng ngoặc lớn nhất nếu hợp lệ, -1 nếu sai. Chỉ chấp nhận ()[]{}; ký tự lạ kể cả space trả -1; input không null.
- **Đầu vào / kết quả cần đạt:** `"{[()]}" → 3`, `"()[]" → 1`, `"" → 0`, `"([)]" → -1`.
- **Trường hợp biên:** Rỗng; dấu đóng đầu tiên; ngoặc mở thừa; sai loại; ký tự ngoài hợp đồng.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** String, switch, Deque/ArrayDeque và bài Valid Parentheses cũ; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## BRACK-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Độ sâu ngoặc hợp lệ kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Bộ kiểm cấu trúc nhận nhiều chuỗi. Viết `depths(String[] texts)` trả int[] độ sâu hoặc -1 cho từng chuỗi, không dừng cả lô khi một chuỗi sai.
- **Đầu vào / kết quả cần đạt:** `["{[()]}","([)]","", "]"] → [3,-1,0,-1]`; [] → [].
- **Trường hợp biên:** Rỗng; dấu đóng đầu tiên; ngoặc mở thừa; sai loại; ký tự ngoài hợp đồng.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** String, switch, Deque/ArrayDeque và bài Valid Parentheses cũ; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.valid_parentheses.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.valid_parentheses.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
