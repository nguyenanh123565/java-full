BEGIN;
-- 1. FK kiểm tra sự tồn tại của cha; NOT NULL làm quan hệ bắt buộc.
CREATE TEMP TABLE lesson_fk_parent (id BIGINT PRIMARY KEY, name TEXT NOT NULL)
ON COMMIT DROP;
CREATE TEMP TABLE lesson_fk_child (
    id BIGINT PRIMARY KEY,
    name TEXT NOT NULL,
    category_id BIGINT NOT NULL REFERENCES lesson_fk_parent(id) ON DELETE RESTRICT
) ON COMMIT DROP;
INSERT INTO lesson_fk_parent (id, name) VALUES (1, 'robot');
INSERT INTO lesson_fk_child (id, name, category_id) VALUES (1, 'Robot demo', 1);

-- 2. Không có dòng cha 999: FK từ chối, không tự thêm cha hay đọc tên cha.
-- INSERT INTO lesson_fk_child (id, name, category_id) VALUES (2, 'Sai FK', 999);

-- 3. RESTRICT từ chối xóa cha còn được tham chiếu; giữ statement lỗi ở comment.
-- DELETE FROM lesson_fk_parent WHERE id = 1;
DELETE FROM lesson_fk_child WHERE category_id = 1 RETURNING id, category_id;
DELETE FROM lesson_fk_parent WHERE id = 1 RETURNING id, name;
-- CASCADE sẽ tự xóa con khi xóa cha; có thể làm mất lịch sử nghiệp vụ.
-- FK chỉ kiểm tra con tham chiếu cha hợp lệ, không yêu cầu mọi cha có con.
ROLLBACK;
