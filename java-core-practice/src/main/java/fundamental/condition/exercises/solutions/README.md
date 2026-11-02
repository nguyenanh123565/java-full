# Tham khảo: Rẽ nhánh

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## CON-01 — Phí vào thư viện

Chuỗi if: ngoài miền -> INVALID; age<6 ->0; age<18 ->10000; else ->20000.

**Lỗi thường gặp:** Đặt nhánh age<6 đầu tiên khiến tuổi âm được miễn phí.

## CON-02 — Hai kiểu switch

Bản cũ 1->30,2->20,3/0->99. Bản mũi tên 1->10,2->20,3/0->99.

**Lỗi thường gặp:** Chỉ sửa nội dung case mà không giải quyết fall-through.

## CON-03 — Dấu chấm phẩy phá điều kiện

Dấu ; kết thúc if trước block in. Dùng if(stock<0)...else if(stock==0)...else SELL.

**Lỗi thường gặp:** Thêm else nhưng vẫn giữ ; khiến block phía sau không còn ghép được với if như mong muốn.

## CON-04 — Bộ kiểm tra tam giác

Miền giới hạn khiến mọi tổng hai cạnh an toàn trong int. Loại input sai, sau đó xét đều, cân và thường theo thứ tự.

**Lỗi thường gặp:** Xét cân trước đều nên tam giác đều luôn bị báo cân.

## CON-05 — Tiền điện theo bậc

Ba nhánh <=50, <=100, >100; dùng long từ phép nhân. 1_000_000 kWh -> 2_499_935_000 đồng.

**Lỗi thường gặp:** Lấy toàn bộ kWh nhân giá bậc cao nhất hoặc để phép nhân int tràn trước gán long.
