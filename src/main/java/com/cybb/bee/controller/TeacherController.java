package com.cybb.bee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybb.bee.mapper.TeacherMapper;
import com.cybb.bee.model.Teacher;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;
    
    //Get localhost:8080/teachers/query?subject=xx
    @GetMapping("/query")
    public List<Teacher> query(@RequestParam("subject")String subject){
        return teacherMapper.findTeacher(subject);

    }

    //Get localhost:8080/teachers/query2?campus=xx&subject=xxgender=xx
    @GetMapping("/query2")
    public List<Teacher> query2(@RequestParam("campus")String campus, @RequestParam("subject")String subject, @RequestParam("gender")String gender){
        return teacherMapper.findTeacher2(campus, subject, gender);

    }

    //Get localhost:8080/teachers/query3?age=xx&level=xx
    @GetMapping("/query3")
    public List<Teacher> query3(@RequestParam("age")int age, @RequestParam("level")int level){
        
        return teacherMapper.findTeacher3(age, level);

    }
}
