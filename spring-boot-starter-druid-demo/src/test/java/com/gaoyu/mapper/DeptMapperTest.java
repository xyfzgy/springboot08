package com.gaoyu.mapper;

import com.gaoyu.entity.Dept;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author：
 * @Description:
 * @Date Created in 2026-06-2517:09
 * @Modified By:
 **/
@SpringBootTest
public class DeptMapperTest {
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void findAll(){
        List<Dept> list = deptMapper.findAll();
        list.forEach(dept -> System.out.println(dept));
        System.out.println("-----------------");
        list.forEach(System.out::println);
    }
}