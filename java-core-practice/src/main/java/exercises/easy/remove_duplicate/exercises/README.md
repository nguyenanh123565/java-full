# Tự kiểm tra — Nhận diện mã bị lặp

**Tiên quyết:** Arrays, Set/LinkedHashSet và Map; học Collections trước mục này.

Ba bài cũ trong [README gốc](../README.md) vẫn giữ nguyên. Bộ này luyện trace/lỗi và một biến thể mới, không yêu cầu chép lại bài cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## DUP-01 — Theo dõi dữ liệu từng bước · Cơ bản + suy luận

- **Luyện:** Nhận diện mã bị lặp; trạng thái vòng lặp/reference.
- **Bối cảnh và yêu cầu:** Đọc đoạn sau, lập bảng biến/trạng thái sau mỗi lượt và dự đoán kết quả trước khi chạy. `Set<Integer> s=new LinkedHashSet<>(); boolean a=s.add(8); boolean b=s.add(3); boolean c=s.add(8);` Dự đoán a,b,c và thứ tự s.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trace và kết luận có giải thích; tự chạy snippet trong main sau khi dự đoán.
- **Trường hợp biên:** Lặp lại với dữ liệu rỗng hoặc một phần tử nếu đoạn code cho phép; chỉ rõ tiền điều kiện.
- **Hoàn thành khi:** Bảng không bỏ sót bước cập nhật và giải thích được điều kiện dừng.
- **Được dùng / giới hạn:** Arrays, Set/LinkedHashSet và Map; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## DUP-02 — Phản ví dụ và sửa lỗi · Vừa · tìm lỗi

- **Luyện:** Nhận diện mã bị lặp; xác định nguyên nhân.
- **Bối cảnh và yêu cầu:** Đoạn sau là mã lỗi cố ý. Tạo phản ví dụ, sửa tối thiểu và giải thích vì sao sửa đúng: `Set<Integer> s=new HashSet<>(); for(int x:values)s.add(x);` dùng khi hợp đồng hứa giữ thứ tự.
- **Đầu vào / kết quả cần đạt:** Với `[8,3,8,1]`, danh sách duy nhất phải `[8,3,1]` trên mọi lần chạy/JDK.
- **Trường hợp biên:** Rỗng; một phần tử; lặp ba lần; thứ tự lần gặp đầu khác thứ tự lần lặp.
- **Hoàn thành khi:** Chỉ ra dòng gây lỗi, có kết quả trước/sau sửa và ít nhất một ca không bị lỗi ban đầu.
- **Được dùng / giới hạn:** Arrays, Set/LinkedHashSet và Map; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## DUP-03 — Tự viết biến thể · Vừa · vận dụng

- **Luyện:** Nhận diện mã bị lặp; method và hợp đồng.
- **Bối cảnh và yêu cầu:** Viết `repeated(int[] a)` trả mỗi giá trị có tần suất >=2 đúng một lần, theo thứ tự xuất hiện đầu trong nguồn, không theo thứ tự gặp lần lặp. Không sửa input, input không null.
- **Đầu vào / kết quả cần đạt:** `[5,2,2,5,7] → [5,2]`, `[1,2] → []`.
- **Trường hợp biên:** Rỗng; một phần tử; lặp ba lần; thứ tự lần gặp đầu khác thứ tự lần lặp.
- **Hoàn thành khi:** Đúng tất cả ví dụ/biên, không gọi Solution cũ, giải thích tính đúng và chi phí.
- **Được dùng / giới hạn:** Arrays, Set/LinkedHashSet và Map; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## DUP-04 — Báo cáo từ dữ liệu thực hành · Khó · tổng kết

- **Luyện:** Nhận diện mã bị lặp kết hợp methods, arrays, điều kiện và kiểu số.
- **Bối cảnh và yêu cầu:** Báo cáo nhập mã kho bằng `report(int[] ids)` trả chuỗi `distinct=X;repeated=Y`, X là số mã khác nhau, Y là số mã bị lặp, không phải số lượt lặp.
- **Đầu vào / kết quả cần đạt:** `[5,2,2,5,7] → distinct=3;repeated=2`; `[] → distinct=0;repeated=0`.
- **Trường hợp biên:** Rỗng; một phần tử; lặp ba lần; thứ tự lần gặp đầu khác thứ tự lần lặp.
- **Hoàn thành khi:** Chương trình tái dùng method bài 03, có đầu ra rõ, kiểm biên và giải thích trách nhiệm từng phần.
- **Được dùng / giới hạn:** Arrays, Set/LinkedHashSet và Map; học Collections trước mục này. Không dùng Stream, thư viện ngoài hay sort nếu đề không yêu cầu.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.remove_duplicate.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.remove_duplicate.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
