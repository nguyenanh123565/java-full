# Đối chiếu — Container: process với môi trường tách biệt

App và DB là hai process/container; JVM nằm ở app, table do PostgreSQL quản lý và lưu trên volume. Image chưa phải process. Dừng/restart app không xóa named DB volume. Cấu hình kết nối và network vẫn cần đúng dù code không đổi.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
