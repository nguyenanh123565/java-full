# ProductManagement

## Dùng để làm gì?
Quản lý sản phẩm và tồn kho trong bộ nhớ để luyện validation, collection và comparator.

## Những ý bắt buộc phải hiểu
- Mã sản phẩm duy nhất; tên không rỗng.
- Giá dùng long là số đồng nguyên không âm; tồn kho int không âm.
- Bán số lượng dương không vượt tồn; kiểm tra trước khi thay đổi trạng thái.
- Tính tổng giá trị kho bằng long và xử lý overflow; không dùng double cho tiền.

## Lỗi người mới thường gặp
- Viết toàn bộ nghiệp vụ vào main khiến khó kiểm tra.
- Dùng static cho trạng thái mỗi object.
- Cập nhật một phần dữ liệu trước khi hoàn tất validation.

## Câu hỏi tự kiểm tra
1. Vì sao giá không nên là double?
2. Nếu bán thất bại thì tồn kho có được đổi không?
3. Comparator giá giảm/tên tăng cần ghép như thế nào?
4. Làm sao ngăn người dùng sửa tồn kho trực tiếp?
5. Khi nhân giá với số lượng cần kiểm tra overflow ở đâu?

## Ba bài tập từ dễ đến khó
1. Dễ: tự tạo Product gồm id, name, priceVnd, quantity; validate constructor. Giải thích vì sao field private và giá dùng long.
2. Vừa: tự viết ProductService thêm/tìm/cập nhật/xóa, nhập kho/bán hàng; kiểm tra mã trùng, số lượng không dương và thiếu hàng trước khi cập nhật. Giải thích trạng thái phải giữ nguyên khi lỗi.
3. Khó: tự làm menu, tìm tên, sort giá giảm rồi mã tăng, thống kê giá trị kho; xử lý input sai và dùng Math.multiplyExact/addExact hoặc kiểm tra giới hạn. Giải thích overflow và tie-break.

## Cách học
Đọc `ProductManagementDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`ProductManagementExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `ProductManagementSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.mini_projects.product_management.ProductManagementDemo` (sau khi biên dịch).

## Khung được cung cấp
- `Product.java`: model trống, chỉ có TODO.
- `ProductService.java`: service trống, chỉ có TODO.
- `ProductManagementExercise.java`: điểm bắt đầu để tự làm menu console.
- `ProductManagementSolution.java`: chỉ gợi ý phân chia trách nhiệm bằng TODO, không triển khai tính năng.

Tự kiểm tra bằng thao tác thành công, dữ liệu sai, mã trùng và không tìm thấy.
Mỗi ca thất bại cần kiểm tra trạng thái trước/sau và giải thích vì sao.


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
