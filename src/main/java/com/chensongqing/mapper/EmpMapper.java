package com.chensongqing.mapper;

import com.chensongqing.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
        @Select("select * from emp")
        public List<Emp> list();
        @Select("select * from emp where username = #{username}&& password= #{password}")
        public Emp getbyuserandpassword(Emp emp);
        @Select("select * from emp where username = #{username}")
        public Emp selectone(String username);
        @Select("select count(*) from emp ")
        public long count();
        @Select("select * from emp limit #{start},#{pageSize}")
        public List<Emp> page(Integer start, Integer pageSize);
}
