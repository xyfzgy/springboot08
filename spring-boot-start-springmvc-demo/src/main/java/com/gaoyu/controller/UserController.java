package com.gaoyu.controller;

import com.gaoyu.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public User getUser() {
        return new User("高宇", 18, "男", "中国");
    }
}
