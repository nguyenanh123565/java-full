# Entity, table, field và column

## 1. Problem — vì sao cần khái niệm này?
Database có hàng với primary key; object Java có field. ORM cần metadata để biết class và field nào đại diện dữ liệu nào.

## 2. Mental model
@Entity đánh dấu class được ORM quản lý; @Table chọn bảng; @Id là identity; @Column mô tả cột. Annotation cung cấp metadata, Hibernate đọc metadata rồi thực hiện mapping.

## 3. Ví dụ nhỏ
Product.name ↔ learning_jpa.products.name. Hai object tham chiếu tới cùng id trong một persistence context thường được thống nhất thành một managed instance.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: constructor, field và access modifier; SQL: tên bảng/cột, NOT NULL, NUMERIC; HTTP: entity không phải request DTO và annotation JPA không tự validate JSON input.

## 5. Những lỗi thường gặp
Thiếu constructor không tham số; dùng javax.persistence trong baseline Boot 3; dùng entity làm JSON tạo vòng lặp; dùng @Column(nullable=false) thay cho kiểm tra dữ liệu người dùng.

## 6. Câu hỏi tự kiểm tra
@Entity có tự tạo HTTP endpoint không? Constructor protected không tham số phục vụ ai? @Table có tự tạo database mới không?

## 7. Exercise
Map class Book của riêng bạn sang table/column trên giấy; thêm một field có tên Java khác tên SQL trong bản sao lab và kiểm chứng bằng SQL log.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
