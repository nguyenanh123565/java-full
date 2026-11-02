# Đối chiếu sau khi tự làm — ResultSet và ánh xạ object

0 hàng tạo List rỗng; không phải một Product có mọi field null. ResultSet gắn với tài nguyên JDBC nên DAO nên trả object/value. Với getInt trên SQL NULL, đọc wasNull() ngay sau getter để phân biệt 0 thật.

Hãy dùng dữ liệu khác demo để kiểm tra lại. Một kết quả chạy đúng nhưng không giải thích được luồng vẫn chưa đủ. Đối chiếu với README workspace để giữ đúng phạm vi công nghệ.
