# Đối chiếu sau khi tự làm — Vòng đời tài nguyên JDBC

Thoát scope vẫn gọi close; nếu close cũng lỗi, lỗi phụ có thể nằm trong suppressed exceptions. Caller chỉ nhận object đã materialize. Trong pool, close thường trả handle về pool; hiện tại DriverManager mở kết nối thật, chưa dùng pool.

Hãy dùng dữ liệu khác demo để kiểm tra lại. Một kết quả chạy đúng nhưng không giải thích được luồng vẫn chưa đủ. Đối chiếu với README workspace để giữ đúng phạm vi công nghệ.
