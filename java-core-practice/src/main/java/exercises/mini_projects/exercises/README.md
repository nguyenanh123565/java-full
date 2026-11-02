# Tự kiểm tra — Đối soát số dư theo mã

**Tiên quyết:** Sau OOP, exception, Collections và comparable_comparator; hoàn thành ít nhất một mini project trước bộ tổng kết nhóm.

Các bài con hiện có được giữ nguyên. Đây là phần tổng kết riêng sau khi học các mục con, không yêu cầu làm lại toàn bộ TODO cũ.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## PROJECTS-01 — Viết hợp đồng trước code · Cơ bản

- **Luyện:** Phân rã đầu vào/kết quả, chọn cấu trúc.
- **Bối cảnh và yêu cầu:** Từ tình huống bài 04, viết bảng đầu vào hợp lệ/không hợp lệ, dữ liệu nào được sửa và đầu ra. Chọn mảng, Map hoặc Set và giải thích.
- **Đầu vào / kết quả cần đạt:** Ví dụ chọn ngân hàng: A=100,B=40; chuyển 30 thành 70,70; chuyển 71 thất bại và vẫn 70,70; snapshot ban đầu vẫn 100,40. Báo cáo mã `[10,-2,10] → entries=3;distinct=2;checksum=18`; [] → entries=0;distinct=0;checksum=0.
- **Trường hợp biên:** Rỗng; một phần tử; trùng; số âm hoặc không tìm thấy theo hợp đồng bài 04.
- **Hoàn thành khi:** Có ít nhất bốn ca kèm lý do và phân biệt tiền điều kiện với lỗi phải xử lý.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## PROJECTS-02 — Suy luận thất bại ở cuối lô · Vừa · suy luận

- **Luyện:** Validation, commit và trạng thái toàn vẹn.
- **Bối cảnh và yêu cầu:** Đọc bản phác `for(Update u:batch){validate(u); apply(u);}`. Với sổ điểm S1=6,S2=7 và lô S1→9,S2→NaN, dự đoán trạng thái khi phần tử cuối lỗi. So sánh với hai vòng validate toàn bộ rồi mới apply; lập trường hợp tương tự cho giỏ hàng hoặc chuyển tiền.
- **Đầu vào / kết quả cần đạt:** Nộp bảng trạng thái sau từng bước của hai cách; helper validate từ chối NaN, apply thực sự gán điểm.
- **Trường hợp biên:** Lô rỗng; lỗi phần tử đầu/cuối; nhiều lần cùng ID cần quy ước rõ trước commit.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## PROJECTS-03 — Giao diện báo thành công sau lỗi · Vừa · tìm lỗi

- **Luyện:** Exception, kết quả nghiệp vụ và console.
- **Bối cảnh và yêu cầu:** Sửa luồng `try { service.apply(command); } catch(IllegalArgumentException e){println("ERR");} println("OK");`. Bản cũ luôn in OK sau khi đã báo ERR. Tự đặt hợp đồng phản hồi đúng một kết quả cho mỗi lệnh, không dừng menu khi input sai.
- **Đầu vào / kết quả cần đạt:** Một lệnh bị validation từ chối chỉ in ERR; lệnh thành công kế tiếp chỉ in OK. EXIT phải dừng menu rõ ràng.
- **Trường hợp biên:** Parse số sai; thiếu trường; mã không tồn tại; EOF; không trả OK khi nghiệp vụ thất bại.
- **Hoàn thành khi:** Đúng dữ liệu mẫu và biên, giải thích được cách làm và trạng thái khi lỗi.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## PROJECTS-04 — Tổng kết nhóm: chọn một hệ thống và đối soát · Khó · vận dụng + tổng kết

- **Luyện:** Methods, arrays, hợp đồng và kiến thức nhóm.
- **Bối cảnh và yêu cầu:** Chọn sổ điểm, kho hàng hoặc ngân hàng; hoàn thành bộ tổng kết tương ứng và viết transcript có một thao tác thành công, một thao tác thất bại giữ nguyên trạng thái, một snapshot cũ không đổi. Thêm báo cáo kiểm kê mã lệnh: `report(int[] values)` trả `entries=N;distinct=K;checksum=S`, checksum là tổng long mọi mã (âm được nhận), không phải hash bảo mật. Giải thích vì sao báo cáo mã không tự chứng minh nghiệp vụ đúng.
- **Đầu vào / kết quả cần đạt:** Ví dụ chọn ngân hàng: A=100,B=40; chuyển 30 thành 70,70; chuyển 71 thất bại và vẫn 70,70; snapshot ban đầu vẫn 100,40. Báo cáo mã `[10,-2,10] → entries=3;distinct=2;checksum=18`; [] → entries=0;distinct=0;checksum=0.
- **Trường hợp biên:** Input không null. Rỗng phải theo quy ước; tổng dùng long; không sửa nguồn; giữ thứ tự khi đề yêu cầu.
- **Hoàn thành khi:** Chạy đúng ví dụ/biên; tự nêu ít nhất hai lỗi đã tránh; giải thích độ phức tạp và quyết định cấu trúc.
- **Được dùng / giới hạn:** Java Core đã học: methods, arrays, strings, OOP, exception, collections; không Stream/framework/database.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../PROGRESS.md).
