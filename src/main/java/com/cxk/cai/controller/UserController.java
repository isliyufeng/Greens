package com.cxk.cai.controller;

import com.cxk.cai.dto.UserDto;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 喜闻乐见i
 */
@RestController
@RequestMapping("/user")
@Api(value = "登录模块", tags = "登录模块接口")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "登录", notes = "登录接口", httpMethod = "POST")
    @RequestMapping("/login.do")
    public ResultVo login(UserDto user) {
        return userService.login(user);
    }

}
