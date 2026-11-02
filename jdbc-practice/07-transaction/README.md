# Transaction, commit và rollback

## 1. Problem — vì sao cần khái niệm này?
Một thao tác nghiệp vụ có thể cần nhiều câu SQL. Nếu bước sau lỗi mà bước trước đã lưu, dữ liệu có thể lệch nhau.

## 2. Mental model
Một Connection với autoCommit=false gom câu lệnh vào transaction. commit xác nhận toàn bộ; rollback hủy thay đổi chưa commit. Phải dùng cùng Connection cho các bước thuộc cùng transaction.

## 3. Ví dụ nhỏ
Thêm product, ghi stock movement rồi chủ động báo lỗi → rollback → product vừa thêm không tồn tại. Sequence id có thể vẫn tăng dù rollback.

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: try/catch và exception quyết định đường thoát. SQL: atomicity và constraint. HTTP: một request tạo đơn cần một transaction nghiệp vụ, không phải commit từng repository call.

## 5. Những lỗi thường gặp
Bắt SQLException rồi vẫn commit; mỗi DAO mở một Connection khác; quên rollback; nhầm rollback sẽ hoàn lại số sequence đã cấp.

## 6. Câu hỏi tự kiểm tra
Nếu gọi commit rồi mới có lỗi gửi response thì rollback có đảo commit không? Vì sao hai Connection không tự chia sẻ transaction?

## 7. Exercise
Mô phỏng hai lần ghi: chạy một lần cố ý lỗi và một lần thành công. Chứng minh bằng SELECT sau mỗi lần. Vẽ vị trí commit/rollback.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
