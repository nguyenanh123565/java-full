# 03 — Chọn HTTP method theo ý định

## 1. Vấn đề cần giải quyết

Client cần diễn đạt muốn đọc, tạo, thay thế, sửa một phần hay xóa dữ liệu. Method mang ý nghĩa giúp backend, client và các thành phần trung gian xử lý nhất quán.

## 2. Vị trí trong luồng

```text
Client → HTTP Request [method] → Backend [chọn thao tác] → Database → HTTP Response → Client
```

Method là dữ liệu của request. Backend thực hiện contract tương ứng; database có thể chỉ được đọc hoặc thay đổi. Không có quy tắc POST tự động tương ứng một câu INSERT.

## 3. Kiến thức bắt buộc

| Method | Ý định phổ biến | Safe | Idempotent theo ngữ nghĩa |
| --- | --- | --- | --- |
| GET | Lấy representation | Có | Có |
| HEAD | Như GET nhưng không nhận response body | Có | Có |
| POST | Xử lý dữ liệu theo contract, thường tạo tài nguyên | Không | Không được đảm bảo |
| PUT | Tạo/thay thế trạng thái tài nguyên ở URI đã biết | Không | Có |
| PATCH | Áp dụng một bản sửa được định nghĩa bởi định dạng patch | Không | Không được đảm bảo |
| DELETE | Xóa liên kết tài nguyên tại URI | Không | Có |
| OPTIONS | Tìm khả năng giao tiếp của tài nguyên/server | Có | Có |

Safe nói về ý định không yêu cầu thay đổi trạng thái nghiệp vụ; server vẫn có thể ghi log. Idempotent nói về **hiệu ứng mong muốn** khi lặp cùng request, không yêu cầu status hay body lần nào cũng giống nhau.

PUT cần contract rõ cho representation thay thế; thiếu một field không mặc nhiên nghĩa là giữ field cũ. PATCH đặt `stock` thành giá trị cố định có thể idempotent; PATCH tăng stock thì có thể không. GET body không có ngữ nghĩa chung và thường không tương thích với client/proxy; dùng query cho bộ lọc thông thường. POST có thể phục vụ xử lý nghiệp vụ ngoài việc tạo resource.

## 4. Ví dụ request/response

Ví dụ HTTP/1.1:

```http
HEAD /products/10 HTTP/1.1
Host: localhost:8080

```

```http
HTTP/1.1 200 OK
Content-Type: application/json

```

HEAD không có response body. [demo.http](demo.http) còn gửi PUT/PATCH/DELETE tới `/echo` để đọc lại method. Echo **không** sửa hay xóa sản phẩm; bài thiết kế nghiệp vụ làm trên giấy.

## 5. Lỗi thường gặp

- Dùng GET để hủy đơn vì thấy có thể viết nút bấm với URL.
- Nhầm idempotent với “luôn trả 200” hoặc “chỉ chạy một lần”.
- Gửi một field bằng PUT nhưng mong mọi field khác giữ nguyên dù contract không nói vậy.
- Nghĩ POST luôn tạo và PATCH luôn idempotent.

## 6. Tự kiểm tra

1. Vì sao GET có thể ghi access log mà vẫn là safe?
2. DELETE lần đầu 204, lần sau 404 có phá tính idempotent không?
3. PUT khác PATCH ở ý nghĩa body như thế nào?
4. Vì sao client không nên tùy tiện retry một POST đặt hàng?
5. HEAD khác GET ở response nào?

## 7. Ba bài tập

1. **Dễ:** Chọn method cho các thao tác sản phẩm và giải thích ý định.
2. **Vừa:** Phân tích lặp request đặt stock và tăng stock.
3. **Khó:** Sửa một API dùng GET để thay đổi dữ liệu; nêu ảnh hưởng khi request bị retry.

Làm [exercises.md](exercises.md), rồi đối chiếu [solution riêng](../solutions/03-http-methods.md).

Tham khảo: [RFC 9110 — methods](https://www.rfc-editor.org/rfc/rfc9110.html#section-9), [RFC 5789 — PATCH](https://www.rfc-editor.org/rfc/rfc5789.html#section-2).
