# Controller nhận và trả dữ liệu HTTP

## 1. Problem — khái niệm này giải quyết việc gì?

Logic sản phẩm không nên phải đọc raw HTTP bytes. Cần một lớp dịch yêu cầu mạng thành lời gọi Java và dịch kết quả ngược lại.

## 2. Mental model

`@RestController` đăng ký component đảm nhiệm HTTP và mặc định ghi giá trị trả về vào response body. Nếu không có Spring MVC, ta tự đăng ký handler, parse request và serialize JSON. Controller nhận dữ liệu/ủy quyền; service quyết định nghiệp vụ. GET route vẫn cần mapping riêng.

## 3. Ví dụ nhỏ

```java
@RestController
class HelloController {
    @GetMapping("/hello")
    Map<String, String> hello() { return Map.of("message", "xin chao"); }
}
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: method call và Map. HTTP: JSON body khác tên view HTML. SQL: controller không tự chạy SELECT; dữ liệu được lấy qua service/repository.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Dồn tính giá và truy vấn vào controller; nghĩ trả String luôn là JSON object; nhầm controller với server.

## 6. Câu hỏi tự kiểm tra

Lớp nào chịu trách nhiệm chuyển Map thành JSON? Một method public không mapping có tự là API không?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
