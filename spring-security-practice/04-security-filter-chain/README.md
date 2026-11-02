# SecurityFilterChain trước controller

## 1. Problem — khái niệm này giải quyết việc gì?

Nếu từng controller tự kiểm tra login, một route mới dễ bị quên. Cần một ranh giới chung trước MVC để xác thực và kiểm tra quyền.

## 2. Mental model

Servlet filter chain xử lý request trước DispatcherServlet. SecurityFilterChain gom các filter/rule của Spring Security; HttpSecurity là builder. `@Configuration` khai báo cấu hình và `@Bean` đưa chain vào container: thủ công ta tạo đối tượng, đăng ký filters và thứ tự với server. Hai annotation không tạo endpoint HTTP. Mỗi request đi qua security rồi mới đến controller nếu được phép.

## 3. Ví dụ nhỏ

```text
Request → security filters (session, CSRF, authz)
→ DispatcherServlet → controller → service
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: chain và composition. HTTP: cookie, method, CSRF token quyết định có tới handler không. SQL: request bị chặn trước controller không chạy nghiệp vụ/truy vấn.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Tắt CSRF chỉ để POST chạy; nghĩ permitAll bỏ qua mọi filter; cố bắt lỗi filter bằng RestControllerAdvice; copy WebSecurityConfigurerAdapter cũ.

## 6. Câu hỏi tự kiểm tra

Vì sao 403 có thể xuất hiện trước controller? permitAll có tự bỏ kiểm tra CSRF không? Authentication failure do lớp nào xử lý?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
