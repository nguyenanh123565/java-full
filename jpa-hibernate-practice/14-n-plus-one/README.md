# N+1 và fetch join có chủ đích

## 1. Problem — vì sao cần khái niệm này?
Một SELECT lấy danh sách nhưng mỗi lần đọc category.name lại phát một SELECT khác. Dataset nhỏ che chi phí round-trip; dataset lớn làm API chậm.

## 2. Mental model
Một query lấy N product + các query tải quan hệ theo từng category chưa được load. Thực tế first-level cache làm số query phụ phụ thuộc số category khác nhau, không luôn đúng N. Fetch join lấy đúng quan hệ cần trong cùng query.

## 3. Ví dụ nhỏ
Ba product thuộc ba category khác nhau: list có thể 1+3 SELECT; list-details với left join fetch p.category có một SELECT dữ liệu. Left join giữ product không có category.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: vòng lặp getter có thể phát I/O; JDBC: mỗi executeQuery có chi phí; SQL LEFT JOIN cần hiểu trước. HTTP list DTO product/categoryName là use case quyết định fetch plan.

## 5. Những lỗi thường gặp
Chữa bằng EAGER toàn bộ; đếm SQL startup; dùng cùng persistence context đã cache nên bỏ sót N+1; fetch join collection rồi phân trang mà không hiểu nhân bản hàng.

## 6. Câu hỏi tự kiểm tra
Nếu cả ba product cùng category, tại sao có thể chỉ 1+1 query? Vì sao left join fetch phù hợp category optional? Fetch join to-many có rủi ro gì khi paging?

## 7. Exercise
Tạo ít nhất ba category và ba product, mỗi product một category; dự đoán rồi đếm SELECT của list/list-details ở hai lần chạy app riêng. Giải thích chênh lệch.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
