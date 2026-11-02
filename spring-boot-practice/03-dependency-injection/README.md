# Dependency Injection bằng constructor

## 1. Problem — khái niệm này giải quyết việc gì?

Controller tự `new ProductService()` sẽ quyết định luôn cách tạo service và repository. Điều này làm thay implementation khó và khiến kiểm thử phụ thuộc vào lắp ráp ẩn bên trong.

## 2. Mental model

Dependency là object cần để làm việc; injection là đưa object đó vào từ ngoài. `@Component` đánh dấu một class để container quản lý, thay cho code tự tạo/giữ object. `@Service` là component mô tả vai trò nghiệp vụ. Không annotation nào tự ánh xạ HTTP. Với một constructor, Spring tự dùng constructor đó; không cần `@Autowired`.

## 3. Ví dụ nhỏ

```java
class ProductController {
    private final ProductService service;
    ProductController(ProductService service) { this.service = service; }
}
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: constructor, interface và final field. HTTP: request được controller chuyển sang service đã được inject. SQL: có thể thay memory repository bằng JDBC implementation sau này mà giữ controller.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Field injection che phụ thuộc; tạo service bằng new trong controller; nghĩ DI chỉ tồn tại khi có framework; đăng ký hai implementation mà không có cách chọn.

## 6. Câu hỏi tự kiểm tra

Có thể dùng constructor injection trong Java thuần không? Ai chịu trách nhiệm new object khi không dùng Spring?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
