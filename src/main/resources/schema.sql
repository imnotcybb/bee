-- 学生表
CREATE TABLE student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    age INT,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 课程表
CREATE TABLE course (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    teacher VARCHAR(50),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 选课表（中间表）
CREATE TABLE student_course (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    -- 唯一约束：防止重复选课
    UNIQUE KEY uk_student_course (student_id, course_id)
);

INSERT INTO student (name, age) VALUES
('Alice', 20),
('Bob', 21),
('Cathy', 19),
('David', 22);

INSERT INTO course (name, teacher) VALUES
('Java基础', '张老师'),
('MySQL数据库', '李老师'),
('Spring Boot', '王老师'),
('数据结构', '赵老师');