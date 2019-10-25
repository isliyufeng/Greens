package com.cxk.cai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxk.cai.dto.UserDto;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.User;
import com.cxk.cai.mapper.UserMapper;
import com.cxk.cai.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;

/**
 * @author 喜闻乐见i
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public ResultVo login(UserDto user) {
        User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("phone", user.getPhone()));
        if (user1 != null) {
            if (user1.getPhone().equals(user.getPhone()) && user1.getPassword().equals(user.getPassword())) {
                //模拟成功
                //1、创建主题对象
                Subject subject = SecurityUtils.getSubject();
                //2、创建令牌 用户名密码令牌
                UsernamePasswordToken token = new UsernamePasswordToken(user1.getPhone(), user1.getPassword());
                //3、登录 告诉 Shiro 登录成功
                subject.login(token);
                return ResultVo.setSUCCESS("OK");
            } else {
                return ResultVo.setERROR();
            }
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo register(User user) {
        if (!"".equals(user.getPhone()) && !"".equals(user.getPassword())) {
            int i = getBaseMapper().insert(user);
            if (i > 0) {
                return ResultVo.setSUCCESS("OK");
            } else {
                return ResultVo.setERROR();
            }
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo verifyPhone(String phone) {
        if (!"".equals(phone)) {
            Integer result = getBaseMapper().selectCount(new QueryWrapper<User>().eq("phone", phone));
            if (result > 0) {
                return ResultVo.setERROR();
            } else {
                return ResultVo.setSUCCESS("OK");
            }
        } else {
            return ResultVo.setERROR();
        }
    }

    @Override
    public ResultVo updateUserInfo(User user) {
        if (user != null) {
            // 获取登录用户的账号
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
            // 根据登录用户的账号去获取用户信息
            User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("phone", principal));
            // 将用户的id设置到接收到的修改用户的信息的id
            user.setId(user1.getId());
            int i = getBaseMapper().updateById(user);
            if (i > 0) {
                return ResultVo.setSUCCESS("OK");
            } else {
                return ResultVo.setERROR();
            }
        } else {
            return ResultVo.setERROR();
        }
    }
}
