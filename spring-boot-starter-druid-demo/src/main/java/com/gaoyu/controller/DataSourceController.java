package com.gaoyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2516:34
 * @Modified By:
 */
@RestController
@RequestMapping("/datasource")
public class DataSourceController {
    @Autowired
    private DataSource dataSource;
    @GetMapping
    public Map<String, Object> getDataSource() {
        Map<String, Object> map = new HashMap<>();
        map.put("dataSourceType", dataSource.getClass().getName());
        return map;
    }
}
