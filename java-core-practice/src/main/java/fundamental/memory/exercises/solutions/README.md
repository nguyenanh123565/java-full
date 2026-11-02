# Tham khảo: Bộ nhớ và vòng đời tham chiếu

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## MEM-01 — Qua hai frame

Có một array từ biểu thức new ở outer. inner sửa array thành [4]; trả reference qua outer về main, nên frame kết thúc không làm array biến mất.

**Lỗi thường gặp:** Cho rằng mọi dữ liệu được tạo bởi method đều bị hủy khi return.

## MEM-02 — Đường đi qua mảng ngoài

saved[0]=2. Sau table=null, hàng còn reachable qua saved; sau saved=null không còn đường tới hàng từ các biến trong snippet, không xác nhận GC thực tế.

**Lỗi thường gặp:** Gán row=null rồi cho rằng table[0] cũng thành null.

## MEM-03 — Mọi hàng trở thành hàng cuối

Bản cũ in [[2],[2],[2]] vì ba slot cùng row. Bản sửa mỗi lượt cấp phát hàng mới theo ngữ nghĩa Java.

**Lỗi thường gặp:** Copy array ngoài sau loop, vẫn giữ ba reference chung một hàng.

## MEM-04 — Giữ dữ liệu sau khi bỏ vỏ chứa

Sau bỏ slot, retained vẫn dẫn tới array nên dữ liệu còn dùng được. Từ biến đoạn này không còn đường tới Slot, nhưng không suy ra thời điểm GC.

**Lỗi thường gặp:** Nghĩ field data bị xóa ngay khi biến slot mất reference.

## MEM-05 — Lịch sử phiên bản độc lập

nextVersion dùng copyOf/clone. Bỏ v0,v1 chưa làm các bản cũ mất đường tới vì history giữ chúng. Sau xóa hai slot và giả sử không có alias khác, hai bản cũ có thể thu hồi.

**Lỗi thường gặp:** Trả chính previous rồi sửa tại chỗ làm mọi lịch sử cùng thay đổi.
