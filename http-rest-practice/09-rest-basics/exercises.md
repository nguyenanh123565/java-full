# Bài tập 09 — REST basics

## 1. Dễ — Resource và representation

Hệ thống có users, products, orders và một báo cáo tổng doanh thu.

TODO:
- Chọn ba resource, mô tả identity và representation.
- Phân tích một resource không khớp duy nhất một bảng.
- Giải thích vì sao JSON không phải bản thân resource.

## 2. Vừa — Đọc dữ liệu kiểu RPC

API hiện tại:

```http
POST /getProduct?id=10
```

TODO:
- Nhận xét giao kèo hiện tại và các giả định bạn phải hỏi lại.
- Đề xuất method/URL theo tài nguyên nếu đây là thao tác chỉ đọc.
- Giải thích thay đổi về ngữ nghĩa; cho biết body có cần không.

## 3. Khó — Kiểm tra các ràng buộc

API có URL danh từ và trả JSON. Client phải gọi một endpoint chọn user, sau đó endpoint lấy orders dùng “user đang được chọn” trong session. Không có liên kết hướng dẫn client chuyển trạng thái. Response nào cũng không mô tả chính sách cache.

TODO:
- Phân tích từng ràng buộc REST có liên quan.
- Đề xuất cách gửi đủ ngữ cảnh trong mỗi request.
- Giải thích API theo tài nguyên và REST đầy đủ khác nhau ở điểm nào.
