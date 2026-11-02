# Đối chiếu — Lifecycle: chọn kết quả cần đến

Clean dọn target; compile tạo main classes; test đi qua test-compile/test nhưng demo không có test framework nên không có automated suite; package tạo JAR; install thêm JAR và POM vào local repository sau các phase trước. Install chưa deploy remote. ManualPriceCheck phải gọi java riêng; đó là smoke check thủ công, không được giả làm test đã chạy bởi mvn test.

Dùng output và nội dung artifact làm bằng chứng; không chỉ kết luận BUILD SUCCESS. Mở solution sau khi đã ghi dự đoán và tự thử.
