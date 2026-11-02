# Medium

## Dùng để làm gì?
Ghép Java Core với thuật toán trên dữ liệu có cấu trúc, trước khi làm mini project.

## Những ý bắt buộc phải hiểu
- Chọn Map/Set/Deque theo yêu cầu, không chỉ theo thói quen.
- Đặt quy ước cho input rỗng, trùng và không tìm thấy.
- Phân tích thời gian/bộ nhớ và chứng minh invariant.
- So sánh chuỗi theo giá trị, không theo identity.

## Lỗi người mới thường gặp
- Dùng contains trong vòng lặp khiến thuật toán O(n²).
- Quên chuẩn hóa input từ.
- Tính tổng cửa sổ bằng int khiến tràn.

## Câu hỏi tự kiểm tra
1. Tại sao không được giả định HashMap duyệt theo thứ tự?
2. Bất biến cửa sổ trượt là gì?
3. Vì sao cần long để cộng nhiều int?
4. Phương thức có sửa input không và điều đó ảnh hưởng caller thế nào?

## Ba bài tập từ dễ đến khó
1. Dễ: tìm char ASCII đầu tiên xuất hiện đúng một lần, trả Character hoặc null; "swiss" -> w, "aabb" -> null. Giải thích vì sao cần đếm rồi duyệt theo thứ tự nguồn.
2. Vừa: kiểm tra hai từ là anagram sau trim và đổi chữ thường Locale.ROOT; chỉ chấp nhận chữ ASCII a-z, input không hợp lệ ném IllegalArgumentException; " Listen " và "silent" -> true. Giải thích map tần suất và quy ước chuẩn hóa.
3. Khó: tìm tổng lớn nhất của cửa sổ liên tiếp kích thước k, trả long; [2, 1, 5, 1, 3, 2], k=3 -> 9. k không hợp lệ ném IllegalArgumentException. Giải thích invariant và vì sao O(n).

## Cách học
Đọc `MediumDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`MediumExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `MediumSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.medium.MediumDemo` (sau khi biên dịch).


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
