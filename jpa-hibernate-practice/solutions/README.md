# Chỉ mục đối chiếu JPA

Mỗi lesson có `solution/README.md` riêng. [Console reference](../mini-project/solution/README.md) là một lời giải nhỏ cho bài Product/Category, không triển khai tất cả quan hệ trong một ứng dụng lớn.

Đối chiếu tổng hợp: Product.category sở hữu FK, Category.products mappedBy="category"; không cascade REMOVE sang category dùng chung. DTO được map trong transaction. list có thể gặp query phụ; list-details fetch join chỉ quan hệ cần cho response. Transaction bao nghiệp vụ; fail-add ném RuntimeException để rollback.

OrderItem là entity có quantity/price nên không chỉ là hàng quan hệ ManyToMany không thuộc tính. Hãy tự viết DDL, entity và transaction tạo order ở bài project tổng hợp sau này; chưa mở rộng lab thành production.
