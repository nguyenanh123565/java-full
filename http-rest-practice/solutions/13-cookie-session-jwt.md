# Solution tham khảo — 13 Cookie / session / JWT

## 1. Ba chiều

Cookie và Authorization là các cách mang dữ liệu request. JWT là định dạng token; session id thường là giá trị tham chiếu tới state server. Một hệ thống có thể gửi JWT trong cookie, hoặc session id trong cookie, hoặc JWT trong Authorization. Không phải cách kết hợp nào cũng có cùng đặc điểm XSS/CSRF và thu hồi.

## 2. Session

Một thiết kế: `POST /sessions` qua HTTPS với credentials → server xác thực, tạo session id khó đoán, lưu owner/thời hạn server → `201` cùng Set-Cookie HttpOnly/Secure/SameSite phù hợp. Browser gửi cookie theo policy cho request tiếp theo; backend tra session rồi kiểm tra quyền.

Logout có thể `DELETE /sessions/current`: server hủy session, response xóa cookie cùng scope Path/Domain; `204` không body. Cookie mẫu `sid=; Path=/; Max-Age=0; HttpOnly; Secure; SameSite=Lax`. Session store có thể database hoặc nơi khác; không bắt buộc framework.

Cookie tự gửi nên thao tác thay đổi dữ liệu cần thiết kế chống CSRF phù hợp, chẳng hạn CSRF token kiểm tra server và kiểm tra Origin theo policy, cùng SameSite. HttpOnly không ngăn script độc hại gửi request với cookie tự kèm.

## 3. JWT

Decode chỉ đọc claims; verify kiểm tra bảo vệ mật mã theo thuật toán/key đáng tin. Còn cần thời hạn/issuer/audience và authorization.

Một policy là access token ngắn hạn: giảm cửa sổ token còn dùng được nhưng không thu hồi ngay. Policy khác là kiểm tra trạng thái khóa/token version hoặc danh sách revocation ở backend; có thể thu hồi sớm hơn nhưng thêm state/lookup. Refresh token cũng cần lifecycle riêng. Nếu yêu cầu khóa ngay, phải xác định độ trễ cho phép và không chỉ chờ exp.

Không đưa password/hash vào token. Token ký không che payload. Không tự viết cryptography cho bài này.
