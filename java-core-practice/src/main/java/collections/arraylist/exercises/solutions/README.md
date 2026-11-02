# Đối chiếu sau khi tự làm: ArrayList

[ReferenceSolution.java](ReferenceSolution.java) chứa một phương án và các kiểm tra bằng `AssertionError`; không cần JUnit hay `-ea`. Code thiết kế mở chỉ là một phương án, không phải đáp án duy nhất. Đối chiếu hành vi và bất biến, không yêu cầu tên class hay cách chia method giống nhau.

Từ thư mục `java-core-practice`:

```powershell
.\build.ps1
java -cp target/classes collections.arraylist.exercises.solutions.ReferenceSolution
```

Chạy xong in `PASS AL: 5 bài`. Reference kiểm tra các tình huống đại diện được ghi trong source; bạn vẫn cần tự bổ sung các trường hợp biên còn lại của đề và giải thích bằng lời. Check có tiền tố mã bài để xác định yêu cầu bị sai.

## AL-01 — Lọc điểm hợp lệ

Duyệt từng điểm, add khi 0 <= điểm <= 10. Lỗi hay gặp là sửa nguồn hoặc loại nhầm điểm biên.

Đối chiếu đoạn kiểm tra có mã `AL-01` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## AL-02 — Bản sao nông với object

Hai value đều 7, a.size() bằng 1. Bản sao cấu trúc không sao chép Item.

Đối chiếu đoạn kiểm tra có mã `AL-02` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## AL-03 — Xóa liên tiếp bị bỏ sót

Duyệt từ size()-1 xuống 0 và xóa nếu âm. Duyệt xuôi cần chỉ tăng i khi không xóa.

Đối chiếu đoạn kiểm tra có mã `AL-03` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## AL-04 — Phân trang danh sách

Kiểm tra âm; khi offset vượt nguồn trả rỗng; lấy min(limit,size-offset) phần tử vào list mới.

Đối chiếu đoạn kiểm tra có mã `AL-04` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.

## AL-05 — Sổ điểm và báo cáo độc lập

Một phương án: giữ list private, kiểm tra điểm trước add và new ArrayList<>(scores) khi snapshot. Không cần deep copy Integer.

Đối chiếu đoạn kiểm tra có mã `AL-05` trong [source tham khảo](ReferenceSolution.java), sau đó tự chạy lại đầu vào chuẩn, biên và lỗi ở đề.
