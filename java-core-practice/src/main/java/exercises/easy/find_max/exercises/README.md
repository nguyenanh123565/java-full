# Tự kiểm tra — Cực đại và số lần đạt cực đại

**Tiên quyết:** Methods, arrays; học exception/IllegalArgumentException trước khi làm biến thể có dữ liệu rỗng.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## MAX-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Cực đại và số lần đạt cực đại; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `int[] a={-4,-4,-9}; int best=a[0], count=0; for(int x:a){if(x>best){best=x;count=1;}else if(x==best)count++;}`
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Methods, arrays; học exception/IllegalArgumentException trước khi làm biến thể có dữ liệu rỗng. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## MAX-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Cực đại và số lần đạt cực đại; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `int best=0; for(int x:a) if(x>best) best=x;`
- **Đầu vào / kết quả cần đạt:** `a={-6,-3}` phải cho cực đại -3, không phải 0.
- **Trường hợp biên:** Rỗng; một phần tử; toàn âm; tất cả bằng nhau; Integer.MIN_VALUE/MAX_VALUE.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Methods, arrays; học exception/IllegalArgumentException trước khi làm biến thể có dữ liệu rỗng. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## MAX-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Cực đại và số lần đạt cực đại; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `countAtMax(int[] a)` trả số phần tử bằng giá trị lớn nhất. Input không null; rỗng ném IllegalArgumentException; không sửa nguồn.
- **Đầu vào / kết quả cần đạt:** `[-4,-4,-9] → 2`, `[8] → 1`, `[2,7,7,1] → 2`.
- **Trường hợp biên:** Rỗng; một phần tử; toàn âm; tất cả bằng nhau; Integer.MIN_VALUE/MAX_VALUE.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Methods, arrays; học exception/IllegalArgumentException trước khi làm biến thể có dữ liệu rỗng. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## MAX-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Cực đại và số lần đạt cực đại kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Bộ đọc cảm biến có nhiều ngày, mỗi ngày là int[] không rỗng. Viết `dailyCounts(int[][] days)` trả số lần đạt cực đại mỗi ngày; không có ngày trả mảng rỗng.
- **Đầu vào / kết quả cần đạt:** `{{-4,-4,-9},{8},{2,2,2}} → [2,1,3]`; ngày rỗng phải bị từ chối, không sửa days.
- **Trường hợp biên:** Rỗng; một phần tử; toàn âm; tất cả bằng nhau; Integer.MIN_VALUE/MAX_VALUE.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Methods, arrays; học exception/IllegalArgumentException trước khi làm biến thể có dữ liệu rỗng. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.find_max.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.find_max.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
