# Quan hệ one-to-one và owning side

## 1. Problem — vì sao cần khái niệm này?
Một product có thể có một detail riêng; nếu chỉ thêm hai object reference mà không có FK/unique constraint thì database không bảo đảm one-to-one.

## 2. Mental model
Bên chứa FK là owning side, dùng @JoinColumn. Bên còn lại dùng mappedBy với tên field Java của owning side. UNIQUE trên FK mới giới hạn một detail cho mỗi product.

## 3. Ví dụ nhỏ
ProductDetail.product có product_id UNIQUE; Product.detail dùng mappedBy="product". mappedBy không phải tên cột product_id.

Đọc [demo](demo/README.md); ghi dự đoán SQL trước khi chạy.

## 4. Liên hệ kiến thức đã học
Java Core: hai reference cần được đồng bộ trong bộ nhớ; SQL: FK + UNIQUE; HTTP: nên trả DTO để không serialize Product ↔ Detail thành vòng lặp.

## 5. Những lỗi thường gặp
Đặt @JoinColumn ở cả hai bên rồi tạo hai liên kết khác nhau; mappedBy dùng tên cột; nghĩ inverse one-to-one LAZY luôn tránh query phụ.

## 6. Câu hỏi tự kiểm tra
Nếu chỉ set Product.detail mà không set ProductDetail.product thì FK lấy từ đâu? Điều gì bảo đảm không có hai detail cùng product?

## 7. Exercise
Thiết kế ProductDetail riêng với FK UNIQUE trên giấy và trong bản sao lab mới; xác định owning side và thử lưu chỉ phía inverse.

Làm [exercise](exercise/README.md), ghi [notes](notes.md), sau đó mới mở [solution](solution/README.md).
