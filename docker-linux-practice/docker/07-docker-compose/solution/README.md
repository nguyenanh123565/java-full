# Đối chiếu — Compose: mô tả app và DB cùng nhau

DB healthcheck healthy cho phép app được tạo; JVM vẫn cần thời gian start, nên đợi log Started rồi gửi curl. HTTP count thành công kiểm tra thêm server route, datasource, driver, table và query. pg_isready không thay kiểm tra nghiệp vụ. Compose chỉ là công cụ chạy các service học tập trên một môi trường.

Đối chiếu với output thật; nếu chưa chạy môi trường tương ứng, ghi rõ đây là dự đoán chứ chưa phải kết quả kiểm tra.
