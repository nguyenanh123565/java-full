# Tự kiểm tra — Đếm mọi cặp chỉ số có tổng cho trước

**Tiên quyết:** Arrays, long/overflow, wrapper, HashMap; học Collections trước mục này.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## PAIR-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Đếm mọi cặp chỉ số có tổng cho trước; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `int[] a={4,4,4};` Liệt kê bằng tay mọi cặp i<j có tổng 8; so sánh với hợp đồng TwoSum cũ chỉ trả một cặp.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Arrays, long/overflow, wrapper, HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## PAIR-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Đếm mọi cặp chỉ số có tổng cho trước; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `for(int i=0;i<a.length;i++){ seen.put(a[i],i); if(seen.containsKey(target-a[i])) return true; }`
- **Đầu vào / kết quả cần đạt:** `[4], target=8` phải false; đoạn lỗi có thể ghép index với chính nó. `[MAX_VALUE,1], MIN_VALUE` cũng không phải nghiệm toán học.
- **Trường hợp biên:** Rỗng; một phần tử; phần tử trùng nhiều; số âm; phần bù ngoài int; kết quả vượt int.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Arrays, long/overflow, wrapper, HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## PAIR-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Đếm mọi cặp chỉ số có tổng cho trước; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `pairCount(int[] a,int target)` trả long số cặp index i<j có tổng toán học bằng target. Mỗi cặp tính một lần, không sửa input, input không null.
- **Đầu vào / kết quả cần đạt:** `[4,4,4],8 → 3`, `[1,3,2,2],4 → 2`, `[4],8 → 0`.
- **Trường hợp biên:** Rỗng; một phần tử; phần tử trùng nhiều; số âm; phần bù ngoài int; kết quả vượt int.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Arrays, long/overflow, wrapper, HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## PAIR-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Đếm mọi cặp chỉ số có tổng cho trước kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Bộ ghép số nhận một mảng và danh sách target. Viết `counts(int[] a,int[] targets)` trả long[] số cặp tương ứng, giữ đúng thứ tự yêu cầu.
- **Đầu vào / kết quả cần đạt:** `a=[1,3,2,2], targets=[4,5,99] → [2,2,0]`; targets rỗng → [].
- **Trường hợp biên:** Rỗng; một phần tử; phần tử trùng nhiều; số âm; phần bù ngoài int; kết quả vượt int.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Arrays, long/overflow, wrapper, HashMap; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.two_sum.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.two_sum.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
