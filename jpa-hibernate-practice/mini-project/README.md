# Mini project — Product / Category persistence lab

Tái sử dụng Java Core, SQL, JDBC, Maven và Spring DI. Mục tiêu là hiểu mapping + transaction + SQL, chưa thêm HTTP hoặc Security để giữ phạm vi nhỏ.

## Yêu cầu tự làm

- CRUD product; category có id/name, product có id/name/price/stock/category optional.
- FK nằm ở products.category_id; giải thích owning side và mappedBy.
- Service validate input, transaction cho cập nhật; không cascade xóa category dùng chung.
- CLI chỉ parse args và hiển thị DTO. Không đưa entity còn lazy ra ngoài service.
- Có lệnh chứng minh rollback và hai cách list để so sánh N+1/fetch join.
- Chỉ dependency data-jpa + pg driver; Java 17, jakarta.persistence.

Làm [starter](starter/README.md) trước. Dự đoán SQL trước mỗi lần chạy. Vì sao mọi setter không tự cập nhật DB? Liên hệ managed entity với mapper JDBC, và SQL FK với object reference. Sau khi hoàn thành xem [reference chạy được](solution/README.md).

## Checklist

- [ ] Add/list/find/update/delete chạy trên database học mới.
- [ ] Không tìm thấy khác lỗi truy cập dữ liệu; price/stock âm bị từ chối.
- [ ] Đọc code lẫn SQL để giải thích entity ↔ row.
- [ ] Rollback không để hàng mới sau lỗi có chủ đích.
- [ ] Dùng ba category khác nhau để đo N+1 rồi fetch join.
- [ ] Giải thích được Application → Spring Data JPA → JPA → Hibernate → JDBC → PostgreSQL.
