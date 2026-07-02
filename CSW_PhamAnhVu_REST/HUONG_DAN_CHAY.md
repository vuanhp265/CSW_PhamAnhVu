# Hướng dẫn chạy project REST API

## 1. Giải nén zip

```bash
unzip CSW_PhamAnhVu_REST.zip
cd CSW_PhamAnhVu_REST
```

## 2. Kiểm tra có pom.xml chưa

```bash
ls
```

Phải thấy file:

```text
pom.xml
```

## 3. Chạy project

```bash
mvn spring-boot:run
```

## 4. Mở web test

```text
http://localhost:8080/employees
```

## 5. Test API bằng curl

Lấy danh sách nhân viên:

```bash
curl http://localhost:8080/api/employees
```

Thêm nhân viên:

```bash
curl -X POST http://localhost:8080/api/employees \
-H "Content-Type: application/json" \
-d '{"name":"Le Minh Quan","salary":2000}'
```

Cập nhật nhân viên id = 1:

```bash
curl -X PUT http://localhost:8080/api/employees/1 \
-H "Content-Type: application/json" \
-d '{"name":"Nguyen Van An Updated","salary":2500}'
```

## Lỗi hay gặp

### Lỗi: No plugin found for prefix 'spring-boot'

Nguyên nhân: chưa đứng đúng thư mục có `pom.xml`.

Cách sửa:

```bash
cd CSW_PhamAnhVu_REST
ls
mvn spring-boot:run
```

### Lỗi port 8080 đang bị dùng

Chạy:

```bash
lsof -i :8080
kill -9 PID
```

Thay `PID` bằng số process hiện ra.
