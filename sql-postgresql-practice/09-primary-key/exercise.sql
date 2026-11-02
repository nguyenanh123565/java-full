-- TODO 1 (dễ): Trong BEGIN ... ROLLBACK, tạo TEMP TABLE lesson_pk_exercise
-- có id BIGINT PRIMARY KEY (không identity), name TEXT NOT NULL; ghi hai ID khác nhau.
-- Giải thích vì sao phải tự truyền ID và vì sao ID không cần liên tục.

-- TODO 2 (vừa): Chỉ viết bằng comment hai INSERT: một trùng ID, một ID NULL.
-- Dự đoán chúng vi phạm điều kiện nào của PRIMARY KEY và giải thích vì sao.
-- Không chạy statement lỗi trong cùng script demo để transaction không bị abort.

-- TODO 3 (khó): Tạo TEMP TABLE lesson_cart_exercise có user_id, product_id, quantity.
-- Dùng PRIMARY KEY (user_id, product_id), quantity > 0; ghi (1,1), (1,2), (2,1).
-- Giải thích vì sao từng user_id và product_id có thể lặp nhưng cặp không được lặp.
-- Liên hệ vì sao order_items có id PRIMARY KEY vẫn cần UNIQUE(order_id, product_id).
