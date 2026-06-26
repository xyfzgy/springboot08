package com.gaoyu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Author：高宇
 * @Description：部门实体类
 * @Data Created in 2026-06-2516:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;
}
