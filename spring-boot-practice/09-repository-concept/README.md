# Repository là ranh giới lưu trữ

## 1. Problem — khái niệm này giải quyết việc gì?

Map và PostgreSQL có cách đọc/ghi khác nhau nhưng service cần các thao tác sản phẩm giống nhau. Trộn cách lưu vào service khiến thay storage làm thay cả nghiệp vụ.

## 2. Mental model

Repository là interface về nhu cầu lưu trữ, implementation memory dùng Map. `@Repository` đánh dấu bean thuộc tầng dữ liệu và có khả năng tham gia dịch exception khi có hạ tầng thích hợp; không tự tạo table hay SQL. Java thuần truyền implementation vào constructor. Với HTTP, repository nằm sau service và không biết URI/status.

## 3. Ví dụ nhỏ

```java
interface ProductRepository {
    Optional<Product> find(long id);
    List<Product> findAll();
    Product create(String name, BigDecimal price);
}
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: interface, Optional, Map, AtomicLong. HTTP: GET /products/10 gọi find(10). SQL: về sau implementation viết SELECT WHERE id = ?, không thay hợp đồng HTTP.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Gọi memory Map là database bền vững; để controller đọc Map; trả Map mutable trực tiếp; nghĩ @Repository là Spring Data JPA.

## 6. Câu hỏi tự kiểm tra

Tắt app rồi bật lại thì dữ liệu memory ra sao? Có thể dùng JDBC sau interface này không? AtomicLong giải quyết việc gì?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
