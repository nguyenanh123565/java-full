# Tự kiểm tra — Medium — nhóm anagram và cửa sổ có vị trí

**Tiên quyết:** Hoàn thành easy có Map/Deque, OOP và exception; nội dung chuẩn hóa/anagram/cửa sổ trong README cũ.

Ba TODO cũ giữ nguyên. Bộ mới mở rộng từ một cặp từ sang nhiều nhóm và từ max sum sang vị trí có quy tắc hòa.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## MED-01 — Chọn cấu trúc trước khi viết code · Cơ bản

- **Luyện:** Map tần suất, thứ tự nguồn, cửa sổ trượt.
- **Bối cảnh và yêu cầu:** Làm tay ba dữ liệu; ghi cấu trúc giữ trạng thái, kết quả và bất biến. Không viết thuật toán trước khi có bảng.
- **Đầu vào / kết quả cần đạt:** Ký tự duy nhất đầu của "redivider"; anagram " Dormitory " / "dirtyroom"; tổng cửa sổ k=2 của [-2,4,-1,3].
- **Trường hợp biên:** Chuỗi rỗng; nhiều ký tự trùng; mảng toàn âm; k=1 và k=n.
- **Hoàn thành khi:** Có ba kết quả cùng lý do chọn cấu trúc, phân biệt thứ tự Map với thứ tự nguồn.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## MED-02 — Theo dõi cửa sổ · Vừa · suy luận

- **Luyện:** long, cập nhật tổng, tie-break.
- **Bối cảnh và yêu cầu:** Đọc `int[] a={-2,4,-1,3}; long sum=(long)a[0]+a[1]; for(int i=2;i<a.length;i++)sum+=(long)a[i]-a[i-2];`. Ghi sum ban đầu và sau mỗi lượt, dự đoán index cửa sổ tốt nhất.
- **Đầu vào / kết quả cần đạt:** Nộp bảng gồm [start,end], phần thêm, phần bỏ, sum và best; chưa chạy trước khi lập bảng.
- **Trường hợp biên:** Nếu đổi 3 thành 4 thì hai cửa sổ hòa; hãy đề xuất quy tắc lấy cửa sổ sớm nhất.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## MED-03 — long vẫn có thể nhận kết quả sai · Vừa · tìm lỗi

- **Luyện:** Kiểu biểu thức và tràn số.
- **Bối cảnh và yêu cầu:** Sửa `long sum=a[0]; for(int i=1;i<a.length;i++)sum+=a[i]-a[i-1];` khi mô phỏng k=1. Giải thích vì sao khai báo sum là long chưa đủ.
- **Đầu vào / kết quả cần đạt:** `[Integer.MIN_VALUE,Integer.MAX_VALUE]`, k=1 phải có các tổng -2147483648 và 2147483647.
- **Trường hợp biên:** Chênh lệch vượt int; dữ liệu một phần tử; k<=0 hoặc k>n phải bị từ chối ở hàm tổng quát.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## MED-04 — Kích thước các nhóm anagram · Vừa · vận dụng

- **Luyện:** Chuẩn hóa ASCII, Map và arrays.
- **Bối cảnh và yêu cầu:** Viết `groupSizes(String[] words)` gom anagram sau trim/toLowerCase(Locale.ROOT), trả int[] kích thước nhóm theo thứ tự nhóm gặp đầu. Chỉ nhận a-z sau chuẩn hóa; chuỗi rỗng được nhận. Phần tử/mảng không null. Không gọi Solution cũ.
- **Đầu vào / kết quả cần đạt:** `["eat","Tea","ate","tan","Nat"] → [3,2]`; `["", " "] → [2]`; có "a1" ném IllegalArgumentException.
- **Trường hợp biên:** Mảng rỗng; chuỗi rỗng; uppercase; space đầu/cuối; ký tự số hoặc dấu câu bị từ chối.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## MED-05 — Cửa sổ tốt nhất và vị trí · Vừa · vận dụng

- **Luyện:** Sliding window, long, quy tắc hòa.
- **Bối cảnh và yêu cầu:** Viết `bestWindow(int[] a,int k)` trả long[] gồm [startIndex,maxSum]. Hòa tổng chọn index nhỏ nhất. 1<=k<=n, sai ném IllegalArgumentException; không sửa nguồn; input không null.
- **Đầu vào / kết quả cần đạt:** `[-2,4,-1,3],2 → [1,3]`; `[1,1,1],2 → [0,2]`; `[MAX_VALUE,MAX_VALUE],2 → [0,4294967294]`.
- **Trường hợp biên:** Toàn âm; rỗng; k=0,k>n; k=1,k=n; tổng vượt int.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## MED-06 — Báo cáo hai loại dữ liệu · Khó · tổng kết

- **Luyện:** Tách method, kiểm hợp đồng và hai thuật toán.
- **Bối cảnh và yêu cầu:** Viết `report(String[] words,int[] a,int k)` trả chuỗi chứa kích thước nhóm và cửa sổ tốt nhất; tái dùng bài 04/05, không thay đổi input. Nếu một đầu vào sai, từ chối báo cáo.
- **Đầu vào / kết quả cần đạt:** `words=["eat","Tea","ate","tan","Nat"], a=[-2,4,-1,3],k=2 → groups=[3, 2];window=[1, 3]`.
- **Trường hợp biên:** Không có từ vẫn có báo cáo cửa sổ; không có phần tử mảng thì k không hợp lệ; từ sai phải bị từ chối.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.medium.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.medium.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../PROGRESS.md).
