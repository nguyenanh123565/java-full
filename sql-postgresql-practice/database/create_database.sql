-- Chạy khi đang kết nối database postgres, bằng role có quyền CREATEDB.
-- Chỉ chạy một lần. PostgreSQL không có CREATE DATABASE IF NOT EXISTS.
-- Không bọc CREATE DATABASE trong BEGIN/COMMIT.
CREATE DATABASE sql_postgresql_practice WITH ENCODING 'UTF8';
