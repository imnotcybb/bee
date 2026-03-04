package com.cybb.bee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cybb.bee.mapper.StudentMapper;
import com.cybb.bee.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public List<Student> list() {
        return studentMapper.findAll();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentMapper.findById(id);
    }

    @GetMapping("/student-number/{studentNumber}")
    public Student getByStudentNumber(@PathVariable String studentNumber) {
        return studentMapper.findByStudentNumber(studentNumber);
    }

    @GetMapping("/major/{major}")
    public List<Student> getByMajor(@PathVariable String major) {
        return studentMapper.findByMajor(major);
    }

    @GetMapping("/grade/{grade}")
    public List<Student> getByGrade(@PathVariable String grade) {
        return studentMapper.findByGrade(grade);
    }

    @PostMapping
    public int create(@RequestBody Student student) {
        return studentMapper.insert(student);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentMapper.update(student);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Long id) {
        return studentMapper.delete(id);
    }
}
