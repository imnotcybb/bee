package com.cybb.bee.mapper;

import com.cybb.bee.model.StudentCourse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseMapper {
    //查询选课
    @Select("SELECT * FROM StudentCourse where studentId = #{studentId}")
    List<StudentCourse> findSc(long studentId);

    //查询学生与课
    @Select("SELECT count(1) FROM StudentCourse where studentId = #{studentId} and courseId = #{courseId}")
    int find2(@Param("studentId") long studentId,@Param("courseId") long courseId);

    //学生选课
    @Insert("INSERT INTO StudentCourse (studentid,courseid) VALUES (#{studentId}, #{courseId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(StudentCourse studentCourse);

    //学生退课
    @Delete("DELETE FROM StudentCourse WHERE studentId = #{studentId} and courseId = #{courseId}")
    int delete(long studentId,long courseId);
}

