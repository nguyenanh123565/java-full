# Cấu hình và môi trường

## 1. Problem — khái niệm này giải quyết việc gì?

Port và thông số môi trường thay đổi mà không nên sửa source. Gắn credential vào code khiến bản build khó chuyển nơi chạy và dễ lộ bí mật.

## 2. Mental model

`application.properties` và environment là nguồn cấu hình ngoài source. `@Value("${...}")` đọc một thuộc tính khi tạo bean; Java thuần dùng System.getenv rồi parse/default. `@Configuration` đánh dấu lớp khai báo cấu hình; `@Bean` đăng ký object do method tạo, tương đương tự gọi factory rồi giữ object dùng chung. Với HTTP, server.port đổi nơi server lắng nghe; không đổi mapping URI.

## 3. Ví dụ nhỏ

```properties
server.port=${PORT:8080}
server.error.include-stacktrace=never
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: đọc environment và chuyển kiểu. HTTP: host:port khác path. SQL: JDBC URL/user/password sẽ đưa qua environment ở bài lưu trữ sau này, chưa thêm DB ở đây.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Commit mật khẩu; nhầm port app với port database; sửa properties trong target; dùng @Value cho mọi loại object nghiệp vụ.

## 6. Câu hỏi tự kiểm tra

Port mặc định khi PORT không có là gì? Chuyển port có cần đổi @GetMapping không? @Bean khác new cục bộ ở điểm quản lý nào?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
