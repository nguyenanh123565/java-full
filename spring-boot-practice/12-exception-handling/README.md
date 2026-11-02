# Dịch exception thành HTTP response

## 1. Problem — khái niệm này giải quyết việc gì?

Nếu exception thoát tự do, client nhận lỗi không phù hợp hoặc chi tiết nội bộ. Các controller lặp try/catch cũng làm phản hồi lệch nhau.

## 2. Mental model

`@RestControllerAdvice` đăng ký nơi xử lý lỗi dùng chung và ghi body; `@ExceptionHandler` chọn loại exception để xử lý. Java thủ công phải catch ở biên server rồi đặt status/body. HTTP: lỗi nghiệp vụ not found → 404; request không hợp lệ → 400; lỗi bất ngờ không nên bị giả thành 400.

## 3. Ví dụ nhỏ

```java
@ExceptionHandler(ProductNotFound.class)
ResponseEntity<Map<String, String>> missing(ProductNotFound error) {
    return ResponseEntity.status(404).body(Map.of("error", error.getMessage()));
}
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: checked/unchecked exception, try/catch. HTTP: status phân loại lỗi. SQL: lỗi kết nối DB không phải người dùng nhập sai id; không nuốt thành success.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Catch Exception rồi trả 200; lộ stack trace/SQL; trả mọi lỗi 400; nghĩ advice bắt mọi lỗi security filter trước MVC.

## 6. Câu hỏi tự kiểm tra

Vì sao service không trả status trực tiếp? Advice có xử lý filter authentication failure trước controller không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
