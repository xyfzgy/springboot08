package com.gaoyu.controller;

import com.gaoyu.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2516:45
 * @Modified By:
 */
@RestController
public class DeptController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("deptlist")
    public List<Dept> findAll() {
        String sql = "select * from dept";
        List<Dept> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Dept.class));
        return list;
    }
}
