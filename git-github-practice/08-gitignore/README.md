# .gitignore: bỏ qua file sinh ra và cấu hình riêng

## 1. Problem — tại sao khái niệm tồn tại

Build tạo .class/JAR/log; máy mỗi người có cấu hình riêng. Commit chúng làm diff nhiễu hoặc lộ dữ liệu.

## 2. Mental model

`.gitignore` đặt quy tắc chọn file untracked cần bỏ qua. File đã tracked vẫn tracked dù vừa thêm pattern. Ignore không xóa dữ liệu và không thu hồi bí mật đã commit.

## 3. Ví dụ nhỏ

Demo ignore `target/` và `.env`, dùng `git check-ignore -v` xem pattern. Một file đã tracked vẫn hiện modified sau khi thêm nó vào ignore.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: `.class` có thể build lại từ source. HTTP: token test thật không đặt trong repo. SQL: dùng placeholder cho DB password, không ignore migration SQL cần chia sẻ.

## 5. Những lỗi thường gặp

Ignore pom.xml/source; tưởng ignore xóa lịch sử bí mật; pattern quá rộng; commit .env rồi mới ignore và nghĩ đã an toàn.

## 6. Câu hỏi tự kiểm tra

Vì sao target có thể bỏ qua còn migration nên commit? File tracked có chịu quy tắc ignore không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
