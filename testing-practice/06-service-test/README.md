# Kiểm quy tắc service

## 1. Problem — vì sao tồn tại
Controller và repository có thể đúng riêng lẻ nhưng quyết định nghiệp vụ ở service vẫn sai.

## 2. Mental model
Service nhận giá trị Java, áp dụng quy tắc rồi gọi dependency; test đầu vào/đầu ra trước khi kiểm các tương tác.

## 3. Ví dụ nhỏ
ID <= 0 bị từ chối trước khi gọi repository; ID hợp lệ thiếu dữ liệu là ProductNotFoundException.
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
Validation HTTP có thể trả 400, nhưng service còn được CLI gọi. Constraint SQL là lớp bảo vệ dữ liệu cuối cùng.

## 5. Những lỗi thường gặp
Chỉ test happy path; nhét HTTP status vào mọi method service; để DB thực hiện mọi validation.

## 6. Câu hỏi tự kiểm tra
Vì sao cần phân biệt input sai với product không tồn tại? Repository có nên được gọi khi ID âm?

## 7. Exercise
TODO test id=0, id âm, id hợp lệ thiếu dữ liệu; dự đoán số lần repo được gọi và giải thích.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
