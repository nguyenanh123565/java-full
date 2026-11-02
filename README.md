# Java Backend — học từ cơ chế đến project

Đây là thư mục gốc workspace (`E:\JAVA_FULL`), tương ứng `backend-learning/`
trong sơ đồ yêu cầu. Ba khu Java Core, HTTP và SQL giữ nguyên vị trí và nội dung.
Mỗi công nghệ có khu riêng; ghép chúng lại qua các project monolith nhỏ.

## Roadmap

```text
Java Core
   + HTTP
   + SQL
       ↓
JDBC
       ↓
Maven
       ↓
Spring Boot
       ↓
JPA / Hibernate
       ↓
Security
       ↓
Testing
       ↓
Docker / Linux
       ↓
Backend Project
```

Git học song song từ ngày đầu. Testing có một chặng học riêng sau Security,
nhưng tư duy kiểm tra input/output dùng ngay khi học Java; không cần chờ framework.
Các project nhỏ thực hiện sau mỗi chặng, project cuối chỉ làm khi đủ điều kiện.

## Học ngay và điều kiện chuyển bước

| Thứ tự | Workspace | Khi nào học / dấu hiệu đã hiểu |
| --- | --- | --- |
| 1 | [Java Core](java-core-practice/README.md) | Học ngay. Tự viết method, class, interface, collection và xử lý exception. |
| 1 | [HTTP + REST](http-rest-practice/README.md) | Học song song Java: đọc method, URL, header, JSON, status; phân biệt 400/401/403/404. |
| 1 | [SQL + PostgreSQL](sql-postgresql-practice/README.md) | Học ngay: SELECT, CRUD, PK/FK, JOIN, constraint và transaction. |
| Song song | [Git + GitHub](git-github-practice/README.md) | Học ngay từ repository đến commit; làm PR sau khi hiểu branch, merge và remote. |
| 2 | [JDBC](jdbc-practice/README.md) | Sau Java OOP/exception + SQL CRUD. Tự map ResultSet, đóng resource và rollback khi lỗi. |
| 3 | [Maven](maven-practice/README.md) | Sau khi đã thấy javac/classpath ở JDBC. Giải thích compile/test/package/install và dependency/plugin. |
| 4 | [Spring Boot](spring-boot-practice/README.md) | Sau HTTP + JDBC + Maven. Vẽ request → controller → service → repository bằng lời của mình. |
| 5 | [JPA / Hibernate](jpa-hibernate-practice/README.md) | Sau JDBC transaction và Spring DI. Đọc SQL sinh ra; giải thích FK, owning side, N+1. |
| 6 | [Spring Security](spring-security-practice/README.md) | Sau REST CRUD/validation/error. Giải thích authentication khác authorization và session khác JWT. |
| 7 | [Testing](testing-practice/README.md) | Học theo thứ tự: hành vi → JUnit → fake → Mockito → HTTP → DB integration. |
| 8 | [Docker + Linux](docker-linux-practice/README.md) | Sau khi chạy được app bằng lệnh. Phân biệt host/container port, env, log và volume. |
| Sau từng chặng | [Backend mini projects](backend-mini-projects/README.md) | CLI → JDBC → HTTP thuần → Spring API → e-commerce monolith. |
| Mỗi buổi | [Notes + review](notes-review/README.md) | Ghi dự đoán sai, bug, mental model và câu hỏi còn mở. |

**Chưa nên bắt đầu Spring/JPA/Security/JWT/Docker và e-commerce nếu chưa qua
điều kiện ở hàng tương ứng.** Không cần đọc hết mọi folder trong một lượt.

## Nhịp học một lesson

1. Đọc Problem và Mental model; tự nói khái niệm giải quyết việc gì.
2. Ghi dự đoán output, HTTP response hoặc SQL trước khi chạy demo.
3. Làm `exercise/` với TODO; thử input bình thường, biên và lỗi.
4. Viết lý do vào `notes.md` rồi mới đối chiếu `solution/` riêng.
5. Làm bài tổng hợp ở `exercises/` hoặc `mini-project/` của workspace.

Các bài mới dùng `README.md`, `demo/`, `exercise/`, `solution/`, `notes.md`.
Demo dùng chung một lab nhỏ khi hợp lý; README chỉ rõ file và lệnh thay vì tạo
một ứng dụng/dependency riêng cho từng annotation. Snippet được ghi rõ là đoạn
minh họa, không hứa chạy độc lập. Thư mục `solution/` và `solutions/` là tài liệu
đối chiếu; exercise không import hoặc gọi code lời giải.

## Công cụ và phạm vi

Source mới dùng cú pháp Java 17, không yêu cầu thay đổi JDK hiện có. Các lab Spring
chọn cố định Boot 3.5.16 làm mốc học, không gọi đó là phiên bản mới nhất.
Theo [yêu cầu hệ thống chính thức](https://docs.spring.io/spring-boot/3.5/system-requirements.html),
nhánh này hỗ trợ Java 17–25. Đọc lệnh chạy ở README của từng lab; Maven, driver
PostgreSQL và Docker chỉ cần khi thực sự chạy bài tương ứng. Không có root POM,
không build tất cả workspace cùng lúc, không cần cài thêm công cụ để đọc bài.

Dependency được giới hạn trong lab cần nó: PostgreSQL driver cho JDBC/JPA,
starter web/validation cho REST, security cho bài bảo vệ API, test cho bài test.
Chưa học microservices, Kafka, Kubernetes hay cloud. Không có bước tự động sửa
bài cũ hoặc setup database của bạn.

Xem [toàn bộ cây thư mục mới](STRUCTURE.md), [bức tranh backend](notes-review/backend-big-picture.md)
và [kết quả kiểm tra / phần chưa chạy](VALIDATION.md).
