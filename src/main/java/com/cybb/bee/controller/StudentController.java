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

    // GET localhost:8080/students/query?minAge=21&major=计算机科学与技术	
    // GET localhost:8080/students/query?minAge=xxxx&major=xxxx
    @GetMapping("/query")
    public List<Student> query(@RequestParam("minAge") long minAge, @RequestParam("major") String major) {
        return studentMapper.findAgeMajor(major, minAge);
    }

    // Get localhost:8080/students/query2?studentNumber=2024004
    @GetMapping("/query2")
    public Student query2(@RequestParam("studentNumber") String studentNumber){
        return studentMapper.findByStudentNumber(studentNumber);
    }

    @PostMapping
    public int create(@RequestBody Student student) {
        return studentMapper.insert(student);
    }
}
