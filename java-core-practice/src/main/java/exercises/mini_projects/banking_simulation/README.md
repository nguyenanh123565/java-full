# BankingSimulation

## Dùng để làm gì?
Mô phỏng tài khoản, nạp/rút/chuyển tiền trong bộ nhớ để luyện bất biến và exception.

## Những ý bắt buộc phải hiểu
- Chỉ là mô phỏng một luồng, dữ liệu trong bộ nhớ; không có kết nối ngân hàng.
- Số tài khoản duy nhất; số dư long theo đồng nguyên không âm.
- Nạp/rút/chuyển phải có số tiền > 0, kiểm tra thiếu tiền và overflow trước khi cập nhật.
- Chuyển tiền thất bại phải giữ cả hai số dư; từ chối chuyển tới chính tài khoản đó.

## Lỗi người mới thường gặp
- Viết toàn bộ nghiệp vụ vào main khiến khó kiểm tra.
- Dùng static cho trạng thái mỗi object.
- Cập nhật một phần dữ liệu trước khi hoàn tất validation.

## Câu hỏi tự kiểm tra
1. Bất biến số dư không âm được bảo vệ ở đâu?
2. Vì sao cần kiểm tra cả hai tài khoản trước khi đổi số dư?
3. Thiếu tiền nên biểu diễn bằng checked hay unchecked exception và vì sao?
4. Tổng số dư thay đổi thế nào khi chuyển nội bộ?
5. Làm sao kiểm tra overflow khi cộng tiền?

## Ba bài tập từ dễ đến khó
1. Dễ: tự tạo BankAccount có accountNumber, owner, balanceVnd; số dư khởi tạo không âm và field private. Giải thích bất biến.
2. Vừa: tự viết nạp/rút có validation và exception phù hợp; không chấp nhận số tiền <= 0, thiếu tiền hoặc overflow. Giải thích vì sao lỗi không làm đổi số dư.
3. Khó: tự viết BankService chuyển giữa hai tài khoản và menu console; kiểm tra tồn tại, khác tài khoản, đủ tiền, receiver không overflow trước khi cập nhật. Giải thích vì sao tổng số dư được bảo toàn, thử một lần thành công và các lần thất bại.

## Cách học
Đọc `BankingSimulationDemo.java`, ghi dự đoán output trước khi chạy. Làm ba TODO trong
`BankingSimulationExercise.java` và viết phần giải thích của bạn trong comment. Sau khi tự làm,
mới mở `BankingSimulationSolution.java` để đối chiếu. Lời giải mẫu là một cách làm, không phải cách duy nhất.

Từ thư mục gốc project: `java -cp target/classes exercises.mini_projects.banking_simulation.BankingSimulationDemo` (sau khi biên dịch).

## Khung được cung cấp
- `BankAccount.java`: model trống, chỉ có TODO.
- `BankService.java`: service trống, chỉ có TODO.
- `BankingSimulationExercise.java`: điểm bắt đầu để tự làm menu console.
- `BankingSimulationSolution.java`: chỉ gợi ý phân chia trách nhiệm bằng TODO, không triển khai tính năng.

Tự kiểm tra bằng thao tác thành công, dữ liệu sai, mã trùng và không tìm thấy.
Mỗi ca thất bại cần kiểm tra trạng thái trước/sau và giải thích vì sao.


## Bộ tự kiểm tra cuối mục

Làm [bài tập mở rộng](exercises/README.md), rồi hoàn tất [checklist và câu hỏi tự luận](exercises/review.md). Gợi ý và lời giải nằm riêng; phần nội dung/bài làm phía trên được giữ nguyên.
