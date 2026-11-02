# Học và tự kiểm tra Java Core

Bắt đầu ở [variables](src/main/java/fundamental/variables/README.md), học phần diễn giải và ví dụ, rồi làm [bộ tự kiểm tra variables](src/main/java/fundamental/variables/exercises/README.md). [Bảng tiến độ](PROGRESS.md) dẫn tới bộ bài của từng mục và mục con.

## Quy trình một buổi

1. Đọc README chủ đề, phần giải thích khái niệm và tutorial nếu có. Repository hiện dùng README làm phần diễn giải, chưa có file tutorial riêng.
2. Đọc Demo và ghi dự đoán trước khi chạy. Ghi cả lý do; chạy đúng nhưng đoán sai vẫn là điều cần học lại.
3. Đọc đề trong `exercises/README.md`, tự xác định đầu vào, đầu ra, điều kiện hợp lệ và trạng thái phải giữ khi lỗi.
4. Tự làm trong `exercises/starter/`. Bài cũ trong `*Exercise.java` vẫn dùng bình thường. Khung mới chỉ chứa TODO; biên dịch được chưa có nghĩa đã giải xong.
5. Chạy dữ liệu mẫu, thêm ca biên và ca sai theo đề. Với object mutable, so sánh cả trạng thái trước và sau thao tác thất bại.
6. Giải thích bằng lời: vì sao đúng, vì sao dừng, chi phí thời gian/bộ nhớ khi đã học, và nguyên nhân lỗi đã sửa.
7. Nếu bí, mở riêng `hints.md`: thử mức 1 trước, chỉ mở mức tiếp theo sau khi đã thử lại.
8. Cuối cùng mới đối chiếu `solutions/README.md` và code tham khảo. Cách thiết kế khác được chấp nhận khi giữ hành vi và giải thích được trách nhiệm.
9. Hoàn tất `review.md`, ghi điều đã hiểu/còn vướng vào ghi chú riêng và cập nhật tiến độ. Không cần thay ghi chú cũ.

## Thứ tự và điều kiện học

| Chặng | Điều kiện và lưu ý |
| --- | --- |
| Fundamental | variables → operators → condition → loops → methods → arrays → strings → reference → memory. Chỉ dùng cú pháp đã tới trong chặng. |
| OOP | class/object → constructor → encapsulation → inheritance → abstraction → polymorphism → interface → overriding → overloading → composition; làm bộ tổng kết OOP sau các mục con. |
| Exception, static/final, wrapper | Sau OOP. Các bài yêu cầu từ chối bằng exception cần học exception trước. |
| Generics, equals/hashCode, Collections | Theo thứ tự README gốc. Collections mới dùng thứ tự tự nhiên của số nguyên khi chưa học Comparator/lambda. |
| Enum, Comparable/Comparator, lambda, Stream | Theo thứ tự README gốc và phần tiên quyết ở từng bộ đề. Không ép dùng Stream cho bài chưa học Stream. |
| Easy dùng mảng/chuỗi | Find Min, Reverse Array, Binary Search, Palindrome có thể làm sau nền tảng. Bài Find Max mới dùng IllegalArgumentException nên học exception trước phần viết biến thể. |
| Easy dùng collection | Count Frequency, Remove Duplicate, Character Frequency, Two Sum cần Map/Set; Valid Parentheses cần Deque. Học Collections trước các bài này dù nằm trong nhóm easy. |
| Medium và mini project | Medium sau collection/easy; mini project sau OOP, exception, collection và Comparator. Tiền là long theo đồng nguyên; không có database. |

Một số ví dụ/bài cũ sử dụng khái niệm xuất hiện ở chặng sau. Chúng được giữ nguyên; theo phần tiên quyết của bộ mới và quay lại bài mở rộng cũ sau khi đủ kiến thức. Các helper kiểm tra trong lời giải như `assert`, `check`, `Runnable` chỉ phục vụ chạy kiểm chứng, không bắt người học dùng chúng để giải bài trước chặng tương ứng.

## Chạy từng phần

Mở PowerShell tại `java-core-practice`, dùng JDK 17 trở lên:

```powershell
.\build.ps1
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.variables.exercises.starter.Starter
```

Tên class starter/reference cụ thể được ghi trong README của từng bộ bài. Các package `...exercises.starter` và `...exercises.solutions` độc lập; starter không gọi lời giải. Khung chưa làm có thể chưa in gì hoặc báo TODO khi gọi method. Luôn biên dịch lại sau khi sửa code.

Sau khi tự làm, có thể chạy tất cả ví dụ/lời giải và kiểm liên kết tài liệu:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\verify-exercises.ps1
```

Lệnh dùng `build.ps1` hiện có với `javac --release 17 -encoding UTF-8`, bật assertions bằng `-ea` và ghi output vào `target/exercise-verification/run-log.txt`. Không cần Maven, thư viện ngoài hoặc framework kiểm thử. Script kiểm tra đích file của liên kết Markdown nội bộ và chạy main Demo/Solution; không truy cập các URL ngoài mạng và không chấm tự động bài làm của bạn. Xem [kết quả thực tế và giới hạn kiểm tra](PRACTICE_VALIDATION.md).

Ba file `*ManagementSolution.java` / `BankingSimulationSolution.java` cũ vẫn là skeleton. Lời giải chạy được của nhánh thực hành mới nằm dưới `exercises/solutions/`, có phạm vi đúng các bài mới; chúng không tự điền các TODO cũ.
