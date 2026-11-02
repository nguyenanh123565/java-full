# Gợi ý: Tổng kết nền tảng

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## FUN-01 — Đọc số đếm ASCII bằng tay

**Mức 1:** Kiểm tra độ dài trước khi ghép giá trị.

**Mức 2:** Mỗi bước value=value*10+(c-'0'); loại char ngoài 0..9 trước.

## FUN-02 — Text, data và snapshot qua hàm

**Mức 1:** Phân biệt gán biến với sửa ô của array.

**Mức 2:** name và values là biến tham số riêng; chỉ values[0] sửa object dùng chung.

## FUN-03 — Trung bình bị âm

**Mức 1:** Gán kết quả cuối vào double không đổi các phép tính đã xảy ra.

**Mức 2:** long sum=0; cộng từng int; return (double)sum/values.length.

## FUN-04 — Báo cáo điểm có dữ liệu sai

**Mức 1:** Phân loại hợp lệ trước đạt.

**Mức 2:** Một loop có nhánh sai tăng invalid rồi continue; nhánh đúng cộng total và đếm pass nếu >=50.

## FUN-05 — Phiếu bán hàng bằng mảng song song

**Mức 1:** Kiểm tra hợp đồng rồi mới xây dựng kết quả.

**Mức 2:** Hàm kiểm tra tên dùng trim + charAt; vòng tính tiền dùng 1L*price*quantity; tách dấu phân cách trước các dòng sau dòng đầu.
