-- SQLite 学生数据库初始化脚本

-- 删除现有表（如果存在）
DROP TABLE IF EXISTS STUDENTS;

-- 创建学生表
CREATE TABLE STUDENTS (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    student_number TEXT UNIQUE NOT NULL,
    name TEXT NOT NULL,
    email TEXT,
    age INTEGER,
    major TEXT,
    grade TEXT,
    phone TEXT
);

-- 插入初始学生数据
INSERT INTO STUDENTS (student_number, name, email, age, major, grade, phone) VALUES
('2024001', '张三', 'zhangsan@example.com', 20, '计算机科学与技术', '大二', '13800138001'),
('2024002', '李四', 'lisi@example.com', 19, '软件工程', '大一', '13800138002'),
('2024003', '王五', 'wangwu@example.com', 21, '数据科学与大数据技术', '大三', '13800138003'),
('2024004', '赵六', 'zhaoliu@example.com', 22, '人工智能', '大四', '13800138004'),
('2024005', '刘七', 'liuqi@example.com', 20, '网络工程', '大二', '13800138005'),
('2024006', '陈八', 'chenba@example.com', 19, '信息安全', '大一', '13800138006'),
('2024007', '杨九', 'yangjiu@example.com', 21, '物联网工程', '大三', '13800138007'),
('2024008', '周十', 'zhoushi@example.com', 18, '计算机科学与技术', '大一', '13800138008');

-- SQLite 教师数据库初始化脚本

-- 删除现有表（如果存在）
DROP TABLE IF EXISTS TEACHERS;

-- 创建教师表
CREATE TABLE TEACHERS (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    teacher_number TEXT UNIQUE NOT NULL,
    name TEXT NOT NULL,
    gender TEXT,
    age INTEGER,
    subject TEXT,
    level INTEGER,
    campus TEXT,
    years INTEGER
);

-- 插入初始教师数据
INSERT INTO TEACHERS (teacher_number, name, gender, age, subject, level, campus, years) VALUES
('T2024001', '刘建国', '男', 45, '计算机网络', 6, '主校区', 20),
('T2024002', '王丽', '女', 38, '数据结构', 5, '主校区', 12),
('T2024003', '张伟', '男', 54, '操作系统', 7, '南校区', 25),
('T2024004', '陈敏', '女', 35, '软件工程', 4, '南校区', 10),
('T2024005', '赵强', '男', 58, '数据库原理', 6, '北校区', 18),
('T2024006', '孙婷', '女', 33, '人工智能', 3, '主校区', 8),
('T2024007', '周磊', '男', 47, '计算机组成原理', 7, '北校区', 22),
('T2024008', '吴娜', '女', 29, '数据结构', 2, '主校区', 5),
('T2024009', '郑凯', '男', 55, '机器学习', 5, '南校区', 15),
('T2024010', '何静', '女', 36, '数据结构', 4, '北校区', 11);