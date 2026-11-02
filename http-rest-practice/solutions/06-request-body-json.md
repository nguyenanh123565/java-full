# Đối chiếu 06 — Body/JSON

## Bài 1

A dùng nháy đơn nên không phải JSON chuẩn; đổi sang nháy kép và bổ sung field bắt buộc theo contract. B là JSON hợp lệ nhưng price là string, trái contract đã cho. C đúng cú pháp và kiểu cơ bản nhưng stock âm không hợp lệ. Một mẫu sửa: `{"name":"Arm Kit","price":1200000,"stock":4}`. Echo có thể phản chiếu cả ba và trả 200 vì không parse hoặc validate.

## Bài 2

Mẫu request `{"name":"Arm Kit","price":1200000,"stock":4,"categoryCode":"robot"}`; contract công bố giá VND, categoryCode phải tồn tại. Dùng categoryId cũng hợp lý nếu ổn định và có quy tắc tra cứu. Response có id mới và dữ liệu đã chuẩn hóa. Client không tự cấp id hay role; backend kiểm tra name, miền giá, kiểu và miền stock, category tồn tại và quyền tạo. Field tiền cần quy định độ chính xác và giới hạn.

## Bài 3

Mẫu body `{"items":[{"productId":27,"quantity":2},{"productId":31,"quantity":1}]}`. Backend lấy user từ cơ chế xác thực, kiểm tra quyền, đọc giá và stock hiện hành, tính tổng từ các item và xử lý thay đổi tồn kho nhất quán. Nếu stock thiếu hoặc giá thay đổi cần quy tắc trả lỗi/xác nhận lại rõ ràng. Tin total hoặc role client gửi cho phép client sửa dữ liệu để tự giảm giá hoặc tăng quyền; parse JSON không ngăn được việc đó.
