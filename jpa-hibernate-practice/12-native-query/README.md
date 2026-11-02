# Native SQL trong repository

## 1. Problem — vì sao cần khái niệm này?
Đôi khi cần chức năng PostgreSQL hoặc SQL cụ thể khó diễn đạt bằng JPQL. Có thể dùng native query, nhưng phải hiểu schema và kiểu kết quả.

## 2. Mental model
@Query(nativeQuery=true) gửi SQL theo table/column thật. Mức phụ thuộc database tăng; mapping kết quả phải phù hợp method return type.

## 3. Ví dụ nhỏ
select count(*) from learning_jpa.products where price >= :minimum trả long. Native query không có nghĩa được phép nối input.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
SQL PostgreSQL là nền tảng trực tiếp; JDBC từng bind tham số bằng PreparedStatement; Java long chứa count; HTTP chỉ thấy DTO/kết quả, không cần biết query implementation.

## 5. Những lỗi thường gặp
Dùng tên entity trong native SQL; lấy thiếu cột mà vẫn trả Product entity; nghĩ native query tự cập nhật mọi managed object sau bulk update; nối dữ liệu chưa tin vào SQL.

## 6. Câu hỏi tự kiểm tra
Đổi table name có ảnh hưởng native query không? Vì sao count projection đơn giản hơn map entity thiếu cột?

## 7. Exercise
So sánh count giá tối thiểu bằng SQL thuần và repository native query trong bản sao lab; dự đoán với bảng rỗng.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
