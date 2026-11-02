# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## MED-01 — Chọn cấu trúc trước khi viết code

Ký tự duy nhất là v. Dormitory/dirtyroom là anagram. Các tổng cửa sổ là 2,3,2; best=3. Lỗi: duyệt HashMap để chọn ký tự đầu.

## MED-02 — Theo dõi cửa sổ

Bảng tổng: start=0 sum=2; start=1 thêm -1 bỏ -2 → 3; start=2 thêm 3 bỏ 4 → 2. Nếu đổi 3 thành 4, cửa sổ start 1 và 2 cùng 3, giữ 1.

## MED-03 — long vẫn có thể nhận kết quả sai

`a[i]-a[i-1]` được tính bằng int trước khi cộng long. Sửa `sum+=(long)a[i]-a[i-1]`. Cần kiểm k trước truy cập đầu mảng.

## MED-04 — Kích thước các nhóm anagram

Chuẩn hóa riêng, kiểm mọi char nằm a-z; 26 số đếm tạo key duy nhất cho mỗi đa tập chữ. Map giữ count mỗi nhóm. O(tổng ký tự + 26*số từ), bộ nhớ theo số nhóm. Không dùng tổng mã ký tự vì có thể đụng chữ ký.

## MED-05 — Cửa sổ tốt nhất và vị trí

Khởi tạo tổng long của k phần tử; trượt thêm/bỏ với ép long trước trừ, cập nhật best bằng >. O(n), O(1) bộ nhớ ngoài kết quả. Khởi tạo best=0 sai khi toàn âm.

## MED-06 — Báo cáo hai loại dữ liệu

report gọi groupSizes và bestWindow, ghép Arrays.toString. Không sửa dữ liệu nên lỗi không tạo trạng thái nửa chừng. Mã bên dưới là một phương án.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
