# Tự làm cuối mục: Tổng kết Collections

Tiên quyết: Hoàn thành cả 7 mục con Collections, OOP, exception, wrapper, generics, equals/hashCode. Chưa cần comparator, lambda, Stream.

Đã có: README nhóm đã gợi ý chọn collection và bài cũ ở từng con. Bộ này đặt các cấu trúc cạnh nhau để kiểm tra lựa chọn và phối hợp. Các file cũ được giữ nguyên. Làm phần bài cũ đã đủ tiên quyết trước bộ kiểm tra cuối mục này; phần có API/khái niệm thuộc chặng sau thì quay lại khi đã học tới, không coi đó là điều kiện bắt đầu bộ này.

Quy trình: **Đọc đề → tự làm → chạy kiểm tra → giải thích → xem gợi ý nếu bí → đối chiếu lời giải sau cùng**. Học theo README → tutorial/ý chính → demo → tự làm → ghi chú. Viết dự đoán trước khi chạy bài suy luận; chỉ ghi lời giải riêng của bạn khi đã thử. Không cần thêm framework, dependency, Spring hay database.

Làm theo mã tăng dần; bài cuối kết hợp kiến thức trong mục và các tiên quyết. Với bài thiết kế, chọn class và cách tổ chức của bạn miễn đạt hành vi, bất biến và tiêu chí. [Starter](starter/Starter.java) chỉ chứa khung/TODO, main ban đầu không chạy thuật toán; không import lời giải vào starter. Viết lời giải và checks riêng trong starter hoặc class mới cùng package, dùng AssertionError để báo sai, tránh phụ thuộc cờ `-ea`.

Từ thư mục `java-core-practice` chạy PowerShell:

```powershell
.\build.ps1
java -cp target/classes collections.exercises.starter.Starter
```

Sau khi tự làm, kiểm tra cả ví dụ chuẩn lẫn biên của từng đề, tự giải thích nguyên nhân rồi dùng [checklist và câu hỏi](review.md). [Gợi ý hai mức](hints.md) và [lời giải riêng](solutions/README.md) chỉ mở khi đến đúng bước. Lệnh chạy reference có trong trang lời giải; reference đứng độc lập và không chạy tự động khi chạy starter.

Quy ước: input không null trừ khi đề yêu cầu xử lý null; validation sai dùng IllegalArgumentException nếu đề không chỉ định khác. Kết quả tập hợp/Map so theo nội dung, không theo thứ tự in trừ khi đề yêu cầu thứ tự. Các snippet minh họa nằm trong method/main và cần import/class được mô tả; code sai có chủ đích chỉ nằm trong Markdown.

## COL-01 — Chọn cấu trúc có lý do

- **Dạng / mức độ:** Cơ bản · Vừa.
- **Kiến thức luyện:** List/Set/Map/Queue/Deque/PriorityQueue.
- **Bối cảnh và yêu cầu:** Với sáu nhu cầu: lưu điểm theo lượt; mã duy nhất; tra giá theo mã; khách đến trước phục vụ trước; hoàn tác gần nhất; phút hẹn sớm nhất. Chọn cấu trúc và viết ví dụ 3 phần tử cho mỗi nhu cầu; giải thích ít nhất một lựa chọn khác sẽ khó hơn ở đâu.
- **Đầu vào / kết quả / ví dụ sử dụng:** Điểm 8,8,9 phải giữ hai số 8; mã A,A,B chỉ giữ hai mã.
- **Biên và chính sách:** Rỗng; trùng; nhu cầu thứ tự khác nhau; dùng String/Integer và không giả định HashSet giữ thứ tự.
- **Hoàn thành khi:** Sáu lựa chọn phù hợp hành vi, không chỉ nêu tên class.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-02 — Cùng dữ liệu, khác kết quả

