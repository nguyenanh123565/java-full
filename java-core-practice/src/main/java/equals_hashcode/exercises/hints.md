# Gợi ý: Equals và hashCode

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## EQ-01 — Tọa độ theo giá trị

1. **Mức 1:** So từng field sau kiểm tra loại.
2. **Mức 2:** Hash kết hợp hai field; overflow trong tính hash được phép.

## EQ-02 — Bộ ba hợp đồng

1. **Mức 1:** Hợp đồng chỉ bắt buộc một chiều.
2. **Mức 2:** Hash khác chứng minh không equals theo hợp đồng; hash giống chưa kết luận.

## EQ-03 — Overload bị tưởng là override

1. **Mức 1:** Object khai báo equals nhận Object.
2. **Mức 2:** equals(BadKey) tạo overload mới; sửa tham số Object rồi kiểm tra kiểu.

## EQ-04 — Định danh ấn bản sách

1. **Mức 1:** Xác định dữ liệu nhận diện trước viết equals.
2. **Mức 2:** So String bằng equals, kết hợp hash của ISBN và edition.

## EQ-05 — Đếm giá trị duy nhất không dùng Set

1. **Mức 1:** Mỗi phần tử chỉ mới khi chưa bằng phần tử nào trước đó.
2. **Mức 2:** So null an toàn: a==b hoặc a!=null && a.equals(b).
