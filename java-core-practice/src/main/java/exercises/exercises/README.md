# Tự kiểm tra — Tần suất và tổng lần nhập

**Tiên quyết:** Sau easy và medium; cần HashMap/LinkedHashMap, long và methods.

Các bài con hiện có được giữ nguyên. Đây là phần tổng kết riêng sau khi học các mục con, không yêu cầu làm lại toàn bộ TODO cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## PRACT-01 — Viết hợp đồng trước code · Cơ bản

- **Luyện:** Phân rã đầu vào/kết quả, chọn cấu trúc.
- **Bối cảnh và yêu cầu:** Từ tình huống bài 04, viết bảng đầu vào hợp lệ/không hợp lệ, dữ liệu nào được sửa và đầu ra. Chọn mảng, Map hoặc Set và giải thích.
- **Đầu vào / kết quả cần đạt:** `[3,1,3] → distinct=2;sum=7;counts={3=2, 1=1}`; [] → distinct=0;sum=0;counts={}.
- **Trường hợp biên:** Rỗng; một phần tử; trùng; số âm hoặc không tìm thấy theo hợp đồng bài 04.
- **Hoàn thành khi:** Có ít nhất bốn ca kèm lý do và phân biệt tiền điều kiện với lỗi phải xử lý.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## PRACT-02 — Hai báo cáo liên tiếp · Vừa · suy luận

- **Luyện:** Scope, Map và tính độc lập giữa các lần gọi.
- **Bối cảnh và yêu cầu:** Hàm badReport dùng `static Map<Integer,Integer> counts=new LinkedHashMap<>();` ngoài hàm, mỗi lần gọi cộng tần suất vào counts rồi trả nó. Gọi lần lượt với [3,1,3] và [1]. Dự đoán map của lần thứ hai và nhận xét reference kết quả lần đầu có thể đổi không.
- **Đầu vào / kết quả cần đạt:** Nộp nội dung map sau hai lần và đối chiếu hợp đồng mỗi báo cáo chỉ phản ánh một đầu vào.
- **Trường hợp biên:** Gọi báo cáo rỗng sau báo cáo không rỗng; gọi hai mảng không có key chung.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## PRACT-03 — Báo cáo bị tràn số · Vừa · tìm lỗi

- **Luyện:** Kiểu biểu thức và dữ liệu nguồn.
- **Bối cảnh và yêu cầu:** Sửa `int total=0; for(int x:values)total+=x;` trong báo cáo cần tổng chính xác của int[]. Giải thích vì sao ép `(long)total` lúc return là quá muộn.
- **Đầu vào / kết quả cần đạt:** `[Integer.MAX_VALUE,1] → 2147483648`, [] → 0.
- **Trường hợp biên:** Số âm; hai cực int; dữ liệu một phần tử. Không sửa nguồn.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## PRACT-04 — Tổng kết nhóm: Tần suất và tổng lần nhập · Khó · vận dụng + tổng kết

- **Luyện:** Methods, arrays, hợp đồng và kiến thức nhóm.
- **Bối cảnh và yêu cầu:** Viết `report(int[] values)` trả `distinct=K;sum=S;counts=MAP`. MAP theo thứ tự xuất hiện đầu, mọi phần tử kể cả âm đều được nhận; rỗng có distinct=0,sum=0,counts={}. Không gọi Solution.
- **Đầu vào / kết quả cần đạt:** `[3,1,3] → distinct=2;sum=7;counts={3=2, 1=1}`; [] → distinct=0;sum=0;counts={}.
- **Trường hợp biên:** Input không null. Rỗng phải theo quy ước; tổng dùng long; không sửa nguồn; giữ thứ tự khi đề yêu cầu.
- **Hoàn thành khi:** Chạy đúng ví dụ/biên; tự nêu ít nhất hai lỗi đã tránh; giải thích độ phức tạp và quyết định cấu trúc.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../PROGRESS.md).
