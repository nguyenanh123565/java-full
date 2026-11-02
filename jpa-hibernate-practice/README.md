# JPA / Hibernate — chỉ học sau JDBC

Trước khi mở workspace này, hoàn thành JDBC Product CLI và giải thích được PreparedStatement, ResultSet, commit/rollback. Học Spring Boot DI + Service trước để hiểu proxy và transaction.

```text
Application
    ↓ gọi repository
Spring Data JPA (repository abstraction, proxy implementation)
    ↓ dùng EntityManager
JPA (đặc tả/API jakarta.persistence)
    ↓ provider triển khai
Hibernate (ORM implementation, mapping + dirty checking + SQL)
    ↓
JDBC (API + PostgreSQL driver)
    ↓
PostgreSQL (database server)
```

JPA không phải database. Hibernate vẫn thực thi SQL thông qua JDBC. Có thể dùng JPA EntityManager trực tiếp mà không dùng Spring Data JPA. HTTP do web layer xử lý; workspace này tập trung persistence bằng console lab để nhìn SQL rõ hơn.

```text
Java Object ↔ Database Row
Class       ↔ Table
Field       ↔ Column
```

## Thứ tự học
1. [Vấn đề ORM giải quyết](01-orm-problem/README.md)
2. [JPA, Hibernate và Spring Data JPA](02-jpa-vs-hibernate/README.md)
3. [Entity, table, field và column](03-entity/README.md)
4. [Sinh ID và identity](04-id-generation/README.md)
5. [Repository và truy cập dữ liệu](05-repository/README.md)
6. [Quan hệ one-to-one và owning side](06-one-to-one/README.md)
7. [One-to-many và many-to-one](07-one-to-many/README.md)
8. [Many-to-many và join table](08-many-to-many/README.md)
9. [Fetch type và thời điểm đọc dữ liệu](09-fetch-type/README.md)
10. [Cascade và vòng đời entity](10-cascade/README.md)
11. [JPQL và entity query](11-jpql/README.md)
12. [Native SQL trong repository](12-native-query/README.md)
13. [Transaction, persistence context và dirty checking](13-transaction/README.md)
14. [N+1 và fetch join có chủ đích](14-n-plus-one/README.md)

Sau bài 14 làm [bài tổng hợp](exercises/README.md) và [mini project](mini-project/README.md); [solutions](solutions/README.md) tách riêng.

## Cách đọc và chạy

Mỗi lesson có bảy phần README, demo/exercise/solution/notes. Các file `demo/example.java.txt` là **trích đoạn có ngữ cảnh**, không phải 14 ứng dụng độc lập, không đem javac riêng. Chúng giải thích một thay đổi nhỏ trên [console reference](mini-project/solution/README.md). Demo quan hệ chưa có trong reference ghi rõ DDL/entity cần bổ sung ở bản sao; không tự chạy hết snippets cùng lúc.

Reference dùng Java 17, Spring Boot **3.5.16** làm baseline học cố định, không tuyên bố là bản mới nhất; `jakarta.persistence`, chỉ dependency trực tiếp `spring-boot-starter-data-jpa` và PostgreSQL driver. Maven giải quyết dependency khi bạn chủ động chạy; workspace này chưa tải dependency hay setup database.

Schema `learning_jpa` trong database học MỚI `learning_backend_jpa`, tách JDBC và ba workspace cũ. `ddl-auto=validate` không tạo/reset schema; bạn đọc và chạy SQL thủ công sau khi đã tạo database học đúng. Không dùng ddl-auto=create/create-drop/update để tránh âm thầm đổi cấu trúc dữ liệu.

Quan sát SQL log để thấy ORM thực sự làm gì. `save()` khác commit; setter của managed entity có thể tạo UPDATE ở flush; mọi relation không nhất thiết đã load. Ghi dự đoán số SQL trước khi chạy.

Tài liệu chính thức: [Jakarta Persistence](https://jakarta.ee/specifications/persistence/), [Hibernate ORM user guide](https://docs.jboss.org/hibernate/orm/6.6/userguide/html_single/Hibernate_User_Guide.html), [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/reference/), [Spring transaction semantics](https://docs.spring.io/spring-framework/reference/data-access/transaction/declarative/annotations.html).
