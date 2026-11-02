-- 1. AVG không GROUP BY tạo một dòng cho toàn bộ products, dùng chung làm ngưỡng.
SELECT id, name, price
FROM products
WHERE price > (SELECT AVG(price) FROM products)
ORDER BY price DESC, id;

-- 2. Correlation nối product hiện tại với items của nó.
SELECT p.id, p.name
FROM products AS p
WHERE NOT EXISTS (
    SELECT 1
    FROM order_items AS oi
    WHERE oi.product_id = p.id
)
ORDER BY p.id;
-- Nếu bỏ WHERE trong query con, nó hỏi toàn bảng có item không cho mọi product.
-- Với seed có items, NOT EXISTS lúc đó sẽ loại mọi product.

-- 3. Category của dòng ngoài giới hạn đầu vào AVG, nên ngưỡng thay đổi theo category.
SELECT p.id, p.name, p.category_id, p.price
FROM products AS p
WHERE p.price > (
    SELECT AVG(p2.price)
    FROM products AS p2
    WHERE p2.category_id = p.category_id
)
ORDER BY p.category_id, p.id;
-- Category chỉ có một product: price bằng AVG nên không thỏa dấu >.
