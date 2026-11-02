# Tự làm: Vòng lặp

[Về mục học](../README.md)

## Trước khi làm

Sau condition; đọc LoopDemo. Dùng biến, rẽ nhánh và vòng lặp trong main. Chưa cần method tự viết, mảng hay chuỗi để phân tích chữ số.

Bài cũ [LoopExercise.java](../LoopExercise.java) đã có tổng 1..n, bỏ số chẵn và tam giác sao. Bộ mới luyện tích, tiến triển của while và dừng khi đạt mục tiêu.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.loops.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.loops.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### LOP-01 — Giai thừa có giới hạn · Dễ · Cơ bản

- **Kiến thức luyện:** Tích lũy; biến đếm; long.
- **Bối cảnh và yêu cầu:** Cho n trong [0,20], tính n! bằng vòng for và in long. Không dùng đệ quy, Math hoặc công thức thay vòng lặp.
- **Dữ liệu / kết quả / ví dụ:** 5 -> 120; 0 -> 1; 20 -> 2432902008176640000.
- **Trường hợp biên:** n=1 và n=20; n ngoài [0,20] không thuộc hợp đồng. Không thử 21! rồi coi số âm là hợp lệ.
- **Tiêu chí hoàn thành:** Đúng ba mốc, giải thích vì sao khởi tạo bằng 1 và vì sao long cũng có giới hạn. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### LOP-02 — Đọc vòng lọc có dừng sớm · Vừa · Suy luận

- **Kiến thức luyện:** Continue; break; cập nhật for.
- **Bối cảnh và yêu cầu:** Dự đoán các số in và giá trị sum: `int sum=0; for(int i=1;i<=8;i++){if(i%3==0)continue; if(i>6)break; sum+=i; System.out.println(i);}`. Lập bảng i, điều kiện, hành vi; giải thích vì sao 6 và 7 không in.
- **Dữ liệu / kết quả / ví dụ:** Tự ghi danh sách và tổng trước chạy. Đổi điều kiện i>6 thành i>0 để so sánh.
- **Trường hợp biên:** Nếu giới hạn trên là 0 thì vòng không chạy; continue trong for vẫn chạy phần i++.
- **Tiêu chí hoàn thành:** Theo dõi đúng các lượt 3,6,7 và ca vòng không chạy. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### LOP-03 — While đứng yên ở số chẵn · Vừa · Tìm lỗi

- **Kiến thức luyện:** Tiến triển; continue; điều kiện dừng.
- **Bối cảnh và yêu cầu:** Phân tích mà chưa chạy đoạn lỗi: `int i=4,sum=0; while(i>0){if(i%2==0)continue; sum+=i; i--;}`. Sửa để cộng số lẻ dương từ i ban đầu trở về 1, giữ cách dùng while. Giải thích vị trí cập nhật mới.
- **Dữ liệu / kết quả / ví dụ:** i ban đầu 4 -> sum=4; 0 -> 0; 1 -> 1.
- **Trường hợp biên:** Đầu vào [0,1000000]; tổng dùng long; mọi nhánh đều phải tiến tới i=0.
- **Tiêu chí hoàn thành:** Chỉ ra trạng thái lặp mãi của bản gốc; bản sửa chạy dứt và đúng ca 0. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### LOP-04 — Số chữ số không cần String · Vừa · Vận dụng

- **Kiến thức luyện:** Chia nguyên lặp; while; xử lý 0.
- **Bối cảnh và yêu cầu:** Cho int number không âm. Tính số chữ số thập phân bằng cách chia bản sao cho 10 nhiều lần; không chuyển sang String. Giữ nguyên number ban đầu.
- **Dữ liệu / kết quả / ví dụ:** 0 ->1; 7 ->1; 1000 ->4; 2147483647 ->10.
- **Trường hợp biên:** 0 cần xử lý rõ ràng; thử 10,100,999; không nhận số âm nên không phải xử lý abs của MIN_VALUE.
- **Tiêu chí hoàn thành:** Số gốc không đổi và chứng minh được bản sao tiến về 0. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### LOP-05 — Ngày đạt mục tiêu tiết kiệm · Vừa · Tổng kết

- **Kiến thức luyện:** While; tổng long; dừng sớm; giải thích invariant.
- **Bối cảnh và yêu cầu:** Ngày 1 gửi 1000 đồng, ngày d gửi d*1000 đồng. Với target long trong [0,1000000000], tìm ngày đầu tiên tổng tiết kiệm đạt hoặc vượt target; in số ngày và tổng. Target=0 chưa cần ngày nào. Không dùng công thức nghiệm hoặc thư viện ngoài.
- **Dữ liệu / kết quả / ví dụ:** target=5500 -> days=3,total=6000; 6000 ->3,6000; 0 ->0,0.
- **Trường hợp biên:** 1 ->1,1000; 1000 ->1,1000; 1001 ->2,3000; thử mức tối đa để kiểm tra long.
- **Tiêu chí hoàn thành:** Không đi thừa một ngày khi đã bằng target; tự giải thích trước mỗi lượt tổng còn nhỏ hơn target. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
