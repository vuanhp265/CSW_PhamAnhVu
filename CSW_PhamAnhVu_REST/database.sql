CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL
);

INSERT INTO employees (name, salary) VALUES
('Nguyen Van An', 1200),
('Tran Thi Binh', 1500),
('Pham Anh Vu', 1800);
