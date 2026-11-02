# Unit test và fake viết tay

## 1. Problem — vì sao tồn tại
Nếu mỗi test service đều kết nối DB thì khó cô lập lỗi logic và môi trường.

## 2. Mental model
Unit test kiểm một đơn vị hành vi; fake là implementation nhỏ có trạng thái; stub cung cấp câu trả lời cố định.

## 3. Ví dụ nhỏ
ProductRepository repo = id -> Optional.of(new Product(id, "Book", 3));
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
Interface Java là điểm thay thế dependency. HTTP và PostgreSQL nằm ngoài unit này nên không được unit test bảo đảm.

## 5. Những lỗi thường gặp
Gọi test là unit nhưng khởi động Spring/DB; nhầm fake trong bộ nhớ với PostgreSQL thật.

## 6. Câu hỏi tự kiểm tra
Một fake có kiểm được SQL syntax và constraint không? Vì sao?

## 7. Exercise
TODO viết fake Map chứa hai product, test case tìm thấy và thiếu ID; dự đoán khi dùng chung Map giữa test.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
