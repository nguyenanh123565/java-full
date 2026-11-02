BEGIN;

DO $$
BEGIN
    IF current_database() <> 'sql_postgresql_practice' THEN
        RAISE EXCEPTION 'Hãy kết nối database sql_postgresql_practice trước khi chạy';
    END IF;
END $$;

-- Chạy trên các bảng rỗng. Nếu đã seed, chạy reset.sql trước.
INSERT INTO public.users (id, name, email, created_at) VALUES
    (1, 'An', 'an@example.com', '2025-12-01 08:00:00+07'),
    (2, 'Bình', 'binh@example.com', '2025-12-02 08:00:00+07'),
    (3, 'Chi', 'chi@example.com', '2025-12-03 08:00:00+07'),
    (4, 'Dũng', 'dung@example.com', '2025-12-04 08:00:00+07'),
    (5, 'Giang', 'giang@example.com', '2025-12-05 08:00:00+07'),
    (6, 'Hạnh', 'hanh@example.com', '2025-12-06 08:00:00+07'),
    (7, 'Khánh', 'khanh@example.com', '2025-12-07 08:00:00+07'),
    (8, 'Linh', 'linh@example.com', '2025-12-08 08:00:00+07'),
    (9, 'Minh', 'minh@example.com', '2025-12-09 08:00:00+07'),
    (10, 'Nam', 'nam@example.com', '2025-12-10 08:00:00+07'),
    (11, 'Phương', 'phuong@example.com', '2025-12-11 08:00:00+07'),
    (12, 'Trang', 'trang@example.com', '2025-12-12 08:00:00+07');

INSERT INTO public.categories (id, name) VALUES
    (1, 'robot'),
    (2, 'laptop'),
    (3, 'phone'),
    (4, 'accessories'),
    (5, 'books');

INSERT INTO public.products (id, name, price, stock, category_id) VALUES
    (1, 'Robot hút bụi A', 7500000, 18, 1),
    (2, 'Robot lau nhà B', 5200000, 12, 1),
    (3, 'Robot cao cấp C', 12500000, 5, 1),
    (4, 'Robot mini D', 3200000, 30, 1),
    (5, 'Robot E', 8900000, 0, 1),
    (6, 'Laptop Core', 15900000, 8, 2),
    (7, 'Laptop Pro', 24500000, 5, 2),
    (8, 'Laptop Air', 18900000, 9, 2),
    (9, 'Laptop Budget', 9900000, 16, 2),
    (10, 'Laptop Gaming', 32900000, 0, 2),
    (11, 'Phone A', 6500000, 40, 3),
    (12, 'Phone B', 12000000, 15, 3),
    (13, 'Phone C', 4300000, 22, 3),
    (14, 'Phone D', 18500000, 10, 3),
    (15, 'Phone Mini', 2900000, 8, 3),
    (16, 'Tai nghe', 700000, 60, 4),
    (17, 'Chuột không dây', 350000, 80, 4),
    (18, 'Bàn phím', 1200000, 45, 4),
    (19, 'USB', 250000, 100, 4),
    (20, 'Sạc nhanh', 450000, 0, 4),
    (21, 'Sách Java Core', 420000, 25, 5),
    (22, 'Sách SQL', 350000, 30, 5),
    (23, 'Sách DSA', 380000, 20, 5),
    (24, 'Sách Clean Code', 450000, 15, 5),
    (25, 'Sách PostgreSQL', 550000, 0, 5);

