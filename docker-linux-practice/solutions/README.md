# Định hướng bài tổng hợp

HTTP client trên host dùng host port publish; app container dùng service DNS db và container port 5432. Thay host port không làm đổi JDBC URL. Controller trả JSON count từ JdbcTemplate query; driver chuyển SQL sang PostgreSQL protocol; DB lưu row trên named volume.

Sai host port: thường không nhận HTTP response. Sai route: nhận 404. Sai DB hostname: app có thể fail startup vì SQL init cần DB; đọc log app. Sai table: query SQL fail, thường app log có lỗi relation nếu startup init chưa tạo đúng bảng. Restart không xóa named volume nên row còn; đây chưa phải backup. DB healthy không chứng minh API đã start hay query đúng.

Một bài hoàn thành có sơ đồ, output request/SQL tương ứng, count trước/sau insert/restart và bảng lỗi có bằng chứng. Đừng khai nhận đã chạy Docker khi chỉ mới validate YAML hoặc đọc code.
