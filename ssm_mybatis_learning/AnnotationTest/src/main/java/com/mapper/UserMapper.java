package com.mapper;

import com.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.log4j.spi.NOPLoggerRepository;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user(username,sex,age) values(#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertUser(User user) throws Exception;

    @Update("update user set age=#{age} where id=#{id}")
    public void updateUser(User user) throws Exception;

    @Delete("delete from user where id=#{user_id}")
    public int deleteUser(@Param("user_id") int id) throws Exception;

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "name", column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age"),
    })
    public User selectUserById(int id) throws Exception;

    @Select("select * from user")
    public List<User> selectAllUser() throws Exception;
}
