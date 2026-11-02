# Checklist project — ghi bằng chứng cạnh mỗi mục

- [ ] Tôi giải thích input → Java object → lưu trữ → output mà không đọc code.
- [ ] Tôi dự đoán một case trước khi chạy và ghi lý do kết quả khác dự đoán.
- [ ] CRUD phân biệt ID thiếu, input sai và lỗi hệ thống.
- [ ] Giá dùng BigDecimal; validation nhất quán; có case biên.
- [ ] Nếu có HTTP: method, status, header và DTO có contract rõ.
- [ ] Nếu có SQL: parameter đúng; FK/CHECK/transaction không chỉ dựa vào Java.
- [ ] Nếu có JDBC: Connection/Statement/ResultSet đóng đúng; rollback khi lỗi.
- [ ] Nếu có JPA: tôi đọc SQL log; hiểu owning side, fetch và N+1.
- [ ] Nếu có auth: owner và role được kiểm; 401/403 phân biệt đúng.
- [ ] Test hành vi có thể đỏ khi cố tình đưa bug vào; hiểu giới hạn mock.
- [ ] README ghi lệnh chạy, env cần thiết, dữ liệu demo, điều chưa triển khai.
- [ ] Commit nhỏ, không chứa mật khẩu hay target; tự review diff trước commit.

Chỉ đánh dấu các mục áp dụng cho chặng hiện tại. TODO — Ghi một bằng chứng cho mỗi
mục đã đánh dấu; vì sao mục còn lại chưa áp dụng? Liên hệ Java/HTTP/SQL ở chặng sau.
