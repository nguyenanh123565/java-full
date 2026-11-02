# Ánh xạ method và URI

## 1. Problem — khái niệm này giải quyết việc gì?

Cùng `/products` nhưng đọc danh sách và tạo sản phẩm là hai ý định HTTP khác nhau. Server cần phân biệt method lẫn path.

## 2. Mental model

`@RequestMapping("/products")` nhóm path chung. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` gắn một method Java với cặp HTTP method+path. Nếu làm Java thuần, handler phải tự so method/path và gọi đúng hàm. Mapping không tự cài CRUD hoặc SQL.

## 3. Ví dụ nhỏ

```text
GET /products/10
→ @GetMapping("/{id}") trong @RequestMapping("/products")
→ controller.find(10) → service.find(10)
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: dispatch tới method. HTTP: safe/idempotent, 404 so với 405. SQL: SELECT/INSERT/UPDATE/DELETE là cách lưu trữ, không phải Spring tự suy ra từ tên route.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Dùng GET để xóa; hai handler trùng method/path; nhầm tên Java method với URI; coi PUT thiếu resource luôn phải tạo mới.

## 6. Câu hỏi tự kiểm tra

Vì sao GET và POST cùng path không xung đột? Khi nào 405 khác 404? DELETE cần body không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
