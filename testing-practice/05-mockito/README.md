# Khi cần mock / stub

## 1. Problem — vì sao tồn tại
Đôi khi cần buộc dependency trả lỗi hoặc xác nhận service đã gọi đúng thao tác; fake tự viết có thể dài.

## 2. Mental model
Mockito mock là đối tượng thay thế. when(...).thenReturn(...) là stubbing; verify(...) kiểm tương tác quan trọng, không thay thế assertion kết quả.

## 3. Ví dụ nhỏ
when(repo.findById(9)).thenReturn(Optional.empty());
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
Mockito vẫn dựa trên interface/object Java. Mock repository không chạy SQL và mock controller dependency không gửi HTTP thật.

## 5. Những lỗi thường gặp
Mock mọi thứ kể cả value object; verify tất cả dòng implementation; stub không khớp argument dẫn đến test sai mục đích.

## 6. Câu hỏi tự kiểm tra
Vì sao mock xanh không chứng minh database hoạt động? Khi nào fake dễ đọc hơn?

## 7. Exercise
TODO ép repo.findById(77) trả empty, kiểm exception và lookup đúng ID; không mock Product.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
