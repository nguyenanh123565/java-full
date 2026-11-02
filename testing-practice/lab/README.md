# Lab testing dùng chung

Chạy từ `E:\JAVA_FULL` khi đã học Maven:

```powershell
mvn -f testing-practice/lab/pom.xml test
```

Lab mặc định gồm unit test, Mockito test, MVC test và HTTP integration với Map.
JDBC integration **bị skip** nếu chưa đặt `TEST_DB_URL`; không suy ra DB đã được test.
JUnit/Mockito/MockMvc đi qua starter-test; web cần cho controller/HTTP. Profile
`postgres-test` chỉ thêm driver test khi cần kiểm PostgreSQL thật.

Để chạy DB test sau khi tự chuẩn bị DB học riêng, đặt `TEST_DB_URL` dạng
`jdbc:postgresql://localhost:5432/backend_testing`, `TEST_DB_USER`, `TEST_DB_PASSWORD`
bằng giá trị của bạn trong shell, rồi:

```powershell
mvn -f testing-practice/lab/pom.xml -Ppostgres-test -Dtest=JdbcIntegrationTest test
```

Test chỉ tạo TEMP TABLE trong transaction và luôn rollback. Không dùng database
đang chứa bài SQL cũ. Không cần cài thư viện chỉ để đọc README; Maven sẽ resolve
dependency khi bạn chủ động chạy. Chưa có Maven trên PATH tại lúc soạn workspace.

`@SpringBootApplication` đánh dấu cấu hình, component scan và auto-configuration;
nếu Java thuần bạn phải tự nối object và khởi động HTTP server.
`@Repository`/`@Service` đăng ký object theo trách nhiệm, constructor nhận dependency;
nếu không có Spring, tự new repo rồi truyền vào service. Chúng không tự tạo query SQL.
`@RestController`, `@RequestMapping`, `@GetMapping`, `@PathVariable` nối HTTP path/method
và dữ liệu vào method Java; Java HTTP thuần phải tự route/parse/serialize.
`@ExceptionHandler` chuyển lỗi Java thành response hợp đồng. Trong test, `@Test`
được JUnit runner gọi; `@SpringBootTest` dựng app thật; `@Autowired` cấp HTTP test client.
Không có annotation nào biến Map thành PostgreSQL.
