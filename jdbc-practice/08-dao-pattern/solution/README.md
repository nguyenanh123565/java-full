# Đối chiếu sau khi tự làm — DAO pattern cơ bản

Demo DAO nhận Connection do caller quản lý để caller quyết định transaction và đóng tài nguyên. DAO chỉ đóng PreparedStatement/ResultSet. Với CLI tham khảo, mỗi thao tác độc lập sở hữu một kết nối; nghiệp vụ nhiều bước cần thiết kế chung transaction.

Hãy dùng dữ liệu khác demo để kiểm tra lại. Một kết quả chạy đúng nhưng không giải thích được luồng vẫn chưa đủ. Đối chiếu với README workspace để giữ đúng phạm vi công nghệ.
