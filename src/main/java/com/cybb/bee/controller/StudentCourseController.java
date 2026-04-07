package com.cybb.bee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cybb.bee.service.StudentCourseService;


@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("deleteStudentCourse")
    public String delete(@RequestParam("studentId") long studentId, @RequestParam("courseId") long courseId) {
        if (studentCourseService.exists(studentId, courseId)) {
            studentCourseService.delete(studentId, courseId);
            return "退课成功";
        } else {
            return "退课失败，学生未选该课程";
        }
    }

    // 完成学生选课
    // 需要判断学生是否已经选了这门课，如果选了就不能再选了



}
