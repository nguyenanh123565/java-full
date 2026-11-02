# Many-to-many và join table

## 1. Problem — vì sao cần khái niệm này?
Một product có nhiều tag và một tag dùng cho nhiều product. Một cột FK đơn không diễn đạt được quan hệ này.

## 2. Mental model
Cần bảng nối product_tags(product_id, tag_id), thường có PK ghép hoặc UNIQUE cặp FK. Owning side khai báo @JoinTable; phía inverse dùng mappedBy.

## 3. Ví dụ nhỏ
Product.tags sở hữu bảng nối; Tag.products mappedBy="tags". Thêm tag vào product nghĩa là thêm hàng bảng nối, không clone tag.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: Set tránh trùng reference theo equals/hashCode; SQL: junction table và khóa ghép; HTTP: request gửi tag ids, service tìm tag có sẵn.

## 5. Những lỗi thường gặp
CascadeType.REMOVE từ product sang tag dùng chung; cả hai phía đều sở hữu join table; đặt thuộc tính quantity trên quan hệ @ManyToMany không có entity nối.

## 6. Câu hỏi tự kiểm tra
Xóa product có nên xóa luôn tag của product khác không? Khi quan hệ có quantity hoặc created_at thì vì sao cần entity nối?

## 7. Exercise
Vẽ ba bảng products/tags/product_tags và map owning side. Nếu thêm quantity, đổi thiết kế sang entity nối trên giấy.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
