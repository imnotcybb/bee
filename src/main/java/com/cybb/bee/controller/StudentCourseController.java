package com.cybb.bee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cybb.bee.service.StudentCourseService;


@RestController
@RequestMapping("/studentCourse")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    /** 退课：与 {@code deleteStudentCourse} 同义，便于记忆 */
    @GetMapping({ "deleteStudentCourse", "drop" })
    public String delete(@RequestParam("studentId") long studentId, @RequestParam("courseId") long courseId) {
        if (studentCourseService.deleteCourse(studentId, courseId)) {
            return "退课成功";
        } else {
            return "退课失败，学生不存在或学生未选该课程！";
        }
    }

    @GetMapping("addStudentCourse")
    public String insert(@RequestParam("studentId") long studentId, @RequestParam("courseId") long courseId) {
        if (studentCourseService.selectCourse(studentId, courseId)) {
            return "选课成功";
        } else {
            return "选课失败，学生不存在或学生已选该课程！";
        }
    }
}
