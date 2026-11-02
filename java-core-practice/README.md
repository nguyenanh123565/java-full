# Java Core Practice

Project tự học Java Core từ cơ bản đến nâng cao, có bài Java + DSA và ba mini project skeleton.
Java thuần, không dependency ứng dụng, không Spring Boot/JPA/Hibernate/database/Lombok/framework.
Cần **JDK 17 trở lên**. Source tương thích Java 17; Maven là tùy chọn.

## Bắt đầu ở đâu?
1. Bắt đầu tại [fundamental/variables](src/main/java/fundamental/variables/README.md),
   rồi operators → condition → loops → methods → arrays → strings → reference → memory.
2. Dành thêm thời gian cho [methods](src/main/java/fundamental/methods/README.md),
   [reference](src/main/java/fundamental/reference/README.md) và
   [memory](src/main/java/fundamental/memory/README.md): Java luôn pass-by-value;
   thay đổi object và gán lại reference là hai thao tác khác nhau.
3. Học [OOP](src/main/java/oop/README.md) theo thứ tự trong README của nhóm.
4. Học [exception](src/main/java/exception/README.md),
   [static_final](src/main/java/static_final/README.md),
   [wrapper](src/main/java/wrapper/README.md),
   [generics](src/main/java/generics/README.md),
   [equals_hashcode](src/main/java/equals_hashcode/README.md), rồi
   [collections](src/main/java/collections/README.md).
5. Tiếp tục [enum_demo](src/main/java/enum_demo/README.md),
   [comparable_comparator](src/main/java/comparable_comparator/README.md),
   [lambda](src/main/java/lambda/README.md), [stream](src/main/java/stream/README.md).
6. Làm [easy](src/main/java/exercises/easy/README.md) song song sau arrays/strings;
   Two Sum cần Map, Valid Parentheses cần Deque. Sau đó làm
   [medium](src/main/java/exercises/medium/README.md) và
   [mini_projects](src/main/java/exercises/mini_projects/README.md).

## Cách học một chủ đề
Mỗi chủ đề có package riêng và bốn file. Ví dụ:
```text
fundamental/arrays/
├── ArrayDemo.java       # Ví dụ ngắn, đoán output trước khi chạy
├── ArrayExercise.java   # Đề bài + TODO, tự viết code ở đây
├── ArraySolution.java   # Lời giải mẫu riêng, chỉ mở để đối chiếu
└── README.md            # Mục tiêu, ý cần hiểu, lỗi, câu hỏi, 3 bài tập
```
1. Đọc README, ghi dự đoán output của Demo cùng lý do.
2. Chạy Demo để kiểm chứng, giải thích điểm khác với dự đoán.
3. Tự giải TODO trong Exercise; thử trường hợp rỗng, trùng, âm hoặc input sai khi phù hợp.
4. Ghi “vì sao” trong comment hoặc ghi chú của bạn; phân biệt kết quả và cơ chế.
5. Chỉ sau khi tự làm mới mở Solution. Không chép lời giải vào Exercise trước khi thử.

Exercises được biên dịch nhưng main ban đầu không làm gì vì chỉ có TODO.
Các file Solution đứng riêng cùng package, không được Exercise gọi tự động.
Riêng ba mini project, **cả Solution cũng chỉ là skeleton/TODO**, chưa làm sẵn tính năng.
Mô hình stack/heap là mô hình khái niệm, không khẳng định cách JVM bố trí/tối ưu thực tế.

## Biên dịch và chạy trên Windows PowerShell
Mở terminal trong thư mục `java-core-practice`:
```powershell
.uild.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.arrays.ArrayDemo
```
Hoặc biên dịch và chạy một class bằng một lệnh:
```powershell
.uild.ps1 -MainClass fundamental.variables.VariableDemo
.uild.ps1 -MainClass exercises.easy.two_sum.TwoSumExercise
```
Nếu PowerShell chặn script theo execution policy, dùng lệnh theo lần chạy này:
```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .uild.ps1 -MainClass fundamental.arrays.ArrayDemo
```
Để output tiếng Việt hiển thị đúng trong Windows PowerShell:
```powershell
[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new($false)
```
Script dùng `javac --release 17 -encoding UTF-8` và ghi class vào `target/classes`.
Sau khi sửa bài tập, biên dịch lại. Mỗi Demo/Exercise/Solution có main riêng để chạy độc lập.

## Maven tối giản (nếu máy đã cài Maven)
```powershell
mvn compile
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.arrays.ArrayDemo
```
POM chỉ cấu hình compiler và UTF-8, không có dependency ứng dụng.
Lần chạy Maven đầu có thể cần internet để tải build plugin. Script PowerShell chỉ cần JDK.
Trong IDE, mở project từ `pom.xml` hoặc đánh dấu `src/main/java` là source root và chọn JDK 17+.
Chạy main bằng tên class đầy đủ như `fundamental.reference.ReferenceDemo`.

## 10 bài Java + DSA cơ bản
Trong `exercises/easy`, mỗi bài có package và bốn file riêng:
Find Max, Find Min, Reverse Array, Count Frequency, Remove Duplicate,
Two Sum, Valid Parentheses, Binary Search, Palindrome, Character Frequency.
Ba bài medium: ký tự duy nhất đầu tiên, anagram, tổng cửa sổ trượt lớn nhất.

## Ba mini project skeleton
- Student Management: model, service, CRUD, điểm và menu console.
- Product Management: sản phẩm, tồn kho, giá, sort và menu console.
- Banking Simulation: tài khoản, nạp/rút/chuyển, bất biến số dư và menu console.

Dữ liệu chỉ tồn tại trong bộ nhớ. Các model/service để trống với TODO.
Tiền dùng `long` theo đồng nguyên để thực hành validation và kiểm tra overflow.

## Cây thư mục
Xem [STRUCTURE.md](STRUCTURE.md) để có cây đầy đủ của mọi file source và tài liệu.
`target/` là kết quả biên dịch, không thuộc cây học tập và được bỏ qua trong Git.

## Bài tập tự kiểm tra cuối từng mục

Đã bổ sung bộ `exercises/` riêng tại mọi mục học và mục con, gồm đề, starter TODO,
gợi ý theo mức, checklist tự luận và lời giải tham khảo tách riêng. Bài làm/code và
ghi chú cũ được giữ nguyên; ba Solution mini project cũ vẫn là skeleton, còn nhánh
bài mới có lời giải chạy được trong `exercises/solutions/`.

Bắt đầu ở [hướng dẫn học và chạy kiểm tra](STUDY_GUIDE.md), rồi dùng
[bảng tiến độ từng mục](PROGRESS.md). Theo [khảo sát nội dung và tiên quyết](PRACTICE_AUDIT.md)
để tránh làm bài dùng collection/exception trước khi học tới nơi.
[Kết quả kiểm tra](PRACTICE_VALIDATION.md) ghi rõ phần đã chạy và giới hạn.