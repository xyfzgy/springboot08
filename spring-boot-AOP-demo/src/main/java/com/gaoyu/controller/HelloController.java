package com.gaoyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2514:47
 * @Modified By:
 */
@RestController
//@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/hello")
     public String hello() {
        return "hello Spring Boot";
    }
}
