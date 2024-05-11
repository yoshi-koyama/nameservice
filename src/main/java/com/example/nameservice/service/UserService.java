package com.example.nameservice.service;

import com.example.nameservice.User;
import com.example.nameservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * ユーザーに関する業務処理を担うサービスクラス
 */
@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User insert(String name, String email) {
        User user = new User(name, email);
        userMapper.insert(user);
        return user;
    }


}
