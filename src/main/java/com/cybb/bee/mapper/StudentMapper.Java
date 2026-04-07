package com.cybb.bee.mapper;//这个类属于哪个“包”（文件夹）

import com.cybb.bee.model.Student;//我要用别的包里的Student类 或者说 import = 把别的地方的类“拿过来用”
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    //添加一个学生
    @Insert("INSERT INTO COURSES(id, name, age, createTime) VALUES(#{id}, #{name},  #{age}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);

    //修改一个学生
    @Update("UPDATE STUDENTS SET name=#{name},  age=#{age},  createTime=#{createTime} WHERE id=#{id}")
    int update(Student student);

    //删除一个学生
    @Delete("DELETE FROM STUDENTS WHERE id=#{id}")
    int delete(Long id);

    //查询学生
    @Select("SELECT * FROM STUDENTS WHERE id=#{id}")
    Student findStudent(Long id);

    //查询学生列表
    @Select("SELECT * FROM STUDENTS")
    List<Student> findAll();

}