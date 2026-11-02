# Gợi ý: LinkedList

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## LL-01 — Xoay danh sách một lần

1. **Mức 1:** Tách phần tử đầu rồi thêm cuối.
2. **Mức 2:** Kiểm tra isEmpty trước pollFirst để không thêm tín hiệu null.

## LL-02 — Null có nghĩa là rỗng?

1. **Mức 1:** LinkedList cho phép chứa một phần tử null.
2. **Mức 2:** Kết hợp isEmpty/size, hoặc cấm null ở biên nghiệp vụ.

## LL-03 — Vòng quay không kết thúc

1. **Mức 1:** poll rồi add khiến size không giảm.
2. **Mức 2:** Lưu số người lúc bắt đầu và đếm số lượt.

## LL-04 — Bộ đệm ba thông báo

1. **Mức 1:** Khi vượt sức chứa, phần tử nào cũ nhất?
2. **Mức 2:** Thêm cuối, nếu vượt thì bỏ đầu; snapshot bằng constructor.

## LL-05 — Chia lượt trực tuần

1. **Mức 1:** Sao chép nguồn trước khi dùng làm trạng thái.
2. **Mức 2:** Mỗi next chỉ cần thao tác đầu và cuối.
