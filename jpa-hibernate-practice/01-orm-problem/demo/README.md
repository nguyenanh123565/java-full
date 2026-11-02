# Demo — Vấn đề ORM giải quyết

Đây là một trích đoạn Java có ngữ cảnh, không phải ứng dụng độc lập. Đọc [example.java.txt](example.java.txt) cùng code tương ứng trong [console reference](../../mini-project/solution/README.md). Không javac file .txt. Khi cần thực hành thay đổi, tạo bản sao lab riêng; các snippet entity độc lập cần đủ @Entity, @Id, constructor và schema tương ứng trước khi chạy.

Baseline: Java 17 + Boot 3.5.16, jakarta.persistence. Chuẩn bị database học mới và biến môi trường theo README reference khi bạn quyết định chạy; không chạy setup trên database cũ.

## Quan sát có thể kiểm chứng

Chạy find với một id do add trả về. Quan sát SELECT theo PK. Lặp find trong cùng persistence context có thể không phát thêm SELECT; không kết luận rằng mọi find luôn truy vấn DB.

TODO trước khi chạy: ghi số SELECT/INSERT/UPDATE/DELETE dự đoán. Sau chạy: ghi SQL thật, giá trị bind đã lược bỏ secret và kết quả SELECT kiểm chứng. Vì sao SQL xuất hiện ở thời điểm đó? Liên hệ lại code JDBC tương đương.
