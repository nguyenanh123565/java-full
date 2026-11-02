# JPA, Hibernate và Spring Data JPA

## 1. Problem — vì sao cần khái niệm này?
Ba tên thường xuất hiện cùng nhau nên dễ tưởng chúng đều là database hoặc ba ORM độc lập cần học thuộc annotation.

## 2. Mental model
JPA là đặc tả/API persistence Java; Hibernate là provider triển khai JPA; Spring Data JPA xây repository abstraction trên JPA; JDBC là API kết nối thấp hơn; PostgreSQL là database server.

## 3. Ví dụ nhỏ
Application gọi ProductRepository.findById → proxy Spring Data JPA → EntityManager (JPA API) → Hibernate → JDBC driver → PostgreSQL.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: interface/implementation; JDBC: interface Connection và driver implementation là phép so sánh hữu ích nhưng không đồng nhất với JPA. HTTP vẫn do web layer xử lý, không phải Hibernate.

## 5. Những lỗi thường gặp
Nói JPA là database; nghĩ Spring Data JPA trực tiếp gửi SQL qua HTTP; coi Hibernate và JPA là hai dependency nghiệp vụ phải gọi đồng thời.

## 6. Câu hỏi tự kiểm tra
Nếu đổi provider JPA, đặc tả nào giữ nguyên? Nếu dùng EntityManager trực tiếp có bắt buộc Spring Data repository không?

## 7. Exercise
Vẽ luồng từ repository đến PostgreSQL, ghi mỗi lớp giải quyết vấn đề gì. Đối chiếu với JDBC tuần trước.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
