package com.cybb.bee.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import com.cybb.bee.model.Student;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM STUDENTS")
    List<Student> findAll();

    @Select("SELECT * FROM STUDENTS WHERE id = #{id}")
    Student findById(Long id);

    @Select("SELECT * FROM STUDENTS WHERE student_number = #{studentNumber}")
    Student findByStudentNumber(String studentNumber);

    @Insert("INSERT INTO STUDENTS(student_number, name, email, age, major, grade, phone) VALUES(#{studentNumber}, #{name}, #{email}, #{age}, #{major}, #{grade}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);

    @Update("UPDATE STUDENTS SET student_number=#{studentNumber}, name=#{name}, email=#{email}, age=#{age}, major=#{major}, grade=#{grade}, phone=#{phone} WHERE id=#{id}")
    int update(Student student);

    @Delete("DELETE FROM STUDENTS WHERE id=#{id}")
    int delete(Long id);

    @Select("SELECT * FROM STUDENTS WHERE major = #{major}")
    List<Student> findByMajor(String major);

    @Select("SELECT * FROM STUDENTS WHERE grade = #{grade}")
    List<Student> findByGrade(String grade);

    @Select("select * from students where age > #{age} and major = #{major}")
    List<Student> findAgeMajor(String major, Long age);
}
