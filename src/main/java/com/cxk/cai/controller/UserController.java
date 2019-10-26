package com.cxk.cai.controller;

import com.cxk.cai.dto.UserDto;
import com.cxk.cai.entity.Order;
import com.cxk.cai.entity.ResultVo;
import com.cxk.cai.entity.User;
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

    @ApiOperation(value = "注册", notes = "注册接口", httpMethod = "POST")
    @RequestMapping("/register.do")
    public ResultVo register(User user) {
        return userService.register(user);
    }

    @ApiOperation(value = "查询个人信息", notes = "查询个人信息接口", httpMethod = "POST")
    @RequestMapping("/userMassage.do")
    public ResultVo UserMassage() {
        return userService.selectUser();
    }
    @ApiOperation(value = "校验手机号", notes = "校验手机号是否已经使用的接口", httpMethod = "POST")
    @RequestMapping("/verifyPhone.do")
    public ResultVo VerifyPhone(String phone) {
        return userService.verifyPhone(phone);
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息接口", httpMethod = "POST")
    @RequestMapping("/updateUserInfo.do")
    public ResultVo updateUserInfo(User user) {
        return userService.updateUserInfo(user);
    }

    @ApiOperation(value = "查询用户订单信息", notes = "查询用户订单信息", httpMethod = "POST")
    @RequestMapping("/userOrder.do")
    public ResultVo userOrder(Integer uid) {
        return userService.userOrder(uid);
    }
}
