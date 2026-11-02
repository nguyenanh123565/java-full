# 09 — PRIMARY KEY và định danh dòng

## Khái niệm giải quyết vấn đề gì?

PRIMARY KEY giúp xác định duy nhất một dòng. API `GET /products/{id}` cần biết ID chỉ ứng với một sản phẩm. Khóa chính không được NULL và không được trùng; mỗi bảng có tối đa một PRIMARY KEY, nhưng khóa đó có thể gồm nhiều cột.

## SQL hoạt động như thế nào?

PostgreSQL kiểm tra các cột khóa chính không NULL và tổ hợp giá trị duy nhất; một unique index hỗ trợ kiểm tra tính duy nhất. PRIMARY KEY không tự sinh ID. Cột identity sinh số tự động là cơ chế riêng, và sequence có thể có khoảng trống.

Khóa ghép `(user_id, product_id)` trong một giỏ hàng nghĩa là mỗi user có tối đa một dòng cho một sản phẩm. Từng user_id hoặc product_id riêng lẻ vẫn có thể lặp. Trong schema chính, `order_items` dùng `id` làm PK và `UNIQUE (order_id, product_id)` để bảo vệ quy tắc một sản phẩm chỉ có một dòng trong mỗi đơn.

## Ví dụ

```sql
CREATE TEMP TABLE lesson_cart_key (
    user_id BIGINT,
    product_id BIGINT,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    PRIMARY KEY (user_id, product_id)
) ON COMMIT DROP;
```

Trong transaction của demo, đoán ba tổ hợp `(1,1)`, `(1,2)`, `(2,1)` có hợp lệ đồng thời không. Sau đó đoán vì sao thêm `(1,1)` lần nữa bị từ chối.

## Lỗi người mới hay mắc

- Nghĩ PRIMARY KEY mặc định tự tăng.
- Dùng tên người dùng làm khóa chính dù tên có thể trùng và thay đổi.
- Nghĩ khóa ghép cấm lặp từng cột riêng lẻ.
- Dùng thứ tự dòng trên màn hình như định danh dòng.
- Coi ID liên tục là yêu cầu của khóa chính và cố lấp khoảng trống.

## Câu hỏi kiểm tra hiểu biết

1. PRIMARY KEY bảo đảm những điều kiện nào?
2. PRIMARY KEY khác identity ở đâu?
3. Vì sao `(1,1)` và `(1,2)` hợp lệ trong PK ghép `(user_id, product_id)`?
4. Vì sao order_items vẫn cần UNIQUE(order_id, product_id) dù đã có id PRIMARY KEY?
5. ID 1, 3, 8 có vi phạm tính chất khóa chính không?

## Ba bài tập từ dễ đến khó

1. Tạo bảng tạm dùng ID cấp thủ công làm PK và ghi hai dòng; phân biệt định danh với tự tăng.
2. Mô tả INSERT trùng ID và ID NULL bằng comment; dự đoán constraint từ chối từng trường hợp.
3. Tạo bảng giỏ hàng PK ghép, ghi ba tổ hợp hợp lệ; giải thích vì sao cần UNIQUE nghiệp vụ bên cạnh PK đơn cột của order_items.

Đối chiếu riêng tại `../solutions/09-primary-key.sql`.
