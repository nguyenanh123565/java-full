# Tự làm: Mảng

[Về mục học](../README.md)

## Trước khi làm

Sau methods; đọc ArrayDemo. Dùng array một/hai chiều, loop, method, Arrays.copyOf/equals/deepEquals. Không dùng collection, stream hoặc lớp nghiệp vụ.

Bài cũ [ArrayExercise.java](../ArrayExercise.java) đã tính tổng, alias/copy một chiều và hàng dùng chung. Bộ mới mở rộng thao tác trên phần tử, copy lớp ngoài và báo cáo mảng lệch hàng.

Học theo thứ tự README → ví dụ → tự làm bài → ghi chú. Với bộ này: đọc đề → tự làm → chạy kiểm tra → giải thích → xem [gợi ý](hints.md) theo từng mức nếu bí → đối chiếu [lời giải](solutions/README.md) sau cùng. Ghi dự đoán trước khi chạy các bài suy luận. Không mở lời giải trong lần đọc đề đầu.

Làm lần lượt các mã dưới đây; bài cuối là tổng kết. Bạn có thể làm trong file mới thuộc starter, giữ nguyên bài làm cũ. Starter ban đầu chỉ có TODO và main rỗng; chạy thành công chưa có nghĩa đã giải xong. Đối chiếu ví dụ cùng toàn bộ ca biên ở mỗi bài rồi tự thêm ít nhất một ca.

## Chạy từ thư mục gốc java-core-practice

```powershell
.\build.ps1
java -Dfile.encoding=UTF-8 -cp target/classes fundamental.arrays.exercises.starter.Starter
```

Chạy lại build sau mỗi lần sửa. Bản tham khảo ở thư mục riêng, chỉ mở sau khi tự làm. Khi đối chiếu có thể chạy:

```powershell
java -ea -Dfile.encoding=UTF-8 -cp target/classes fundamental.arrays.exercises.solutions.ReferenceSolution
```

`-ea` bật assert của bộ kiểm chứng. Assert là khung tự kiểm tra có sẵn của lời giải, không phải kiến thức bắt buộc để giải các bài; không bỏ `-ea` khi kiểm chứng. Lệnh này chỉ kiểm tra bản tham khảo; hãy tự đưa các ca dữ liệu trong đề vào bài của bạn. Các đoạn cố ý sai hoặc chưa học chỉ nằm trong Markdown, không được chép nguyên vào source đang build.

## Đề bài

### ARR-01 — Đếm số dương · Dễ · Cơ bản

- **Kiến thức luyện:** Duyệt mảng; điều kiện; không sửa input.
- **Bối cảnh và yêu cầu:** Viết countPositive(int[] values), đầu vào khác null, trả số phần tử >0; 0 không tính. In nội dung trước/sau để xác nhận không bị sửa.
- **Dữ liệu / kết quả / ví dụ:** [-2,0,3,3] ->2; [] ->0.
- **Trường hợp biên:** Toàn âm, toàn 0, một phần tử, MAX_VALUE và MIN_VALUE.
- **Tiêu chí hoàn thành:** Đúng số lượng, mảng nguồn giữ nguyên và không truy cập phần tử đầu của mảng rỗng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### ARR-02 — Copy ngoài và thay một hàng · Vừa · Suy luận

- **Kiến thức luyện:** Shallow copy; mutation; gán phần tử reference.
- **Bối cảnh và yêu cầu:** Dự đoán `int[][] a={{1,2},{3}}; int[][] b=Arrays.copyOf(a,a.length); b[0][0]=9; b[1]=new int[]{8};`. In a,b và a[0]==b[0], a[1]==b[1]. Vẽ từng mảng ngoài và hàng; không cần đếm object của JVM.
- **Dữ liệu / kết quả / ví dụ:** Tự viết output trước chạy; sau đó đổi b[0] sang mảng rỗng và dự đoán a[0].
- **Trường hợp biên:** Copy mảng ngoài dài 0 vẫn hợp lệ; riêng snippet có hai hàng khác null.
- **Tiêu chí hoàn thành:** Phân biệt đúng sửa ô trong hàng chung với gán một slot của mảng ngoài. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### ARR-03 — Vòng lặp không xóa mảng · Dễ · Tìm lỗi

- **Kiến thức luyện:** Enhanced for; phép gán primitive; chỉ số.
- **Bối cảnh và yêu cầu:** Một hàm muốn đặt mọi phần tử thành 0 nhưng dùng `for(int value:values){value=0;}`. Giải thích vì sao input [4,-2] không đổi; viết reset(int[] values) thực sự sửa từng phần tử, không tạo mảng mới.
- **Dữ liệu / kết quả / ví dụ:** Sau reset([4,-2]) ->[0,0]; alias của input cũng quan sát [0,0].
- **Trường hợp biên:** [] không gây lỗi; [0] vẫn [0]; input khác null.
- **Tiêu chí hoàn thành:** Cùng object mảng trước/sau, tất cả phần tử bằng 0, giải thích biến value chỉ là bản sao. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### ARR-04 — Xoay phải một bước · Vừa · Vận dụng

- **Kiến thức luyện:** Cấp phát mảng mới; ánh xạ chỉ số; hợp đồng không mutation.
- **Bối cảnh và yêu cầu:** Viết rotateRight(int[] values) trả mảng mới dịch phần tử cuối lên đầu, các phần tử còn lại dịch phải một vị trí. Input khác null, không sửa input, không dùng collection.
- **Dữ liệu / kết quả / ví dụ:** [1,2,3]->[3,1,2]; []->[]; [7]->[7].
- **Trường hợp biên:** Phần tử trùng, âm; luôn trả mảng mới kể cả rỗng/một phần tử; tránh modulo cho length=0.
- **Tiêu chí hoàn thành:** Dãy đúng, result!=values, sửa result không ảnh hưởng input. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

### ARR-05 — Báo cáo bán hàng lệch hàng · Vừa · Tổng kết

- **Kiến thức luyện:** Mảng hai chiều; loop lồng; long; kiểm chứng không mutation.
- **Bối cảnh và yêu cầu:** Một int[][] lưu lượng bán từng quầy, mỗi hàng có thể dài khác nhau. Viết rowTotals trả long[] tổng từng hàng và grandTotal dùng lại rowTotals để tính tổng toàn cửa hàng. Không sửa input; ngoài và từng hàng khác null.
- **Dữ liệu / kết quả / ví dụ:** [[2,3],[],[4,0,5]] -> totals=[5,0,9], grand=14.
- **Trường hợp biên:** Mảng ngoài rỗng; mọi hàng rỗng; phần tử [0,1000000], tổng số ô <=10000 nên tổng có thể vượt int.
- **Tiêu chí hoàn thành:** Đúng chiều dài output bằng số hàng, không giả định matrix[0].length cho mọi hàng; ca tổng 3_000_000_000 đúng. Ghi dự đoán (nếu đọc code), kết quả chạy và lý do cho ít nhất một ca biên.
- **Được phép và giới hạn:** Theo phần tiên quyết ở đầu bộ; chỉ dùng kiến thức đã học đến mục này và giới hạn input ghi trong bài. Không thêm dependency; dữ liệu có thể gán literal, chưa bắt buộc nhập bàn phím.

## Sau khi làm

Hoàn thành [checklist và câu tự luận](review.md), cập nhật tiến độ ở cấp gốc theo mã bài. Lưu lời giải của bạn trong starter hoặc file riêng; không gọi/import code trong solutions từ starter.