- **Dạng / mức độ:** Suy luận · Vừa.
- **Kiến thức luyện:** Ngữ nghĩa cấu trúc.
- **Bối cảnh và yêu cầu:** Cho [3,1,3,2] vào ArrayList, HashSet, ArrayDeque FIFO và PriorityQueue. Ghi size mỗi cấu trúc, thứ tự lấy hết khi có hợp đồng; với Set chỉ ghi tập giá trị, không ép thứ tự.
- **Đầu vào / kết quả / ví dụ sử dụng:** Input [3,1,3,2]; viết bảng dự đoán trước khi chạy.
- **Biên và chính sách:** Input rỗng và toàn trùng; không coi thứ tự Set trên một máy là bảo đảm.
- **Hoàn thành khi:** Phân biệt trùng, FIFO và min; nói được vì sao Set không có poll.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-03 — Sao chép hai lớp cấu trúc

- **Dạng / mức độ:** Suy luận · Khó.
- **Kiến thức luyện:** Map chứa List, sao chép nông.
- **Bối cảnh và yêu cầu:** Map<String,List<Integer>> gốc A→[1]; sao bằng new HashMap<>(gốc), rồi thêm 2 vào list A của bản sao và thêm key B. Dự đoán gốc; viết bản sao cấu trúc hai tầng để thay List không ảnh hưởng nguồn.
- **Đầu vào / kết quả / ví dụ sử dụng:** Sau bản sao nông: gốc có A→?; có key B không? Ghi lý do trước khi chạy.
- **Biên và chính sách:** Map rỗng; list rỗng; Integer bất biến nên không cần sao chép sâu hơn.
- **Hoàn thành khi:** Copy riêng Map và mỗi List; không nói mọi clone đều deep copy.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-04 — Định danh không được trôi

- **Dạng / mức độ:** Tìm lỗi · Khó.
- **Kiến thức luyện:** Key bất biến, equals/hashCode.
- **Bối cảnh và yêu cầu:** Mô hình Ticket có id thay đổi qua setter sau khi được đưa vào HashSet và làm key HashMap. Chỉ ra hợp đồng bị phá và thay thiết kế bằng định danh bất biến; dữ liệu mô tả có thể đổi riêng. Không yêu cầu dự đoán bucket JVM.
- **Đầu vào / kết quả / ví dụ sử dụng:** Ticket id=A; sau đổi id=B vẫn muốn tra theo A: hãy nêu vì sao yêu cầu đang mâu thuẫn và đưa API rõ ràng.
- **Biên và chính sách:** Hai object khác cùng id; hash collision không phải mất dữ liệu; không khẳng định contains chắc chắn luôn trả false sau mutation.
- **Hoàn thành khi:** Id final hoặc key riêng bất biến; test lookup bằng object mới cùng id và cập nhật mô tả.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-05 — Tồn kho và nhật ký thành công

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** Map trạng thái và List lịch sử.
- **Bối cảnh và yêu cầu:** Tạo Inventory có take(code,amount). Chỉ ghi nhật ký code:amount khi lấy thành công; thiếu mã/thiếu hàng trả false, amount<=0 ném IllegalArgumentException. Trả snapshot nhật ký.
- **Đầu vào / kết quả / ví dụ sử dụng:** A=3; take(A,2)=true; take(A,2)=false; tồn1; history=[A:2].
- **Biên và chính sách:** Lấy đúng hết; mã thiếu; lỗi không ghi history; snapshot caller sửa được mà không đổi nội bộ.
- **Hoàn thành khi:** Tồn và lịch sử nhất quán, validation trước mutation.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-06 — Hàng chờ chống trùng kèm lịch sử

- **Dạng / mức độ:** Vận dụng · Khó.
- **Kiến thức luyện:** Queue + Set + List.
- **Bối cảnh và yêu cầu:** Tạo JobBoard.submit(id) chặn trùng đang chờ; process() lấy job đầu, xóa pending và thêm vào history. Cho phép submit lại job đã xử lý. Không có retry ở bài này.
- **Đầu vào / kết quả / ví dụ sử dụng:** submit A,B,A; process→A; submit A; process hết → history=[A,B,A].
- **Biên và chính sách:** Process rỗng trả null; history snapshot; id null/trắng bị từ chối.
- **Hoàn thành khi:** Mỗi cấu trúc có trách nhiệm rõ và đồng bộ sau process.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-07 — Báo cáo ưu tiên không phá nguồn

