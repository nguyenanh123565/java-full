# Path, query và JSON body

## 1. Problem — khái niệm này giải quyết việc gì?

Client gửi id, bộ lọc và dữ liệu mới qua các phần khác nhau của HTTP request. Tự parse mọi thứ bằng chuỗi dễ làm mất kiểu và lẫn ý nghĩa.

## 2. Mental model

`@PathVariable` lấy một đoạn path; `@RequestParam` lấy query/form parameter; `@RequestBody` nhờ converter đọc body thành Java object. Java thủ công phải parse URI/query, đọc stream và ánh xạ JSON. Các annotation này đưa dữ liệu HTTP vào tham số; chưa kiểm tra mọi quy tắc nghiệp vụ.

## 3. Ví dụ nhỏ

```text
GET /products/10           → path id
GET /products?name=book    → query name
POST /products + JSON     → request body
```

Xem [demo](demo/README.md). Đây là đoạn minh họa để đọc và thay đổi trong project tham chiếu; thư mục lesson không phải một Maven module độc lập.

## 4. Liên hệ kiến thức đã học

Java: parse long, null, record. HTTP: Content-Type application/json, URL encoding. SQL: query name có thể thành parameter của PreparedStatement ở repository sau này.

Ôn [Java Core](../../java-core-practice/README.md), [HTTP](../../http-rest-practice/README.md), [SQL](../../sql-postgresql-practice/README.md). Ghi lại một điều tương đương khi làm thủ công bằng Java.

## 5. Những lỗi thường gặp

Gửi JSON nhưng thiếu Content-Type; dùng @RequestParam cho JSON body; parse id lỗi rồi nghĩ database hỏng; tin body chỉ vì parse được.

## 6. Câu hỏi tự kiểm tra

id=abc lỗi ở bước chuyển kiểu hay service? Query optional khác path id bắt buộc thế nào? JSON đúng cú pháp có chắc hợp lệ nghiệp vụ?

## 7. Exercise

Làm [exercise](exercise/README.md), ghi dự đoán trước khi chạy. Chỉ mở [solution](solution/README.md) sau khi đã có câu trả lời và bằng chứng. Ghi hiểu nhầm vào [notes.md](notes.md).
