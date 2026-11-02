# Tự kiểm tra — Lọc giá trị chỉ xuất hiện một lần

**Tiên quyết:** Arrays, generics, wrapper, LinkedHashMap/HashMap; học Collections trước mục này.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## FREQ-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Lọc giá trị chỉ xuất hiện một lần; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `Map<Integer,Integer> m=new LinkedHashMap<>(); for(int x:new int[]{4,2,4,9})m.put(x,m.getOrDefault(x,0)+1);` Hãy ghi cả thứ tự key.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Arrays, generics, wrapper, LinkedHashMap/HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## FREQ-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Lọc giá trị chỉ xuất hiện một lần; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `for(int x:a) counts.put(x,1);`
- **Đầu vào / kết quả cần đạt:** `[4,2,4]` cần `{4=2,2=1}`, không được cho cả hai value bằng 1.
- **Trường hợp biên:** Rỗng; mọi phần tử lặp; toàn khác; số âm; hai cực int.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Arrays, generics, wrapper, LinkedHashMap/HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## FREQ-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Lọc giá trị chỉ xuất hiện một lần; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `singletons(int[] a)` trả mảng mới các giá trị xuất hiện đúng một lần, giữ thứ tự nguồn. Input không null, không sửa nguồn.
- **Đầu vào / kết quả cần đạt:** `[4,2,4,9,2,7] → [9,7]`, `[] → []`.
- **Trường hợp biên:** Rỗng; mọi phần tử lặp; toàn khác; số âm; hai cực int.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Arrays, generics, wrapper, LinkedHashMap/HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## FREQ-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Lọc giá trị chỉ xuất hiện một lần kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Báo cáo cảm biến: loại mọi giá trị lặp rồi tính tổng các giá trị còn lại bằng long trong `uniqueSum(int[] a)`; tái dùng singletons.
- **Đầu vào / kết quả cần đạt:** `[4,2,4,9,2,7] → 16`; `[2147483647,2147483646] → 4294967293`; [] → 0.
- **Trường hợp biên:** Rỗng; mọi phần tử lặp; toàn khác; số âm; hai cực int.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Arrays, generics, wrapper, LinkedHashMap/HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.count_frequency.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.count_frequency.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
