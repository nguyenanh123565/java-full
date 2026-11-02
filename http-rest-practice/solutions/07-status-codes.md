# Đối chiếu 07 — Status codes

## Bài 1

Đọc thành công: 200 kèm JSON. Tạo: 201 và `Location: /products/27` theo contract ví dụ, có thể kèm representation mới. Xóa không trả dữ liệu: 204, body trống. Id không tồn tại: 404 kèm error body nếu contract có. Các status phân biệt dữ liệu được trả, resource được tạo và kết quả không có nội dung.

## Bài 2

Một quy ước: JSON sai → 400; thiếu credentials hợp lệ → 401 kèm WWW-Authenticate; thiếu quyền → 403; media type không hỗ trợ → 415; email trùng → 409; quantity không chấp nhận được dù JSON hợp lệ → 422. Dùng 400 cho validation thay 422 cũng có thể là contract của API, nhưng phải nhất quán. Các lỗi này không mặc nhiên là điều kiện bất ngờ phía server nên không gom thành 500.

## Bài 3

401 cần challenge, chẳng hạn `WWW-Authenticate: Bearer realm="shop-api"`. 204 phải bỏ body; không gửi JSON “deleted”. 405 cần `Allow` liệt kê methods thực sự được resource cho phép, chẳng hạn `Allow: GET, HEAD` khi chỉ đọc. Error body có thể dùng `{"error":{"code":"AUTH_REQUIRED","message":"Authentication is required"}}`. Client dùng code ổn định, message phục vụ giải thích và có thể được đổi ngôn ngữ. Lỗi mạng chưa nhận response chỉ cho biết chưa có kết quả HTTP để đọc; server có thể chưa nhận request hoặc đã xử lý nhưng response bị mất.
