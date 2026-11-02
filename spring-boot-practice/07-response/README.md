# Status, header và response body

## 1. Problem — khái niệm này giải quyết việc gì?

Client cần biết request thành công, tạo mới, không tìm thấy hay lỗi dữ liệu. Trả mọi kết quả với 200 làm hợp đồng API mơ hồ.

## 2. Mental model

`ResponseEntity<T>` là object Java gói status, header, body; không phải annotation. MVC ghi nó thành HTTP response. Java thủ công phải đặt status/header và ghi body lên socket/HTTP exchange. Dữ liệu trả ra là hợp đồng cho client, không cần giống hệt cấu trúc lưu trong memory.

## 3. Ví dụ nhỏ

```java
return ResponseEntity.created(URI.create("/products/" + result.id())).body(result);
// 201 + Location + JSON
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: generic T và object value. HTTP: 200, 201, 204, 400, 404. SQL: INSERT thành công có thể tạo id nhưng repository không nên quyết định HTTP status.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Trả body cùng 204; trả stack trace; 200 cho missing resource; luôn dùng 201 cho update.

## 6. Câu hỏi tự kiểm tra

Vì sao 201 nên có Location? Service có nên trả ResponseEntity không? 204 có body không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
