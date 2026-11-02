# Gợi ý: Generics

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## GEN-01 — Cặp hai kiểu độc lập

1. **Mức 1:** Mỗi tham số kiểu là một vị trí độc lập.
2. **Mức 2:** Field private final L và R, getter trả đúng kiểu.

## GEN-02 — Invariance qua biến cha

1. **Mức 1:** Quan hệ kế thừa của T không chuyển sang Slot<T>.
2. **Mức 2:** Wildcard extends cho phép xem giá trị như Number.

## GEN-03 — Raw type phá hàng rào kiểu

1. **Mức 1:** Raw type bỏ thông tin T ở thao tác set.
2. **Mức 2:** Slot<String> raw được thay bằng biến có kiểu String nhất quán.

## GEN-04 — Tổng bình phương các Number

1. **Mức 1:** Number cung cấp doubleValue.
2. **Mức 2:** Bound giúp compiler biết có method đó; null validate riêng.

## GEN-05 — Kết quả thành công hoặc thất bại

1. **Mức 1:** Constructor private giúp giới hạn trạng thái hợp lệ.
2. **Mức 2:** Static method không dùng T của một instance, cần <T> trên method.
