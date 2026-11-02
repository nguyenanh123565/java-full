# Demo định hướng mini project JPA/Hibernate

Đọc [yêu cầu](../README.md) và [hướng dẫn chạy reference](../solution/README.md). Demo là một phiên nhỏ: thêm dữ liệu → đọc lại → tìm id → sửa → xóa → xác nhận không còn. Chỉ dùng database học mới nêu trong README workspace.

Dự đoán trước khi chạy: mỗi bước phát SQL nào và tác động bao nhiêu hàng? Vì sao not-found khác lỗi kết nối? Liên hệ Java Core (object/Optional/exception), SQL (PK/WHERE/constraint) và HTTP (nếu chuyển thành API thì response nào phù hợp).

Reference chứa implementation; nếu bạn đang tự làm thì chỉ đọc contract và hướng dẫn môi trường, chưa mở source solution. Workspace này chưa tự setup database hoặc tải dependency.
