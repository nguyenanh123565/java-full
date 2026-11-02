# Bài tổng hợp — đóng gói Product CLI nhỏ

- TODO: Trong bản copy riêng của demo, đổi label resource, thêm một hàm giảm giá bằng Java chuẩn, giữ release17.
- TODO: **Dự đoán trước khi chạy:** lập bảng output của compile/test/package/install và nội dung JAR. Đánh dấu command nào gọi main.
- TODO: Viết tọa độ artifact đầy đủ; thay version để nhìn thay đổi tên JAR.
- TODO: **Vì sao:** package không tự clean, không tự start API và không đưa artifact vào local repo?
- TODO: **Liên hệ kiến thức cũ:** nếu chuyển CLI thành JDBC app, thành phần nào sẽ cần driver; nếu thành HTTP server, bước nào mới mở port?
- TODO: Kiểm tra cả input hợp lệ và quantity không hợp lệ bằng smoke check; không tuyên bố mvn test đã chạy chúng nếu chưa có test framework.
- TODO: Ghi bằng chứng source/resource/test class ở đúng vị trí; dùng jar tf kiểm tra test không bị đóng vào JAR app.

Tự chấm: giải thích được vai trò từng file và kết quả từng command. Định hướng [solution riêng](../solutions/README.md).
