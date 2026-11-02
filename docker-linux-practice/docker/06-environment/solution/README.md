# Đối chiếu — Environment trong Compose: cấu hình kết nối

localhost trong app container chỉ chính app container; DB là service db. POSTGRES_* là hướng dẫn initialize của image khi data directory mới; role trong DB cũ phải quản lý bằng SQL thích hợp, không bằng đổi env rồi kỳ vọng tự cập nhật. Demo giữ cấu hình giả nhất quán và không hướng dẫn reset/xóa dữ liệu.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
