# Tham khảo: Tổng kết nền tảng

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## FUN-01 — Đọc số đếm ASCII bằng tay

Sau kiểm tra null và length, duyệt từng char rồi tích lũy. Sentinel -1 không trùng miền kết quả hợp lệ.

**Lỗi thường gặp:** Bỏ qua char sai rồi chấp nhận "12a" thành 12.

## FUN-02 — Text, data và snapshot qua hàm

Caller name="A", data=[2], copy=[1]. Gán lại values không thay caller; concat không sửa String cũ.

**Lỗi thường gặp:** Kết luận vì name không đổi nên data cũng không được đổi do pass-by-value.

## FUN-03 — Trung bình bị âm

Lỗi thứ nhất tổng int tràn; thứ hai chia hai số nguyên bỏ phần lẻ. Sửa cả hai ở đúng thời điểm.

**Lỗi thường gặp:** Chỉ đổi kiểu trả về thành double mà giữ tổng int và phép chia nguyên.

## FUN-04 — Báo cáo điểm có dữ liệu sai

Tách dữ liệu sai khỏi nghiệp vụ đạt; dùng count theo hợp đồng, total long. Chuỗi báo cáo xác định nên đối chiếu trực tiếp được.

**Lỗi thường gặp:** Loại điểm 0 như dữ liệu thiếu hoặc tính điểm 101 là đạt.

## FUN-05 — Phiếu bán hàng bằng mảng song song

Có thể kiểm tra tất cả input trong lượt đầu rồi dựng phiếu trong lượt thứ hai. Tổng tối đa 1_000_000_000_000 nên long đủ. Đây là một cách chia hàm, không ép cấu trúc duy nhất.

**Lỗi thường gặp:** Dùng int cho thành tiền, sửa names tại chỗ khi chuẩn hóa hoặc bỏ qua dòng sai thay vì trả INVALID.
