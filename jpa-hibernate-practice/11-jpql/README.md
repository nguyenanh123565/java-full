# JPQL và entity query

## 1. Problem — vì sao cần khái niệm này?
Derived method dài khó đọc khi điều kiện phức tạp. Cần một ngôn ngữ query theo entity và thuộc tính Java.

## 2. Mental model
JPQL dùng tên entity và field Java, Hibernate dịch sang SQL cho database. Parameter binding vẫn cần thiết. Fetch join tải quan hệ cho use case, không biến JPQL thành SQL thuần.

## 3. Ví dụ nhỏ
select p from Product p where p.price >= :minimum order by p.id. Product là entity, price là field; learning_jpa.products là tên SQL và không đặt vào vị trí entity.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
JDBC: PreparedStatement dùng ?, JPQL thường dùng :minimum; SQL WHERE/ORDER BY vẫn là mental model nền. HTTP query minPrice cần parse/validate trước khi gọi repository.

## 5. Những lỗi thường gặp
Dùng tên table trong JPQL; nối input vào JPQL string; nghĩ join và join fetch giống nhau; đặt SELECT * trong JPQL entity query.

## 6. Câu hỏi tự kiểm tra
JPQL trả entity hay ResultSet? WHERE p.category.name có thể cần join gì? Parameter có thay được entity name không?

## 7. Exercise
Thêm JPQL lọc giá tối thiểu vào bản sao repository; so sánh query và kết quả với JDBC PreparedStatement tương đương.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
