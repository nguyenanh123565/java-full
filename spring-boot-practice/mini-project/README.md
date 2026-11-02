# Mini-project — Product REST API trong memory

Tái sử dụng Java Core (record, interface, Map, BigDecimal, exception), HTTP (method/path/status/JSON), ý tưởng CRUD từ SQL/JDBC và Maven. Chưa dùng JPA hoặc database.

| Method | Path | Ý định | Thành công | Lỗi chính |
|---|---|---|---|---|
| GET | /products | Danh sách | 200 + array | — |
| GET | /products/{id} | Một sản phẩm | 200 + object | 404 missing; 400 id sai kiểu |
| POST | /products | Tạo name, price | 201 + Location + object | 400 validation/JSON |
| PUT | /products/{id} | Thay name, price item hiện có | 200 + object | 400 input; 404 missing |
| DELETE | /products/{id} | Xóa item hiện có | 204 không body | 404 missing |

## Tự làm

[Starter](starter/README.md) chứa entry point, DTO và chữ ký TODO; các phần CRUD cố ý chưa thực hiện. Dự đoán từng request trước khi gửi, ghi vì sao mỗi status phù hợp. Làm tối thiểu create/list/find rồi update/delete, sau đó validation/advice. Giữ SQL ngoài controller; bài memory chỉ dùng hợp đồng repository.

## Đối chiếu

[Solution](solution/README.md) là project tham chiếu độc lập. Không cần chạy starter và solution cùng lúc vì cùng port 8080. Dữ liệu mất khi dừng process; id chỉ có ý nghĩa trong lần chạy đó. Không thêm login, upload, pagination hay nhiều module vào bài CRUD đầu tiên.
