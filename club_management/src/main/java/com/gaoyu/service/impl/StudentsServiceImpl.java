package com.gaoyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoyu.entity.Students;
import com.gaoyu.service.StudentsService;
import com.gaoyu.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

/**
* @author gao18
* @description 针对表【students(学生基本信息表)】的数据库操作Service实现
* @createDate 2026-06-26 18:56:31
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService {

}




