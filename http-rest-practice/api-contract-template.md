# Khung tự thiết kế một endpoint

Sao chép khung này cho từng nghiệp vụ. Không có method/URL/status đã điền sẵn.

## Nghiệp vụ và resource
- Người gọi muốn đạt điều gì: TODO
- Resource/representation liên quan: TODO
- Dữ liệu cần đọc/ghi; có cần Database không: TODO
- Ai được phép gọi; có cần kiểm tra chủ sở hữu không: TODO

## Request
- Method và lý do: TODO
- Path và ý nghĩa từng đoạn: TODO
- Path variables, kiểu và giới hạn: TODO
- Query parameters, mặc định, sort và pagination: TODO
- Headers bắt buộc/tùy chọn và lý do: TODO
- Body JSON và lý do từng field: TODO
- Field nào client không được tự quyết định: TODO
- Validate cú pháp, kiểu và nghiệp vụ: TODO

## Response
- Thành công: status + headers + JSON/body rỗng + lý do: TODO
- Input sai hoặc không hợp lệ: TODO
- Resource không tồn tại: TODO
- Chưa xác thực/không đủ quyền: TODO
- Xung đột trạng thái/dữ liệu: TODO
- Dạng error body nhất quán; không lộ dữ liệu nhạy cảm: TODO

## Khi gọi lặp lại hoặc đồng thời
- Method safe không, vì sao: TODO
- Intended effect có idempotent không, vì sao: TODO
- Retry sau timeout có thể tạo/trừ dữ liệu hai lần không: TODO
- Cần idempotency key, version/ETag hoặc transaction không; lý do: TODO

## Ba ca tự kiểm tra
1. Luồng thành công: TODO
2. Input/quyền sai: TODO
3. Lặp request hoặc xung đột trạng thái: TODO

Hoàn thành khung rồi giải thích contract cho một người chưa đọc code backend.
