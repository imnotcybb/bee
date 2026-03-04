# Bee - 学生管理系统

这是一个基于Spring Boot + MyBatis + H2数据库的学生管理系统。

## 技术栈

- Spring Boot 2.7.18
- MyBatis 2.3.2
- SQLite 数据库（单文件存储）
- Maven

## 数据持久化

系统使用SQLite文件数据库，数据会保存在 `./data/students.db` 文件中，应用重启后数据不会丢失。

- 数据库文件位置：`./data/students.db` 
- 数据库类型：SQLite（轻量级单文件数据库）
- 首次启动时会自动创建数据库表和初始数据
- 可以用任何SQLite工具直接查看和编辑数据文件
- 数据库文件已添加到 `.gitignore` 中，不会被提交到版本控制

## 启动应用

```bash
mvn spring-boot:run
```

应用启动后，访问地址为：http://localhost:8080

H2数据库控制台：http://localhost:8080/h2-console

## API 接口

### 1. 获取所有学生

```bash
curl -X GET http://localhost:8080/students
```

### 2. 根据ID获取学生信息

```bash
curl -X GET http://localhost:8080/students/1
```

### 3. 根据学号查询学生

```bash
curl -X GET http://localhost:8080/students/student-number/2024001
```

### 4. 根据专业查询学生

```bash
curl -X GET http://localhost:8080/students/major/计算机科学与技术
```

### 5. 根据年级查询学生

```bash
curl -X GET http://localhost:8080/students/grade/大二
```

### 6. 创建新学生

```bash
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{
    "studentNumber": "2024009",
    "name": "新学生",
    "email": "newstudent@example.com",
    "age": 19,
    "major": "计算机科学与技术",
    "grade": "大一",
    "phone": "13800138009"
  }'
```

### 7. 更新学生信息

```bash
curl -X PUT http://localhost:8080/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "studentNumber": "2024001",
    "name": "张三_更新",
    "email": "zhangsan_updated@example.com",
    "age": 21,
    "major": "计算机科学与技术",
    "grade": "大三",
    "phone": "13800138001"
  }'
```

### 8. 删除学生

```bash
curl -X DELETE http://localhost:8080/students/1
```

## 数据库结构

### 学生表 (STUDENTS)

| 字段 | 类型 | 说明 |
|------|------|------|
| id | BIGINT | 主键，自增 |
| student_number | VARCHAR(50) | 学号，唯一 |
| name | VARCHAR(100) | 姓名 |
| email | VARCHAR(255) | 邮箱 |
| age | INTEGER | 年龄 |
| major | VARCHAR(100) | 专业 |
| grade | VARCHAR(20) | 年级 |
| phone | VARCHAR(20) | 电话 |

## 初始数据

系统启动时会自动创建8个示例学生数据：

- 张三 (2024001) - 计算机科学与技术 - 大二
- 李四 (2024002) - 软件工程 - 大一
- 王五 (2024003) - 数据科学与大数据技术 - 大三
- 赵六 (2024004) - 人工智能 - 大四
- 刘七 (2024005) - 网络工程 - 大二
- 陈八 (2024006) - 信息安全 - 大一
- 杨九 (2024007) - 物联网工程 - 大三
- 周十 (2024008) - 计算机科学与技术 - 大一
