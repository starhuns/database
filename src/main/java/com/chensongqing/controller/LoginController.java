package com.chensongqing.controller;

import com.chensongqing.Config.SecurityConfig;
import com.chensongqing.dto.AuthRequestDTO;
import com.chensongqing.pojo.Result;
import com.chensongqing.pojo.User;
import com.chensongqing.service.UserService;
import com.chensongqing.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/jwt")
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(@RequestBody AuthRequestDTO authRequest) {
        try {
            // 调用服务层进行注册
            userService.registerUser(authRequest.getUsername(), authRequest.getPassword());
            Map<String, Object> claims = Map.of(
                    "sub", authRequest.getUsername(),
                    "role", "user"
            );
            // 注册成功后生成 JWT
            String token = JwtUtils.generateJwt(claims); // 30 minutes
            return Result.success(token); // 返回成功结果
        } catch (RuntimeException e) {
            return Result.error(e.getMessage()); // 返回失败信息
        }
    }
    @PostMapping("/token")
    public Result login(@RequestBody AuthRequestDTO authRequest) {
        try {
            // 调用服务层校验用户
            User user = userService.findByUsername(authRequest.getUsername());
            if (user == null || !userService.verifyPassword(authRequest.getPassword(), user.getPasswordHash())) {
                return Result.error("Invalid username or password");
            }

            // 定义 JWT Claims
            Map<String, Object> claims = Map.of(
                    "sub", user.getUsername(),
                    "role", "user"
            );

            // 登录成功后生成 JWT
            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
}
}
