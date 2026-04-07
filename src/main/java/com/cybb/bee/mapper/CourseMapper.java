package com.cybb.bee.mapper;

import com.cybb.bee.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    //添加课程
    @Insert("INSERT INTO COURSE(id, name, teacher, createTime) VALUES(#{id}, #{name},  #{teacher}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Course course);

    //修改课程
    @Update("UPDATE COURSE SET name=#{name},  teacher=#{teacher},  createTime=#{createTime} WHERE id=#{id}")
    int update(Course course);

    //删除课程
    @Delete("DELETE FROM COURSE WHERE id=#{id}")
    int delete(Long id);

    //查询课程
    @Select("SELECT * FROM COURSE WHERE id=#{id}")
    Course findCourse(Long id);

    //看课程list
    @Select("SELECT * FROM COURSE")
    List<Course> findCourseList();
}
