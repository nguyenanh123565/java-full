# Backend big picture

```text
Client
 ↓
HTTP Request
 ↓
Spring Controller
 ↓
Service
 ↓
Repository
 ↓
JPA
 ↓
Hibernate
 ↓
JDBC
 ↓
PostgreSQL
 ↓
Response
```

Sơ đồ biểu diễn hành trình tổng quan. Database trả row qua JDBC rồi các lớp phía
trên tạo HTTP Response; PostgreSQL không trực tiếp gửi JSON cho client. Spring Data
JPA là phần có thể đứng ở Repository; JPA là đặc tả API, Hibernate là implementation.
Khi học JDBC thuần, Repository/DAO gọi JDBC trực tiếp; khi học Spring đầu tiên,
Repository có thể chỉ giữ Map trong bộ nhớ.

| Tầng | TODO: trách nhiệm | TODO: ví dụ khi GET /products/10 | TODO: lỗi quan sát được |
| --- | --- | --- | --- |
| Client / HTTP | TODO | TODO | TODO |
| Controller / DTO | TODO | TODO | TODO |
| Service | TODO | TODO | TODO |
| Repository | TODO | TODO | TODO |
| JPA / Hibernate | TODO | TODO | TODO |
| JDBC / PostgreSQL | TODO | TODO | TODO |

TODO — Vẽ đường đi của kết quả ngược về client.
TODO — Đặt authentication, authorization, validation và transaction vào sơ đồ.
TODO — Chỉ ra object Java nào là DTO, entity; câu SQL nào thực sự được chạy.
TODO — Thử mô tả POST /orders khi product hết hàng; ai trả 409, ai rollback?
