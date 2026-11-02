# 02 — HTTP request và response

## 1. Vấn đề cần giải quyết

Client và backend cần một thông điệp đủ rõ để biết đang yêu cầu gì, kết quả ra sao và dữ liệu có định dạng nào. Request diễn đạt yêu cầu; response diễn đạt kết quả xử lý.

## 2. Vị trí trong luồng

```text
Client → [HTTP Request] → Backend → Database → [HTTP Response] → Client
```

Backend đọc method, đích request, headers và body trước khi quyết định xử lý. Backend tạo response sau khi xử lý; database có thể không được dùng.

## 3. Kiến thức bắt buộc

- Request có method, đích request, thông tin header và body khi phù hợp.
- Response có status, headers và body khi được phép; HEAD và 204 không có response body.
- Trong ví dụ HTTP/1.1, dòng trống phân cách headers và body. Đừng nhầm body với header cuối.
- `Content-Type` mô tả kiểu dữ liệu đang gửi; `Accept` mô tả kiểu response client muốn nhận.
- Body có thể là JSON, text, form hoặc dữ liệu nhị phân; response không phải lúc nào cũng có body.
- Status và body phải được đọc cùng nhau: một response JSON vẫn có thể báo lỗi.
- Công cụ HTTP thường tự tạo `Host` và tính độ dài dữ liệu. Đừng tự đếm `Content-Length` theo số ký tự; nó tính theo byte.

## 4. Ví dụ request/response

Ví dụ HTTP/1.1 minh họa, lược header do công cụ tự tính:

```http
POST /echo HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

{"note":"learn request structure"}
```

Response minh họa phần dữ liệu quan trọng:

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"method":"POST","path":"/echo","rawQuery":null,"headers":{"content-type":"application/json","accept":"application/json"},"receivedBody":"{\"note\":\"learn request structure\"}"}
```

`/echo` phản chiếu raw body trong trường `receivedBody`, một **chuỗi JSON**; không parse body thành object và không tạo dữ liệu nghiệp vụ. Lab chỉ phản chiếu một số headers đã chọn. Chạy [demo.http](demo.http), tìm dòng trống, status, headers và body bằng giao diện IDE hoặc curl.

## 5. Lỗi thường gặp

- Nghĩ header `Content-Type: application/json` tự làm nội dung thành JSON hợp lệ.
- Chỉ nhìn body có dữ liệu mà bỏ qua status lỗi.
- Gửi request trước khi dự đoán rồi chép kết quả; cách này không kiểm tra được mô hình hiểu biết.
- Cho rằng mọi response đều chứa JSON, kể cả HEAD và 204.

## 6. Tự kiểm tra

1. Method và status code thuộc request hay response?
2. Dòng trống có vai trò gì trong ví dụ HTTP/1.1?
3. Vì sao response từ echo chứa dấu `\"` trong trường `receivedBody`?
4. Nếu kết nối bị từ chối, có thể đọc status HTTP từ backend không?

## 7. Ba bài tập

1. **Dễ:** Tách các thành phần của một request đã cho.
2. **Vừa:** Dự đoán response có hoặc không có body rồi kiểm tra thật.
3. **Khó:** Mô tả hai request/response độc lập cho một thao tác UI cần nhiều bước.

Làm [exercises.md](exercises.md). [Solution riêng](../solutions/02-http-request-response.md) dùng để đối chiếu sau.

Tham khảo: [RFC 9110 — mô hình thông điệp](https://www.rfc-editor.org/rfc/rfc9110.html#section-6).
