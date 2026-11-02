# Đối chiếu sau khi tự làm — Kiểm các thành phần ghép thật

HTTP test dùng app Map thật nên kiểm wiring/MVC qua TCP. JdbcIntegrationTest kiểm driver và SQL thật khi bật TEST_DB_URL; transaction rollback giữ DB học sạch.

Kiểm lại dự đoán với demo. Một lời giải đạt yêu cầu phải nêu input cụ thể,
expected độc lập và ranh giới test. Không chỉ viết “test pass”.
