# Tự kiểm tra — Đối xứng khi bỏ dấu cách ASCII

**Tiên quyết:** Methods, arrays, String/charAt; chỉ ASCII, không yêu cầu Unicode hay regex.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## PAL-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Đối xứng khi bỏ dấu cách ASCII; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `String s="Ab bA"; int l=0,r=s.length()-1;` Ghi từng cặp ký tự được so nếu chỉ bỏ dấu cách U+0020; chữ hoa/thường vẫn phân biệt.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Methods, arrays, String/charAt; chỉ ASCII, không yêu cầu Unicode hay regex. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## PAL-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Đối xứng khi bỏ dấu cách ASCII; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `return text.charAt(0)==text.charAt(text.length()-1);`
- **Đầu vào / kết quả cần đạt:** `"abca"` phải false dù hai đầu cùng a; chuỗi rỗng phải true thay vì truy cập index sai.
- **Trường hợp biên:** Rỗng; toàn space; space ở đầu/cuối; một ký tự; tab không được bỏ; khác hoa/thường.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Methods, arrays, String/charAt; chỉ ASCII, không yêu cầu Unicode hay regex. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## PAL-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Đối xứng khi bỏ dấu cách ASCII; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `ignoringSpaces(String text)` chỉ bỏ ký tự space ASCII U+0020 khi kiểm palindrome; giữ hoa/thường và mọi ký tự ASCII khác. Input không null; không sửa String; không tạo chuỗi đảo.
- **Đầu vào / kết quả cần đạt:** `"a b a" → true`, `"Aa" → false`, `"   " → true`, `"a\tb" → false`.
- **Trường hợp biên:** Rỗng; toàn space; space ở đầu/cuối; một ký tự; tab không được bỏ; khác hoa/thường.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Methods, arrays, String/charAt; chỉ ASCII, không yêu cầu Unicode hay regex. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## PAL-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Đối xứng khi bỏ dấu cách ASCII kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Bộ kiểm mã nhãn nhận String[] không null, phần tử ASCII không null. Viết `accepted(String[] labels)` trả số nhãn đối xứng theo quy tắc bài 03.
- **Đầu vào / kết quả cần đạt:** `["a b a","Aa","   ","abc"] → 2`; [] → 0. Viết lời giải thích vì sao kết quả khác quy tắc palindrome cũ.
- **Trường hợp biên:** Rỗng; toàn space; space ở đầu/cuối; một ký tự; tab không được bỏ; khác hoa/thường.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Methods, arrays, String/charAt; chỉ ASCII, không yêu cầu Unicode hay regex. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.palindrome.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.palindrome.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
