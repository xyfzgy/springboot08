package com.gaoyu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2615:34
 * @Modified By:
 */
@Data
@TableName("t_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}