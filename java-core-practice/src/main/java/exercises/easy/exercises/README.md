# Tự kiểm tra — Thống kê mảng không sửa nguồn

**Tiên quyết:** Methods/arrays/strings; chỉ cần nhóm easy dùng mảng, chưa cần Collections. Các bài count_frequency/remove_duplicate/character_frequency/TwoSum/Valid Parentheses học sau Collections.

Các bài con hiện có được giữ nguyên. Đây là phần tổng kết riêng sau khi học các mục con, không yêu cầu làm lại toàn bộ TODO cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## EASY-01 — Viết hợp đồng trước code · Cơ bản

- **Luyện:** Phân rã đầu vào/kết quả, chọn cấu trúc.
- **Bối cảnh và yêu cầu:** Từ tình huống bài 04, viết bảng đầu vào hợp lệ/không hợp lệ, dữ liệu nào được sửa và đầu ra. Giải thích cách duyệt mảng và các biến tích lũy cần giữ.
- **Đầu vào / kết quả cần đạt:** `[-2,4,4] → count=3;min=-2;max=4;sum=6`; [] → EMPTY.
- **Trường hợp biên:** Rỗng; một phần tử; trùng; số âm hoặc không tìm thấy theo hợp đồng bài 04.
- **Hoàn thành khi:** Có ít nhất bốn ca kèm lý do và phân biệt tiền điều kiện với lỗi phải xử lý.
- **Được dùng / giới hạn:** Methods, arrays, strings, condition/loops và long; input không null theo tiền điều kiện. Chưa cần OOP/exception/Collections/Stream.

## EASY-02 — Bất biến của báo cáo một lượt · Vừa · suy luận

- **Luyện:** Min/max, tổng long và bất biến vòng lặp.
- **Bối cảnh và yêu cầu:** Đọc `int[] a={-2,4,4}; int lo=a[0],hi=a[0]; long sum=0; for(int x:a){if(x<lo)lo=x; if(x>hi)hi=x; sum+=x;}`. Ghi lo,hi,sum sau từng lượt, dự đoán báo cáo và giải thích vì sao hai lần gặp 4 đều phải được cộng.
- **Đầu vào / kết quả cần đạt:** Nộp ba dòng trạng thái và kết quả cuối; nêu bất biến tổng là tổng phần đã duyệt, kể cả phần tử trùng.
- **Trường hợp biên:** Mảng rỗng cần nhánh EMPTY trước truy cập a[0]; thử mảng toàn âm và một phần tử.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Methods, arrays, strings, condition/loops và long; input không null theo tiền điều kiện. Chưa cần OOP/exception/Collections/Stream.

## EASY-03 — Báo cáo bị tràn số · Vừa · tìm lỗi

- **Luyện:** Kiểu biểu thức và dữ liệu nguồn.
- **Bối cảnh và yêu cầu:** Sửa `int total=0; for(int x:values)total+=x;` trong báo cáo cần tổng chính xác của int[]. Giải thích vì sao ép `(long)total` lúc return là quá muộn.
- **Đầu vào / kết quả cần đạt:** `[Integer.MAX_VALUE,1] → 2147483648`, [] → 0.
- **Trường hợp biên:** Số âm; hai cực int; dữ liệu một phần tử. Không sửa nguồn.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Methods, arrays, strings, condition/loops và long; input không null theo tiền điều kiện. Chưa cần OOP/exception/Collections/Stream.

## EASY-04 — Tổng kết nhóm: Thống kê mảng không sửa nguồn · Khó · vận dụng + tổng kết

- **Luyện:** Methods, arrays, hợp đồng và kiến thức nhóm.
- **Bối cảnh và yêu cầu:** Viết `report(int[] values)` trả `count=N;min=X;max=Y;sum=S`; rỗng trả `EMPTY`. Kết hợp tìm min/max với tổng long trong một lượt. Không sort/Stream, không sửa nguồn.
- **Đầu vào / kết quả cần đạt:** `[-2,4,4] → count=3;min=-2;max=4;sum=6`; [] → EMPTY.
- **Trường hợp biên:** Input không null. Rỗng phải theo quy ước; tổng dùng long; không sửa nguồn; giữ thứ tự khi đề yêu cầu.
- **Hoàn thành khi:** Chạy đúng ví dụ/biên; tự nêu ít nhất hai lỗi đã tránh; giải thích độ phức tạp và quyết định cấu trúc.
- **Được dùng / giới hạn:** Methods, arrays, strings, condition/loops và long; input không null theo tiền điều kiện. Chưa cần OOP/exception/Collections/Stream.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.easy.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../PROGRESS.md).
