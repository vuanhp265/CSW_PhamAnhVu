# Hướng dẫn chạy nhanh

1. Giải nén zip.
2. Mở terminal trong thư mục `EmployeeWebService`.
3. Chạy:

```bash
mvn spring-boot:run
```

4. Vào:

```text
http://localhost:8080/employees
```

5. Test:

- Bảng đầu trang là chức năng `getEmployees`.
- Form bên trái là `addEmployees(Employee e)`.
- Form bên phải là `updateEmployee(Employee e)`.

Nếu muốn kiểm tra API trực tiếp, dùng:

```bash
curl http://localhost:8080/api/employees
```
