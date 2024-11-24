package com.chensongqing.controller;

import com.chensongqing.pojo.Dept;
import com.chensongqing.pojo.Result;
import com.chensongqing.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptserver;
    @GetMapping("/Dept")
    public Result list(){
           log.info("查数据");
        List<Dept> list=deptserver.list();
           return Result.success(list);
    }
    @PostMapping("/Dept")
    public Result insert(@RequestBody Dept dept){
        log.info("插入数据:{}",dept);
        deptserver.insert(dept);
        return Result.success();
    }
    @DeleteMapping("/Dept/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除id:{}",id);
        deptserver.delete(id);
        return Result.success();
    }
}
