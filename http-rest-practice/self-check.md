# Tự kiểm tra khi đóng README và solutions

Ghi câu trả lời và “vì sao” bằng lời của bạn. Những câu này không có đáp án ở file này.

1. Vẽ một request lấy dữ liệu từ Client đến Backend và trở về. Database có luôn được gọi không?
2. HTTP method, URL, headers, body nằm ở đâu? Response khác request ở những phần nào?
3. Một URL có query và fragment: phần nào được gửi tới server? Đoán rawQuery và giải thích percent-encoding.
4. Phân biệt Content-Type và Accept. JSON là một cách biểu diễn hay yêu cầu bắt buộc của mọi API?
5. Với tạo mới, thay toàn bộ, đổi một field và xóa, hãy tự chọn method và nêu contract.
6. DELETE lần đầu trả 204, lần sau trả 404: chỉ riêng việc khác response có bác bỏ idempotent không?
7. PUT và PATCH khác ở ý nghĩa gì? Có phải mọi PATCH đều idempotent không?
8. Tự phân biệt lỗi input, chưa xác thực, thiếu quyền, không tìm thấy và xung đột trạng thái bằng status và ví dụ.
9. “REST = JSON + URL danh từ” có đủ không? Hãy kể các ràng buộc bạn hiểu và phần chưa áp dụng trong API mình thiết kế.
10. Stateless có cấm Database không? Session server-side và token gửi mỗi request ảnh hưởng gì tới lập luận này?
11. Cookie là gì, session là gì, JWT là gì? JWT ký có đồng nghĩa mã hóa không? Backend phải kiểm tra quyền ở đâu?
12. Postman gọi được nhưng browser fetch bị chặn: bạn kiểm tra Origin, preflight, credentials và response headers thế nào?
13. HTTPS giải quyết điều gì và điều gì vẫn phải được Backend kiểm tra?
14. Hủy một order đã shipped: bạn tự thiết kế contract, status lỗi, kiểm tra ownership và hành vi retry.

Chỉ đánh dấu đã nắm khi giải thích được cơ chế và một phản ví dụ, không chỉ nhớ một URL hay mã số.
