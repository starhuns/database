package com.chensongqing.controller;

import com.chensongqing.pojo.PageBean;
import com.chensongqing.pojo.Result;
import com.chensongqing.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/Emp")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize){
        PageBean p= empService.page(page,pageSize);
        return Result.success(p);
    }
//    // 只有拥有ADMIN角色的用户可以删除会议
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/emp/{id}")
//    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
//        // 删除会议的逻辑
//    }
}
