# StudentManagement

## Dùng để làm gì?
Quản lý sinh viên trong bộ nhớ: thêm, tìm theo mã, cập nhật, xóa, liệt kê và thống kê điểm.

## Những ý bắt buộc phải hiểu
- Mã sinh viên không rỗng và không trùng.
- Tên không rỗng, điểm hữu hạn trong [0, 10].
- Dữ liệu nằm trong Map<String, Student> hoặc List<Student>, mất khi đóng chương trình.
- Tách console nhập/xuất khỏi service và model; không dùng field static cho thông tin từng sinh viên.

## Lỗi người mới thường gặp
- Viết toàn bộ nghiệp vụ vào main khiến khó kiểm tra.
- Dùng static cho trạng thái mỗi object.
- Cập nhật một phần dữ liệu trước khi hoàn tất validation.

## Câu hỏi tự kiểm tra
1. Tại sao mã phải duy nhất?
2. Vì sao kiểm tra điểm nằm trong model hoặc service?
3. List và Map có khác biệt gì khi tìm theo mã?
4. Nếu getter trả collection nội bộ thì caller có thể làm gì?
5. Thay đổi mã của object đang làm key có gây vấn đề không?

## Ba bài tập từ dễ đến khó
1. Dễ: tự tạo Student với id, name, score; constructor kiểm tra dữ liệu. Mô tả vì sao cần encapsulation và thử score=-1, 11, NaN.
2. Vừa: tự viết StudentService thêm/tìm/cập nhật/xóa trong bộ nhớ; từ chối mã trùng, báo rõ mã không tồn tại. Giải thích chọn List hay Map.
3. Khó: tự làm menu console, sắp xếp điểm giảm (hòa thì mã tăng), tính điểm trung bình; xử lý input sai mà menu vẫn tiếp tục. Giải thích reference và việc không trả dữ liệu nội bộ tùy ý.

## Cách học
Đọc `StudentManagementDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`StudentManagementExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `StudentManagementSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.mini_projects.student_management.StudentManagementDemo` (sau khi biên dịch).

## Khung được cung cấp
- `Student.java`: model trống, chỉ có TODO.
- `StudentService.java`: service trống, chỉ có TODO.
- `StudentManagementExercise.java`: điểm bắt đầu để tự làm menu console.
- `StudentManagementSolution.java`: chỉ gợi ý phân chia trách nhiệm bằng TODO, không triển khai tính năng.

Tự kiểm tra bằng thao tác thành công, dữ liệu sai, mã trùng và không tìm thấy.
Mỗi ca thất bại cần kiểm tra trạng thái trước/sau và giải thích vì sao.


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
