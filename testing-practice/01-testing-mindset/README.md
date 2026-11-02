# Test để bắt sai hành vi

## 1. Problem — vì sao tồn tại
Chạy thủ công một ví dụ đúng không chứng minh các trường hợp khác đều đúng.

## 2. Mental model
Test là một thí nghiệm có input và kỳ vọng độc lập; phải có khả năng thất bại khi hành vi sai.

## 3. Ví dụ nhỏ
0.1 + 0.2 không bằng chính xác 0.3 với double; tiền nên dùng BigDecimal.
Đọc [demo](demo/README.md) để biết file chạy và ranh giới kiểm tra.

## 4. Liên hệ kiến thức đã học
Dùng kiến thức kiểu số Java; lỗi tổng tiền có thể đi qua HTTP thành response sai và lưu sai xuống SQL.

## 5. Những lỗi thường gặp
Chỉ println rồi tự nhìn; dùng cùng một công thức sai để tính cả actual và expected.

## 6. Câu hỏi tự kiểm tra
Test xanh có chứng minh mọi input đúng không? Vì sao cần trường hợp biên?

## 7. Exercise
Viết bảng case giá âm, số lượng 0, số lượng âm và giá hợp lệ. Dự đoán kết quả trước khi viết test.
Làm tại [exercise](exercise/README.md), ghi kết quả vào [notes](notes.md),
sau đó mới mở [solution riêng](solution/README.md).
