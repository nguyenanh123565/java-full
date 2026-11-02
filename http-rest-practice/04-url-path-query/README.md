# 04 — URL, path và query

## 1. Vấn đề cần giải quyết

Backend cần biết client đang hỏi tài nguyên nào và muốn lựa chọn dữ liệu ra sao. URL xác định đích; path thường định danh resource, còn query thường diễn đạt bộ lọc, sắp xếp và phân trang.

## 2. Vị trí trong luồng

```text
Client → HTTP Request [URL đích] → Backend [routing + đọc tham số] → Database → HTTP Response → Client
```

Router đối chiếu path và method với contract. Backend đọc query rồi có thể xây truy vấn database phù hợp. Query không tự biến thành điều kiện SQL nếu backend chưa triển khai.

## 3. Kiến thức bắt buộc

Với `http://localhost:8080/products/10?view=summary#details`:

- Scheme là `http`; host là `localhost`; port là `8080`.
- Path là `/products/10`; query là `view=summary`.
- Fragment `details` được client sử dụng, không được gửi như một phần request target tới backend.
- `/products/{id}` là cách ghi trong tài liệu route; request thực tế dùng một giá trị như `/products/10`, không gửi nguyên `{id}`.
- Phân trang, lọc và sort là contract API, không phải tính năng có sẵn chỉ vì thêm query.
- Giá trị cần percent-encoding đúng, nhất là khoảng trắng, tiếng Việt và ký tự `&`. `%20` biểu diễn khoảng trắng; nhiều bộ giải mã form hiểu `+` là khoảng trắng, nên phải biết quy tắc công cụ đang dùng.
- Query string có thể xuất hiện trong log và lịch sử; không đặt mật khẩu hoặc token thật vào URL.

## 4. Ví dụ request/response

Ví dụ HTTP/1.1 quan sát query thô:

```http
GET /echo?topic=robot%20arm&minPrice=5000000 HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"method":"GET","path":"/echo","rawQuery":"topic=robot%20arm&minPrice=5000000","headers":{"accept":"application/json"},"receivedBody":""}
```

Lab chỉ cho bạn thấy `rawQuery`. `/products` của lab chưa hỗ trợ lọc hoặc phân trang; không suy ra rằng kết quả echo đã lọc sản phẩm. Chạy [demo.http](demo.http) để kiểm chứng request target.

## 5. Lỗi thường gặp

- Đưa toàn bộ JSON tìm kiếm vào GET body rồi mong mọi client/proxy đều xử lý.
- Gửi tên có `&` chưa encode, làm server hiểu nhầm thành tham số mới.
- Nhầm fragment với query; mong backend nhận đoạn sau `#`.
- Đổi tên `id` trong URL nhưng không xác định resource nào đang được yêu cầu.

## 6. Tự kiểm tra

1. Path variable có phải một header đặc biệt không?
2. Query `page=2` có tự làm backend phân trang không?
3. Vì sao `name=A&B` có thể khác `name=A%26B`?
4. Thêm `#reviews` có yêu cầu server trả resource khác không?

## 7. Ba bài tập

1. **Dễ:** Tách một URL thành các thành phần và dự đoán request target.
2. **Vừa:** Thiết kế nơi đặt id, bộ lọc và thông tin tạo resource.
3. **Khó:** Xử lý giá trị có ký tự đặc biệt và định nghĩa contract phân trang.

Làm [exercises.md](exercises.md). [Solution riêng](../solutions/04-url-path-query.md).

Tham khảo: [RFC 9110 — URI và fragment](https://www.rfc-editor.org/rfc/rfc9110.html#section-4.2).
