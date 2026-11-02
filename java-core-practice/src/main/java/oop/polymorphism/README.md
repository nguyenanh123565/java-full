# Polymorphism

## Dùng để làm gì?
Đa hình cho phép cùng một hợp đồng xử lý nhiều kiểu object. Caller gọi hành vi chung, mỗi object cung cấp cài đặt riêng.

## Bắt buộc hiểu
- Kiểu khai báo của reference quyết định những member có thể gọi khi biên dịch.
- Kiểu thực tế của object quyết định method instance bị override nào chạy.
- Upcast từ lớp con sang lớp cha không tạo object mới.
- Downcast phải phù hợp kiểu object; cast sai gây `ClassCastException`.
- Cast không thay đổi object. `instanceof` kiểm tra trước khi cần hành vi riêng của lớp con.

## Lỗi thường gặp
- Tưởng `Animal a = new Dog()` tạo object Animal.
- Dùng chuỗi instanceof cho hành vi chung đã có thể được override.
- Ép kiểu để ép object trở thành một class khác.
- Mong gọi method riêng của Dog qua biến Animal mà không xem xét kiểu khai báo.

## Tự kiểm tra
1. Kiểu khai báo và kiểu thực tế khác nhau thế nào?
2. Tại sao a.speak() có thể gọi method Dog khi a khai báo là Animal?
3. Tại sao checkout không cần biết CashPayment hay CardPayment?
4. Khi nào downcast lỗi lúc chạy? instanceof với null trả gì?

## Bài tập từ dễ đến khó
1. Animal[] gồm Dog/Cat, dự đoán âm thanh và giải thích dispatch.
2. Payment với hai cách thanh toán mô phỏng và checkout dùng hợp đồng chung.
3. Dog.fetch(), kiểm tra instanceof và quan sát cast Cat sang Dog bị từ chối.

Đoán output của `PolymorphismDemo.java`; tự làm `PolymorphismExercise.java`; giải mẫu ở `PolymorphismSolution.java`.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
