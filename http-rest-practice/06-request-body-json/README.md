# 06 — Request body và JSON

## 1. Vấn đề cần giải quyết

Khi tạo hoặc chỉnh sửa tài nguyên, client cần gửi một tập dữ liệu có cấu trúc. Body mang dữ liệu đó; JSON là một định dạng văn bản để diễn đạt object, array và các giá trị cơ bản.

## 2. Vị trí trong luồng

```text
Client → HTTP Request [body] → Backend [parse → validate → nghiệp vụ] → Database → HTTP Response → Client
```

Ba bước ở backend khác nhau: parse kiểm tra cấu trúc JSON; validate kiểm tra dữ liệu theo contract; nghiệp vụ kiểm tra điều kiện như tồn kho, quyền và giá hiện tại. Chưa có parser JSON hoặc database trong echo lab.

## 3. Kiến thức bắt buộc

- JSON có object `{}`, array `[]`, string, number, boolean và `null`.
- Tên field và string dùng dấu nháy kép. JSON chuẩn không có comment hoặc dấu phẩy dư cuối danh sách.
- `10` khác `"10"`; `false` khác `"false"`; field thiếu khác field có giá trị `null` nếu contract phân biệt chúng.
- Body JSON cần Content-Type phù hợp. Header không làm JSON sai thành đúng.
- POST/PUT/PATCH thường dùng body theo contract; không gắn JSON vào GET body cho tìm kiếm thông thường.
- Không tin các field client gửi như userId, role, price hay total nếu backend cần tự xác định chúng.
- Giá tiền cần quy tắc đơn vị và độ chính xác rõ. Java có thể dùng BigDecimal; JSON number không tự đảm bảo client dùng phép toán thập phân chính xác.
- Echo trả raw body thành chuỗi, nên dấu nháy và xuống dòng được escape trong response JSON. Nó chưa kiểm tra schema hay ý nghĩa body.

## 4. Ví dụ request/response

Ví dụ HTTP/1.1 dùng body để quan sát, không tạo sản phẩm:

```http
POST /echo HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{"label":"sensor","enabled":true,"tags":["demo","lab"]}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"method":"POST","path":"/echo","rawQuery":null,"headers":{"content-type":"application/json","accept":"application/json"},"receivedBody":"{\"label\":\"sensor\",\"enabled\":true,\"tags\":[\"demo\",\"lab\"]}"}
```

IDE có thể thêm newline cuối body; khi đó `receivedBody` còn có `\n`. [demo.http](demo.http) có cả JSON đúng và nội dung cố tình sai để chứng minh echo **không parse JSON**. Response 200 của echo không chứng minh input hợp lệ cho API nghiệp vụ.

## 5. Lỗi thường gặp

- Dùng cú pháp JavaScript như single quote hoặc comment trong JSON chuẩn.
- Parse được JSON rồi coi mọi quy tắc nghiệp vụ đã đạt.
- Cho client gửi tổng tiền và lưu nguyên mà không tính lại từ các mặt hàng.
- Chuyển mọi số sang string cho “dễ gửi” mà không định nghĩa contract.
- Nhầm chuỗi raw body trong response echo với object JSON đã parse.

## 6. Tự kiểm tra

1. JSON hợp lệ có đảm bảo stock không âm không?
2. Field thiếu và field `null` có luôn mang cùng ý nghĩa không?
3. Vì sao role trong request không nên tự động cấp quyền cho user?
4. Vì sao echo có thể trả 200 cho body JSON sai?
5. Khi đọc giá tiền bằng Java, cần xác định những quy tắc nào?

## 7. Ba bài tập

1. **Dễ:** Tìm lỗi cú pháp và phân biệt chúng với lỗi dữ liệu.
2. **Vừa:** Thiết kế JSON tạo sản phẩm và response phù hợp.
3. **Khó:** Thiết kế input đặt hàng và chỉ ra dữ liệu backend phải tự tính.

Làm [exercises.md](exercises.md). [Solution riêng](../solutions/06-request-body-json.md).

Tham khảo: [RFC 9110 — content semantics](https://www.rfc-editor.org/rfc/rfc9110.html#section-6.4.1). Khi cần kiểm tra cú pháp JSON, đối chiếu [RFC 8259](https://www.rfc-editor.org/rfc/rfc8259.html).
