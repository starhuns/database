package com.chensongqing.service;

import com.chensongqing.mapper.EmpMapper;
import com.chensongqing.pojo.Emp;
import com.chensongqing.pojo.LoginUser;
import com.chensongqing.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmpService implements UserDetailsService {
    @Autowired
    private EmpMapper empMapper;
    public PageBean page(Integer page,Integer pageSize){
        PageBean pageBean=new PageBean();
        long count=empMapper.count();
        pageBean.setTotal(count);
        Integer start=(page-1)*pageSize;
        List<Emp>rows = empMapper.page(start,pageSize);
        pageBean.setRows(rows);
        return pageBean;
    }

    public Emp login(Emp emp) {
        return  empMapper.getbyuserandpassword(emp);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Emp emp=empMapper.selectone(username);
        if(Objects.isNull(emp)){
            try {
                throw new Exception("用户名或密码错误");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return new LoginUser(emp);
    }
}
