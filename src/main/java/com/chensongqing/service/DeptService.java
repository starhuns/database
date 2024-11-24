package com.chensongqing.service;

import com.chensongqing.mapper.DeptMapper;
import com.chensongqing.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptMapper deptmapper;
    public List<Dept> list(){
        return deptmapper.list();
    }

    public void insert(Dept dept) {
        deptmapper.insert(dept);

    }

    public void delete(Integer id) {
        deptmapper.delete(id);
    }
}
