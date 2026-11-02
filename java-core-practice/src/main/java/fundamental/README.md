# Nền tảng Java

## Dùng để làm gì?
Học cú pháp và cách dữ liệu được sao chép hoặc chia sẻ.

## Thứ tự học
1. [variables](variables/README.md)
2. [operators](operators/README.md)
3. [condition](condition/README.md)
4. [loops](loops/README.md)
5. [methods](methods/README.md)
6. [arrays](arrays/README.md)
7. [strings](strings/README.md)
8. [reference](reference/README.md)
9. [memory](memory/README.md)

## Những ý bắt buộc phải hiểu
- Primitive giữ giá trị; reference giữ tham chiếu hoặc null.
- Java luôn pass-by-value, kể cả khi truyền reference.
- Stack/heap chỉ là mô hình học cơ bản; không suy diễn layout JVM cụ thể.

## Lỗi người mới thường gặp
- Nhầm mutation với gán lại reference.
- Đoán số String object mà bỏ qua intern và tối ưu JVM.

## Câu hỏi tự kiểm tra
1. Truyền int vào method có đổi biến caller không?
2. Hai biến array cùng reference có thể quan sát thay đổi nào?
3. Vì sao String immutable vẫn gán lại biến được?

## Ba bài tập từ dễ đến khó
1. Dễ: hoàn thành variables và operators, giải thích kiểu dữ liệu.
2. Vừa: hoàn thành loops/methods/arrays và viết invariant vòng lặp.
3. Khó: hoàn thành reference/memory, vẽ quan hệ tham chiếu trước và sau lời gọi hàm.


## Bài tập tự làm cuối mục

Tiếp tục với [bộ bài tập tự làm](exercises/README.md): đề, starter, gợi ý theo mức, checklist và lời giải tách riêng. Giữ nguyên bài làm/ghi chú cũ; làm bài mới trước khi mở lời giải.
