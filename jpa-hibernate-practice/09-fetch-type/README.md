# Fetch type và thời điểm đọc dữ liệu

## 1. Problem — vì sao cần khái niệm này?
Đọc product không phải lúc nào cũng cần toàn bộ category/products. Tải quá nhiều làm chậm; tải muộn sai scope gây lỗi.

## 2. Mental model
LAZY trì hoãn tải khi có thể; EAGER yêu cầu dữ liệu sẵn nhưng không bảo đảm một JOIN duy nhất. To-many mặc định LAZY; to-one mặc định EAGER theo JPA. Reference chủ động đặt ManyToOne LAZY.

## 3. Ví dụ nhỏ
list lấy Product, rồi view.getCategoryName cần category trong transaction. list-details dùng fetch join cho use case cần cả hai.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: gọi getter có thể không còn là đọc field đơn giản khi có proxy. JDBC: mỗi query có chi phí mạng; SQL JOIN đọc nhiều bảng; HTTP: DTO cần được tạo trước khi rời persistence context.

## 5. Những lỗi thường gặp
Đổi mọi quan hệ sang EAGER để che lỗi; nghĩ LAZY không bao giờ query; trả entity để serializer âm thầm tải quan hệ; dựa vào Open Session in View.

## 6. Câu hỏi tự kiểm tra
EAGER có đảm bảo một query không? Tại sao fetch plan nên theo use case? LazyInitializationException gợi ý lỗi ranh giới nào?

## 7. Exercise
Đo SQL của list và list-details với ba category khác nhau; dự đoán trước khi chạy. Giải thích vì sao DTO được tạo trong service transaction.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
