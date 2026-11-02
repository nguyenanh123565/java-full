# BinarySearch

## Dùng để làm gì?
Tìm giá trị trên mảng đã sắp xếp tăng bằng cách thu hẹp một nửa vùng tìm kiếm.

## Những ý bắt buộc phải hiểu
- Tiền điều kiện: mảng đã sắp xếp; hàm không tự sort.
- Khoảng tìm kiếm [left, right] gồm cả hai đầu.
- mid = left + (right - left) / 2 tránh tràn cộng index.

## Lỗi người mới thường gặp
- Bỏ qua trường hợp rỗng, một phần tử hoặc giá trị lặp.
- Chạy code trước khi viết dự đoán và giải thích vì sao.
- Đưa lời giải vào Exercise trước khi tự thử hoặc bỏ qua độ phức tạp.

## Câu hỏi tự kiểm tra
1. Tại sao mảng chưa sort không dùng được binary search?
2. Vì sao cập nhật left=mid+1 hoặc right=mid-1?
3. Khi có phần tử trùng, có bắt buộc trả index đầu tiên không?

## Ba bài tập từ dễ đến khó
1. Dễ: mô phỏng tìm 7 trong [1, 3, 5, 7, 9]; ghi left/right/mid từng lượt và giải thích bỏ nửa nào.
2. Vừa: viết search(int[], int) trả index bất kỳ nếu tìm thấy, -1 nếu không; không tự sort. Giải thích O(log n).
3. Khó: thử [], [4], target không có và [1, 2, 2, 3]; giải thích điều kiện dừng, phần tử trùng và cách tính mid an toàn.

## Cách học
Đọc `BinarySearchDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`BinarySearchExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `BinarySearchSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.easy.binary_search.BinarySearchDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
