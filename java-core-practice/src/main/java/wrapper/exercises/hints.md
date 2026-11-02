# Gợi ý: Wrapper

[Về đề bài](README.md)

Chỉ mở từng mức khi đã thử và ghi rõ điểm bí. Mức 2 gần cách làm hơn; lời giải vẫn tách riêng.

## WRP-01 — Primitive hay object từ văn bản

**Mức 1:** Cả hai kiểm tra miền int nhưng kiểu trả về khác.

**Mức 2:** Dùng khai báo int primitive=... và Integer boxed=..., catch NumberFormatException trong lượt xử lý.

## WRP-02 — Kết luận nào độc lập cache?

**Mức 1:** equals wrapper xét cả loại wrapper.

**Mức 2:** a.equals(b) true; a.equals(c) false; khi unbox thành primitive thì 1000 và 1000L bằng nhau.

## WRP-03 — Fallback bị unbox thành lỗi

**Mức 1:** Hai nhánh ?: có kiểu int và Integer, hãy kiểm tra kiểu biểu thức kết quả.

**Mức 2:** Dùng if(preferred!=null)return preferred; return fallback; để không có unboxing bắt buộc.

## WRP-04 — Nhập một giá trị có thể vắng

**Mức 1:** Kiểm tra null trước trim; parse sau khi đã có chuỗi sạch.

**Mức 2:** Trả Integer.valueOf(clean) trong try, catch NumberFormatException trả null; vòng ngoài chỉ cộng khi value!=null.

## WRP-05 — Báo cáo cảm biến có dữ liệu thiếu

**Mức 1:** Chưa biết min/max cho tới số hợp lệ đầu tiên.

**Mức 2:** Dùng count==0 để nhận số đầu, sau đó so sánh primitive; khi kết thúc count==0 thì xuất NA.
