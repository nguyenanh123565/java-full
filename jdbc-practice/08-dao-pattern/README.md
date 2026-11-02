# DAO pattern cơ bản

## 1. Problem — vì sao cần khái niệm này?
Nếu menu CLI chứa SQL, nhập liệu, mapping và nghiệp vụ cùng chỗ, một thay đổi schema dễ phá cả giao diện.

## 2. Mental model
DAO đóng gói truy cập dữ liệu và mapping. Caller làm việc với Product, Optional và List. Service giữ quy tắc nghiệp vụ; CLI chỉ nhập/xuất. Pattern này là Java thông thường, không cần framework.

## 3. Ví dụ nhỏ
`dao.findById(id)` trả Optional<JdbcProduct>; CLI tự chọn thông báo khi không tìm thấy.

Đọc [demo](demo/README.md), ghi dự đoán, rồi mới chạy hoặc quan sát SQL theo hướng dẫn.

## 4. Liên hệ kiến thức đã học
Java Core: tách class theo trách nhiệm và dùng interface khi cần thay implementation. HTTP: Controller cũng không nên trực tiếp duyệt ResultSet. SQL vẫn phải hiểu dù được giấu trong DAO.

## 5. Những lỗi thường gặp
Trả ResultSet ra ngoài; bắt lỗi rồi trả List rỗng làm mất phân biệt lỗi DB với không có dữ liệu; DAO in menu; transaction bị chia nhỏ theo từng method.

## 6. Câu hỏi tự kiểm tra
DAO khác Service ở quy tắc nào? Khi một nghiệp vụ cần hai DAO thì ai nên sở hữu Connection/transaction?

## 7. Exercise
Tách tìm product ra DAO; viết một caller không có chuỗi SQL. Mô tả cách truyền cùng Connection cho hai DAO trong một transaction.

Làm tại [exercise](exercise/README.md). Chỉ mở [solution](solution/README.md) sau khi tự ghi kết quả và giải thích. Ghi điều hiểu sai vào [notes.md](notes.md).
