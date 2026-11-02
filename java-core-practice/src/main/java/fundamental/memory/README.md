# Memory — Stack, heap và vòng đời tham chiếu

## Dùng để làm gì?

Mô hình bộ nhớ giúp giải thích lời gọi method, bản sao giá trị, object dùng chung và vì sao một object có thể còn sống sau khi method tạo nó đã kết thúc.

## Những ý bắt buộc phải hiểu

- Trong mô hình JVM, mỗi thread có Java stack. Mỗi lời gọi method có frame chứa vùng biến cục bộ, operand stack và dữ liệu phục vụ thực thi. Tham số cũng nằm trong vùng biến cục bộ của frame.
- Heap là vùng dùng chung để mô hình hóa object và mảng. Biến cục bộ reference giữ giá trị tham chiếu; object được tham chiếu không phải chính biến đó.
- Không nói “mọi primitive ở stack”: primitive còn có thể là field của object hoặc phần tử mảng. Reference cũng có thể nằm trong field hay phần tử mảng, không chỉ biến cục bộ.
- Method kết thúc thì frame không còn hoạt động; object trả về vẫn có thể được caller giữ tham chiếu và sử dụng.
- Gán `null` bỏ một tham chiếu. Nếu object không còn reachable từ GC roots, nó có thể được thu hồi; không có cam kết thu hồi ngay. Trong bài tập nhỏ, chỉ theo dõi các đường tham chiếu trong đoạn mã, không quan sát toàn bộ JVM.
- Đây là mô hình ngữ nghĩa để học, không phải bản đồ địa chỉ vật lý: JIT có thể inline method, dùng thanh ghi, thực hiện escape analysis và tối ưu cấp phát. Không suy ra số byte, địa chỉ hay thời điểm GC từ vài dòng Java.
- Không đếm toàn bộ object String trong heap từ literal; không dùng `System.gc()` để chứng minh object đã bị thu hồi.

## Lỗi người mới thường gặp

- Nghĩ gán `null` hủy object ngay hoặc làm tất cả alias cùng thành `null`.
- Nghĩ object tạo trong method biến mất khi method return, nên không thể trả mảng mới.
- Nhầm thời gian một biến còn trong scope với thời gian object còn được tham chiếu.
- Vẽ mỗi biến reference thành một object riêng hoặc cho rằng `int[]` nằm hoàn toàn trong frame vì khai báo ở method.

## Tự kiểm tra

1. Khi gọi method nhận `int x`, biến `x` ở caller và ở tham số có phải cùng biến không?
2. Sau `b = a; a = null;`, `b` có còn truy cập object cũ không?
3. Vì sao trả một mảng mới tạo trong method không tạo tham chiếu bị treo?
4. Primitive là field của object có nhất thiết nằm ở stack không?
5. Tại sao mất mọi tham chiếu trong snippet không chứng minh object đã được GC ngay?

## Ba bài tập từ dễ đến khó

1. **Dễ — Hai frame:** caller có `x=3`; method nhận `int x`, tăng và in `4`; caller sau lời gọi in `3`. Vẽ hai frame khi method đang chạy, ghi riêng hai biến `x`. Giải thích pass-by-value; không tính địa chỉ hoặc dung lượng vật lý.
2. **Vừa — Bỏ alias:** `a=new int[]{1}`, `b=a`, rồi `b=null`; `a` vẫn in `[1]`. Tiếp tục `a=null`; giả sử không có tham chiếu nào khác, mảng không còn reachable từ đoạn mã. Có đúng một mảng được tạo bởi biểu thức `new int[]` ở bài này, không nói về toàn bộ heap. Giải thích vì sao hai phép gán `null` không đảm bảo GC đã chạy; không gọi `System.gc()`.
3. **Khó — Thoát khỏi lời gọi:** method `createNumbers()` tạo và trả mảng `[7,8,9]`. Caller in `[7,8,9]`, gán sang alias, bỏ tham chiếu ban đầu rồi in alias vẫn `[7,8,9]`. Giải thích sự kết thúc của frame, việc sao chép tham chiếu trả về và khả năng truy cập object. Các lời gọi không dùng thread khác hay giữ tham chiếu qua field.

## Sơ đồ nên tự vẽ

```text
Frame main:      numbers ─┐
                         ├──> mảng [7, 8, 9] trên heap (mô hình JVM)
                alias ───┘
Frame tạo mảng:  đã kết thúc; mảng vẫn được main tham chiếu
```

## Cách học

Đoán `MemoryDemo.java`; vẽ frame và mũi tên cho từng TODO trong `MemoryExercise.java`; chỉ mở `MemorySolution.java` sau khi giải thích được bằng lời. Không thử tạo lỗi tràn stack/heap để “xác minh” mô hình ở phần nhập môn này.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
