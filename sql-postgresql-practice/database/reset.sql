BEGIN;

DO $$
BEGIN
    IF current_database() <> 'sql_postgresql_practice' THEN
        RAISE EXCEPTION 'Hãy kết nối database sql_postgresql_practice trước khi chạy';
    END IF;
END $$;

-- Xóa dữ liệu của ĐÚNG năm bảng học tập; giữ schema và reset identity.
-- Không dùng CASCADE để tránh xóa ngoài những bảng được liệt kê.
TRUNCATE TABLE public.order_items, public.orders, public.products,
               public.categories, public.users RESTART IDENTITY;
COMMIT;
-- Chạy database/seed.sql riêng sau file này để khôi phục dữ liệu mẫu.
