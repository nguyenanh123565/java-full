# Bài tổng hợp: bảo vệ Product API bằng test

Tái sử dụng API tự làm ở Spring, chưa thêm framework mới.

1. TODO — Unit: validation ở service; tồn tại/không tồn tại; không gọi repo với ID sai.
2. TODO — MVC: route, JSON, 200/201/204/400/404; mapping exception.
3. TODO — Integration: nếu dùng JDBC/JPA, CRUD với DB học riêng, rollback khi lỗi.
4. TODO — Dự đoán một bug mỗi lớp trước khi chạy; chứng minh ít nhất một test bắt được bug.
5. TODO — Vì sao test mock repository xanh chưa chứng minh transaction đúng?

Xem [demo](demo/README.md), tự làm [exercise](exercise/README.md);
lời giải lý luận riêng ở
[solution](solution/README.md); ghi trải nghiệm vào [notes](notes.md).
