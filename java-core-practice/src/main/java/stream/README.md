# Stream

## Dùng để làm gì?
Xử lý chuỗi phần tử bằng pipeline lọc, biến đổi và tổng hợp.

## Những ý bắt buộc phải hiểu
- Stream không phải nơi chứa dữ liệu; Collection mới giữ các phần tử.
- Intermediate operation lazy; terminal operation bắt đầu xử lý.
- Một stream chỉ dùng cho một terminal operation; muốn dùng tiếp phải tạo stream mới.
- map biến đổi, filter lọc, reduce/collect tổng hợp; tránh sửa nguồn trong pipeline.

## Lỗi người mới thường gặp
- Quên terminal operation rồi nghĩ map không hoạt động.
- Dùng lại stream đã consume.
- Lạm dụng peek hoặc parallelStream cho logic có tác dụng phụ.

## Câu hỏi tự kiểm tra
1. Vì sao filter chưa thực thi ngay khi khai báo pipeline?
2. map khác forEach như thế nào?
3. Khi nào dùng mapToInt?
4. distinct dựa trên cơ chế nào để xét bằng nhau?

## Ba bài tập từ dễ đến khó
1. Dễ: từ [1, 2, 3, 4] lấy bình phương các số chẵn thành [4, 16]; giải thích thứ tự filter rồi map.
2. Vừa: chuẩn hóa từ bằng trim + chữ thường Locale.ROOT, bỏ từ rỗng rồi đếm tần suất; thử [" Java ", "java", "Core", ""]. Giải thích groupingBy và counting.
3. Khó: lấy ba điểm cao nhất không trùng, bỏ điểm âm; từ [9, 5, 9, -1, 8, 7] lấy [9, 8, 7]. Giải thích distinct, sorted, limit và việc không sửa list gốc.

## Cách học
Đọc `StreamDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`StreamExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `StreamSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes stream.StreamDemo` (sau khi biên dịch).


## Bài tự làm cuối mục

Đọc và tự kiểm tra tại [bộ bài cuối mục](exercises/README.md), làm trước khi đối chiếu [gợi ý](exercises/hints.md), [tự đánh giá](exercises/review.md) và lời giải tách riêng. Bộ mới mở rộng bài có sẵn; giữ nguyên bài làm và ghi chú của bạn.
