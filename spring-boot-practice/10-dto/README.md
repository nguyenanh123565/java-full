# DTO định hình dữ liệu qua biên HTTP

## 1. Problem — khái niệm này giải quyết việc gì?

Client không nên gửi id do server cấp hoặc nhận những field nội bộ. Dùng cùng object cho mọi mục đích làm hợp đồng API phụ thuộc cách lưu.

## 2. Mental model

DTO là Java object mang dữ liệu qua một biên. ProductRequest chỉ chứa name/price; ProductResponse thêm id. Record Java 17 phù hợp cho dữ liệu nhỏ bất biến. Jackson chuyển JSON qua getter/record component; `@RequestBody` nối HTTP body vào DTO, không biến nó thành entity/table.

## 3. Ví dụ nhỏ

```java
record ProductRequest(String name, BigDecimal price) {}
record ProductResponse(long id, String name, BigDecimal price) {}
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: record, BigDecimal, mapping object. HTTP: request/response schema. SQL: cột database có thể nhiều hơn field công khai; DTO không phải bảng.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Để client quyết định id; dùng double cho tiền; thêm Lombok dù record đủ; cho rằng DTO tự validate hoặc persist.

## 6. Câu hỏi tự kiểm tra

Vì sao request không chứa id? DTO và row có bắt buộc trùng field không? Ai chịu trách nhiệm mapping?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