- **Dạng / mức độ:** Vận dụng · Vừa.
- **Kiến thức luyện:** PriorityQueue bản sao + Map số đếm.
- **Bối cảnh và yêu cầu:** Nhận List<Integer> mức ưu tiên 0..9. report trả chuỗi theo thứ tự nhỏ→lớn dạng level:count, giữ nguồn. Không dùng comparator hoặc Stream; có thể quét mức 0..9 để output ổn định.
- **Đầu vào / kết quả / ví dụ sử dụng:** [3,1,3,2] → [1:1,2:1,3:2].
- **Biên và chính sách:** Rỗng; 0 và9; mức ngoài miền ném IllegalArgumentException; phần tử không null.
- **Hoàn thành khi:** Không dựa vào iterator heap hoặc HashMap; đếm đúng trùng.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-08 — Giải thích độ phức tạp đúng phạm vi

- **Dạng / mức độ:** Suy luận + tìm lỗi · Vừa.
- **Kiến thức luyện:** Truy cập index, tìm kiếm và thao tác hai đầu.
- **Bối cảnh và yêu cầu:** Hai hàm tính tổng LinkedList<Integer>: một dùng get(i) mọi index, một for-each. Tạo input 0..99, chứng minh cùng tổng, giải thích chi phí tăng theo n; sửa nhận định “LinkedList luôn O(1) khi xóa”. Không benchmark hoặc dùng đồng hồ làm bằng chứng.
- **Đầu vào / kết quả / ví dụ sử dụng:** 0..99 → 4950 ở cả hai cách; n=0→0.
- **Biên và chính sách:** Phân biệt xóa đầu với tìm giá trị rồi xóa; không áp dụng chi phí LinkedList cho ArrayList.
- **Hoàn thành khi:** Nêu get(i) lặp có thể O(n²), duyệt tuần tự O(n), tìm node vẫn tốn chi phí.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.

## COL-09 — Quầy mượn thiết bị

- **Dạng / mức độ:** Tổng kết · Khó.
- **Kiến thức luyện:** OOP, Map, Set, Queue, List, validation.
- **Bối cảnh và yêu cầu:** Tự thiết kế quầy mượn: đăng ký thiết bị id duy nhất với số lượng không âm; tiếp nhận yêu cầu (người,mã,số lượng dương) theo FIFO; chặn cùng requestId đang chờ; xử lý từng yêu cầu, đủ hàng thì giảm tồn và lưu kết quả OK, thiếu/mã lạ ghi REJECTED; request thất bại không đổi tồn. requestId được nhận lại sau xử lý. Viết báo cáo kết quả theo thứ tự và snapshot tồn. Giải thích trách nhiệm từng class, cấu trúc chọn và bất biến.
- **Đầu vào / kết quả / ví dụ sử dụng:** Kho CAM=2; R1(An,CAM,1),R2(Bao,CAM,2) → [R1:OK,R2:REJECTED], tồn CAM=1. Gửi lại R1 sau xử lý được phép.
- **Biên và chính sách:** Queue rỗng; trùng pending; thiết bị chưa có; amount<=0; gọi báo cáo nhiều lần không mất dữ liệu; snapshot không làm lộ trạng thái.
- **Hoàn thành khi:** Có demo/check tự viết cho thành công, từ chối, trùng và lỗi; thiết kế có thể khác, không ép dùng mọi collection hoặc đủ bốn tính chất OOP.
- **Được dùng / giới hạn:** chỉ Java Core trong các tiên quyết ở đầu trang, cộng API của mục hiện tại; tuân các giới hạn riêng của bài. Starter không chứa sẵn thuật toán.
