# Tự kiểm tra — Cực tiểu và vị trí xuất hiện đầu

**Tiên quyết:** Methods, arrays, strings; biến thể dùng -1 cho rỗng nên chưa cần exception.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## MIN-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Cực tiểu và vị trí xuất hiện đầu; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `int[] a={7,2,2,9}; int p=0; for(int i=1;i<a.length;i++) if(a[i]<a[p])p=i;`
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Methods, arrays, strings; biến thể dùng -1 cho rỗng nên chưa cần exception. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## MIN-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Cực tiểu và vị trí xuất hiện đầu; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `int p=0; for(int i=1;i<a.length;i++) if(a[i]<=a[p])p=i;`
- **Đầu vào / kết quả cần đạt:** `[7,2,2,9]` cần vị trí đầu 1, đoạn lỗi trả 2.
- **Trường hợp biên:** Rỗng; một phần tử; cực tiểu lặp; số âm; hai cực int.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Methods, arrays, strings; biến thể dùng -1 cho rỗng nên chưa cần exception. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## MIN-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Cực tiểu và vị trí xuất hiện đầu; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `firstMinIndex(int[] a)` trả index cực tiểu xuất hiện đầu; input không null; rỗng trả -1; không sửa nguồn.
- **Đầu vào / kết quả cần đạt:** `[7,2,2,9] → 1`, `[] → -1`, `[4] → 0`.
- **Trường hợp biên:** Rỗng; một phần tử; cực tiểu lặp; số âm; hai cực int.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Methods, arrays, strings; biến thể dùng -1 cho rỗng nên chưa cần exception. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## MIN-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Cực tiểu và vị trí xuất hiện đầu kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Ba nhà cung cấp được lưu bằng hai mảng tên/giá cùng độ dài. Dùng index cực tiểu để chọn tên nhà cung cấp rẻ nhất; hòa chọn người đầu, không có ai trả chuỗi "KHONG_CO". Hai mảng không null và cùng độ dài là tiền điều kiện.
- **Đầu vào / kết quả cần đạt:** `["An","Binh","Chi"]`, giá `[30,20,20]` → `Binh`; hai mảng rỗng → `KHONG_CO`.
- **Trường hợp biên:** Rỗng; một phần tử; cực tiểu lặp; số âm; hai cực int.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Methods, arrays, strings; biến thể dùng -1 cho rỗng nên chưa cần exception. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.find_min.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.find_min.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
