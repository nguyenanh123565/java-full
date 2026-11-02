# Đối chiếu sau khi tự làm

Một phương án tham khảo; cách khác được chấp nhận nếu đúng hợp đồng và giải thích được.

## PROD-01 — Giá trị kho chính xác

Giá trị kho = priceVnd*quantity tính bằng Math.multiplyExact(long,long); 12000*3=36000. Sau bán 2 còn 1, giá trị 12000. Giá và stock không âm; lượng bán dương.

## PROD-02 — Hai danh mục cùng giữ một sản phẩm

Map copy vẫn chứa cùng Product. Cập nhật quantity ảnh hưởng value ở cả hai Map; đổi cấu trúc copy không đổi map gốc. Snapshot phải giữ giá trị tại thời điểm lấy.

## PROD-03 — Giảm kho trước validation

Không trừ stock trước khi kiểm đủ hàng. Tính tổng tiền bằng long và multiplyExact/addExact trước commit; nếu overflow, không cập nhật bất kỳ sản phẩm nào.

## PROD-04 — Bán giỏ nhiều dòng

Gộp số lượng cùng ID trong Map tạm bằng Math.addExact, kiểm mọi ID tồn tại và đủ stock, dự tính tổng tiền rồi commit một lần. O(m+k) kỳ vọng; lỗi không có hiệu ứng phụ.

## PROD-05 — Danh sách giá là snapshot

Tạo snapshot id/name/price/quantity bất biến, sort giá giảm rồi mã tăng bằng Long.compare; không dùng hiệu ép int. Snapshot cũ không đổi sau bán.

## PROD-06 — Lệnh bán sai và tiếp tục

SELL cần đúng ba trường và số lượng parse được; lỗi trả ERR và tồn kho giữ nguyên. EXIT là lệnh duy nhất yêu cầu kết thúc. Console loop tiếp tục sau ERR.

## PROD-07 — Quầy bán hàng có đối soát

Mã tham khảo dùng service một luồng và các snapshot độc lập. Bài toán không cần kế thừa. Nếu thiết kế khác vẫn bảo vệ stock và commit sau validation thì được chấp nhận.

[ReferenceSolution.java](ReferenceSolution.java) chứa cách làm và ca chạy cho phần viết code. Các câu suy luận/thiết kế cần đối chiếu phần giải thích phía trên.
