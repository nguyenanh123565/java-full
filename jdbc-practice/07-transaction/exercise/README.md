# Bài tập — Transaction, commit và rollback

TODO: Mô phỏng hai lần ghi: chạy một lần cố ý lỗi và một lần thành công. Chứng minh bằng SELECT sau mỗi lần. Vẽ vị trí commit/rollback.

1. Dự đoán trước khi chạy: ghi kết quả, số dòng bị ảnh hưởng hoặc số câu SQL mong đợi.
2. Tạo ví dụ nhỏ của riêng bạn trong thư mục này; không chép demo nguyên vẹn.
3. Chạy trên môi trường học riêng theo README workspace. Ghi lệnh, kết quả thực tế và điểm khác dự đoán.
4. Vì sao hành vi đó xảy ra? Trả lời bằng luồng xử lý, không chỉ tên annotation/API.
5. Liên hệ kiến thức cũ: Java Core: try/catch và exception quyết định đường thoát. SQL: atomicity và constraint. HTTP: một request tạo đơn cần một transaction nghiệp vụ, không phải commit từng repository call.
6. TODO: thêm một trường hợp lỗi, ghi cách tái hiện và nguyên nhân trước khi sửa.

Không có đáp án trong thư mục này. Kết quả khác dự đoán là dữ liệu để học.
