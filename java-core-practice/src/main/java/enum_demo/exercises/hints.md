# Gợi ý: Enum có dữ liệu và hành vi

Chỉ mở đúng mã bài đang bí. Thử mức 1, quay lại tự làm; chỉ mở mức 2 nếu vẫn chưa tiến triển. Đây là hướng suy nghĩ, không cần chọn cùng thiết kế với lời giải.

## ENUM-01

**Mức 1 — khái niệm:** Hướng đối diện là quan hệ nghiệp vụ rõ ràng.

**Mức 2 — hướng triển khai:** switch cần có nhánh cho từng hằng; null là trường hợp riêng.

## ENUM-02

**Mức 1 — khái niệm:** ordinal đếm vị trí bắt đầu từ 0.

**Mức 2 — hướng triển khai:** Dữ liệu truyền constructor không tự đổi khi di chuyển hằng.

## ENUM-03

**Mức 1 — khái niệm:** Code nghiệp vụ và name là hai thuộc tính khác nhau.

**Mức 2 — hướng triển khai:** Duyệt values, so equalsIgnoreCase với code đã trim.

## ENUM-04

**Mức 1 — khái niệm:** Vẽ bảng chuyển 4x4 trước.

**Mức 2 — hướng triển khai:** Object nhờ enum quyết định, chỉ đổi state khi kết quả true.

## ENUM-05

**Mức 1 — khái niệm:** Enum mô tả tập giá trị, object giữ trạng thái của một phiếu.

**Mức 2 — hướng triển khai:** Index output phải được xác định bởi hợp đồng thống kê.
