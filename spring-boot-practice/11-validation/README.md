# Validation dữ liệu đầu vào

## 1. Problem — khái niệm này giải quyết việc gì?

Parse được JSON không có nghĩa name không rỗng hay price không âm. Cần phản hồi sớm, nhất quán trước khi dữ liệu không hợp lệ đi vào nghiệp vụ.

## 2. Mental model

`@NotBlank` mô tả chuỗi không null/rỗng/toàn khoảng trắng; `@NotNull` cấm null; `@DecimalMin("0.00")` đặt ngưỡng số; `@Valid` yêu cầu kiểm tra object đã bind. Không Spring/Bean Validation thì tự viết if và thu thập lỗi. Kết nối HTTP: controller nhận JSON, validation thất bại dẫn đến 400; constraint không tạo SQL CHECK.

## 3. Ví dụ nhỏ

```java
record ProductRequest(
    @NotBlank String name,
    @NotNull @DecimalMin("0.00") BigDecimal price) {}
// Controller: create(@Valid @RequestBody ProductRequest request)
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: null, String.isBlank và BigDecimal.compareTo. HTTP: malformed JSON khác semantic validation. SQL: NOT NULL/CHECK vẫn bảo vệ database khi nhiều ứng dụng ghi.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Thêm annotation nhưng quên @Valid; cho rằng @DecimalMin cấm null; dùng @NotBlank cho số; thay business rule bằng mọi annotation có sẵn.

## 6. Câu hỏi tự kiểm tra

Vì sao price cần cả NotNull và DecimalMin? Validation HTTP có thay database constraint không? Giá 0 có được phép theo quy tắc bài này?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
