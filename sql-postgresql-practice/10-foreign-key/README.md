# 10 — FOREIGN KEY và dữ liệu tham chiếu

## Khái niệm giải quyết vấn đề gì?

FOREIGN KEY bảo đảm một giá trị tham chiếu tới dòng cha có thật. Sản phẩm có category_id cần thuộc một category tồn tại; đơn hàng có user_id cần thuộc một user có thật. Nhờ vậy database không lưu dòng hàng tham chiếu sản phẩm đã biến mất hoặc đơn hàng gắn với user không tồn tại.

## SQL hoạt động như thế nào?

PostgreSQL kiểm tra giá trị FK khi INSERT/UPDATE bảng con và khi sửa/xóa khóa được tham chiếu ở bảng cha. Cột đích cần PRIMARY KEY hoặc một khóa UNIQUE phù hợp. FK không tự JOIN dữ liệu; bạn vẫn phải viết SELECT/JOIN khi muốn lấy tên category.

FK không tự cấm NULL: nếu quan hệ bắt buộc cần thêm `NOT NULL`. Trong schema chính, mọi FK đều NOT NULL. Với `ON DELETE RESTRICT`, xóa cha đang có con sẽ bị từ chối. Các chính sách khác như CASCADE có thể tự xóa con; cần cân nhắc nghiệp vụ trước khi dùng, nhất là dữ liệu lịch sử đơn hàng.

PostgreSQL tự tạo index hỗ trợ PK/UNIQUE ở phía cha, nhưng không tự tạo index cho cột FK ở phía con. Constraint và tối ưu truy vấn là hai việc khác nhau; bài index sẽ quay lại điểm này.

## Ví dụ

```sql
category_id BIGINT NOT NULL
    REFERENCES lesson_fk_categories(id) ON DELETE RESTRICT
```

Trong demo, category được thêm trước product. Đoán vì sao thứ tự ngược lại không hợp lệ nếu FK được kiểm tra ngay, và vì sao FK không bảo đảm một category phải có ít nhất một product.

## Lỗi người mới hay mắc

- Ghi ID cha chưa tồn tại và nghĩ chỉ cần cùng kiểu BIGINT là được.
- Nghĩ FK tự sinh dòng cha hoặc tự tải dữ liệu cha.
- Nghĩ FK tự tạo index ở bảng con.
- Quên NOT NULL khi muốn bắt buộc mỗi product có category.
- Dùng CASCADE mà không hiểu phạm vi dữ liệu có thể bị xóa.

## Câu hỏi kiểm tra hiểu biết

1. FK bảo vệ phía con và phía cha trong những thao tác nào?
2. Vì sao thường phải INSERT category trước product?
3. Một category chưa có product có vi phạm FK không?
4. FK có đủ để cấm category_id NULL không?
5. Vì sao FK không thay thế JOIN hoặc index ở phía con?

## Ba bài tập từ dễ đến khó

1. Tạo hai bảng tạm category/product có FK bắt buộc và ghi cha trước con.
2. Viết INSERT tham chiếu ID không tồn tại dưới dạng comment; giải thích vì sao bị từ chối.
3. Dự đoán xóa cha đang có con, rồi xóa con trước cha trên bảng tạm; giải thích khác biệt RESTRICT và CASCADE.

Đối chiếu riêng tại `../solutions/10-foreign-key.sql`.
