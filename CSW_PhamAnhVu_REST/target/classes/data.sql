INSERT INTO employees (name, salary) SELECT 'Nguyen Van An', 1200 WHERE NOT EXISTS (SELECT 1 FROM employees WHERE name = 'Nguyen Van An');
INSERT INTO employees (name, salary) SELECT 'Tran Thi Binh', 1500 WHERE NOT EXISTS (SELECT 1 FROM employees WHERE name = 'Tran Thi Binh');
INSERT INTO employees (name, salary) SELECT 'Pham Anh Vu', 1800 WHERE NOT EXISTS (SELECT 1 FROM employees WHERE name = 'Pham Anh Vu');
