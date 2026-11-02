# Composition

## Dùng để làm gì?
Kết hợp object theo quan hệ has-a để tái sử dụng hành vi bằng cách ủy quyền, như Car sử dụng Engine hoặc NotificationService sử dụng MessageSender.

## Bắt buộc hiểu
- Has-a khác is-a; không cần extends chỉ để gọi method của object khác.
- Owner giữ reference tới collaborator và gọi hành vi của nó.
- Có thể tự tạo thành phần hoặc nhận qua constructor; nhận interface giúp thay cài đặt dễ hơn.
- Quyền sở hữu và chia sẻ cần rõ ràng. Theo UML chặt chẽ, Student được chia sẻ bên ngoài Classroom là aggregation, không phải composition độc quyền.
- Sao chép collection là shallow copy: cấu trúc độc lập, object phần tử có thể vẫn được chia sẻ.
- `final` cấm gán lại field reference, không làm collaborator immutable.

## Lỗi thường gặp
- Cho Car extends Engine dù Car không phải một Engine.
- Tưởng field final khiến object bên trong bất biến.
- Tưởng getter trả List mới thì mọi Student cũng đã được sao chép.
- Không quyết định object nào có quyền thay đổi thành phần được chia sẻ.

## Tự kiểm tra
1. Car.drive ủy quyền cho Engine như thế nào?
2. Lợi ích của nhận MessageSender qua constructor là gì?
3. clear bản sao List có xóa phần tử trong List nội bộ không? Vì sao?
4. Sửa Student trong bản sao List có thể ảnh hưởng Classroom không? Vì sao?

## Bài tập từ dễ đến khó
1. Car sở hữu Engine riêng và ủy quyền khởi động; đếm object và giải thích has-a.
2. NotificationService nhận MessageSender; thay hai cài đặt mà không sửa service.
3. Classroom trả bản sao List<Student>; phân biệt bảo vệ cấu trúc và chia sẻ phần tử.

Đoán `CompositionDemo.java`; làm `CompositionExercise.java`; chỉ mở `CompositionSolution.java` để đối chiếu khi cần.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
