# Tự làm: Bộ nhớ và vòng đời tham chiếu

[Về mục học](../README.md)

## Trước khi làm

Sau reference; đọc MemoryDemo. Dùng mô hình frame/heap, array và lớp chứa dữ liệu nhỏ như demo reference. Không đo địa chỉ, số byte, ép GC hoặc tạo lỗi hết bộ nhớ.

Bài cũ [MemoryExercise.java](../MemoryExercise.java) đã có hai frame, bỏ alias và trả array từ method. Bộ này mở rộng chuỗi lời gọi, đường tham chiếu qua field/array và snapshot có lịch sử.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.memory.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.memory.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### MEM-01 — Qua hai frame · Vừa · Cơ bản

- **Kiến thức luyện:** Frame; tham số primitive/reference; mảng trả về.
- **Bối cảnh và yêu cầu:** Viết outer(int seed) tạo int[]{seed}, gọi inner(int[] values) tăng ô đầu và trả cùng array. Caller có seed=3, nhận kết quả rồi in seed và result[0]. Vẽ main/outer/inner khi inner đang chạy.
- **Dữ liệu / kết quả / ví dụ:** Caller sau lời gọi: seed=3, result[0]=4.
- **Trường hợp biên:** Thử seed=0 và -1; chỉ giá trị nhỏ, không cần xử lý overflow; outer/inner không giữ field toàn cục.
- **Tiêu chí hoàn thành:** Có sơ đồ ba frame lúc inner hoạt động; khi return chỉ ra array còn được main truy cập. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MEM-02 — Đường đi qua mảng ngoài · Vừa · Suy luận

- **Kiến thức luyện:** Reachability; reference trong phần tử mảng.
- **Bối cảnh và yêu cầu:** Lập sơ đồ sau từng bước: `int[] row={1}; int[][] table={row}; row=null; table[0][0]=2; int[] saved=table[0]; table=null;`. Cuối cùng saved[0] là gì? Nếu thêm saved=null thì có thể kết luận gì về hàng từ snippet này?
- **Dữ liệu / kết quả / ví dụ:** Ghi dự đoán output saved[0] trước chạy, dùng bảng biến còn dẫn tới từng array.
- **Trường hợp biên:** Giả sử không có field/thread khác giữ tham chiếu; không truy cập table sau null; không gọi System.gc().
- **Tiêu chí hoàn thành:** Theo dõi riêng array ngoài và array hàng; dùng “có thể thu hồi” thay cho “đã bị GC”. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MEM-03 — Mọi hàng trở thành hàng cuối · Vừa · Tìm lỗi

- **Kiến thức luyện:** Vị trí cấp phát; alias giữa các hàng.
- **Bối cảnh và yêu cầu:** Hàm tạo ba hàng đang làm `int[] row=new int[1]; int[][] out=new int[3][]; for(int i=0;i<3;i++){row[0]=i;out[i]=row;}`. Vì sao kết quả không là [[0],[1],[2]]? Sửa vị trí tạo hàng để mỗi hàng độc lập.
- **Dữ liệu / kết quả / ví dụ:** Sau sửa [[0],[1],[2]]; sửa out[0][0]=99 thì hai hàng sau vẫn [1],[2].
- **Trường hợp biên:** Tổng quát count trong [0,10]; count=0 không tạo hàng; count=1 vẫn hợp lệ.
- **Tiêu chí hoàn thành:** Vẽ rõ một array ngoài và các array hàng của hai bản; không chỉ đổi cách in. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MEM-04 — Giữ dữ liệu sau khi bỏ vỏ chứa · Vừa · Vận dụng

- **Kiến thức luyện:** Reference trong field; vòng đời object khác nhau.
- **Bối cảnh và yêu cầu:** Dùng Slot nhỏ có int[] data và constructor. makeSlot() trả Slot chứa [7,8]. Caller lưu int[] retained=slot.data rồi gán slot=null. In retained, sửa retained[0] và giải thích những object nào còn đường tới từ các biến caller.
- **Dữ liệu / kết quả / ví dụ:** Sau slot=null retained in [7,8]; sau sửa [9,8].
- **Trường hợp biên:** Không dùng static giữ Slot; không khẳng định JVM đã thu hồi Slot; không truy cập slot.data sau khi null.
- **Tiêu chí hoàn thành:** Sơ đồ phân biệt Slot với array trong field; giải thích vì sao array vẫn reachable còn Slot không cần phải còn reachable. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### MEM-05 — Lịch sử phiên bản độc lập · Vừa · Tổng kết

- **Kiến thức luyện:** Copy array; frame; lịch sử; reachability.
- **Bối cảnh và yêu cầu:** Viết nextVersion(int[] previous,int index,int value) tạo array mới, thay một ô rồi trả về; không sửa previous. Tạo v0=[1,2], v1 từ v0 đổi ô 0 thành 9, v2 từ v1 đổi ô 1 thành 8; lưu trong int[][] history. Gán các biến v0,v1 về null, chứng minh history vẫn đọc được bản cũ. Sau đó bỏ history[0],history[1], giải thích đường tới từng phiên bản.
- **Dữ liệu / kết quả / ví dụ:** Ban đầu history=[[1,2],[9,2],[9,8]]; cuối cùng history[2] vẫn [9,8].
- **Trường hợp biên:** Input khác null; index hợp lệ; thử array một ô; version mới luôn khác previous; không gọi nextVersion trên array rỗng vì không có index hợp lệ.
- **Tiêu chí hoàn thành:** Ba snapshot độc lập, không nhầm gán local=null với bỏ mọi đường tới array; tự giải thích mô hình và giới hạn quan sát JVM. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
