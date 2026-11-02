# Đối chiếu JDBC

Reference chạy được và hướng dẫn ở [JDBC mini project](../../../jdbc-practice/mini-project/README.md).
Trước khi xem, tự kiểm: INSERT trả ID, ResultSet.next trước khi get, UPDATE/DELETE
kiểm affected rows, mọi resource đóng bằng try-with-resources. Nếu SQL fail trong
transaction thì rollback; không báo thành công chỉ vì CLI chưa crash.
