# Gợi ý: HashSet

Mở mức 1 trước, thử lại rồi mới xem mức 2. Ghi điều đã thử vào ghi chú của bạn.

## HS-01 — Giao hai nhóm

1. **Mức 1:** Xét từng phần tử ở tập thứ nhất.
2. **Mức 2:** Chỉ add khi tập thứ hai contains.

## HS-02 — Cùng hash vẫn khác

1. **Mức 1:** Hash khoanh vùng ứng viên, equals phân biệt ứng viên.
2. **Mức 2:** A và B không equals dù hash giống nhau.

## HS-03 — Kiểm tra đã tham gia sai

1. **Mức 1:** add trả boolean có ý nghĩa.
2. **Mức 2:** Chỉ tăng accepted khi set.add trả true sau validation.

## HS-04 — Thiếu ai trong buổi học?

1. **Mức 1:** Chỉ xét người đã đăng ký.
2. **Mức 2:** Có thể sao chép registered rồi removeAll(present).

## HS-05 — Điểm danh nhiều buổi

1. **Mức 1:** Một cấu trúc kiểm tra tồn tại, một cấu trúc lưu thứ tự.
2. **Mức 2:** Set.add quyết định khi nào thêm vào list; trả copy list.
