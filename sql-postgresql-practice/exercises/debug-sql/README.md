# Tìm lỗi SQL bằng dữ liệu và lập luận

## Khái niệm giải quyết vấn đề gì?

Một query có thể chạy thành công nhưng trả dữ liệu sai, hoặc thay đổi nhiều dữ liệu hơn dự kiến. Debug SQL là đối chiếu câu hỏi nghiệp vụ với khóa JOIN, số dòng, điều kiện lọc và đơn vị tổng hợp. Không chỉ tìm lỗi cú pháp.

## SQL hoạt động như thế nào?

Query sai khóa JOIN vẫn có thể tạo các cặp hợp lệ về kiểu dữ liệu. `= NULL` cho `UNKNOWN` nên WHERE không giữ dòng. GROUP BY tạo một dòng mỗi nhóm, các cột còn lại phải có ý nghĩa duy nhất trong nhóm. UPDATE/DELETE tác động lên **mọi dòng khớp điều kiện**, và khi không có WHERE thì phạm vi là toàn bảng. JOIN một-nhiều có thể nhân dòng trước khi SUM.

## Ví dụ và cách chạy

Để điều tra một JOIN, tạm chọn cả khóa hai bên và đếm số dòng theo từng thực thể. `demo.sql` chỉ đọc dữ liệu, cho thấy một đơn có nhiều dòng hàng và hậu quả nếu cộng tổng đơn ở mức dòng hàng. Dự đoán giá trị đơn 1 trước khi chạy:

```powershell
psql -U postgres -d sql_postgresql_practice -v ON_ERROR_STOP=1 -f exercises/debug-sql/demo.sql
```

`exercise.sql` chứa sáu query cố tình sai **dưới dạng comment**, vì vậy chạy cả file sẽ không thay đổi dữ liệu. Tự viết bản sửa trong file nháp. Với DML, xem trước đối tượng bằng SELECT, dùng `BEGIN`, kiểm tra `RETURNING` và kết thúc `ROLLBACK` trong lúc học. Không bỏ comment của câu UPDATE/DELETE sai để thử trên dữ liệu đang dùng.

## Lỗi người mới hay mắc

- Chỉ nhìn “query chạy được” mà không kiểm tra ý nghĩa dữ liệu.
- Tin khóa ngoại sẽ tự sửa điều kiện JOIN sai.
- Dùng DISTINCT che hiện tượng nhân dòng, rồi vẫn tính sai tổng.
- Trông chờ CHECK hoặc FK bảo vệ mọi lỗi nghiệp vụ trong UPDATE/DELETE.
- Thêm WHERE nhưng không xác minh số dòng và dữ liệu thực sự khớp.

## Câu hỏi kiểm tra hiểu biết

1. Query JOIN sai khóa có thể chạy thành công vì sao?
2. `NULL = NULL` có cho TRUE không? WHERE sẽ làm gì với kết quả đó?
3. Một group theo user_id có thể chứa nhiều order.id vì sao?
4. UPDATE không WHERE thay đổi bao nhiêu dòng? CHECK có thay thế WHERE được không?
5. Tại sao SUM(DISTINCT total) không phải cách sửa chung cho JOIN bị nhân dòng?

## Bài tập

Sáu TODO bao gồm JOIN sai key, so sánh NULL, GROUP BY sai, UPDATE thiếu WHERE, DELETE nguy hiểm và cộng sai vì JOIN dòng hàng. Với mỗi lỗi, viết: điều gì xảy ra, vì sao xảy ra, câu sửa và cách chứng minh câu sửa đúng. Solutions tách riêng tại `../../solutions/exercises/debug-sql.sql`; các ví dụ sửa DML dùng transaction rồi ROLLBACK.
