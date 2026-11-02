# Tự kiểm tra — Tìm lần xuất hiện đầu bằng tìm kiếm nhị phân

**Tiên quyết:** Methods, arrays, loops và bài Binary Search cũ; input đã sorted là tiền điều kiện.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## BIN-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Tìm lần xuất hiện đầu bằng tìm kiếm nhị phân; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `int left=0,right=3; int mid=left+(right-left)/2;` trên `[1,2,2,8]`, target=2: nếu dừng tại mid thì đã chắc đó là lần đầu chưa?
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Methods, arrays, loops và bài Binary Search cũ; input đã sorted là tiền điều kiện. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## BIN-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Tìm lần xuất hiện đầu bằng tìm kiếm nhị phân; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `while(left<=right){int mid=left+(right-left)/2; if(a[mid]<target)left=mid; else right=mid;}`
- **Đầu vào / kết quả cần đạt:** `a=[1,3], target=3` phải dừng và trả 1; đoạn lỗi có thể lặp vô hạn. Giới hạn số lượt khi chạy đoạn lỗi.
- **Trường hợp biên:** Rỗng; một phần tử; target trước/sau miền; mọi phần tử bằng nhau; hai cực int.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Methods, arrays, loops và bài Binary Search cũ; input đã sorted là tiền điều kiện. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## BIN-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Tìm lần xuất hiện đầu bằng tìm kiếm nhị phân; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `firstIndex(int[] sorted,int target)` trả index xuất hiện đầu hoặc -1, O(log n). Không tự sort/validate toàn mảng, không sửa nguồn, input không null.
- **Đầu vào / kết quả cần đạt:** `[1,2,2,2,8],2 → 1`; `[2,2,2],2 → 0`; `[],2 → -1`.
- **Trường hợp biên:** Rỗng; một phần tử; target trước/sau miền; mọi phần tử bằng nhau; hai cực int.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Methods, arrays, loops và bài Binary Search cũ; input đã sorted là tiền điều kiện. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## BIN-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Tìm lần xuất hiện đầu bằng tìm kiếm nhị phân kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Tra cứu nhiều mã trên danh mục sorted: viết `lookup(int[] sorted,int[] targets)` trả int[] các vị trí đầu, đúng thứ tự targets. Không dùng sort hay tuyến tính tìm từng mã.
- **Đầu vào / kết quả cần đạt:** `sorted=[1,2,2,8], targets=[2,7,1] → [1,-1,0]`; targets=[] → [].
- **Trường hợp biên:** Rỗng; một phần tử; target trước/sau miền; mọi phần tử bằng nhau; hai cực int.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Methods, arrays, loops và bài Binary Search cũ; input đã sorted là tiền điều kiện. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.binary_search.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.binary_search.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
