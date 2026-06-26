package com.gaoyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2516:33
 * @Modified By:
 */
@SpringBootApplication
@MapperScan("com.gaoyu.mapper")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
