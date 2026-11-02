# Annotation: vấn đề → Java thủ công → HTTP

Không dùng annotation như một câu thần chú. Annotation chỉ là metadata; Spring/validation đọc metadata rồi áp dụng cơ chế.

| Annotation | Vấn đề được giải quyết | Không Spring thì tự làm | Quan hệ HTTP |
|---|---|---|---|
| @SpringBootApplication | Khởi tạo cấu hình, component scan và auto-configuration có điều kiện | Tạo server, object graph, đăng ký adapter | Chưa tạo route; web starter hỗ trợ server/MVC |
| @Component | Container tìm và quản lý object phổ thông | new trong main, giữ và truyền object | Không ánh xạ request |
| @Service | Component có vai trò nghiệp vụ | new service(repository) | Controller gọi nó sau khi bind request; không tự tạo route/transaction |
| @Repository | Component dữ liệu; tham gia cơ chế dịch lỗi khi có hạ tầng phù hợp | new implementation, xử lý lỗi lưu trữ tại ranh giới | Không đọc URI hay quyết định status |
| @RestController | Component HTTP ghi kết quả vào body | Đăng ký handler và serialize object | Tạo JSON body qua converter khi có mapping |
| @RequestMapping | Nhóm/khai báo path và điều kiện dispatch | Bảng handler theo method/path | Ghép path chung và path method |
| @GetMapping | Dispatch HTTP GET | Kiểm tra request method/path rồi gọi hàm đọc | GET đọc tài nguyên |
| @PostMapping | Dispatch HTTP POST | Chọn hàm tạo/xử lý body | POST collection để tạo trong bài này |
| @PutMapping | Dispatch HTTP PUT | Chọn hàm thay dữ liệu | PUT item; mini-project chọn missing → 404 |
| @DeleteMapping | Dispatch HTTP DELETE | Chọn hàm xóa | DELETE item; thành công → 204 |
| @PathVariable | Bind đoạn URI path thành tham số | Tách path và parse kiểu | /products/10 → id=10 |
| @RequestParam | Bind query/form parameter | Parse query/form, xử lý default/required | ?name=book không phải JSON body |
| @RequestBody | Đọc body qua message converter | Đọc stream và deserialize JSON | Thường cần Content-Type application/json |
| @Valid | Kích hoạt validation object đã bind | Gọi hàm kiểm tra và gom lỗi | Không hợp lệ → xử lý 400 |
| @NotBlank | Chuỗi không null/rỗng/trắng | if (s == null || s.isBlank()) | Constraint DTO, không phải filter mạng |
| @NotNull | Cấm null | if (value == null) | Field JSON thiếu có thể thành null |
| @DecimalMin | Ngưỡng số thập phân | BigDecimal.compareTo | Giá âm bị từ chối trước service; vẫn cần NotNull |
| @RestControllerAdvice | Xử lý exception MVC tập trung, trả body | Catch ở biên HTTP và viết response | Dịch lỗi MVC/nghiệp vụ, không thay security filters |
| @ExceptionHandler | Chọn handler theo loại exception | if/catch đúng loại lỗi | Quyết định 400/404 và body tương ứng |
| @Configuration | Lớp khai báo factory/cấu hình bean | Lớp composition root trong Java | Không tạo route |
| @Bean | Đưa object trả về factory vào container | Gọi factory, giữ object và truyền dependency | Có thể cung cấp config cho server/security, không tự là endpoint |
| @Value | Đọc thuộc tính ngoài source | System.getenv, parse và default | Ví dụ cấu hình thông số; không thay request parameter |

`@Override` là annotation Java Core kiểm tra việc override khi compile, không có hành vi Spring/HTTP. Constructor duy nhất trong ví dụ không cần `@Autowired`. `ResponseEntity`, record và interface là kiểu Java, không phải annotation.
