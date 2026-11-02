# Service giữ quy tắc nghiệp vụ

## 1. Problem — khái niệm này giải quyết việc gì?

Cùng quy tắc có thể được gọi từ HTTP, CLI hoặc test. Đặt quy tắc trong controller sẽ buộc nơi gọi khác lặp lại và dễ xử lý khác nhau.

## 2. Mental model

Service là use case Java: kiểm tra quy tắc rồi phối hợp repository. `@Service` giúp Spring phát hiện và tạo bean có vai trò nghiệp vụ. Không Spring thì ta `new ProductService(repository)`. Annotation không tạo route và không tự mở transaction trong bài này; HTTP chỉ gọi service qua controller.

## 3. Ví dụ nhỏ

```text
Controller: nhận ProductRequest
Service: cập nhật sản phẩm chỉ khi id tồn tại
Repository: tìm/lưu dữ liệu
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: tách method theo trách nhiệm, exception. HTTP: controller/advice dịch lỗi service sang status. SQL: transaction sau này thường bao quanh một use case, không quanh việc parse JSON.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Service chỉ chuyển tiếp vô nghĩa nhưng controller chứa mọi quy tắc; service nhận HttpServletRequest; service tự nối JSON; nghĩ @Service đồng nghĩa transaction.

## 6. Câu hỏi tự kiểm tra

Nếu gọi service từ main, có cần biết status 404 không? SQL nên nằm ở đâu? Bỏ service khiến quy tắc bị lặp ra sao?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
