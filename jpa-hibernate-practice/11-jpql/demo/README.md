# Demo — JPQL và entity query

Đây là một trích đoạn Java có ngữ cảnh, không phải ứng dụng độc lập. Đọc [example.java.txt](example.java.txt) cùng code tương ứng trong [console reference](../../mini-project/solution/README.md). Không javac file .txt. Khi cần thực hành thay đổi, tạo bản sao lab riêng; các snippet entity độc lập cần đủ @Entity, @Id, constructor và schema tương ứng trước khi chạy.

Baseline: Java 17 + Boot 3.5.16, jakarta.persistence. Chuẩn bị database học mới và biến môi trường theo README reference khi bạn quyết định chạy; không chạy setup trên database cũ.

## Quan sát có thể kiểm chứng

Thêm method trên trong bản sao ProductRepository rồi gọi từ service read-only, xem SQL sinh ra. Thử ngưỡng bằng giá một sản phẩm để kiểm tra >= thay vì >.

TODO trước khi chạy: ghi số SELECT/INSERT/UPDATE/DELETE dự đoán. Sau chạy: ghi SQL thật, giá trị bind đã lược bỏ secret và kết quả SELECT kiểm chứng. Vì sao SQL xuất hiện ở thời điểm đó? Liên hệ lại code JDBC tương đương.
