package com.cybb.bee.service;

import com.cybb.bee.mapper.StudentCourseMapper;
import com.cybb.bee.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 依赖了 2 个其他的 service 和一个 mapper
 */
@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    // 学生退课
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    /**
     * 给学生退课，学生id是studentId，课程id是courseId
     * 
     * @param studentId 学生ID
     * @param courseId  课程ID
     * @return 是否退课成功
     */
    public boolean deleteCourse(long studentId, long courseId) {
        // 1.校验学生是否存在
        if (!studentService.exists(studentId)) {
            return false;
        }
        // 2.检查课程是否存在
        if (!courseService.exists(courseId)) {
            return false;
        }
        // 3.检查是否已经选课
        if (!this.exists(studentId, courseId)) {
            return false;
        }
        // 4.退课
        studentCourseMapper.delete(studentId, courseId);
        return true;
    }

    // 学生选课
    public boolean selectCourse(long studentId, long courseId) {
        // 1.校验学生是否存在
        if (!studentService.exists(studentId)) {
            return false;
        }
        // 2.校验课程是否存在
        if (!courseService.exists(courseId)) {
            return false;
        }
        // 3.校验是否已经选课
        if (this.exists(studentId, courseId)) {
            return false;
        }
        // 4.选课
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        studentCourseMapper.insert(studentCourse);
        return true;
    }

    private boolean exists(long studentId, long courseId) {
        return studentCourseMapper.find2(studentId, courseId) > 0;
    }
}
