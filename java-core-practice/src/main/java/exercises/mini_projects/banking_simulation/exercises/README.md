# Tự kiểm tra — Chuyển tiền an toàn và chống lặp mã lệnh

**Tiên quyết:** Hoàn thành OOP, exception, Collections, comparable_comparator và đọc ba TODO mini project cũ; String.split(";", -1) được dùng để giữ trường rỗng khi đọc lệnh.

Các model/service/Exercise/Solution cũ đều giữ nguyên skeleton hoặc bài làm. Bộ mới là một nhánh thực hành riêng có lời giải chạy được. Với bài thiết kế, tên class và chữ ký tham khảo không bắt buộc; đánh giá hành vi, bất biến và trách nhiệm.

Đọc [README chủ đề](../README.md), tutorial/diễn giải và demo hiện có trước. Làm theo mã bài bên dưới: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng → ghi chú vào file riêng của bạn. Không cần sửa bài cũ.

Dùng [starter](starter/Starter.java); khung chưa triển khai có thể ném `UnsupportedOperationException`. Bài đọc/tìm lỗi được chép vào nháp riêng; đoạn lỗi trong đề không tham gia build.

## BANK-01 — Bảo toàn số dư · Cơ bản

- **Luyện:** long, điều kiện, bất biến.
- **Bối cảnh và yêu cầu:** Tính tay chuyển nội bộ và liệt kê điều kiện hợp lệ. Viết helper tổng số dư phát hiện tràn long; helper này phục vụ báo cáo, không thay đổi tài khoản.
- **Đầu vào / kết quả cần đạt:** A=100,B=40, chuyển 30 từ A sang B: ghi số dư cuối và tổng; tổng [MAX_VALUE,1] phải báo overflow.
- **Trường hợp biên:** Tiền 0/âm; vừa hết số dư; thiếu tiền; tổng báo cáo vượt long.
- **Hoàn thành khi:** Nêu được bất biến không âm và bảo toàn tổng khi chuyển thành công.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## BANK-02 — Bản sao danh bạ tài khoản · Vừa · suy luận

- **Luyện:** Reference, copy và quyền thay đổi.
- **Bối cảnh và yêu cầu:** Hai map original và new HashMap<>(original) cùng giữ Account A số dư 100. Service rút 30 qua object trong map gốc. Dự đoán số dư thấy ở copy, rồi phân tích nếu thay value ở copy bằng Long snapshot.
- **Đầu vào / kết quả cần đạt:** Nộp sơ đồ object và bảng số dư trước/sau, ghi rõ thao tác nào chỉ đổi map.
- **Trường hợp biên:** Account thiếu; snapshot rỗng; caller sửa snapshot không được sửa bank.
- **Hoàn thành khi:** Phân biệt object mutable với giá trị Long bất biến.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## BANK-03 — Chuyển tiền mất nửa giao dịch · Vừa · tìm lỗi

- **Luyện:** Tìm lỗi và kiểm validation.
- **Bối cảnh và yêu cầu:** Sửa mô hình `from.balance-=amount; to.balance=Math.addExact(to.balance,amount);` với kiểm điều kiện đặt sau. Phân tích thiếu tiền, thiếu tài khoản, tự chuyển và overflow phía nhận.
- **Đầu vào / kết quả cần đạt:** A=100,B=MAX_VALUE,chuyển 1 phải thất bại và A vẫn 100,B vẫn MAX_VALUE.
- **Trường hợp biên:** from/to null hoặc không tồn tại; amount<=0; cùng tài khoản; bên nhận overflow.
- **Hoàn thành khi:** Mọi lỗi phát hiện trước cập nhật; kiểm cả hai số dư sau lỗi.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## BANK-04 — Gửi lại lệnh không chuyển hai lần · Khó · vận dụng

