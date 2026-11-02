# Merge: kết hợp hai dòng thay đổi

## 1. Problem — tại sao khái niệm tồn tại

Hai người sửa những phần khác nhau rồi muốn tích hợp tính năng vào main mà vẫn giữ lịch sử.

## 2. Mental model

Merge xét common ancestor và hai đầu branch. Fast-forward chỉ tiến ref khi không phân nhánh; khi đã phân nhánh thường tạo merge commit có hai cha.

## 3. Ví dụ nhỏ

Demo tạo branch thêm `search.txt`, main thêm `api.txt`, sau đó merge. Hai thay đổi độc lập cùng xuất hiện.

Đọc [demo](demo/demo.ps1); dự đoán kết quả trước khi thử. Mỗi demo độc lập; dùng thư mục thử riêng.

## 4. Liên hệ kiến thức đã học

Java: compile sau merge để thấy kết hợp có hợp nghĩa không. HTTP: hai branch sửa các endpoint khác nhau vẫn có thể phá contract chung. SQL: merge không phát hiện mọi xung đột logic giữa migration.

## 5. Những lỗi thường gặp

Tưởng merge không conflict nghĩa là code đúng; merge nhầm branch đích; quên đọc diff và chạy kiểm tra sau merge.

## 6. Câu hỏi tự kiểm tra

Branch nào nhận kết quả khi gọi merge? Merge commit có mấy parent? Git có biết logic Java đúng không?

## 7. Exercise

Làm [bài tập](exercise/README.md), ghi bằng chứng vào [notes](notes.md), rồi mới đối chiếu [lời giải tham khảo](solution/README.md).
