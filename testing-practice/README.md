# Testing practice

Điều kiện: Java methods/interface/exception; Maven test; Spring MVC cho bài 07–08.
Thứ tự bắt buộc ở đây là hành vi → JUnit/AAA → assertion → fake → mock → service → controller → integration.
Không bắt đầu bằng việc mock mọi lớp. Test tồn tại để phát hiện hành vi sai, không để đếm annotation.

| Bài | Nội dung |
| --- | --- |
| 01 | [Test để bắt sai hành vi](01-testing-mindset/README.md) |
| 02 | [JUnit và Arrange / Act / Assert](02-junit/README.md) |
| 03 | [Assertion diễn đạt hợp đồng](03-assertions/README.md) |
| 04 | [Unit test và fake viết tay](04-unit-test/README.md) |
| 05 | [Khi cần mock / stub](05-mockito/README.md) |
| 06 | [Kiểm quy tắc service](06-service-test/README.md) |
| 07 | [Kiểm HTTP mapping với MockMvc](07-controller-test/README.md) |
| 08 | [Kiểm các thành phần ghép thật](08-integration-test/README.md) |

## Cách chạy khi học tới đây

Lab chung ở [lab/](lab/README.md), dùng Java 17 + Boot 3.5.16 để chia sẻ JUnit,
Mockito và MockMvc đã được quản lý version. Chỉ bài HTTP integration mới khởi động
Spring. Bài unit chỉ `new` object. Không cần DB để chạy các test mặc định.
Xem [JUnit 5.12.2](https://docs.junit.org/5.12.2/user-guide/) cho cơ chế runner/AAA/assertion
và [Mockito](https://site.mockito.org/) cho mock/stubbing/verification.

1. Từng bài: đọc README → dự đoán → demo → exercise → notes → solution.
2. Làm [exercises tổng hợp](exercises/README.md).
3. Áp dụng [mini-project-tests](mini-project-tests/README.md) cho product API của mình.

Đạt chặng khi một bug nghiệp vụ làm test đỏ, sửa bug làm xanh, và bạn chỉ rõ mỗi
test kiểm lớp nào, bỏ sót lớp nào. Test xanh với mock không chứng minh SQL đúng.
