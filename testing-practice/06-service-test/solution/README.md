# Đối chiếu sau khi tự làm — Kiểm quy tắc service

ID không hợp lệ ném IllegalArgumentException trước I/O. Dùng verifyNoInteractions trong case đó nếu cần bảo đảm service không truy vấn vô ích.

Kiểm lại dự đoán với demo. Một lời giải đạt yêu cầu phải nêu input cụ thể,
expected độc lập và ranh giới test. Không chỉ viết “test pass”.
