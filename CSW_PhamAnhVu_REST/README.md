# Employee Web Service - REST API

Bài làm CSW: Creating Services for the Web.

## Chức năng theo đề

- Tạo database table `employees`
- Tạo Java class `Employee` gồm `id`, `name`, `salary`
- `getEmployees`: lấy toàn bộ nhân viên
- `addEmployees(Employee e)`: thêm nhân viên mới
- `updateEmployee(Employee e)`: cập nhật nhân viên
- Web application để test web service

## Công nghệ

- Java 17
- Spring Boot 3.3.5
- Spring Web REST API
- Spring Data JPA
- H2 Database file
- Thymeleaf + JavaScript để test API

## Cách chạy

Mở Terminal tại thư mục project, nơi có file `pom.xml`, rồi chạy:

```bash
mvn spring-boot:run
```

Sau khi chạy thành công, mở:

```text
http://localhost:8080/employees
```

## API endpoints

### 1. getEmployees

```http
GET http://localhost:8080/api/employees
```

### 2. addEmployees

```http
POST http://localhost:8080/api/employees
Content-Type: application/json

{
  "name": "Le Minh Quan",
  "salary": 2000
}
```

### 3. updateEmployee

```http
PUT http://localhost:8080/api/employees/1
Content-Type: application/json

{
  "name": "Nguyen Van An Updated",
  "salary": 2500
}
```

## H2 Database Console

Mở:

```text
http://localhost:8080/h2-console
```

Điền:

```text
JDBC URL: jdbc:h2:file:./data/employeedb
User Name: sa
Password: để trống
```

## Nếu Maven chưa tải dependency

Lần chạy đầu tiên Maven cần Internet để tải thư viện. Nếu thấy nhiều dòng `Downloading from central`, đó là bình thường.
