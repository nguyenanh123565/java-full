# Đối chiếu — Logs: bằng chứng về lúc app thực thi

Client chỉ nên nhận thông báo phù hợp; stack trace là dữ liệu chẩn đoán nội bộ. `docker compose logs app` đọc stdout/stderr của app; DB có log riêng. Lỗi connect có thể xảy ra ở client ngay cả khi DB không nhận request; lỗi SQL constraint thường chứng minh connection đã tới DB và câu lệnh được xử lý.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
