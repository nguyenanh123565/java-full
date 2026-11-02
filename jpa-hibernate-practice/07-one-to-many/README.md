# One-to-many và many-to-one

## 1. Problem — vì sao cần khái niệm này?
Một category chứa nhiều product, nhưng FK nằm trong mỗi hàng products. Hướng duyệt object và nơi lưu FK là hai việc khác nhau.

## 2. Mental model
Product.category @ManyToOne + @JoinColumn(category_id) sở hữu FK. Category.products @OneToMany(mappedBy="category") là phía inverse. Helper method đồng bộ cả hai reference.

## 3. Ví dụ nhỏ
category.addProduct(product) thêm vào collection và set product.category = category. Mỗi product chỉ có một category_id trong schema hiện tại.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: List chứa object reference; SQL: products.category_id FK; JDBC: join cùng khóa; HTTP: DTO product có categoryName thay vì trả cả collection entity.

## 5. Những lỗi thường gặp
Chỉ add vào list inverse; mappedBy="category_id"; mặc định mọi cascade; đọc collection ngoài transaction rồi lỗi lazy loading.

## 6. Câu hỏi tự kiểm tra
Bên nào đổi category_id? Vì sao chỉ sửa collection inverse có thể không đổi FK? Collection rỗng khác category chưa được load thế nào?

## 7. Exercise
Tạo hai category và ba product bằng lab; chuyển một product giữa hai category trong bản sao service, đồng bộ hai phía và kiểm tra FK bằng SQL.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
