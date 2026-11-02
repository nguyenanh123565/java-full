# Chỉ mục đối chiếu JDBC

Đáp án theo từng bài ở `../01-jdbc-overview/solution/` đến `../09-connection-management/solution/`.

Reference tổng hợp chạy được: [Product CLI](../mini-project/solution/README.md). Đừng chép trước khi làm starter.

Đối chiếu bài transaction: transaction bao phủ toàn nghiệp vụ, không bao phủ thời gian người dùng gõ menu. Hai DAO trong cùng nghiệp vụ phải nhận cùng Connection. Mẫu DAO từng thao tác trong CLI phù hợp CRUD độc lập; không tự suy rộng sang checkout nhiều bước.

Query kiểm chứng rollback phải đọc lại bằng id vừa được trả; không kiểm tra bằng giả định id liên tiếp. Với price âm, PostgreSQL CHECK từ chối; app cũng nên báo lỗi dễ hiểu trước khi gửi SQL.
