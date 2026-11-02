# Đối chiếu sau khi tự làm — Transaction, commit và rollback

Demo cố tình lỗi sau hai INSERT nên rollback xóa cả hai thay đổi chưa commit. Kiểm tra id đó bằng query cho count 0. Lần thành công chỉ commit sau cả hai bước; id sequence tăng không vi phạm atomicity.

Hãy dùng dữ liệu khác demo để kiểm tra lại. Một kết quả chạy đúng nhưng không giải thích được luồng vẫn chưa đủ. Đối chiếu với README workspace để giữ đúng phạm vi công nghệ.
