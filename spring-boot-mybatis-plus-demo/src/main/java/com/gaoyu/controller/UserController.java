package com.gaoyu.controller;

import ch.qos.logback.core.model.Model;
import com.gaoyu.entity.User;
import com.gaoyu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.management.modelmbean.ModelMBean;
import java.util.List;

/**
 * @Author：高宇
 * @Description：
 * @Data Created in 2026-06-2615:49
 * @Modified By:
 */
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("user")
    public String getUser(ModelMap modelMap){
        List<User> list=userMapper.selectList(null);
        modelMap.addAttribute("userlist",list);
        return "show";
    }

}
