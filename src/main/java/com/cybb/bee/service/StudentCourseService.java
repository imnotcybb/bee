package com.cybb.bee.service;
import java.util.List;
import com.cybb.bee.mapper.StudentCourseMapper;
import com.cybb.bee.model.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    public List<StudentCourse> findSc(long studentId){
        return studentCourseMapper.findSc(studentId);
    }

    public boolean exists(long studentId, long courseId){
        return studentCourseMapper.find2(studentId, courseId) >0 ;
    }

    //学生退课
    public void delete(long studentId,long courseId){studentCourseMapper.delete(studentId,courseId);}
}
