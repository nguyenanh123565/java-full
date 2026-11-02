# Starter security — bài chưa giải

Có POM web+security và main; controller/config chỉ là TODO. Nếu chạy ngay, auto-configuration Security sẽ áp mặc định và user/password sinh tạm trong log; đó chưa phải lời giải đề bài. Không dùng tài khoản mặc định làm kết quả hoàn thành.

- TODO: Cài GET products, GET me theo principal, POST products với list memory nhỏ.
- TODO: Cài PasswordEncoder BCrypt và in-memory USER/ADMIN; đưa password demo qua environment.
- TODO: Lập SecurityFilterChain theo ma trận; formLogin và session; giữ CSRF bật.
- TODO: Hỗ trợ lấy CSRF token để tự gửi unsafe request hoặc dùng form mặc định trước.
- TODO: Dự đoán trước khi chạy các request khách/USER/ADMIN, thiếu token và sau logout. Vì sao thiếu CSRF có thể làm bài kiểm tra role bị hiểu sai?
- TODO: Liên hệ Java constructor/bean và HTTP Cookie; phác SQL users/password_hash không triển khai DB ở đây.

Khi đã có Maven 3.6.3+ và JDK 17–25, tự chạy `mvn spring-boot:run` trong thư mục này. Không có lệnh tự cài, không có solution nhúng trong starter.
