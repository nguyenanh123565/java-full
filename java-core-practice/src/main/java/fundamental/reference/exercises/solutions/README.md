# Tham khảo: Tham chiếu

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## REF-01 — Ảnh chụp số và alias

Mutation làm a thấy 8; saved vẫn 5. Sau alias=new Box(9), a vẫn giữ Box8.

**Lỗi thường gặp:** Cho rằng saved cũng thành 8 vì được lấy từ field của Box.

## REF-02 — Hai slot rồi tách một slot

9,7,7,false; sau shared=null, boxes[1].value vẫn 7.

**Lỗi thường gặp:** Tưởng hai slot đã được buộc thành một biến duy nhất.

## REF-03 — Reset không tới caller

Kiểm tra null rồi sửa field qua reference. Caller và alias vẫn trỏ cùng object.

**Lỗi thường gặp:** Tạo Box0 và gán vào tham số, vẫn không đổi Box cũ của caller.

## REF-04 — Copy từng Box theo slot

Một vòng for tạo array ngoài rồi từng Box. Đây là copy độc lập theo slot; một hợp đồng khác có thể yêu cầu bảo toàn quan hệ alias.

**Lỗi thường gặp:** Dùng Arrays.copyOf rồi nhầm rằng các Box bên trong đã được sao chép.

## REF-05 — Chuyển giá trị giữa hai hộp

Hợp đồng giới hạn tổng đích tối đa 2_000_000, an toàn int. Loại lỗi trước; chuyển giữa hai Box khác nhau bảo toàn tổng.

**Lỗi thường gặp:** Kiểm tra cùng Box trước thiếu lượng rồi chấp nhận amount vượt số đang có.
