package com.cybb.bee.service;

import com.cybb.bee.mapper.StudentMapper;
import com.cybb.bee.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、这是一个类
 * 2、打上了 @Service 标记后
 * 3、系统自动的生成一个这个类的对象（bean）
 * 4、放入到了看不见的容器（Spring 容器）当中
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public void add(Student student) {
        studentMapper.insert(student);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }

    public void delete(Long id) {
        studentMapper.delete(id);
    }

    public Student get(Long id) {
        return studentMapper.findStudent(id);
    }

    public List<Student> list() {
        return studentMapper.findAll();
    }

    public boolean exists(Long id) {
        return studentMapper.findStudent(id) != null;
    }
}
