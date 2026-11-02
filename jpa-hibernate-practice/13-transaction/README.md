# Transaction, persistence context và dirty checking

## 1. Problem — vì sao cần khái niệm này?
Nhiều thao tác repository trong một nghiệp vụ phải cùng thành công hoặc cùng thất bại. Entity đang managed còn có thể tự phát UPDATE khi field thay đổi.

## 2. Mental model
@Transactional trên service tạo ranh giới transaction qua Spring proxy. Trong persistence context, Hibernate theo dõi managed entity; flush đồng bộ SQL, commit xác nhận. Flush khác commit. Default rollback khi RuntimeException/Error; checked exception cần cấu hình khi muốn rollback.

## 3. Ví dụ nhỏ
Service lấy product, gọi updateDetails, không cần save lại managed object; Hibernate phát UPDATE lúc flush. fail-add ném IllegalStateException để demo rollback.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
JDBC: setAutoCommit(false)/commit/rollback vẫn là nền tảng dưới transaction manager. Java Core: exception và method call; HTTP request nghiệp vụ nên được bao bởi service transaction, không giữ transaction trong thời gian client suy nghĩ.

## 5. Những lỗi thường gặp
Bắt lỗi rồi trả success; gọi @Transactional qua self-invocation và tưởng proxy được áp dụng; nghĩ readOnly=true cấm mọi ghi; xem SQL INSERT trong log là đã commit.

## 6. Câu hỏi tự kiểm tra
SQL đã chạy có thể rollback không? Entity detached sửa field có tự update không? Vì sao service là nơi đặt ranh giới nghiệp vụ?

## 7. Exercise
Chạy fail-add rồi SELECT kiểm tra không có hàng mới. Trong bản sao, đổi managed entity và so sánh SQL khi chỉ đọc. Giải thích flush/commit.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
