# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## BANK-01 — Bảo toàn số dư

A=100,B=40 chuyển 30 → A=70,B=70; tổng 140 giữ nguyên. Số dư không âm, số tiền phải dương. Tổng báo cáo phải kiểm overflow, không dùng double.

## BANK-02 — Bản sao danh bạ tài khoản

Map copy chia sẻ Account nên sửa balance qua một reference xuất hiện ở mọi nơi cùng giữ object. Trả số dư long hoặc snapshot bất biến giúp caller không sửa tài khoản.

## BANK-03 — Chuyển tiền mất nửa giao dịch

Trừ A trước cộng B có thể làm mất tiền nếu B không tồn tại/overflow. Kiểm cả hai, khác tài khoản, amount>0, đủ tiền và receiver+amount không tràn trước khi đổi số dư.

## BANK-04 — Gửi lại lệnh không chuyển hai lần

Giữ Map mã giao dịch → dữ liệu lệnh đã hoàn tất. Cùng mã/cùng nội dung trả false trước khi kiểm đủ tiền lần nữa; cùng mã/khác nội dung bị từ chối. Không ghi nhận lệnh thất bại. Đây là mô phỏng một luồng trong bộ nhớ.

## BANK-05 — Snapshot sổ dư

Snapshot Map<String,Long> mới theo thứ tự đăng ký giúp không lộ Account. Caller sửa snapshot không sửa bank; snapshot cũ không đổi sau transfer.

## BANK-06 — Nhập lệnh sai và gửi lại

ParseLong và xử lý lỗi ở console. TRANSFER lỗi trả ERR, lần BALANCES sau vẫn chạy. Mã lặp chính xác trả DUPLICATE; EXIT trả BYE; không âm thầm nạp/rút lại.

## BANK-07 — Quầy chuyển tiền có đối soát

Main tham khảo kiểm kịch bản thành công, lặp lệnh, xung đột mã, thiếu tiền, tài khoản sai, tự chuyển và overflow. Thêm kênh giao diện không cần sửa invariant trong service. Không yêu cầu thread/transaction database.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
