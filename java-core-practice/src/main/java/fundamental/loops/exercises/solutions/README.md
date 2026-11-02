# Tham khảo: Vòng lặp

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## LOP-01 — Giai thừa có giới hạn

Giữ result=1 trước loop; mỗi lượt result chứa tích từ 1 tới factor. 20! vẫn trong long; 21! vượt long.

**Lỗi thường gặp:** Khởi tạo result=0 khiến mọi kết quả bằng 0.

## LOP-02 — Đọc vòng lọc có dừng sớm

In 1,2,4,5; sum=12. Với i>0 dừng ngay tại 1, tổng 0.

**Lỗi thường gặp:** Tưởng continue bỏ luôn bước i++ nên kết luận vòng bị lặp vô hạn.

## LOP-03 — While đứng yên ở số chẵn

while(i>0){if(i%2!=0)sum+=i; i--;} bảo đảm i giảm đúng một lần mỗi lượt.

**Lỗi thường gặp:** Chỉ giảm i trong nhánh lẻ, để nhánh chẵn vẫn không tiến triển.

## LOP-04 — Số chữ số không cần String

copy=number; digits=0; do{digits++;copy/=10;}while(copy>0); luôn ít nhất một chữ số.

**Lỗi thường gặp:** Dùng while(copy>0) nhưng để kết quả của number=0 bằng 0.

## LOP-05 — Ngày đạt mục tiêu tiết kiệm

Khởi tạo days=0,total=0; while(total<target){days++;total+=days*1000L;}. Target tối đa đạt ở ngày 1414, tổng 1_000_405_000.

**Lỗi thường gặp:** Dùng <= khiến target=0 hoặc tổng đúng mốc vẫn gửi thêm.
