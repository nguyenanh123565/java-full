# Đối chiếu sau khi tự làm — PreparedStatement và SQL parameter

Bind toàn bộ tên vào một parameter nên tên có dấu nháy vẫn là dữ liệu. SQL injection qua giá trị này bị chặn; business validation và phân quyền vẫn phải làm riêng. Identifier động cần whitelist, không bind bằng ?.

Hãy dùng dữ liệu khác demo để kiểm tra lại. Một kết quả chạy đúng nhưng không giải thích được luồng vẫn chưa đủ. Đối chiếu với README workspace để giữ đúng phạm vi công nghệ.
