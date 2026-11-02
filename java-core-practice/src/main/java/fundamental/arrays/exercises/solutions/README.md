# Tham khảo: Mảng

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## ARR-01 — Đếm số dương

Enhanced for thích hợp vì chỉ đọc phần tử; return số đếm sau loop.

**Lỗi thường gặp:** Dùng >=0 nên tính nhầm các số 0.

## ARR-02 — Copy ngoài và thay một hàng

a=[[9,2],[3]], b=[[9,2],[8]], hai so sánh true,false. Thay b[0] bằng [] không làm a[0] đổi.

**Lỗi thường gặp:** Cho rằng mọi thay đổi qua b đều lan sang a hoặc không thay đổi nào lan sang a.

## ARR-03 — Vòng lặp không xóa mảng

Enhanced for sao chép mỗi giá trị int vào value. Vòng có chỉ số sửa đúng phần tử trong mảng gốc.

**Lỗi thường gặp:** Đổi values=new int[values.length] trong hàm rồi cho rằng caller đã nhận mảng mới.

## ARR-04 — Xoay phải một bước

Một array mới và một vòng loop đủ xử lý, O(n) thời gian và O(n) bộ nhớ kết quả.

**Lỗi thường gặp:** Gán result=values rồi xoay làm thay đổi input, hoặc chia dư theo 0 ở mảng rỗng.

## ARR-05 — Báo cáo bán hàng lệch hàng

Duyệt matrix[row].length, cộng dồn trong long. Tái sử dụng rowTotals giúp thống nhất quy tắc xử lý hàng rỗng.

**Lỗi thường gặp:** Lấy độ dài hàng đầu làm số cột chung hoặc dùng int để cộng tổng.
