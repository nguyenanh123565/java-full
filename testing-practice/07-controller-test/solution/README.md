# Đối chiếu sau khi tự làm — Kiểm HTTP mapping với MockMvc

Kiểm 200 cùng JSON path và 404 cho exception đã map. standaloneSetup kiểm controller/advice đăng ký vào builder; integration kiểm wiring thật.

Kiểm lại dự đoán với demo. Một lời giải đạt yêu cầu phải nêu input cụ thể,
expected độc lập và ranh giới test. Không chỉ viết “test pass”.
