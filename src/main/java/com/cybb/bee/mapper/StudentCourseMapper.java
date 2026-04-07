package com.cybb.bee.mapper;

import com.cybb.bee.model.StudentCourse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseMapper {
    //查询选课
    @Select("SELECT * FROM student_course WHERE student_id = #{studentId}")
    List<StudentCourse> findSc(long studentId);

    //查询学生与课
    @Select("SELECT count(1) FROM student_course WHERE student_id = #{studentId} AND course_id = #{courseId}")
    int find2(@Param("studentId") long studentId, @Param("courseId") long courseId);

    //学生选课
    @Insert("INSERT INTO student_course (student_id, course_id) VALUES (#{studentId}, #{courseId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(StudentCourse studentCourse);

    //学生退课
    @Delete("DELETE FROM student_course WHERE student_id = #{studentId} AND course_id = #{courseId}")
    int delete(long studentId, long courseId);
}
