# JUnit và Arrange / Act / Assert

## 1. Problem — vì sao tồn tại
Tự gọi main không tổ chức và báo kết quả hàng chục kiểm tra một cách nhất quán.

## 2. Mental model
JUnit engine phát hiện @Test, tạo instance và chạy; assertion quyết định pass/fail. @Test là metadata cho runner, không phải luồng HTTP.

## 3. Ví dụ nhỏ
Arrange tạo repository giả nhỏ; Act gọi service; Assert so tên product.
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
Method và exception Java vẫn là cơ chế thực thi. Maven test gọi test runner; chưa cần HTTP hay DB để kiểm logic Java.

## 5. Những lỗi thường gặp
Nhầm import org.junit.Test cũ với org.junit.jupiter.api.Test; tên class không khớp *Test; test phụ thuộc thứ tự.

## 6. Câu hỏi tự kiểm tra
Ai gọi method @Test? Nếu xóa assertion thì test còn chứng minh điều gì?

## 7. Exercise
Tự tạo DiscountTest với ít nhất hai @Test và ba khối AAA. TODO chọn expected trước khi gọi method.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
