# Repository và truy cập dữ liệu

## 1. Problem — vì sao cần khái niệm này?
DAO JDBC phải lặp CRUD nhiều lần. Repository cho phép mô tả thao tác dữ liệu theo entity, nhưng nghiệp vụ vẫn cần service.

## 2. Mental model
JpaRepository<Product, Long> là contract; Spring tạo proxy lúc khởi động. Derived method phân tích tên method, @Query khai báo query cụ thể. Repository không phải một collection trong memory.

## 3. Ví dụ nhỏ
findById trả Optional<Product>; findAllByOrderByIdAsc đọc danh sách có thứ tự; save entity mới khác cập nhật một entity đang managed.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: generic, interface, Optional; JDBC DAO: caller nhận object thay ResultSet; HTTP: service chuyển not-found thành kết quả để controller quyết định status.

## 5. Những lỗi thường gặp
Tên method sai property; đặt business rule trong repository; gọi findAll cho bảng lớn không nghĩ phân trang; coi save là commit transaction ngay.

## 6. Câu hỏi tự kiểm tra
Repository implementation ở đâu? Vì sao List rỗng và database connection lỗi là hai kết quả khác nhau?

## 7. Exercise
Thêm method findByName trong bản sao lab; dự đoán SQL và kết quả với tên trùng, không có tên, tên có dấu nháy.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
