package com.cxk.cai.controller;

import com.cxk.cai.dto.UserDto;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.User;
import com.cxk.cai.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * @author 喜闻乐见i
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户模块啊", tags = "用户模块接口")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "登录", notes = "登录接口", httpMethod = "POST")
    @RequestMapping("/login.do")
    public ResultVo login(UserDto user) {
        return userService.login(user);
    }

    @ApiOperation(value = "注册", notes = "注册接口", httpMethod = "POST")
    @RequestMapping("/register.do")
    public ResultVo register(User user) {
        return userService.register(user);
    }

    @ApiOperation(value = "个人信息", notes = "个人信息接口", httpMethod = "POST")
    @RequestMapping("/userMassage.do")
    public ResultVo UserMassage() {
        return userService.selectUser();
    }

}
