# Constructor

## Dùng để làm gì?
Constructor khởi tạo trạng thái object ngay khi `new`, giúp object bắt đầu với dữ liệu hợp lệ.

## Bắt buộc hiểu
- Constructor có tên giống class và không có kiểu trả về, kể cả `void`.
- Trong Java 17, `this(...)` hoặc `super(...)` phải là câu lệnh đầu tiên của constructor; mỗi constructor chỉ gọi trực tiếp một trong hai.
- Compiler chỉ sinh constructor không tham số mặc định khi class không khai báo constructor nào.
- Constructor không được kế thừa; constructor chaining không tạo thêm object.
- Copy constructor phải tự viết và phải cân nhắc các field reference mutable.

## Lỗi thường gặp
- Viết `void Book()` rồi tưởng đó là constructor.
- Gọi `new Book()` dù chỉ khai báo `Book(String title)`.
- Lặp kiểm tra dữ liệu ở nhiều constructor hoặc nghĩ copy constructor tự deep copy.

## Tự kiểm tra
1. Constructor khác method ở đâu?
2. Khi nào compiler tạo constructor mặc định?
3. `this(...)` có tạo object thứ hai không? Vì sao?
4. Copy constructor với field List cần xử lý vấn đề gì?

## Bài tập từ dễ đến khó
1. Book có constructor không tham số và có tham số; giải thích cách khởi tạo title.
2. Product có hai constructor dùng chaining, từ chối giá âm; giải thích nơi đặt validation.
3. Viết copy constructor Student, sửa bản sao và phân biệt nó với phép gán reference.

Đọc `ConstructorDemo.java`, đoán thứ tự chạy. Làm TODO trong `ConstructorExercise.java`; lời giải nằm riêng ở `ConstructorSolution.java`.


## Bộ bài tập tự làm bổ sung

Sau README → tutorial/Demo → ví dụ, làm [bộ bài tập có thứ tự và cách chạy](exercises/README.md), tự [review](exercises/review.md), rồi ghi chú. Gợi ý và lời giải nằm riêng trong bộ bài. Các bài/code/ghi chú hiện có được giữ nguyên.
