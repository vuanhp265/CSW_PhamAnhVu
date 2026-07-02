CREATE TABLE IF NOT EXISTS employees (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL CHECK (salary >= 0)
);
