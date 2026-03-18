# 一、项目名称

**学生课程管理系统（Student Course System）**

功能很简单：

1. 学生管理
2. 课程管理
3. 学生选课

练习点：

- SpringBoot 项目结构
- MyBatis CRUD
- 一点简单业务逻辑
- 表关系（1:N / N:M）

------

# 二、项目功能

只能用 GET / POST 方法，别用 DELETE，FETCH 东西。
1. 学习一下 POST 的 Controller 怎么写（针对于新增和修改方法）
2. 删除：用 GET + id 的方式进行删除
3. service 层怎么实现，
    - 如果是常规的CRUD，也就是下面的1&2，service层也透传。
    - 如果是复杂的逻辑，也就是下面的3，那么需要编织一下业务逻辑。

完成 1

### 1 学生管理

功能：

- 添加学生
- 修改学生
- 删除学生
- 查询学生
- 查询学生列表

------

### 2 课程管理

功能：

- 添加课程
- 修改课程
- 删除课程
- 查询课程

------

### 3 选课功能（简单业务逻辑）

学生可以选择课程。

规则：

1. 一个学生可以选 **多门课程**
2. 一门课程可以被 **多个学生选择**
3. 学生不能重复选同一门课

------

# 三、数据库设计

## 1 学生表

```
student
```

| 字段        | 类型     | 说明     |
| ----------- | -------- | -------- |
| id          | bigint   | 主键     |
| name        | varchar  | 学生姓名 |
| age         | int      | 年龄     |
| create_time | datetime | 创建时间 |

------

## 2 课程表

```
course
```

| 字段        | 类型     | 说明     |
| ----------- | -------- | -------- |
| id          | bigint   | 主键     |
| name        | varchar  | 课程名称 |
| teacher     | varchar  | 老师     |
| create_time | datetime | 创建时间 |

------

## 3 选课表

```
student_course
```

| 字段        | 类型     | 说明     |
| ----------- | -------- | -------- |
| id          | bigint   | 主键     |
| student_id  | bigint   | 学生ID   |
| course_id   | bigint   | 课程ID   |
| create_time | datetime | 选课时间 |

约束：

```
unique(student_id, course_id)
```

防止重复选课。

------

# 四、项目结构

标准 SpringBoot 结构：

```
student-course-system
│
├── controller
│      StudentController
│      CourseController
│      SelectCourseController
│
├── service
│      StudentService
│      CourseService
│      SelectCourseService
│
├── mapper
│      StudentMapper
│      CourseMapper
│      StudentCourseMapper
│
├── entity
│      Student
│      Course
│      StudentCourse
│
└── resources
       mapper
            StudentMapper.xml
            CourseMapper.xml
            StudentCourseMapper.xml
```

------

# 五、核心 CRUD 示例

例如：

## StudentMapper

```java
@Mapper
public interface StudentMapper {

    int insert(Student student);

    int update(Student student);
}
```

------

## StudentMapper.xml

```xml
<mapper namespace="com.example.mapper.StudentMapper">

    <insert id="insert">
        INSERT INTO student(name, age, create_time)
        VALUES(#{name}, #{age}, NOW())
    </insert>

    <update id="update">
        UPDATE student
        SET name = #{name},
            age = #{age}
        WHERE id = #{id}
    </update>

</mapper>
```

------

# 六、简单业务逻辑（选课）

### Service 逻辑

```
学生选课
```

步骤：

1. 判断学生是否存在
2. 判断课程是否存在
3. 判断是否已经选过
4. 插入选课记录

------

示例：

```java
@Transactional
public void selectCourse(Long studentId, Long courseId) {

    Student student = studentMapper.selectById(studentId);
    if (student == null) {
        throw new RuntimeException("学生不存在");
    }

    Course course = courseMapper.selectById(courseId);
    if (course == null) {
        throw new RuntimeException("课程不存在");
    }

    StudentCourse exist =
        studentCourseMapper.select(studentId, courseId);

    if (exist != null) {
        throw new RuntimeException("已经选过该课程");
    }

    studentCourseMapper.insert(studentId, courseId);
}
```

------

# 七、接口示例

### 新增学生

```
POST /student
{
  "name": "Tom",
  "age": 20
}
```

------

### 查询学生

```
GET /student/1
```

------

### 学生选课

```
POST /course/select
{
   "studentId": 1,
   "courseId": 2
}
```

------

# 八、这个项目能学到什么

非常适合刚入门：

1. SpringBoot 三层架构

```
Controller
Service
Mapper
```

1. MyBatis 基本操作

- insert
- update
- delete
- select

1. 表关系

```
student 1:N student_course
course  1:N student_course
```

形成 **N:M关系**

1. 简单业务逻辑

- 校验
- 事务
- 唯一约束