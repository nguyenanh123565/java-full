# Gợi ý: Tổng kết Collections

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## COL-01 — Chọn cấu trúc có lý do

1. **Mức 1:** Phân biệt thứ tự, trùng và tra theo key.
2. **Mức 2:** List giữ lượt; Set duy nhất; Map tra; FIFO queue; LIFO deque; min heap.

## COL-02 — Cùng dữ liệu, khác kết quả

1. **Mức 1:** Chỉ Set loại phần tử bằng nhau.
2. **Mức 2:** Queue FIFO theo insertion; PriorityQueue poll nhỏ nhất.

## COL-03 — Sao chép hai lớp cấu trúc

1. **Mức 1:** Copy Map chỉ copy reference tới value.
2. **Mức 2:** Lặp entrySet, mỗi value dùng new ArrayList<>(value).

## COL-04 — Định danh không được trôi

1. **Mức 1:** Dữ liệu nhận diện cần ổn định khi object ở collection.
2. **Mức 2:** Tách key final khỏi mô tả mutable; đổi id là nghiệp vụ khác.

## COL-05 — Tồn kho và nhật ký thành công

1. **Mức 1:** Phân biệt trạng thái hiện tại với sự kiện đã xảy ra.
2. **Mức 2:** Map giữ số lượng; ArrayList giữ lượt thành công.

## COL-06 — Hàng chờ chống trùng kèm lịch sử

1. **Mức 1:** Lịch sử không dùng làm tập chặn trùng đang chờ.
2. **Mức 2:** Pending Set xóa ngay khi Queue poll; lịch sử append sau khi có job.

## COL-07 — Báo cáo ưu tiên không phá nguồn

1. **Mức 1:** Đếm bằng Map; quy tắc in ổn định tách khỏi cách lưu.
2. **Mức 2:** Quét miền nhỏ 0..9 là đủ, hoặc poll heap các mức duy nhất.

## COL-08 — Giải thích độ phức tạp đúng phạm vi

1. **Mức 1:** Thêm/xóa node không bao gồm việc tìm node.
2. **Mức 2:** get(i) phải lần liên kết; for-each tiến từng node.

## COL-09 — Quầy mượn thiết bị

1. **Mức 1:** Tách yêu cầu bất biến khỏi nơi quản lý trạng thái.
2. **Mức 2:** Map tồn + Queue yêu cầu + Set pending + List kết quả là một phương án; validate trước cập nhật.
