# Gợi ý: Custom exception

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## CE-01 — Ngoại lệ hết chỗ

1. **Mức 1:** Custom exception cần gọi super(message).
2. **Mức 2:** Validate đầu vào trước so yêu cầu với chỗ còn.

## CE-02 — Catch quyết định có tiếp tục

1. **Mức 1:** Kiểm tra trước khi đổi remaining.
2. **Mức 2:** Sau đặt3 còn1; đặt2 thất bại; đặt1 vẫn có thể tiếp tục.

## CE-03 — Trừ trước khi kiểm tra

1. **Mức 1:** Throw không tự rollback phép gán trước đó.
2. **Mức 2:** Chỉ remaining-=requested sau mọi điều kiện.

## CE-04 — Huỷ chỗ không vượt sức chứa

1. **Mức 1:** Số đang được đặt là capacity-available.
2. **Mức 2:** Kiểm tra count <= capacity-available trước cộng.

## CE-05 — Hai khu chỗ phối hợp

1. **Mức 1:** Kiểm tra cả hai khu trước khi thay đổi bất kỳ khu nào.
2. **Mức 2:** Một lớp điều phối có thể validate rồi cập nhật hai số private của nó.
