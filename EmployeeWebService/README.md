# Employee Web Service - CSW Practical Test

Bài làm theo đề: quản lý nhân viên bằng web service, dữ liệu lưu trong database.

## Chức năng đã làm

- Tạo bảng database `employees` gồm: `id`, `name`, `salary`.
- Tạo Java class `Employee` gồm: `id`, `name`, `salary`.
- Web service REST:
  - `GET /api/employees` tương ứng `getEmployees`: lấy toàn bộ employee.
  - `POST /api/employees` tương ứng `addEmployees(Employee e)`: thêm employee mới.
  - `PUT /api/employees` tương ứng `updateEmployee(Employee e)`: cập nhật employee đã tồn tại.
- Web application test tại: `http://localhost:8080/employees`.
- Database dùng H2 file database, dữ liệu được lưu ở thư mục `data`.

## Yêu cầu để chạy

Cài sẵn:

1. JDK 17 hoặc mới hơn
2. Maven 3.8+ hoặc mới hơn

Kiểm tra bằng lệnh:

```bash
java -version
mvn -version
```

## Cách chạy bằng Terminal / CMD

Bước 1: Giải nén file zip.

Bước 2: Mở Terminal/CMD tại thư mục project:

```bash
cd EmployeeWebService
```

Bước 3: Chạy project:

```bash
mvn spring-boot:run
```

Bước 4: Mở trình duyệt:

```text
http://localhost:8080/employees
```

## Cách test web service bằng curl

### 1. getEmployees

```bash
curl http://localhost:8080/api/employees
```

### 2. addEmployees(Employee e)

```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"id":4,"name":"Pham Lam","salary":2000}'
```

Trên Windows CMD, dùng một dòng:

```cmd
curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d "{\"id\":4,\"name\":\"Pham Lam\",\"salary\":2000}"
```

### 3. updateEmployee(Employee e)

```bash
curl -X PUT http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{"id":4,"name":"Pham Lam Updated","salary":2500}'
```

Trên Windows CMD:

```cmd
curl -X PUT http://localhost:8080/api/employees -H "Content-Type: application/json" -d "{\"id\":4,\"name\":\"Pham Lam Updated\",\"salary\":2500}"
```

## Xem database H2

Mở:

```text
http://localhost:8080/h2-console
```

Điền:

```text
JDBC URL: jdbc:h2:file:./data/employees-db
User Name: sa
Password: bỏ trống
```

Sau đó chạy SQL:

```sql
SELECT * FROM employees;
```

## Cấu trúc thư mục quan trọng

```text
src/main/java/com/example/employee/model/Employee.java
src/main/java/com/example/employee/service/EmployeeService.java
src/main/java/com/example/employee/controller/EmployeeRestController.java
src/main/java/com/example/employee/controller/EmployeeWebController.java
src/main/resources/schema.sql
src/main/resources/data.sql
src/main/resources/templates/employees.html
src/main/resources/application.properties
```

## Ghi chú nộp bài

Nếu giáo viên yêu cầu build file `.jar`, chạy:

```bash
mvn clean package
```

File build nằm trong:

```text
target/employee-web-service-1.0.0.jar
```

Chạy file `.jar`:

```bash
java -jar target/employee-web-service-1.0.0.jar
```
