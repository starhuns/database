package com.chensongqing.mapper;


import com.chensongqing.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);
    @Insert("INSERT INTO users (username, password_hash) VALUES (#{username}, #{passwordHash})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);
}
