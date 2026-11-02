# Tham khảo: Biến và kiểu dữ liệu

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## VAR-01 — Bản ghi cảm biến

Dùng int, long, double, char, boolean tương ứng. Literal 3_000_000_000L tạo long ngay từ đầu.

**Lỗi thường gặp:** Viết literal quá lớn dưới dạng int rồi hy vọng biến long tự cứu lỗi biên dịch.

## VAR-02 — Thu hẹp rồi gán lại

Với 130, kết quả là -126, 130, 5. Với 127: 127,127,5; với 128: -128,128,5. Gán lại raw không sửa saved.

**Lỗi thường gặp:** Cho rằng cast là kiểm tra miền và sẽ từ chối giá trị 130.

## VAR-03 — Hai lỗi trước khi chạy

Local không có giá trị mặc định để đọc; gán count=0. Literal lớn cần L dù biến đích là long.

**Lỗi thường gặp:** Nhầm quy tắc mặc định của field/phần tử mảng với local.

## VAR-04 — Tách thời lượng

hours=total/3600; remainder=total-hours*3600; minutes=remainder/60; seconds=remainder-minutes*60.

**Lỗi thường gặp:** Chia tổng ban đầu cho 60 để lấy phút rồi không bỏ phần đã thuộc giờ.

## VAR-05 — Báo cáo hai kho

long total=1L*crates*units; double average=(double)total/2; int snapshot=crates. Tại biên trên tổng là 6_000_000_000, trung bình 3_000_000_000.0.

**Lỗi thường gặp:** Ép kiểu cả tích sau khi phép nhân int đã tràn.
