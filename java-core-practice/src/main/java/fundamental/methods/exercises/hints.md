# Gợi ý: Phương thức

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## MET-01 — Giới hạn giá trị vào khoảng

**Mức 1:** Chỉ ba vùng: dưới, trong, trên.

**Mức 2:** Hai if trả sớm xử lý ngoài khoảng; cuối hàm return value.

## MET-02 — Đối số được tính trước lời gọi

**Mức 1:** Toán hạng của n++ là giá trị cũ; phần tăng vẫn xảy ra trước khi vào add.

**Mức 2:** Với n=3, add nhận (3,3), caller n đã thành 4.

## MET-03 — Return còn thiếu

**Mức 1:** Nhánh if không bao phủ mọi input.

**Mức 2:** Sau if return -value, thêm return value.

## MET-04 — Đếm bội số trong đoạn

**Mức 1:** Một số âm chia hết khi phần dư bằng 0 như số dương.

**Mức 2:** Bắt đầu count=0; duyệt i từ from tới to và tăng khi i%divisor==0.

## MET-05 — Báo giá qua các hàm nhỏ

**Mức 1:** Hai dòng có cùng quy tắc nên tái sử dụng hàm, không chép công thức.

**Mức 2:** discounted trả subtotal-subtotal*percent/100; subtotal nhân bằng long trước.
