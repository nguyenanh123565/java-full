# Kiểm tra workspace — 18/10/2026

## Đã kiểm tra

- So sánh SHA-256 và danh sách toàn bộ 679 file trong ba workspace cũ trước/sau:
  không thay đổi, không thêm/xóa file trong các thư mục đó.
- Đủ 10 workspace mới và 85 bài/project: đúng tên thư mục yêu cầu; mỗi lesson
  có README bảy mục, demo, exercise, solution và notes.
- Bài tập có TODO, yêu cầu dự đoán trước khi chạy và câu hỏi vì sao; lời giải riêng.
- Liên kết Markdown nội bộ tồn tại; file văn bản UTF-8; POM là XML hợp lệ.
- Biên dịch bằng `javac --release 17`: 16 source JDBC và 6 source Java thuần ở
  testing/backend-mini-projects; output chỉ đặt trong thư mục tạm.
- Chạy kiểm tra hành vi Java thuần: BigDecimal, Map demo, CLI add/list/find/update/delete,
  giá/stock/tên không hợp lệ; HTTP 200/404/405, Allow, Content-Type và query string.
- Demo Maven biên dịch bằng javac và kiểm tra main/smoke check thành công;
  điều này không có nghĩa đã chạy Maven lifecycle.
- Git: 8 script parse được với Windows PowerShell 5.1; các demo 01–05, 07, 08
  chạy đúng trong repository tạm, bao gồm conflict có chủ ý.
- Docker Compose: `docker compose config --quiet` kiểm tra cấu hình demo thành công;
  chưa build image hoặc khởi động container.

## Phạm vi chưa chạy

Không tải dependency, cài Maven/driver, setup database hay build/start Docker.
Các project Spring, Security, JPA và bộ test JUnit/Mockito chưa được build/chạy
với dependency của POM; chưa kiểm integration với PostgreSQL thật hoặc issuer JWT.
XML/link/source review không thay cho các kiểm tra runtime đó. Maven chưa có trên
PATH lúc soạn; README từng lab ghi lệnh để chủ động chạy khi học tới nơi.
Demo Git 06 chưa chạy trọn vẹn vì Git shell trong sandbox Windows báo lỗi tạo
signal pipe (Win32 error 5), dù remote mẫu chỉ là bare repository local.

[Roadmap](README.md) · [Toàn bộ cây thư mục mới](STRUCTURE.md)
