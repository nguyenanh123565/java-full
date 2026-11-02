# Tự kiểm tra — Đảo một đoạn và xoay mảng

**Tiên quyết:** Methods, arrays, reference; exception trước khi xử lý chỉ số sai.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## REV-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Đảo một đoạn và xoay mảng; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `int[] a={3,5,7}; int[] b=a; int t=a[0]; a[0]=a[2]; a[2]=t;` Hãy mô tả cả a và b.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Methods, arrays, reference; exception trước khi xử lý chỉ số sai. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## REV-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Đảo một đoạn và xoay mảng; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `a[left]=a[right]; a[right]=a[left];`
- **Đầu vào / kết quả cần đạt:** `[3,5]` phải đổi thành `[5,3]`, đoạn lỗi làm mất 3.
- **Trường hợp biên:** Mảng rỗng với đoạn [0,0); đoạn rỗng; một phần tử; chỉ số âm/vượt độ dài; from>to.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Methods, arrays, reference; exception trước khi xử lý chỉ số sai. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## REV-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Đảo một đoạn và xoay mảng; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `reverseRange(int[] a,int from,int to)` đảo tại chỗ đoạn nửa mở [from,to). Input không null; 0<=from<=to<=length, sai thì IllegalArgumentException trước khi thay đổi.
- **Đầu vào / kết quả cần đạt:** `[1,2,3,4,5], from=1,to=4 → [1,4,3,2,5]`.
- **Trường hợp biên:** Mảng rỗng với đoạn [0,0); đoạn rỗng; một phần tử; chỉ số âm/vượt độ dài; from>to.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Methods, arrays, reference; exception trước khi xử lý chỉ số sai. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## REV-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Đảo một đoạn và xoay mảng kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Viết `rotateLeft(int[] a,int k)` xoay trái k vị trí bằng các lần reverseRange; 0<=k<=length, ngoài miền ném IllegalArgumentException và không sửa input.
- **Đầu vào / kết quả cần đạt:** `[1,2,3,4,5], k=2 → [3,4,5,1,2]`; k=0 hoặc k=length giữ nguyên; [],k=0 hợp lệ.
- **Trường hợp biên:** Mảng rỗng với đoạn [0,0); đoạn rỗng; một phần tử; chỉ số âm/vượt độ dài; from>to.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Methods, arrays, reference; exception trước khi xử lý chỉ số sai. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.reverse_array.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.reverse_array.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
