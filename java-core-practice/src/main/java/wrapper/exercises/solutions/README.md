# Tham khảo: Wrapper

[Về đề bài](../README.md) · [Code chạy được](ReferenceSolution.java)

Đây là một phương án tham khảo; cách khác hợp lý và đúng hợp đồng đều được chấp nhận. Bài suy luận cần giải thích trước khi xem kết quả. Các đoạn lỗi trong đề chỉ giữ dưới dạng văn bản; source này chứa bản đúng. `main` dùng assert để kiểm chứng các ca đại diện và biên; chạy với `-ea`. Các câu assert thuộc bộ kiểm chứng, tách khỏi thuật toán cần học. Kết quả OK không thay cho phần giải thích hay toàn bộ ca bạn tự bổ sung.

## WRP-01 — Primitive hay object từ văn bản

parseInt trả primitive, valueOf trả wrapper; khoảng trắng và vượt miền đều lỗi, +12 và MIN_VALUE hợp lệ.

**Lỗi thường gặp:** Mong parseInt tự trim hoặc chấp nhận số nằm ngoài int vì biến đích là long.

## WRP-02 — Kết luận nào độc lập cache?

Kết luận ổn định true,false,true cho ba biểu thức sau a==b. Với hằng 127 autoboxing có bảo đảm dùng chung identity; ngoài vùng không dùng kết quả == làm nghiệp vụ.

**Lỗi thường gặp:** Khẳng định mọi giá trị trên 127 bắt buộc == false trên mọi JVM.

## WRP-03 — Fallback bị unbox thành lỗi

Bản cũ có numeric conditional nên fallback có thể bị unbox. Return trực tiếp reference qua if bảo toàn null và boxing không cần thiết.

**Lỗi thường gặp:** Dùng preferred!=null?preferred:0, lẫn dữ liệu thiếu với 0.

## WRP-04 — Nhập một giá trị có thể vắng

Tách nhập một phần tử khỏi tổng hợp giúp kiểm tra lỗi riêng. Null sentinel không lẫn với số 0 hoặc số âm.

**Lỗi thường gặp:** Catch Exception quá rộng để che cả lỗi lập trình, hoặc cộng wrapper null vào tổng.

## WRP-05 — Báo cáo cảm biến có dữ liệu thiếu

Bỏ null nhưng tăng missing. Primitive dùng cho tính toán sau guard; wrapper dùng để biểu diễn vắng dữ liệu. Lời giải là một phương án tổ chức.

**Lỗi thường gặp:** Khởi tạo min=0 làm sai dữ liệu toàn dương, max=0 làm sai dữ liệu toàn âm, hoặc biến mọi null thành 0.
