# Guided JWT — bài đọc sau session, chưa phải app chạy độc lập

Reference session không thay đổi. Snippet này là kiến trúc API Bearer-only riêng: issuer tin cậy cấp token; API chỉ nhận và xác minh. Không có dịch vụ issuer được tạo/cài/triển khai trong workspace.

## Dependency chỉ thêm khi chủ động làm nhánh JWT

Boot starter `spring-boot-starter-oauth2-resource-server` mang hỗ trợ resource server và JWT/Jose cần thiết. Không thêm thư viện JWT tùy ý hoặc tự viết filter dài. Cần một issuer thực có metadata/JWKS và tài khoản thử nghiệm theo hướng dẫn của issuer.

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```

Trong một project riêng, khai báo cấu hình (placeholder cố ý không chạy):

```properties
spring.security.oauth2.resourceserver.jwt.issuer-uri=https://issuer.example.invalid
spring.security.oauth2.resourceserver.jwt.audiences=learning-api
```

```java
// Trong @Configuration, với imports Spring Security thích hợp.
@Bean
SecurityFilterChain bearerOnly(HttpSecurity http) throws Exception {
    http.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    // Chỉ cho API Bearer header, không formLogin/httpBasic/cookie authentication.
    http.csrf(csrf -> csrf.disable());
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers(HttpMethod.GET, "/products").hasAuthority("SCOPE_products.read")
        .anyRequest().authenticated());
    http.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
    return http.build();
}
```

`@Configuration` khai báo composition root; `@Bean` đưa chain vào container, tương đương tự tạo/đăng ký filter; chúng không tạo HTTP route. SecurityFilterChain xử lý Authorization trước controller. STATELESS tránh lưu Authentication vào HTTP session; chính sách đó không tự chứng minh ứng dụng miễn CSRF. Tắt CSRF ở snippet dựa trên giả định browser không tự đính kèm credential của API này; nếu chuyển Bearer token vào cookie, phải đánh giá lại và không sao chép tắt CSRF từ đây.

## Vì sao không chỉ decode?

Resource Server kiểm chữ ký bằng khóa tin cậy, algorithm policy và exp/nbf/iss. `audiences=learning-api` bổ sung kiểm audience. Decode Base64URL chỉ đọc JSON; không làm các phép kiểm trên. Scope thường ánh xạ thành SCOPE_ authority, không phải ROLE_. Server phải từ chối token không hợp lệ trước khi tạo principal dùng cho quyền.

TODO tự làm: lập ma trận token hợp lệ, sửa payload, hết hạn, sai issuer, sai audience, thiếu scope; dự đoán 401/403 trước khi có issuer. Vì sao token chữ ký đúng vẫn có thể không được API này chấp nhận? Liên hệ HTTP header và SQL user id từ principal. Không gửi token thật lên website decode công khai.

[Tài liệu Resource Server JWT 6.5](https://docs.spring.io/spring-security/reference/6.5/servlet/oauth2/resource-server/jwt.html) là nguồn để tra cấu hình issuer/audience và authority mapping. Đây là hướng dẫn có điều kiện, chưa được chạy hay kiểm thử với issuer thật.
