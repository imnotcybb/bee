package com.cybb.bee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cybb.bee.model.Teacher;

@Mapper
public interface TeacherMapper {
    // 1. 找到所有的某个科目的老师
    // 2. 找到所有某校区教授某科目的男或者女老师
    // 3. 超过x岁的x级以上教师
    @Select("select * from Teachers where subject = #{subject}")
    List<Teacher> findTeacher(String subject);

    @Select("select * from Teachers where campus = #{campus} and subject = #{subject} and gender = #{gender}")
    List<Teacher> findTeacher2(String campus, String subject, String gender);

    @Select("select * from Teachers where age > #{age} and level > #{level}")
    List<Teacher> findTeacher3(int age, int level);

}
