package com.gaoyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaoyu.entity.Members;
import com.gaoyu.service.MembersService;
import com.gaoyu.mapper.MembersMapper;
import org.springframework.stereotype.Service;

/**
* @author gao18
* @description 针对表【members(社团成员关系表)】的数据库操作Service实现
* @createDate 2026-06-26 18:56:31
*/
@Service
public class MembersServiceImpl extends ServiceImpl<MembersMapper, Members>
    implements MembersService{

}




