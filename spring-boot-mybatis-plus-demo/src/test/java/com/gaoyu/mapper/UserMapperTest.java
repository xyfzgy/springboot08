package com.gaoyu.mapper;


import com.gaoyu.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2615:38
 * @Modified By:
 */
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01() {
        List<User> userList = userMapper.selectList(null);
//        System.out.println(userList);
        userList.forEach(System.out::println);
    }
}