INSERT INTO public.orders (id, user_id, total, status, created_at) VALUES
    (1, 1, 8900000, 'paid', '2026-01-03 09:00:00+07'),
    (2, 2, 15850000, 'shipped', '2026-01-04 09:00:00+07'),
    (3, 3, 6850000, 'paid', '2026-01-05 09:00:00+07'),
    (4, 4, 6400000, 'pending', '2026-01-06 09:00:00+07'),
    (5, 5, 13200000, 'cancelled', '2026-01-07 09:00:00+07'),
    (6, 6, 12300000, 'shipped', '2026-01-08 09:00:00+07'),
    (7, 7, 6900000, 'paid', '2026-01-09 09:00:00+07'),
    (8, 8, 19600000, 'paid', '2026-01-10 09:00:00+07'),
    (9, 9, 5000000, 'cancelled', '2026-01-11 09:00:00+07'),
    (10, 10, 24350000, 'paid', '2026-01-12 09:00:00+07'),
    (11, 1, 18950000, 'shipped', '2026-02-03 09:00:00+07'),
    (12, 2, 10200000, 'paid', '2026-02-04 09:00:00+07'),
    (13, 3, 3600000, 'pending', '2026-02-05 09:00:00+07'),
    (14, 4, 9050000, 'paid', '2026-02-06 09:00:00+07'),
    (15, 5, 33200000, 'paid', '2026-02-07 09:00:00+07'),
    (16, 6, 7850000, 'cancelled', '2026-02-08 09:00:00+07'),
    (17, 7, 13400000, 'paid', '2026-02-09 09:00:00+07'),
    (18, 8, 5450000, 'shipped', '2026-02-10 09:00:00+07'),
    (19, 9, 16250000, 'paid', '2026-02-11 09:00:00+07'),
    (20, 10, 7700000, 'pending', '2026-02-12 09:00:00+07'),
    (21, 1, 13300000, 'paid', '2026-03-03 09:00:00+07'),
    (22, 2, 3900000, 'shipped', '2026-03-04 09:00:00+07'),
    (23, 3, 4650000, 'paid', '2026-03-05 09:00:00+07'),
    (24, 4, 25700000, 'paid', '2026-03-06 09:00:00+07');

INSERT INTO public.order_items (id, order_id, product_id, quantity, price) VALUES
    (1, 1, 1, 1, 7500000),
    (2, 1, 16, 2, 700000),
    (3, 2, 6, 1, 15500000),
    (4, 2, 17, 1, 350000),
    (5, 3, 11, 1, 6400000),
    (6, 3, 20, 1, 450000),
    (7, 4, 2, 1, 5200000),
    (8, 4, 18, 1, 1200000),
    (9, 5, 3, 1, 12500000),
    (10, 5, 16, 1, 700000),
    (11, 6, 12, 1, 11800000),
    (12, 6, 19, 2, 250000),
    (13, 7, 4, 2, 3100000),
    (14, 7, 17, 2, 350000),
    (15, 8, 8, 1, 18500000),
    (16, 8, 18, 1, 1100000),
    (17, 9, 13, 1, 4300000),
    (18, 9, 16, 1, 700000),
    (19, 10, 7, 1, 24000000),
    (20, 10, 17, 1, 350000),
    (21, 11, 14, 1, 18500000),
    (22, 11, 20, 1, 450000),
    (23, 12, 9, 1, 9700000),
    (24, 12, 19, 2, 250000),
    (25, 13, 15, 1, 2900000),
    (26, 13, 16, 1, 700000),
    (27, 14, 5, 1, 8700000),
    (28, 14, 17, 1, 350000),
    (29, 15, 10, 1, 32000000),
    (30, 15, 18, 1, 1200000),
    (31, 16, 1, 1, 7600000),
    (32, 16, 19, 1, 250000),
    (33, 17, 12, 1, 12000000),
    (34, 17, 16, 2, 700000),
    (35, 18, 2, 1, 5000000),
    (36, 18, 20, 1, 450000),
    (37, 19, 6, 1, 15900000),
    (38, 19, 17, 1, 350000),
    (39, 20, 11, 1, 6500000),
    (40, 20, 18, 1, 1200000),
    (41, 21, 3, 1, 12300000),
    (42, 21, 19, 4, 250000),
    (43, 22, 4, 1, 3200000),
    (44, 22, 16, 1, 700000),
    (45, 23, 13, 1, 4300000),
    (46, 23, 17, 1, 350000),
    (47, 24, 7, 1, 24500000),
    (48, 24, 18, 1, 1200000);

SELECT setval(pg_get_serial_sequence('public.users', 'id'), (SELECT MAX(id) FROM public.users), true);
SELECT setval(pg_get_serial_sequence('public.categories', 'id'), (SELECT MAX(id) FROM public.categories), true);
SELECT setval(pg_get_serial_sequence('public.products', 'id'), (SELECT MAX(id) FROM public.products), true);
SELECT setval(pg_get_serial_sequence('public.orders', 'id'), (SELECT MAX(id) FROM public.orders), true);
SELECT setval(pg_get_serial_sequence('public.order_items', 'id'), (SELECT MAX(id) FROM public.order_items), true);

COMMIT;
