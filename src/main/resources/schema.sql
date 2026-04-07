-- SQLite 语法（与 MySQL 的 AUTO_INCREMENT / UNIQUE KEY 写法不同）

-- 学生表
CREATE TABLE IF NOT EXISTS student (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(50) NOT NULL,
    age INTEGER,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 课程表
CREATE TABLE IF NOT EXISTS course (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(100) NOT NULL,
    teacher VARCHAR(50),
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 选课表（中间表）
CREATE TABLE IF NOT EXISTS student_course (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    student_id INTEGER NOT NULL,
    course_id INTEGER NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (student_id, course_id)
);

-- 固定主键，便于重复执行初始化脚本时用 INSERT OR IGNORE 去重
INSERT OR IGNORE INTO student (id, name, age) VALUES
(1, 'Alice', 20),
(2, 'Bob', 21),
(3, 'Cathy', 19),
(4, 'David', 22);

INSERT OR IGNORE INTO course (id, name, teacher) VALUES
(1, 'Java基础', '张老师'),
(2, 'MySQL数据库', '李老师'),
(3, 'Spring Boot', '王老师'),
(4, '数据结构', '赵老师');
