package com.chensongqing.mapper;

import com.chensongqing.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper //创建IOC容器，并注入对象
public interface DeptMapper {
//    @Select("select * from user where " +
//            "name like concat('%',#{name},'%') " +
//            "and gender = #{gender}")

    public List<Dept> list();
    //创建一个返回List的方法，名字叫list
    public void insert(Dept dept);
    public void delete(Integer id);
}
