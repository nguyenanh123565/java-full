# Đối chiếu sau khi tự làm: Tổng kết Collections

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS COL: 9 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## COL-01 — Chọn cấu trúc có lý do

Một phương án: ArrayList, HashSet, HashMap, ArrayDeque qua Queue/Deque, PriorityQueue<Integer>. Ví dụ phải chứng minh hành vi.

Đối chiếu đoạn kiểm tra có mã `COL-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-02 — Cùng dữ liệu, khác kết quả

List/FIFO giữ [3,1,3,2], size4; Set {1,2,3},size3; heap lấy [1,2,3,3],size ban đầu4.

Đối chiếu đoạn kiểm tra có mã `COL-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-03 — Sao chép hai lớp cấu trúc

Gốc A=[1,2], không có B. Copy hai tầng cần Map mới và List mới cho từng entry.

Đối chiếu đoạn kiểm tra có mã `COL-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-04 — Định danh không được trôi

Một phương án: TicketKey final id + equals/hashCode theo id, Map<TicketKey,String> lưu mô tả. Mutation mô tả không làm hash đổi.

Đối chiếu đoạn kiểm tra có mã `COL-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-05 — Tồn kho và nhật ký thành công

Một phương án: kiểm tra số lượng và mã trước, put tồn mới rồi add history; không ghi thất bại như đã xử lý.

Đối chiếu đoạn kiểm tra có mã `COL-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-06 — Hàng chờ chống trùng kèm lịch sử

Một phương án: ba collection private. submit chỉ thêm queue khi set.add true; process poll, remove set, append history.

Đối chiếu đoạn kiểm tra có mã `COL-06` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-07 — Báo cáo ưu tiên không phá nguồn

Một phương án: Map đếm rồi quét 0..9 và thêm chuỗi khi có key. Không cần heap nếu miền đã nhỏ và hữu hạn.

Đối chiếu đoạn kiểm tra có mã `COL-07` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-08 — Giải thích độ phức tạp đúng phạm vi

For-each có một lần đi qua node; get(i) lặp có tổng quãng duyệt bậc hai. Xóa đầu O(1), tìm theo giá trị thường O(n).

Đối chiếu đoạn kiểm tra có mã `COL-08` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## COL-09 — Quầy mượn thiết bị

ReferenceSolution dùng Request bất biến và Counter quản lý các collection. Đây chỉ là một phương án; code từ chối phải không trừ tồn, xử lý xong phải giải phóng pending.

Đối chiếu đoạn kiểm tra có mã `COL-09` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
