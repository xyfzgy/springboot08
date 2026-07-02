package com.gaoyu.goodsorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gaoyu.goodsorder.mapper")
public class GoodsOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsOrderApplication.class, args);
    }

}
