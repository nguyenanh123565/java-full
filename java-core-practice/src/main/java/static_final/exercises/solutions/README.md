# Tham khảo: Static và final

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## STF-01 — Hai phòng dùng chung giới hạn

CAPACITY là hằng thuộc lớp; used là field từng object. reserve bảo vệ bất biến 0<=used<=CAPACITY.

**Lỗi thường gặp:** Đặt used static khiến đặt chỗ phòng A làm phòng B đầy theo.

## STF-02 — Final giữ điều gì?

In 5; gán limits=new... không biên dịch; sửa phần tử hợp lệ; maximum+1 hợp lệ. Final không tự sao chép hoặc khóa array.

**Lỗi thường gặp:** Cho rằng mọi thay đổi qua alias sẽ bị compiler chặn vì limits là final.

## STF-03 — Số dư của người này sửa người khác

Dùng private int balance; private static int created. Constructor kiểm tra đầu vào rồi gán field instance và tăng đếm.

**Lỗi thường gặp:** Chuyển mọi field thành instance khiến created không còn tổng chung, hoặc tăng count trước validation.

## STF-04 — Lịch có các hàng độc lập

Dữ liệu là int nên copy từng hàng đủ tách mọi phần mutable của cấu trúc này. Lời giải là một phương án, không áp đặt helper cụ thể.

**Lỗi thường gặp:** Dùng source.clone() rồi tưởng các hàng đã độc lập.

## STF-05 — Hai giỏ hàng và bộ đếm chung

So amount với phần dung lượng còn lại để không overflow int. Counter là trạng thái chung; quantities là từng giỏ. Snapshot copy để bảo vệ đóng gói.

**Lỗi thường gặp:** Kiểm tra current+amount<=99 khi tổng int có thể tràn, hoặc trả array nội bộ từ getter.
