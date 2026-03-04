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

    // Examples using query parameters instead of path variables
    // GET /students?major=Computer%20Science
    @GetMapping(params = "major")
    public List<Student> getByMajorParam(@RequestParam String major) {
        return studentMapper.findByMajor(major);
    }

    // GET /students?grade=2024
    @GetMapping(params = "grade")
    public List<Student> getByGradeParam(@RequestParam String grade) {
        return studentMapper.findByGrade(grade);
    }

    // GET /students/by-student-number?studentNumber=20210001
    @GetMapping(value = "/by-student-number", params = "studentNumber")
    public Student getByStudentNumberParam(@RequestParam String studentNumber) {
        return studentMapper.findByStudentNumber(studentNumber);
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
