# Statement và SQL cố định

## 1. Problem — vì sao cần khái niệm này?
Để thấy rõ ranh giới giữa Java và SQL, bắt đầu bằng một câu SQL cố định. Sau đó mới thấy nguy hiểm khi trộn dữ liệu do người dùng nhập vào cấu trúc SQL.

## 2. Mental model
Statement gửi chuỗi SQL hoàn chỉnh tới database. Chuỗi Java không tự hiểu đâu là giá trị người dùng, đâu là từ khóa SQL.

## 3. Ví dụ nhỏ
`statement.executeQuery("SELECT current_database() AS db")` phù hợp để quan sát query cố định không có input.

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: nối String chỉ ghép ký tự. SQL: dấu nháy, OR và comment có nghĩa riêng. HTTP: query parameter từ client là dữ liệu chưa đáng tin.

## 5. Những lỗi thường gặp
Nối input vào WHERE; dùng executeQuery cho INSERT không RETURNING; nghĩ kiểm tra trên giao diện là đủ bảo vệ backend.

## 6. Câu hỏi tự kiểm tra
Vì sao dấu nháy trong tên người dùng có thể phá SQL nối chuỗi? Statement có luôn sai nếu SQL hoàn toàn cố định không?

## 7. Exercise
Thêm một SELECT cố định để quan sát server version; viết ra giấy vì sao không dùng nối chuỗi cho bộ lọc tên. Không chạy chuỗi tấn công trên database cũ.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
