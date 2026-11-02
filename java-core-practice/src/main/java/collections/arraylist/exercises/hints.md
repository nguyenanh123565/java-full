# Gợi ý: ArrayList

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## AL-01 — Lọc điểm hợp lệ

1. **Mức 1:** Xác định điều kiện giữ một phần tử.
2. **Mức 2:** Duyệt nguồn một lần và chỉ add vào kết quả.

## AL-02 — Bản sao nông với object

1. **Mức 1:** Constructor ArrayList sao chép reference tới phần tử.
2. **Mức 2:** b.add thay cấu trúc b; b.get(0).value thay object chung.

## AL-03 — Xóa liên tiếp bị bỏ sót

1. **Mức 1:** Sau remove(i), phần tử kế tiếp chuyển về i.
2. **Mức 2:** Có thể duyệt index từ cuối về đầu.

## AL-04 — Phân trang danh sách

1. **Mức 1:** Số phần tử lấy không vượt size-offset.
2. **Mức 2:** Dùng min(limit,size-offset), tránh cộng hai số lớn trước.

## AL-05 — Sổ điểm và báo cáo độc lập

1. **Mức 1:** Getter trả list nội bộ sẽ tạo alias.
2. **Mức 2:** ArrayList<Integer> mới đủ cho snapshot vì Integer bất biến.
