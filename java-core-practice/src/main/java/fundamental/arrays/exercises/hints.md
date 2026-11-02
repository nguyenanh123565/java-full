# Gợi ý: Mảng

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## ARR-01 — Đếm số dương

**Mức 1:** Không cần giá trị khởi đầu từ values[0].

**Mức 2:** Khởi tạo count=0; mỗi phần tử >0 tăng một lần.

## ARR-02 — Copy ngoài và thay một hàng

**Mức 1:** Copy ngoài chứa bản sao các reference hàng.

**Mức 2:** b[0][0] sửa hàng chung; b[1]=... chỉ thay slot trong b.

## ARR-03 — Vòng lặp không xóa mảng

**Mức 1:** Gán lại biến cục bộ không gán lại ô chứa giá trị nguồn.

**Mức 2:** Dùng chỉ số i<values.length rồi gán values[i]=0.

## ARR-04 — Xoay phải một bước

**Mức 1:** Chỉ tính chỉ số cuối khi mảng không rỗng.

**Mức 2:** Tạo result cùng length; nếu length>0 đặt result[0]=values[length-1], rồi copy các phần tử trước đó sang i+1.

## ARR-05 — Báo cáo bán hàng lệch hàng

**Mức 1:** Mỗi hàng tự có length riêng.

**Mức 2:** Tạo long[] theo số hàng, cộng vào totals[row]; grandTotal cộng các tổng long.
