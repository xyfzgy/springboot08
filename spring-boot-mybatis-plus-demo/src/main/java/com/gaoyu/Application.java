package com.gaoyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2615:32
 * @Modified By:
 */
@SpringBootApplication
@MapperScan("com.gaoyu.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
