package com.cybb.bee.service;

import com.cybb.bee.mapper.StudentCourseMapper;
import com.cybb.bee.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    // 学生退课
    @Autowired
    private StudentService studentService;

    public boolean deleteCourse(long studentId, long courseId) {
        //校验学生是否存在
        if (studentService.exists(studentId)) {
            // 检查课程是否存在
            if (this.exists(studentId, courseId)) {
                return false;
            }
            studentCourseMapper.delete(studentId, courseId);
            return true;
        } else {
            return false;
        }
    }

    //学生选课
    public boolean selectCourse(long studentId, long courseId) {
        //校验学生是否存在
        if (studentService.exists(studentId)) {
            if (this.exists(studentId, courseId)) {
                return false;
            }
            StudentCourse studentCourse = new StudentCourse();
            studentCourse.setStudentId(studentId);
            studentCourse.setCourseId(courseId);
            studentCourseMapper.insert(studentCourse);
            return true;
        } else {
            return false;
        }
    }

    private boolean exists(long studentId, long courseId) {
        return studentCourseMapper.find2(studentId, courseId) > 0;
    }
}
