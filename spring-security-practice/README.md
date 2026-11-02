# Spring Security — danh tính trước, token sau

**Authentication != Authorization.** Xác thực trả lời “ai đang gọi”; phân quyền trả lời “người đó có được làm việc này không”. Học sau HTTP cookie/header/status và Spring Boot controller/service/DI. JPA hữu ích khi cần tài khoản database nhưng reference ở đây dùng memory, không phụ thuộc JPA.

```text
Login
→ username/password
→ authenticate (đối chiếu hash)
→ tạo session hoặc phát JWT theo kiến trúc
→ client gửi session id / Bearer token
→ backend xác minh
→ authorization
→ Controller → Service → Repository
```

## Thứ tự học và điều kiện qua bài

1. 01–02: giải thích được xác thực/phân quyền, khách/USER/ADMIN khác nhau.
2. 03: hiểu BCrypt encode/matches, salt và cost; không tự viết crypto.
3. 04–05: hiểu filter trước controller, chạy session demo, giữ CSRF bật.
4. 06–07: chỉ sau session mới đọc JWT và guided Resource Server; không cần issuer bên ngoài để hoàn thành nền tảng.
5. 08: role/permission/ownership; làm [exercises](exercises/README.md) và [mini-project](mini-project/README.md).

Mỗi lesson có demo, exercise TODO, solution riêng và notes. Snippet có nhãn khi không phải app chạy riêng. [Session reference](mini-project/solution/README.md) là project Maven hoàn chỉnh; [starter](mini-project/starter/README.md) là bài chưa giải, không chứa cấu hình quyền đã làm sẵn.

Java 17, Boot 3.5.16 là baseline học giống Spring workspace, không khẳng định phiên bản mới nhất. Boot quản lý phiên bản Security; không tự ghim phiên bản khác. Chỉ web + security cho session. [BCrypt/password storage](https://docs.spring.io/spring-security/reference/6.5/features/authentication/password-storage.html) mô tả encode/verify; [form login](https://docs.spring.io/spring-security/reference/6.5/servlet/authentication/passwords/form.html) giải thích ranh giới filter/session.

## Đọc annotation

`@SpringBootApplication` khởi tạo container/server; thủ công tự new và đăng ký handler. `@Configuration` là nơi lắp ráp object; `@Bean` đăng ký object từ factory vào container, thủ công tự gọi factory và truyền dependency. Các annotation này không tạo route. `@RestController`, `@GetMapping`, `@PostMapping`, `@RequestBody` nối HTTP method/path/body với Java method, thay cho parse/dispatch/serialize bằng tay. Xem bảng đầy đủ ở [Spring annotation map](../spring-boot-practice/annotation-map.md); project Security không thêm annotation bảo mật method khi chưa cần.

## Sẵn sàng chuyển sang testing

Tự phân biệt 302 login/401 API và 403, nhận ra 403 do CSRF khác thiếu role, biết session ở server/cookie ở client và không bao giờ tin JWT chỉ vì decode được. Ghi một request tái hiện mỗi trường hợp trước khi chuyển phần testing.
