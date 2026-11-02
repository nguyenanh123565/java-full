# Spring Boot — dựng REST API sau khi hiểu nền tảng

Học sau Java Core, HTTP/REST, SQL, JDBC và Maven. Chỉ bắt đầu khi bạn tự giải thích được constructor/interface, request method/path/body/status, PreparedStatement và dependency trong pom.xml. JPA chưa cần cho workspace này.

## Thứ tự học

1. 01–03: Spring/Boot, cây project, constructor injection.
2. 04–07: controller, route, dữ liệu request, response.
3. 08–10: service, repository memory, DTO.
4. 11–13: validation, exception handling, configuration.
5. [Bài tổng hợp](exercises/README.md) → [mini-project](mini-project/README.md) → chỉ sau đó mở [solutions](solutions/README.md).

Luồng phải tự kể được:

```text
GET /products/10
→ server nhận HTTP
→ MVC tìm @GetMapping("/{id}") dưới /products
→ Controller chuyển id thành long
→ Service tìm sản phẩm theo quy tắc
→ Repository đọc Map trong memory
→ DTO → JSON + HTTP status
```

Không có database trong bài này. Dừng process sẽ mất dữ liệu; đó là giới hạn có chủ đích để nhìn rõ MVC trước khi học JPA.

## Demo và cách dùng thư mục

Mỗi lesson có README, demo, exercise, solution, notes. Demo lesson là snippet có nhãn, không phải ứng dụng độc lập; import/context đầy đủ nằm trong [ứng dụng tham chiếu](mini-project/solution/README.md). Tự làm ở starter hoặc thư mục riêng; không sửa bài cũ. Starter và solution tách đường dẫn, không chép solution vào exercise.

Java source dùng cú pháp Java 17; Maven POM cố định Spring Boot **3.5.16** làm baseline học, không tuyên bố là bản mới nhất. Boot 3.5 hỗ trợ Java 17–25 theo [system requirements](https://docs.spring.io/spring-boot/3.5/system-requirements.html); Maven cần 3.6.3 trở lên. JDK 23 đang có trên máy phù hợp baseline này. Nếu chưa có Maven, hãy học phần Maven trước; tài liệu không tự cài hoặc tải dependency.

## Đọc annotation bằng vấn đề nó giải quyết

Mọi annotation được dùng trong code có giải thích ở [annotation-map.md](annotation-map.md): việc Spring làm, Java thủ công tương đương và quan hệ HTTP. Đọc bảng trước khi thêm annotation mới. [Spring MVC controllers](https://docs.spring.io/spring-framework/reference/6.2/web/webmvc/mvc-controller.html) là tài liệu gốc để tra tiếp.

## Điều kiện chuyển sang JPA và Security

Tự thêm được một field qua DTO → service → memory repository, giải thích 400/404/201/204, biết validation khác business rule và tự vẽ constructor dependencies. Nếu còn nhầm repository là database hoặc @Service tạo endpoint, ở lại làm bài tổng hợp.
