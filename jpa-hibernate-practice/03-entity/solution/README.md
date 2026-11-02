# Đối chiếu — Entity, table, field và column

Class/table, field/column, object/row là ba mức khác nhau. @Entity cần @Id và constructor no-arg. @Column mô tả mapping; CHECK constraint ở DB và validation ở service có trách nhiệm riêng.

So sánh với [demo](../demo/README.md) và kết quả SQL của bạn. Nếu kết quả khác, ghi dataset, persistence context còn sống hay đã đóng, transaction boundary và số category khác nhau trước khi kết luận framework lỗi.
