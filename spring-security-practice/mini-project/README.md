# Mini-project — bảo vệ danh sách sản phẩm bằng session

Làm trên project nhỏ riêng để thấy filter trước controller; chưa tích hợp database. Tái dùng Java record/Map, HTTP method/status/cookie, Maven và Spring DI.

| Route | Khách | USER | ADMIN |
|---|---|---|---|
| GET /products | đọc | đọc | đọc |
| GET /me | chuyển login | đọc danh tính mình | đọc danh tính mình |
| POST /products | không được ghi | 403 khi token CSRF hợp lệ | được ghi nếu token CSRF hợp lệ |

Unsafe request vẫn cần CSRF; permitAll không bỏ CSRF. Session ở server; JSESSIONID là id bên client. Password chỉ dùng tài khoản học, lấy qua environment ở reference.

TODO: Làm [starter](starter/README.md) trước, dự đoán ma trận và giải thích vì sao. Đối chiếu [solution](solution/README.md) sau đó. Với JWT, chỉ đọc [guided snippet](../guided-jwt.md); không đổi reference session thành stateless để né CSRF.
