# Cascade và vòng đời entity

## 1. Problem — vì sao cần khái niệm này?
Khi lưu/xóa một object, đôi khi cần lan thao tác sang object liên quan, đôi khi tuyệt đối không. Quan hệ có FK không tự đồng nghĩa cascade Java.

## 2. Mental model
CascadeType.PERSIST/MERGE/REMOVE lan thao tác EntityManager sang entity liên quan. Cascade JPA khác ON DELETE CASCADE của database. orphanRemoval xóa child bị tách khỏi quan hệ sở hữu phù hợp, không phải áp dụng cho mọi liên kết.

## 3. Ví dụ nhỏ
Order sở hữu vòng đời OrderItem có thể dùng cascade persist + orphanRemoval. Product không sở hữu vòng đời Category dùng chung nên reference không cascade REMOVE.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: reference không quyết định ownership vòng đời; SQL: FK và ON DELETE action riêng; HTTP DELETE product không có nghĩa tự động xóa category.

## 5. Những lỗi thường gặp
Dùng CascadeType.ALL mọi nơi; nhầm cascade với fetch; xóa category chung khi xóa product; coi orphanRemoval là xóa tất cả object không còn được Java tham chiếu.

## 6. Câu hỏi tự kiểm tra
Cascade PERSIST có làm quan hệ EAGER không? Nếu Product và Category dùng chung, ai được quyền xóa Category?

## 7. Exercise
Viết bảng vòng đời Order/OrderItem và Product/Category; chọn cascade nào cần và nêu trường hợp mất dữ liệu nếu chọn REMOVE sai.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
