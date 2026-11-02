# Tự kiểm tra — Kho hàng: bán cả giỏ hoặc không đổi

**Tiên quyết:** Hoàn thành OOP, exception, Collections, comparable_comparator và đọc ba TODO mini project cũ; String.split(";", -1) được dùng để giữ trường rỗng khi đọc lệnh.

Các model/service/Exercise/Solution cũ đều giữ nguyên skeleton hoặc bài làm. Bộ mới là một nhánh thực hành riêng có lời giải chạy được. Với bài thiết kế, tên class và chữ ký tham khảo không bắt buộc; đánh giá hành vi, bất biến và trách nhiệm.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## PROD-01 — Giá trị kho chính xác · Cơ bản

- **Luyện:** long, bất biến tồn kho.
- **Bối cảnh và yêu cầu:** Tính tay giá trị kho, tồn sau bán và điều kiện được bán. Viết hàm tính giá trị bằng số đồng nguyên, từ chối tràn long thay vì cho kết quả âm.
- **Đầu vào / kết quả cần đạt:** Giá 12000, tồn 3 → giá trị 36000; bán 2 còn 1 → 12000. MAX_VALUE*2 phải bị từ chối.
- **Trường hợp biên:** Giá 0; tồn 0; giá hoặc tồn âm; lượng bán 0/âm.
- **Hoàn thành khi:** Giải thích được miền giá trị và vì sao không dùng double.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## PROD-02 — Hai danh mục cùng giữ một sản phẩm · Vừa · suy luận

- **Luyện:** Reference và quyền thay đổi.
- **Bối cảnh và yêu cầu:** Với `copy=new HashMap<>(original)`, cả hai map có P1 là cùng Product tồn 5. Service bán 2 từ original; dự đoán copy.get(P1).quantity, rồi copy.clear và mô tả original.
- **Đầu vào / kết quả cần đạt:** Nộp bảng số lượng/size trước/sau, cùng sơ đồ reference.
- **Trường hợp biên:** Map rỗng; snapshot số lượng thay vì snapshot Product mutable.
- **Hoàn thành khi:** Giải thích được thay đổi phần tử khác thay đổi cấu trúc.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## PROD-03 — Giảm kho trước validation · Vừa · tìm lỗi

- **Luyện:** Tìm lỗi, trạng thái hợp lệ và overflow.
- **Bối cảnh và yêu cầu:** Sửa `stock-=requested; if(stock<0)throw new IllegalArgumentException(); return price*requested;`. Nêu lỗi khi bán thiếu hàng và khi phép nhân tràn.
- **Đầu vào / kết quả cần đạt:** Tồn 2, bán 3 phải lỗi và vẫn 2; giá MAX_VALUE,bán 2 phải lỗi và không trừ kho.
- **Trường hợp biên:** Số lượng âm, bằng 0, đúng tồn; nhân tràn và tổng nhiều dòng tràn.
- **Hoàn thành khi:** Không có đường lỗi nào để stock thay đổi một phần.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## PROD-04 — Bán giỏ nhiều dòng · Khó · vận dụng

- **Luyện:** Map, validation hai pha, checked arithmetic.
- **Bối cảnh và yêu cầu:** Thiết kế thao tác nhận String[] ids,int[] quantities. Cho phép ID xuất hiện nhiều dòng, gộp số lượng bằng Math.addExact. Tất cả phải tồn tại, lượng từng dòng >0, đủ hàng và tổng tiền không tràn long. Chỉ sau đó mới trừ kho; trả tổng tiền.
- **Đầu vào / kết quả cần đạt:** P1 giá 10000 tồn 5,P2 giá 20000 tồn 2; [P1,P1,P2]/[1,2,1] → 50000, tồn P1=2,P2=1.
- **Trường hợp biên:** Giỏ rỗng trả 0; lệch độ dài; mã lạ; dòng cuối thiếu hàng; số lượng cộng tràn int; tổng tiền tràn long.
- **Hoàn thành khi:** Có ca lỗi ở cuối giỏ và kiểm tất cả tồn không đổi.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## PROD-05 — Danh sách giá là snapshot · Vừa · vận dụng

- **Luyện:** Comparator và đóng gói.
- **Bối cảnh và yêu cầu:** Trả snapshot id/name/giá/tồn, sắp giá giảm rồi mã tăng. Caller sửa danh sách hoặc service bán hàng sau đó đều không đổi snapshot cũ.
- **Đầu vào / kết quả cần đạt:** P1 và P2 giá 10000 → P1 trước P2; MAX_VALUE trước 1; bán xong snapshot cũ giữ tồn ban đầu.
- **Trường hợp biên:** Kho rỗng; một sản phẩm; hòa giá; giá vượt int.
- **Hoàn thành khi:** Dùng so sánh an toàn; không lộ Product mutable nội bộ.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## PROD-06 — Lệnh bán sai và tiếp tục · Vừa · tìm lỗi + vận dụng

- **Luyện:** Parse số, exception, điều khiển console.
- **Bối cảnh và yêu cầu:** Viết xử lý `SELL;id;quantity`, `LIST`, `EXIT`. Bán đúng trả tổng tiền, sai trả ERR và tiếp tục; EXIT trả BYE. Adapter Scanner.nextLine phải dừng cả khi EOF.
- **Đầu vào / kết quả cần đạt:** SELL;P1;abc → ERR; LIST vẫn chạy; SELL;P1;1 → 10000; EXIT → BYE.
- **Trường hợp biên:** Thiếu/thừa trường; int vượt miền; mã không tồn tại; dòng rỗng; EOF.
- **Hoàn thành khi:** Có transcript nối tiếp lỗi/thành công; không parse xong rồi cập nhật trước khi kiểm.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## PROD-07 — Quầy bán hàng có đối soát · Khó · tổng kết

- **Luyện:** Tổng hợp class/service, giỏ, snapshot, console.
- **Bối cảnh và yêu cầu:** Ghép tạo sản phẩm hợp lệ, bán giỏ, danh sách snapshot và lệnh bán lẻ. Tự nêu trách nhiệm class, bất biến và phần code thay đổi nếu thêm giảm giá sau này; chưa triển khai giảm giá. Không ép kế thừa.
- **Đầu vào / kết quả cần đạt:** Khởi tạo ví dụ bài 04, giữ snapshot, bán giỏ 50000; giỏ kế tiếp [P1,P2]/[1,9] lỗi và tồn vẫn 2,1. Snapshot ban đầu vẫn 5,2.
- **Trường hợp biên:** Toàn bộ ca lỗi trước; tên/id rỗng; giá/tồn âm; thao tác lặp.
- **Hoàn thành khi:** Có kiểm trước/sau cả thành công và lỗi, giải thích validation/commit và đánh đổi thiết kế.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.product_management.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.product_management.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
