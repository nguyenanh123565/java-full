# Đối chiếu — Volume: dữ liệu có vòng đời riêng container

Named volume tách dữ liệu khỏi container, nên restart/recreate vẫn dùng row cũ nếu cùng volume/mount. Java List thuộc memory process nên mất khi process dừng. Volume vẫn có thể hỏng/xóa; cần backup riêng nếu dữ liệu quan trọng. Bài chỉ dùng dữ liệu giả, không có lệnh xóa volume.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
