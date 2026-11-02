-- Only initializes the new dedicated learning_backend database on an empty volume.
CREATE TABLE products (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(120) NOT NULL CHECK (length(trim(name)) > 0),
    price NUMERIC(10,2) NOT NULL CHECK (price >= 0)
);

INSERT INTO products (name, price) VALUES
    ('Notebook', 25.50),
    ('Pen', 5.00);
