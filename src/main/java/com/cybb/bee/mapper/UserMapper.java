package com.cybb.bee.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import com.cybb.bee.model.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER")
    List<User> findAll();

    @Select("SELECT * FROM USER WHERE id = #{id}")
    User findById(Long id);

    @Insert("INSERT INTO USER(name, email) VALUES(#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Update("UPDATE USER SET name=#{name}, email=#{email} WHERE id=#{id}")
    int update(User user);

    @Delete("DELETE FROM USER WHERE id=#{id}")
    int delete(Long id);
}
