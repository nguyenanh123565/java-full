# Solution tham khảo — 10 Thiết kế API

Các endpoint là giao kèo mẫu để đối chiếu, không phải CRUD đã chạy trong lab.

## 1. Đọc products

- `GET /products`: danh sách có pagination; `200` dù rỗng.
- `GET /products/42`: `200` hoặc `404`.
- `GET /products?name=robot`: công bố match chứa chuỗi và quy tắc hoa/thường.
- `GET /products?category=robot&minPrice=5000000&maxPrice=12000000`: query là tiêu chí lọc; quy định category dùng slug, price dùng VND và min không lớn hơn max. Query sai trả `400` theo giao kèo.

Một dạng response collection: `{"items":[...],"page":0,"size":20,"total":25}`. Quy định thứ tự ổn định trước pagination.

## 2. Sửa products

`POST /products` nhận name/price/stock/categoryId; `201`, Location tới URI mới. `PUT /products/42` thay thế toàn bộ trường client quản lý; id và createdAt read-only. Thiếu trường bắt buộc bị từ chối theo giao kèo.

`PATCH /products/42` với JSON Merge Patch `{"stock":8}` chỉ đặt stock; các trường vắng mặt giữ nguyên, stock null không hợp lệ. Phải implement đúng định dạng nếu công bố media type này. `DELETE /products/42` có thể trả `204`; quy định xử lý product đã dùng trong orders, chẳng hạn từ chối `409` hoặc chuyển sang trạng thái archived theo mô hình khác.

Success sửa có thể `200` kèm representation hoặc `204` không body. Giá/stock âm có thể `422`; media type không hỗ trợ `415`. Nhất quán và ghi rõ quan trọng hơn đoán một status duy nhất cho mọi validation.

## 3. Orders

`GET /users/12/orders` cần xác thực và kiểm tra quyền truy cập user 12. Không tin id ở URL là danh tính đã xác thực.

Một mô hình: `PATCH /orders/73` với body `{"status":"cancelled"}` theo giao kèo sửa đã mô tả. Chỉ pending được chuyển sang cancelled; đã cancelled trả thành công cùng trạng thái, paid/shipped trả `409`. Cần kiểm tra/chuyển trạng thái nguyên tử để tránh cạnh tranh; có thể thêm ETag/If-Match khi học tiếp.

Mô hình khác là `POST /orders/73/cancellations` tạo resource hủy với idempotency key theo giao kèo. Quyền và lịch sử phải được giữ trong cả hai mô hình. Chưa xác thực thường `401` với WWW-Authenticate; thiếu quyền `403`, hoặc `404` theo chính sách che giấu resource.
