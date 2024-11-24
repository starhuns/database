package com.chensongqing.service;
import com.chensongqing.mapper.UserMapper;
import com.chensongqing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 查找用户
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
    @Transactional
    // 注册用户
    public void registerUser(String username, String password) {
        User existingUser = userMapper.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(passwordEncoder.encode(password));
        userMapper.insert(user);
    }

    // 验证密码
    public boolean verifyPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}