- **Luyện:** Map lưu mã, equality dữ liệu và service.
- **Bối cảnh và yêu cầu:** Thiết kế transfer(txId,from,to,amount) trả true nếu mới thực hiện, false nếu cùng mã/cùng nội dung đã thành công. Cùng mã khác nội dung phải từ chối. Chỉ ghi mã sau chuyển thành công; lệnh thất bại được thử lại khi điều kiện thay đổi.
- **Đầu vào / kết quả cần đạt:** T1,A,B,30 lần đầu: A=70,B=70,true; gửi lại y hệt: vẫn 70,70,false; T1,A,B,20 bị từ chối.
- **Trường hợp biên:** Mã rỗng; chưa có tài khoản; lặp thành công lúc số dư hiện không còn đủ; lệnh thất bại không giữ mã.
- **Hoàn thành khi:** Phân biệt duplicate với conflict, bảo vệ invariant và giải thích đây chỉ là mô phỏng một luồng.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## BANK-05 — Snapshot sổ dư · Vừa · vận dụng

- **Luyện:** Map và defensive copy.
- **Bối cảnh và yêu cầu:** Trả Map mã→số dư theo thứ tự đăng ký. Caller thay/xóa entry không sửa service, snapshot cũ không thay đổi khi chuyển mới.
- **Đầu vào / kết quả cần đạt:** Đăng ký A=100,B=40, lấy snapshot, chuyển 30; snapshot vẫn {A=100,B=40}, service {A=70,B=70}.
- **Trường hợp biên:** Bank rỗng; một tài khoản; ID trùng; số dư ban đầu âm.
- **Hoàn thành khi:** Chạy kiểm sửa snapshot và sửa bank theo hai chiều.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## BANK-06 — Nhập lệnh sai và gửi lại · Vừa · tìm lỗi + vận dụng

- **Luyện:** String parsing, exception, console loop.
- **Bối cảnh và yêu cầu:** Xử lý TRANSFER;tx;from;to;amount, BALANCES, EXIT. Trả OK cho lệnh mới, DUPLICATE cho lặp hợp lệ, ERR khi sai, BYE để kết thúc. Adapter Scanner.nextLine tiếp tục sau ERR và dừng ở EOF.
- **Đầu vào / kết quả cần đạt:** TRANSFER;T1;A;B;abc → ERR; BALANCES vẫn chạy; chuyển 30 đúng → OK; gửi lại → DUPLICATE; EXIT → BYE.
- **Trường hợp biên:** Thiếu/thừa trường; số quá long; mã lạ; lệnh rỗng; EOF.
- **Hoàn thành khi:** Transcript phân biệt thành công/lặp/lỗi; không nuốt exception nghiệp vụ thành OK.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## BANK-07 — Quầy chuyển tiền có đối soát · Khó · tổng kết

- **Luyện:** Tổng hợp OOP, Map, exception, command.
- **Bối cảnh và yêu cầu:** Ghép đăng ký tài khoản, chống lặp, snapshot, console và kiểm tổng bằng long khi tổng biểu diễn được. Tự nêu trách nhiệm class, invariant và phần sửa nếu thêm giao diện nhập khác. Không yêu cầu database/thread hay đủ bốn tính chất OOP.
- **Đầu vào / kết quả cần đạt:** A=100,B=40; T1 chuyển 30 → 70,70; lặp T1 không đổi; T2 chuyển 71 lỗi; T3 chuyển 70 từ B sang A → 140,0, tổng vẫn 140.
- **Trường hợp biên:** Mọi lỗi bài trước; lệnh lặp nội dung khác; receiver overflow; tổng báo cáo overflow.
- **Hoàn thành khi:** Có kiểm trạng thái sau từng lệnh, cả thất bại; giải thích thứ tự validation và lưu mã.
- **Được dùng / giới hạn:** Java Core: OOP, exception, String/Scanner, Collections, Comparator. Một luồng, dữ liệu trong bộ nhớ; không file/database/framework/Stream bắt buộc.

## Chạy và tự đánh giá

Từ thư mục `java-core-practice` trong PowerShell:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.banking_simulation.exercises.starter.Starter
```

Sau khi tự làm, chạy lời giải tham khảo riêng:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes exercises.mini_projects.banking_simulation.exercises.solutions.ReferenceSolution
```

Lời giải in `OK` khi các ca minh họa qua kiểm tra; đây không phải bộ kiểm tra đầy đủ bài làm của bạn. Tự thêm ca biên và kiểm trạng thái trước/sau. Hoàn tất [review](review.md), rồi cập nhật bảng [tiến độ](../../../../../../../PROGRESS.md).
