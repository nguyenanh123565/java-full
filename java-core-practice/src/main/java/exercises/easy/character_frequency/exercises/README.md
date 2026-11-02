# Tự kiểm tra — Ký tự xuất hiện nhiều nhất

**Tiên quyết:** String, wrapper Character, Map/LinkedHashMap; học Collections trước mục này.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## CHAR-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Ký tự xuất hiện nhiều nhất; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `Map<Character,Integer> m=new LinkedHashMap<>(); for(char c:"baba ".toCharArray())m.put(c,m.getOrDefault(c,0)+1);` Nêu thứ tự key và số đếm.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** String, wrapper Character, Map/LinkedHashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## CHAR-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Ký tự xuất hiện nhiều nhất; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `if(ch!=' ') counts.put(ch,counts.getOrDefault(ch,0)+1);` trong bài đếm mọi ký tự ASCII.
- **Đầu vào / kết quả cần đạt:** `"a a"` phải có a=2, space=1; `" "` vẫn có một key space.
- **Trường hợp biên:** Rỗng; chỉ space; một ký tự; hòa tần suất; A và a khác nhau.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** String, wrapper Character, Map/LinkedHashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## CHAR-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Ký tự xuất hiện nhiều nhất; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `mostFrequent(String text)` trả Character có count lớn nhất, hòa chọn ký tự xuất hiện đầu trong nguồn; rỗng trả null. ASCII không null; tính cả space.
- **Đầu vào / kết quả cần đạt:** `"baba " → b`, `"Aa" → A`, `"" → null`, `"  a" → space`.
- **Trường hợp biên:** Rỗng; chỉ space; một ký tự; hòa tần suất; A và a khác nhau.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** String, wrapper Character, Map/LinkedHashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## CHAR-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Ký tự xuất hiện nhiều nhất kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Viết `summaries(String[] texts)` trả Character[] ký tự nổi bật từng tin nhắn, giữ đúng thứ tự; tin rỗng là null. Không giả định thứ tự HashMap.
- **Đầu vào / kết quả cần đạt:** `["baba ","Aa","", "  a"] → [b,A,null,space]`; mảng rỗng → [].
- **Trường hợp biên:** Rỗng; chỉ space; một ký tự; hòa tần suất; A và a khác nhau.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** String, wrapper Character, Map/LinkedHashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.character_frequency.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.character_frequency.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
