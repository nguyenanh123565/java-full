# Thực hành Postman — TODO

## TODO 1 — Chuẩn bị client

- TODO: Khởi động lab; tạo collection và environment local có biến baseUrl.
- TODO: Lưu request đọc health. Dự đoán status, Content-Type và body trước khi gửi.
- TODO: Giải thích lỗi “không kết nối” khác response HTTP lỗi thế nào.

## TODO 2 — GET và HEAD

- TODO: Lưu hai request GET và HEAD cho sản phẩm id 10 của lab.
- TODO: Ghi lại status, headers, body và điểm khác biệt; giải thích theo HTTP.
- TODO: Ghi rõ dữ liệu này ở memory hay PostgreSQL theo README lab.

## TODO 3 — Query và headers

- TODO: Gửi GET vào echo với query `search=robot hut bui`, `limit=3` bằng tab Params.
- TODO: Thêm header `X-Lab-Header` và `Accept`; quan sát query thô và nhóm headers được lab echo.
- TODO: Giải thích encoding, header tự thêm và header do bạn đặt.

## TODO 4 — Raw body

- TODO: Gửi POST vào echo với JSON do bạn viết gồm name, stock và active.
- TODO: Dự đoán body response sẽ chứa object hay string; đối chiếu với lab contract.
- TODO: Gửi JSON sai cú pháp; giải thích vì sao kết quả echo không đại diện cho validation của API thật.

## TODO 5 — Response lỗi và không có body

- TODO: Lưu các request tới status 204, 400, 401, 403, 409 và 422.
- TODO: Tạo bảng status/body/headers và lý do API nghiệp vụ có thể chọn từng status.
- TODO: Kiểm tra method không được hỗ trợ trên `/health`; tìm header có ích.
- TODO: Phân biệt “simulator trả status” với “nghiệp vụ thật tạo ra lỗi”.

## TODO 6 — Tự kiểm tra collection

- TODO: Chọn ba request; ghi điều kiện trước, dự đoán và quan sát.
- TODO: Tự viết kiểm tra bằng tay hoặc script Postman cho status, Content-Type và một trường response; giải thích vì sao kiểm tra đó có ý nghĩa.
- TODO: Không chỉ kiểm tra mọi request đều 200; lập case thất bại có chủ ý.

## TODO 7 — CORS

- TODO: Gửi request `/cors` có Origin `http://localhost:3000`, rồi thử Origin khác.
- TODO: Xem headers; giải thích vì sao Postman vẫn hiển thị response khi browser có thể chặn truy cập response.
- TODO: Dùng bài 14 để quan sát browser thật; giải thích preflight khác request nghiệp vụ thế nào.

## TODO 8 — Chuyển sang API bạn thiết kế

- TODO: Chọn hai nghiệp vụ từ design-api, lưu request dự kiến trong collection nhưng ghi chú CHƯA TRIỂN KHAI.
- TODO: Ghi expected response riêng, không coi response 404 của lab là phản biện thiết kế.
- TODO: Export collection không chứa bí mật và viết cách chạy cho một người khác.
