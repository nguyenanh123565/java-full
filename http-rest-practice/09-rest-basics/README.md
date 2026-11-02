# 09 — REST: tài nguyên, biểu diễn và các ràng buộc

## 1. Khái niệm giải quyết vấn đề gì?

REST là một phong cách kiến trúc giúp các thành phần giao tiếp qua giao diện thống nhất và có thể phát triển độc lập. Ta suy nghĩ bằng tài nguyên và biểu diễn tài nguyên thay vì bắt client biết hàng loạt hàm nội bộ.

Trong công việc, “RESTful API” thường chỉ API HTTP theo tài nguyên. Các bài thiết kế trong workspace theo cách dùng thực tế này; khi chưa có hypermedia để dẫn dắt chuyển trạng thái, không khẳng định đã đáp ứng đầy đủ REST của Fielding.

## 2. Nằm ở đâu trong luồng?

`Client → HTTP Request → Backend → Database → HTTP Response → Client`

REST định hướng cách client/backend trao đổi thông điệp và biểu diễn. Tài nguyên có thể kết hợp nhiều bảng hoặc được tính toán mà không có bảng tương ứng. Database là lựa chọn triển khai của backend.

## 3. Kiến thức bắt buộc

- **Resource:** một khái niệm được định danh, ví dụ giỏ hàng hoặc báo cáo tồn kho. Không bắt buộc khớp một row.
- **Representation:** dữ liệu mô tả tài nguyên tại một thời điểm, như JSON hoặc HTML. JSON không phải điều kiện bắt buộc của REST.
- **Uniform interface:** định danh tài nguyên; thao tác qua biểu diễn; thông điệp tự mô tả; hypermedia dẫn dắt chuyển trạng thái.
- Các ràng buộc khác: client/server, stateless, cache, hệ thống nhiều lớp; code-on-demand là tùy chọn.
- Stateless nói về ngữ cảnh phiên giao tiếp; backend vẫn có thể lưu đơn hàng, sản phẩm và các trạng thái nghiệp vụ.
- URL danh từ số nhiều là quy ước thiết kế hữu ích, không phải định nghĩa REST.
- Cacheability cần được công bố phù hợp; không có nghĩa mọi dữ liệu đều được lưu cache công khai.

## 4. Ví dụ request/response

Ví dụ thiết kế kho hàng độc lập với lab. Minh họa HTTP/1.1; framing được lược bớt.

```http
GET /warehouses/3 HTTP/1.1
Host: api.example.test
Accept: application/json

HTTP/1.1 200 OK
Content-Type: application/json
Cache-Control: private, max-age=30

{"id":3,"name":"South","links":{"self":"/warehouses/3","items":"/warehouses/3/items"}}
```

JSON là biểu diễn; links minh họa cách khám phá liên kết. Chỉ thêm một trường links chưa đủ chứng minh toàn bộ hệ thống tuân thủ REST. Ta còn cần ngữ nghĩa liên kết, kiểu dữ liệu và quy tắc chuyển trạng thái đã định nghĩa.

`demo.http` chỉ đọc sản phẩm; quan sát việc đường dẫn nhận diện tài nguyên và body biểu diễn tài nguyên.

## 5. Lỗi thường gặp

- “URL không có động từ là REST đầy đủ.”
- “REST bắt buộc JSON và CRUD một bảng.”
- Đưa ngữ cảnh trang trước vào server rồi yêu cầu request sau phụ thuộc ngữ cảnh đó.
- Cho rằng stateless cấm database.
- Cho phép GET làm thay đổi tồn kho hoặc hủy đơn.

## 6. Tự kiểm tra

1. Một báo cáo tính từ nhiều bảng có thể là resource không?
2. Resource và representation khác nhau thế nào?
3. URL toàn danh từ có đủ đáp ứng REST không?
4. REST có bắt buộc sử dụng JSON không?
5. Vì sao lưu orders trong database không vi phạm stateless?

## 7. Ba bài tập từ dễ đến khó

1. **Dễ:** Từ users/products/orders, chọn ba resource và mô tả identity cùng representation; giải thích vì sao không phải luôn trùng bảng.
2. **Vừa:** Chuyển `POST /getProduct?id=10` sang một giao kèo HTTP theo tài nguyên; phân tích method, đường dẫn và body.
3. **Khó:** Nhận xét API JSON dùng danh từ nhưng phụ thuộc “user đã chọn trước đó” trong server session; phân tích stateless, hypermedia và khả năng cache.

Làm trong [exercises.md](exercises.md); đối chiếu tại [solutions](../solutions/09-rest-basics.md).

Nguồn: [Fielding — REST architectural style](https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm).
