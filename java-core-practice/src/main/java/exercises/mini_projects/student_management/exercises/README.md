# Tự kiểm tra — Sổ điểm: cập nhật hàng loạt và snapshot

**Tiên quyết:** Hoàn thành OOP, exception, Collections, comparable_comparator và đọc ba TODO mini project cũ; String.split(";", -1) được dùng để giữ trường rỗng khi đọc lệnh.

Các model/service/Exercise/Solution cũ đều giữ nguyên skeleton hoặc bài làm. Bộ mới là một nhánh thực hành riêng có lời giải chạy được. Với bài thiết kế, tên class và chữ ký tham khảo không bắt buộc; đánh giá hành vi, bất biến và trách nhiệm.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## STU-01 — Quy tắc đạt và điểm hợp lệ · Cơ bản

- **Luyện:** Validation, double, điều kiện.
- **Bối cảnh và yêu cầu:** Định nghĩa học viên đạt khi score>=5. Tự viết hàm xét đạt sau kiểm điểm hữu hạn trong [0,10], rồi lập bảng dữ liệu, không làm tròn điểm.
- **Đầu vào / kết quả cần đạt:** Điểm 4.9,5,10,NaN,+Infinity: ghi kết quả đạt/không đạt/bị từ chối theo hợp đồng.
- **Trường hợp biên:** 0,10; -1,11; NaN và hai infinity.
- **Hoàn thành khi:** Nêu đủ miền hợp lệ và không để NaN lọt.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## STU-02 — Map sao chép và điểm chung · Vừa · suy luận

- **Luyện:** Reference, shallow copy, đóng gói.
- **Bối cảnh và yêu cầu:** Đọc mô hình `copy=new HashMap<>(original); copy.get("S1").setScore(9); copy.remove("S1");` với S1 ban đầu điểm 6 và setter hợp lệ. Dự đoán điểm và số entry ở hai map, giải thích lần cập nhật nào lan sang gốc.
- **Đầu vào / kết quả cần đạt:** Nộp sơ đồ object trước/sau và bảng size/score; giả sử cả hai map chỉ có S1 trước thao tác.
- **Trường hợp biên:** Map không có S1 sẽ có hành vi gì? Đừng chạy dereference null như một ca thành công.
- **Hoàn thành khi:** Phân biệt thay đổi cấu trúc map và thay đổi Student.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## STU-03 — Điểm NaN vượt qua validation · Vừa · tìm lỗi

- **Luyện:** Tìm lỗi trạng thái hợp lệ.
- **Bối cảnh và yêu cầu:** Sửa `this.score=score; if(score<0||score>10)throw new IllegalArgumentException();`. Giải thích hai lỗi độc lập và cách giữ trạng thái cũ khi update sai.
- **Đầu vào / kết quả cần đạt:** S1 điểm 6, update NaN hoặc 11 phải bị từ chối và điểm vẫn 6.
- **Trường hợp biên:** NaN,infinity; biên 0/10; mã không tồn tại khi cập nhật phải bị từ chối.
- **Hoàn thành khi:** Kiểm dữ liệu trước gán; có ca kiểm trạng thái trước/sau.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## STU-04 — Cập nhật điểm toàn bộ hoặc không đổi · Khó · vận dụng

- **Luyện:** Service, Map/Set, validate trước mutation.
- **Bối cảnh và yêu cầu:** Tự thiết kế service giữ học viên theo mã. Tạo thao tác nhận String[] ids và double[] scores cùng độ dài, cập nhật hàng loạt. Mã phải tồn tại, không trùng trong một lệnh; mọi điểm hợp lệ. Sai bất kỳ phần tử nào phải giữ nguyên toàn bộ.
- **Đầu vào / kết quả cần đạt:** Ban đầu S1=6,S2=7; [S1,S2]/[8,9] → 8,9. [S1,S9]/[10,5] bị từ chối và vẫn 8,9.
- **Trường hợp biên:** Hai mảng rỗng là no-op; khác độ dài; ID trùng; điểm cuối sai; ID null/rỗng.
- **Hoàn thành khi:** Có kiểm ca lỗi ở cuối lô và chứng minh không cập nhật người đầu.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## STU-05 — Bảng xếp hạng độc lập · Vừa · vận dụng

- **Luyện:** Comparator, defensive copy.
- **Bối cảnh và yêu cầu:** Trả snapshot gồm mã/tên/điểm, sort điểm giảm rồi mã tăng. Snapshot không cho caller sửa trạng thái service; sửa service sau đó không làm snapshot cũ đổi.
- **Đầu vào / kết quả cần đạt:** S2=8,S1=8 → thứ tự S1,S2. Lấy snapshot rồi đổi S1=9; snapshot vẫn ghi S1=8.
- **Trường hợp biên:** Không ai; một người; hòa điểm; tên có khoảng trắng đầu/cuối cần trim.
- **Hoàn thành khi:** Chứng minh bảo vệ cả cấu trúc và dữ liệu phần tử, không chỉ new ArrayList.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## STU-06 — Lệnh lỗi không làm dừng buổi học · Vừa · tìm lỗi + vận dụng

- **Luyện:** String parsing, exception và console loop.
- **Bối cảnh và yêu cầu:** Tự viết xử lý một dòng `SCORE;id;score`, `LIST`, `EXIT`; SCORE thành công trả OK, lỗi trả ERR, EXIT trả BYE; lệnh sai không làm dừng vòng nhập. Viết adapter console lặp Scanner.nextLine đến EXIT hoặc hết input.
- **Đầu vào / kết quả cần đạt:** SCORE;S1;abc → ERR, LIST sau đó vẫn trả bảng cũ, SCORE;S1;9 → OK, EXIT → BYE.
- **Trường hợp biên:** Dòng rỗng; thiếu/thừa trường; trường cuối rỗng; lệnh lạ; EOF trước EXIT.
- **Hoàn thành khi:** Có một bản transcript đầy đủ, code tiếp tục sau lỗi và kết thúc được ở EOF.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## STU-07 — Báo cáo lớp và thay đổi có kiểm soát · Khó · tổng kết

- **Luyện:** Tổng hợp OOP, collection, exception, console.
- **Bối cảnh và yêu cầu:** Ghép service cập nhật hàng loạt, snapshot, số học viên đạt và trung bình; lớp rỗng báo EMPTY. Tự giải thích trách nhiệm mỗi class, vị trí đóng gói/composition và phần phải sửa nếu thêm lệnh BULK. Không ép có kế thừa.
- **Đầu vào / kết quả cần đạt:** S1=6,S2=4 → count=2;passed=1;average=5.0. Lô [S1,S2]/[8,10] → count=2;passed=2;average=9.0; snapshot cũ vẫn 6,4.
- **Trường hợp biên:** Lớp rỗng; bulk lỗi; tên/id trống; menu lỗi; mọi ca ở bài trước.
- **Hoàn thành khi:** Có transcript, kiểm trước/sau, giải thích phân công trách nhiệm và một đánh đổi thiết kế.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.student_management.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.student_management.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
