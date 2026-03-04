-- 删除现有表（如果存在）
DROP TABLE IF EXISTS STUDENTS;

-- 创建学生表
CREATE TABLE STUDENTS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_number VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255),
    age INTEGER,
    major VARCHAR(100),
    grade VARCHAR(20),
    phone VARCHAR(20)
);

-- 插入初始学生数据（只在表为空时插入）
INSERT INTO STUDENTS (student_number, name, email, age, major, grade, phone) 
SELECT * FROM (VALUES
    ('2024001', '张三', 'zhangsan@example.com', 20, '计算机科学与技术', '大二', '13800138001'),
    ('2024002', '李四', 'lisi@example.com', 19, '软件工程', '大一', '13800138002'),
    ('2024003', '王五', 'wangwu@example.com', 21, '数据科学与大数据技术', '大三', '13800138003'),
    ('2024004', '赵六', 'zhaoliu@example.com', 22, '人工智能', '大四', '13800138004'),
    ('2024005', '刘七', 'liuqi@example.com', 20, '网络工程', '大二', '13800138005'),
    ('2024006', '陈八', 'chenba@example.com', 19, '信息安全', '大一', '13800138006'),
    ('2024007', '杨九', 'yangjiu@example.com', 21, '物联网工程', '大三', '13800138007'),
    ('2024008', '周十', 'zhoushi@example.com', 18, '计算机科学与技术', '大一', '13800138008')
) AS tmp(student_number, name, email, age, major, grade, phone)
WHERE NOT EXISTS (SELECT 1 FROM STUDENTS WHERE STUDENTS.student_number = tmp.student_number);
