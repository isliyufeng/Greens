package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.dto.UserDto;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.User;
import com.cxk.cai.mapper.UserMapper;
import com.cxk.cai.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 喜闻乐见i
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public ResultVo login(UserDto user) {
        User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("phone", user.getPhone()));
        if(user1!=null) {
            if (user1.getPhone().equals(user.getPhone()) && user1.getPassword().equals(user.getPassword())) {
                //模拟成功
//                //1、创建主题对象
//                Subject subject = SecurityUtils.getSubject();
//                //2、创建令牌 用户名密码令牌
//                UsernamePasswordToken token = new UsernamePasswordToken(user1.getPhone(), user1.getPassword());
//                //3、登录 告诉Shiro登录成功
//                subject.login(token);
                return ResultVo.setSUCCESS("OK");
            } else {
                return ResultVo.setERROR();
            }
        }else {
            return ResultVo.setERROR();
        }
    }
}
