# Kiểm tra bổ sung bài tập — 22/10/2026

Đã chạy `verify-exercises.ps1` từ thư mục gốc Java Core, sau các chỉnh sửa cuối cùng.

## Kết quả đã chạy

- **58 bộ / 291 bài mới**: đủ mọi mục và mục con có README ban đầu; mỗi bộ có đề, starter, gợi ý, review, lời giải và code tham khảo. Mã bài không trùng.
- **891 đích file liên kết nội bộ**, trong **296 file Markdown**: tồn tại; không còn liên kết hỏng.
- **275 file Java** gồm 159 file cũ và 116 file mới: biên dịch thành công qua `build.ps1` bằng `javac 23.0.1 --release 17 -encoding UTF-8`.
- **160 main Demo/Solution**: chạy thành công trên Java 23.0.1, bật `-ea`; gồm 102 main cũ và 58 reference mới. Main bài làm Exercise/Starter không được chạy để chấm điểm hoặc tự sửa bài của người học.
- Ca kiểm chứng mới có dữ liệu bình thường/biên/lỗi, số âm/trùng/rỗng, overflow, quy tắc hòa/thứ tự, snapshot và trạng thái giữ nguyên khi validation thất bại. OOP kiểm đơn hàng/xác nhận/EMAIL/SMS/PUSH; mini project kiểm cập nhật cả lô, bán cả giỏ và mã chuyển tiền gửi lại. Đã kiểm thêm điểm -0.0/0.0 hòa theo mã.
- Đối chiếu snapshot SHA-256 của **1056 file có trước**: 996 file giữ nguyên hoàn toàn; 60 tài liệu chỉ nối thêm phần mới và giữ nguyên toàn bộ bytes ban đầu. Không đổi code/bài làm/ghi chú cũ, POM hay script build. Không có file mới/thay đổi ngoài Java Core, gồm HTTP/REST và SQL/PostgreSQL.

Output chạy nằm ở `target/exercise-verification/run-log.txt`; báo cáo đối chiếu file là `target/exercise-verification/integrity-report.json`. File kiểm kê trước sửa và các bản kiểm tra riêng từng nhóm cũng chỉ nằm trong `target/`, ngoài source học tập. Có thể chạy lại kiểm tra tài liệu, cấu trúc bộ bài, biên dịch và các main bằng:

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File .\verify-exercises.ps1
```

## Giới hạn kiểm tra

- Máy có JDK 23.0.1; đã kiểm source/bytecode đích Java 17 qua `--release 17`, chưa chạy bằng JVM 17 riêng.
- Chưa chạy Maven vì `mvn` không có trên PATH. Không cài thêm công cụ/dependency; đường build bằng JDK sẵn có đã chạy thành công.
- Kiểm tra liên kết xác nhận đích file Markdown nội bộ; không kiểm URL ngoài mạng hoặc anchor theo trình render.
- Các main kiểm ca minh họa và những biên quan trọng, không phải bộ chấm bao phủ mọi dữ liệu của 291 đề. Bài thiết kế mở, câu hỏi tự luận và khả năng tự giải thích cần người học hoàn tất `review.md`; việc chạy reference không tự nâng tiến độ.

[Hướng dẫn học](STUDY_GUIDE.md) · [Tiến độ](PROGRESS.md) · [Khảo sát](PRACTICE_AUDIT.md)
