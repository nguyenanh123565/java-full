# Đối chiếu — Image: các lớp filesystem và cấu hình khởi chạy

Multi-stage chỉ copy JAR từ build stage; runtime stage dựa trên JRE và không tự chứa source/cache Maven. Code đổi cần build artifact/image mới; restart container cũ chỉ chạy image cũ. Tag mutable nên bài học chọn mốc version rõ nhưng không khẳng định tuyệt đối tái lập như digest.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
