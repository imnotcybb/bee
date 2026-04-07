# Bee 项目 HTTP 接口说明

默认服务地址：`http://localhost:8080`（见 `application.yml` 中 `server.port`）。

以下示例均假设应用在本地 `8080` 端口运行；若端口不同，请替换 URL。

---

## 学生 `StudentController`（前缀 `/student`）

### 查询学生

- **方法 / 路径**：`GET /student/query`
- **参数**：`id`（query，学生主键）

```bash
curl -sS "http://localhost:8080/student/query?id=1"
```

### 删除学生

- **方法 / 路径**：`GET /student/delete`
- **参数**：`id`（query）

```bash
curl -sS "http://localhost:8080/student/delete?id=1"
```

### 学生列表

- **方法 / 路径**：`GET /student/list1`
- **参数**：`id`（query，当前实现中未使用，但接口要求传入）

```bash
curl -sS "http://localhost:8080/student/list1?id=1"
```

### 更新学生

- **方法 / 路径**：`GET /student/update`
- **请求体**：JSON，字段与 `Student` 一致（`id`、`name`、`age` 等）

> 说明：此处使用 `GET` 且带 JSON 请求体，与常见 REST 习惯不一致；若客户端不支持 GET 带 body，请改用浏览器或支持该方式的工具测试。

```bash
curl -sS -X GET "http://localhost:8080/student/update" \
  -H "Content-Type: application/json" \
  -d '{"id":1,"name":"Alice","age":21}'
```

### 新增学生

- **方法 / 路径**：`POST /student/add`
- **请求体**：JSON

```bash
curl -sS -X POST "http://localhost:8080/student/add" \
  -H "Content-Type: application/json" \
  -d '{"name":"Eve","age":20}'
```

带主键（若业务需要自行指定，视数据库与 Mapper 是否支持而定）：

```bash
curl -sS -X POST "http://localhost:8080/student/add" \
  -H "Content-Type: application/json" \
  -d '{"id":5,"name":"Eve","age":20}'
```

---

## 课程 `CourseController`（前缀 `/course`）

### 新增课程

- **方法 / 路径**：`POST /course/add`
- **请求体**：JSON（`name`、`teacher` 等）

```bash
curl -sS -X POST "http://localhost:8080/course/add" \
  -H "Content-Type: application/json" \
  -d '{"name":"算法设计","teacher":"钱老师"}'
```

### 更新课程

- **方法 / 路径**：`POST /course/update`
- **请求体**：JSON（需包含 `id`）

```bash
curl -sS -X POST "http://localhost:8080/course/update" \
  -H "Content-Type: application/json" \
  -d '{"id":1,"name":"Java基础","teacher":"张老师"}'
```

### 删除课程

- **方法 / 路径**：`GET /course/delete`
- **参数**：`id`（query）

```bash
curl -sS "http://localhost:8080/course/delete?id=1"
```

### 查询课程

- **方法 / 路径**：`GET /course/query`
- **参数**：`id`（query）

```bash
curl -sS "http://localhost:8080/course/query?id=1"
```

---

## 选课 `StudentCourseController`（前缀 `/studentCourse`）

### 选课

- **方法 / 路径**：`GET /studentCourse/addStudentCourse`
- **参数**：`studentId`、`courseId`（query）

```bash
curl -sS "http://localhost:8080/studentCourse/addStudentCourse?studentId=1&courseId=1"
```

### 退课

- **方法 / 路径**：`GET /studentCourse/drop`（推荐，与下面旧路径**等价**）
- **参数**：`studentId`、`courseId`（query）

```bash
curl -sS "http://localhost:8080/studentCourse/drop?studentId=1&courseId=1"
```

兼容旧路径（逻辑相同）：

```bash
curl -sS "http://localhost:8080/studentCourse/deleteStudentCourse?studentId=1&courseId=1"
```

---

## 接口一览（共 12 个路径；退课 2 选 1）

| 说明       | 方法 | 路径 |
|------------|------|------|
| 查询学生   | GET  | `/student/query` |
| 删除学生   | GET  | `/student/delete` |
| 学生列表   | GET  | `/student/list1` |
| 更新学生   | GET  | `/student/update` |
| 新增学生   | POST | `/student/add` |
| 新增课程   | POST | `/course/add` |
| 更新课程   | POST | `/course/update` |
| 删除课程   | GET  | `/course/delete` |
| 查询课程   | GET  | `/course/query` |
| 选课       | GET  | `/studentCourse/addStudentCourse` |
| 退课       | GET  | `/studentCourse/drop`（或 `deleteStudentCourse`） |
